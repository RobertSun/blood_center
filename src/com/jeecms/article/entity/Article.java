package com.jeecms.article.entity;

import static com.jeecms.core.Constants.ENCODING;
import static com.jeecms.core.Constants.SPT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeecms.article.entity.base.BaseArticle;
import com.jeecms.cms.entity.CmsChannel;
import com.jeecms.common.util.ComUtils;
import com.jeecms.common.util.StrUtils;
import com.jeecms.core.entity.Attachment;
import com.jeecms.core.util.ContentInterface;

public class Article extends BaseArticle implements ContentInterface {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(Article.class);
	/**
	 * ���±����ݵĴ�ŵ�ַ
	 */
	public static final String ARTICLE_PATH = "article_content";
	/**
	 * �ڸ������е����
	 */
	public static final String ATTACHMENT_CTG = "����";
	/**
	 * ����ϵͳ��Ե�ַ
	 */
	public static final String UPLOAD_PATH = SPT + "article";
	public static final String SUFFIX = ".txt";
	public static final int SPLIT_COUNT = 1000;
	public static final String SPLIT = "<p>[NextPage][/NextPage]</p>";
	public static final String SPLIT_REG = "<p>\\[NextPage\\]\\[/NextPage\\]</p>";

	/**
	 * ���url��ַ
	 *
	 * @return
	 */
	public String getUrl() {
		if (!StringUtils.isBlank(getOuterUrl())) {
			return getOuterUrl();
		}
		StringBuilder sb = getWebsite().getWebUrlBuf();
		String path = getChannel().getPath();
		if (!StringUtils.isBlank(path)) {
			sb.append(SPT).append(path);
		}
		sb.append(SPT).append(getId()).append(".").append(
				getWebsite().getSuffix());
		return sb.toString();
	}

	/**
	 * ѡ��ģ��
	 *
	 * @return
	 */
	public String chooseTpl() {
		String s = getTplContent();
		if (StringUtils.isBlank(s)) {
			return getChannel().chooseTplContent();
		} else {
			return getWebsite().getTplRoot().append(getTplContent()).toString();
		}
	}

	/**
	 * ��õ�Nҳ���������·�����û����ļ���
	 *
	 * @param pageNo
	 * @return
	 */
	public String relPath(int pageNo) {
		StringBuilder sb = getWebsite().getUserRoot();
		sb.append(SPT).append(ARTICLE_PATH).append(SPT).append(
				(getId() / SPLIT_COUNT) + 1).append(SPT).append(getId())
				.append("_").append(pageNo).append(SUFFIX);
		return sb.toString();
	}

	/**
	 * ��õ�Nҳ�ľ�Ե�ַ
	 *
	 * @param root
	 * @param pageNo
	 * @return
	 */
	private String getRealPath(String root, int pageNo) {
		StringBuilder sb = new StringBuilder(root);
		sb.append(relPath(pageNo));
		return sb.toString().replace(SPT, File.separatorChar);
	}

	/**
	 * ���ļ���ȡ����
	 *
	 * @return
	 */
	public String getContentFromFile() {
		if (rootReal == null) {
			throw new RuntimeException("�������÷��������·��rootReal");
		}
		return getContentFromFile(rootReal);
	}

	/**
	 * ���ļ���ȡ����
	 *
	 * @param root
	 * @return
	 */
	public String getContentFromFile(String root) {
		StringBuilder sb = new StringBuilder();
		try {
			File f = null;
			Integer count = getPageCount();
			if (count == null) {
				count = 0;
			}
			for (int i = 0; i < count; i++) {
				f = new File(getRealPath(root, i + 1));
				sb.append(FileUtils.readFileToString(f, ENCODING));
				if (i + 1 < count) {
					sb.append(SPLIT);
				}
			}
		} catch (IOException e) {
			log.error("��ȡ��������ʧ��", e);
		}
		return sb.toString();
	}

	/**
	 * ɾ�������ļ�
	 *
	 * @param root
	 */
	public void deleteContentFile(String root) {
		File f = null;
		Integer count = getPageCount();
		log.debug("ɾ���������ݣ�{}������ {} ҳ", getId(), count);
		if (count == null) {
			count = 0;
		}
		for (int i = 0; i < count; i++) {
			f = new File(getRealPath(root, i + 1));
			if (f.delete()) {
				log.info("ɾ�� �������� �ɹ���{}_{}��{}", new Object[] { getId(), i + 1,
						f.getAbsolutePath() });
			} else {
				log.warn("ɾ�� �������� ʧ�ܣ�{}_{}��{}", new Object[] { getId(), i + 1,
						f.getAbsolutePath() });
			}
		}
	}

