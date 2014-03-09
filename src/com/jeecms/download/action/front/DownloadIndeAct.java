package com.jeecms.download.action.front;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.cms.CmsIndeAction;
import com.jeecms.cms.Constants;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.cms.manager.CmsMemberMng;
import com.jeecms.common.page.Pagination;
import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.core.entity.Member;
import com.jeecms.core.manager.MemberMng;
import com.jeecms.download.entity.Download;
import com.jeecms.download.manager.DownloadMng;

@SuppressWarnings("unchecked")
@Scope("prototype")
@Controller("download.downloadIndeAct")
public class DownloadIndeAct extends CmsIndeAction {

	private static final Logger log = LoggerFactory
			.getLogger(DownloadIndeAct.class);

	private static final String FAIL = "fail";

	public String search() {
		if (!StringUtils.isBlank(searchKey)) {
			try {
				searchKey = new String(searchKey.getBytes("ISO-8859-1"), "GBK");
			} catch (UnsupportedEncodingException e) {
				log.error("��������ʱ������ת���쳣��", e);
			}
		}
		Boolean hasTitleImg;
		switch (hasImg) {
		case 2:
			hasTitleImg = false;
			break;
		case 1:
			hasTitleImg = true;
			break;
		default:
			hasTitleImg = null;
		}
		if (count > 200) {
			count = 200;
		}
		pagination = downloadMng.getForTag(getWebId(), chnlId, null, searchKey,
				hasTitleImg, recommend == 1 ? true : false, 0, orderBy, true,
				0, pageNo, count);
		return handleResult("Search");
	}

	public String downSort() {
		return handleResult("downSortList");
	}

	public String userDownload() {
		this.download = downloadMng.findById(id);
		/*
		 * boolean havelogin = checkLogin(); if (!havelogin) {
		 * addActionMessage("�㻹û�е�¼.���ȵ�¼������"); chnl = download.getChannel();
		 * sysType = chnl.getSysType(); tplPath = download.chooseTpl(); return
		 * FAIL; }
		 */
		if (download.getAttachment() == null) {
			addActionMessage("����������ϲ����ڻ�������ʧ");
			chnl = download.getChannel();
			sysType = chnl.getSysType();
			tplPath = download.chooseTpl();
			return FAIL;
		}
		download(download);
		download.setDownCount(download.getDownCount() + 1);
		downloadMng.update(download);
		return null;
	}

	@SuppressWarnings("unused")
	private boolean checkLogin() {
		member = getMember();
		if (member == null) {
			return false;
		}
		return true;
	}

	private void download(Download bean) {
		String filedownload = contextPvd.getAppRealPath(bean.getAttachment()
				.getRelPath());
		File f = new File(filedownload);
		String filedisplay = bean.getAttachment().getFileName();
		try {
			filedisplay = URLEncoder.encode(filedisplay, "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		contextPvd.getResponse().setContentType("application/zip");
		contextPvd.getResponse().addHeader("Content-Disposition",
				"attachment;filename=" + filedisplay);
		OutputStream outp = null;
		FileInputStream in = null;
		try {
			outp = contextPvd.getResponse().getOutputStream();
			in = new FileInputStream(f);

			byte[] b = new byte[1024];
			int i = 0;

			while ((i = in.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			outp.flush();
		} catch (Exception e) {
			log.error("", e);
		} finally {
			if (in != null) {
				try {
					in.close();
					in = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outp != null) {
				try {
					outp.close();
					outp = null;
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public String getSysType() {
		return Constants.DOWNLOAD_SYS;
	}

	private int count;
	private String searchKey;

	private int orderBy = 0;
	private int recommend = 0;
	private int hasImg = 0;
	private Long chnlId = null;
	private Download download;
	private Long id;

	private Member member;

	private CmsChannel chnl;
	@SuppressWarnings("unused")
	private String sysType;

	public CmsChannel getChnl() {
		return chnl;
	}

	public void setChnl(CmsChannel chnl) {
		this.chnl = chnl;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
	}

	private Pagination pagination;
	@Autowired
	private DownloadMng downloadMng;
	@Autowired
	protected MemberMng memberMng;
	@Autowired
	protected CmsMemberMng cmsMemberMng;
	@Autowired
	private ContextPvd contextPvd;

	public int getRecommend() {
		return recommend;
	}

	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Long getChnlId() {
		return chnlId;
	}

	public void setChnlId(Long chnlId) {
		this.chnlId = chnlId;
	}

	public int getHasImg() {
		return hasImg;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(int orderBy) {
		this.orderBy = orderBy;
	}

	public void setHasImg(int hasImg) {
		this.hasImg = hasImg;
	}

	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Download getDownload() {
		return download;
	}

	public void setDownload(Download download) {
		this.download = download;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