	public void checkNew(int day) {
		Long mydate = (System.currentTimeMillis() - getReleaseDate().getTime())
				/ (24 * 60 * 60 * 1000);
		if (day > mydate) {
			setIfNew(true);
		} else {
			setIfNew(false);
		}
	}

	/**
	 * ������д���ļ�����ɾ������ҳ��
	 *
	 * @param root
	 *            ϵͳ��Ը�·��
	 * @param origCount
	 *            ԭ�з�ҳ��0Ϊԭ����û������
	 */
	public void writeContent(String root, int origCount) {
		String c = getContent();
		if (c == null) {
			c = "";
		}
		String[] arr = c.split(SPLIT_REG);
		try {
			int currCount = arr.length;
			if (currCount == 0) {
				arr = new String[] { "" };
			}
			// д�ļ�
			for (int i = 0; i < currCount; i++) {
				File f = new File(getRealPath(root, i + 1));
				// ��ֹ�մ��޷�д���ļ�
				if (StringUtils.isEmpty(arr[i])) {
					f.createNewFile();
				} else {
					FileUtils.writeStringToFile(f, arr[i], ENCODING);
				}
				log.info("д �������� �ɹ���{}_{}��{}", new Object[] { getId(), i + 1,
						f.getAbsolutePath() });
			}
			// ɾ��ԭʣ���ļ�
			for (int i = currCount; i < origCount; i++) {
				File f = new File(getRealPath(root, i + 1));
				if (f.delete()) {
					log.info("ɾ�� �������� �ɹ���{}_{}��{}", new Object[] { getId(),
							i + 1, f.getAbsolutePath() });
				} else {
					log.warn("ɾ�� �������� ʧ�ܣ�{}_{}��{}", new Object[] { getId(),
							i + 1, f.getAbsolutePath() });
				}
			}
		} catch (IOException e) {
			log.error("д��������ʧ��", e);
		}
	}

	/**
	 * ��������е�ҳ��
	 *
	 * @return
	 */
	public void calculatePageCount() {
		String c = getContent();
		int count = 1;
		if (!StringUtils.isEmpty(c)) {
			count = c.split(SPLIT_REG).length;
		}
		if (count < 1) {
			count = 1;
		}
		setPageCount(count);
	}

	/**
	 * �������ͼƬ��URL��ַ
	 *
	 * @return
	 */
	public String getCttImgUrl() {
		String img = getContentImg();
		if (StringUtils.isBlank(img)) {
			return "";
		} else {
			return getWebsite().getUploadUrlBuf().append(img).toString();
		}
	}

	/**
	 * ��ԴURL�Ƿ�ı䡣
	 *
	 * ��������·�����˿ںŸı䣬��ԴURLҲ��ı䡣�����������е�ͼƬ�޷���ʾ��
	 *
	 * @return
	 */
	public boolean isResPathChannge() {
		String ourl = getContentResPath();
		// ��������ֶ�Ϊ�գ����п��ܲ��ǳ־û�����
		if (StringUtils.isBlank(ourl) || getWebsite() == null
				|| StringUtils.isBlank(getWebsite().getResUrl())) {
			return false;
		}
		String curl = getWebsite().getResUrl();
		return !ourl.equals(curl);
	}

	/**
	 * ������Դ·��
	 */
	public void updateResPath() {
		String newResPath = getWebsite().getResUrl();
		String oldResPath = getContentResPath();
		if (StringUtils.equals(newResPath, oldResPath)) {
			return;
		}
		String content = getContentFromFile();
		setContent(content.replace(oldResPath, newResPath));
		writeContent(getRootReal(), 0);
		setContentResPath(newResPath);
	}

	public void addToAttachments(Attachment attachment) {
		Set<Attachment> attachments = getAttachments();
		if (attachments == null) {
			attachments = new HashSet<Attachment>();
			setAttachments(attachments);
		}
		attachments.add(attachment);
	}

	/**
	 * ����ö�ʱ��
	 *
	 * @return
	 */
	public int getTopHour() {
		Date date = getSortDate();
		if (date == null) {
			return 0;
		}
		long remain = date.getTime() - System.currentTimeMillis();
		if (remain <= 0) {
			return 0;
		}
		return (int) remain / (60 * 60 * 1000);
	}

	/**
	 * ���·��ʴ���
	 */
	public void updateVisit(long count) {
		Date d = getStatDate();
		Date curr = new Date();
		setStatDate(curr);
		setVisitTotal(getVisitTotal() + count);
		Calendar stat = Calendar.getInstance();
		stat.setTime(d);
		Calendar now = Calendar.getInstance();
		now.setTime(curr);
		// ��
		if (stat.get(Calendar.DAY_OF_YEAR) == now.get(Calendar.DAY_OF_YEAR)) {
			setVisitToday(getVisitToday() + count);
		} else {
			setVisitToday(count);
		}
		// ��
		if (stat.get(Calendar.WEEK_OF_YEAR) == now.get(Calendar.WEEK_OF_YEAR)) {
			setVisitWeek(getVisitWeek() + count);
		} else {
			setVisitWeek(count);
		}
		// ��
		if (stat.get(Calendar.MONTH) == now.get(Calendar.MONTH)) {
			setVisitMonth(getVisitMonth() + count);
		} else {
			setVisitMonth(count);
		}
		// ��
		if (stat.get(Calendar.MONTH) / 3 == now.get(Calendar.MONTH) / 3) {
			setVisitQuarter(getVisitQuarter() + count);
		} else {
			setVisitQuarter(count);
		}
		// ��
		if (stat.get(Calendar.YEAR) == now.get(Calendar.YEAR)) {
			setVisitYear(getVisitYear() + count);
		} else {
			setVisitYear(count);
		}
	}

	public String desc(int len) {
		String s = getDescription();
		if (StringUtils.isBlank(s)) {
			return "";
		} else {
			return StrUtils.getCn(s, len);
		}
	}

	public String getImgUrl() {
		String img = getTitleImg();
		if (StringUtils.isBlank(img)) {
			return "";
		} else {
			return getWebsite().getUploadUrlBuf().append(img).toString();
		}
	}

	public boolean isTitBold() {
		return getBold();
	}

	public String stit(int len) {
		String s = getShortTitle();
		if (StringUtils.isBlank(s)) {
			s = getTitle();
		}
		if (StringUtils.isBlank(s)) {
			return "";
		} else {
			return StrUtils.getCn(s, len);
		}
	}

	public String tit(int len) {
		String s = getTitle();
		if (StringUtils.isBlank(s)) {
			return "";
		} else {
			return StrUtils.getCn(s, len);
		}
	}

	public String getTitCol() {
		String s = getTitleColor();
		if (s == null) {
			return "";
		} else {
			return s;
		}
	}

	public String getCtgName() {
		return getChannel().getName();
	}

	public String getCtgUrl() {
		return getChannel().getUrl();
	}

	public String getWebName() {
		return getWebsite().getShortName();
	}

	public String getWebUrl() {
		return getWebsite().getWebUrl();
	}

	public String getDate(int style) {
		Date date = getReleaseDate();
		return ComUtils.formatDate(date, style);
	}

	public Collection<Long> getChannelIds() {
		CmsChannel c = getChannel();
		Collection<Long> ids = new ArrayList<Long>();
		if (c != null) {
			while (c != null) {
				ids.add(c.getId());
				c = c.getParent();
			}
		}
		return ids;
	}

	private String content;
	private String rootReal;
	private boolean ifNew;

	public boolean isIfNew() {
		return ifNew;
	}

	public void setIfNew(boolean ifNew) {
		this.ifNew = ifNew;
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Article() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Article(java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Article(java.lang.Long id,
			com.jeecms.cms.entity.ContentCtg contentCtg,
			com.jeecms.cms.entity.CmsChannel channel,
			com.jeecms.core.entity.Website website,
			com.jeecms.cms.entity.CmsConfig config, java.util.Date sortDate,
			java.util.Date releaseDate, java.util.Date releaseSysDate,
			java.lang.Long visitTotal, java.lang.Long visitToday,
			java.lang.Long visitWeek, java.lang.Long visitMonth,
			java.lang.Long visitQuarter, java.lang.Long visitYear,
			java.lang.Integer checkStep, java.lang.Integer topLevel,
			java.lang.Integer commentCount, java.lang.Boolean hasTitleImg,
			java.lang.Boolean allowComment, java.lang.Boolean bold,
			java.lang.Boolean draft, java.lang.Boolean recommend,
			java.lang.Boolean check, java.lang.Boolean disabled,
			java.lang.Boolean reject) {

		super(id, contentCtg, channel, website, config, sortDate, releaseDate,
				releaseSysDate, visitTotal, visitToday, visitWeek, visitMonth,
				visitQuarter, visitYear, checkStep, topLevel, commentCount,
				hasTitleImg, allowComment, bold, draft, recommend, check,
				disabled, reject);
	}

	/* [CONSTRUCTOR MARKER END] */

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getRootReal() {
		return rootReal;
	}

	public void setRootReal(String rootReal) {
		this.rootReal = rootReal;
	}
}