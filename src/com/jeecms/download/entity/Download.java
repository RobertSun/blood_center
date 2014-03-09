package com.jeecms.download.entity;

import static com.jeecms.core.Constants.SPT;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.jeecms.common.util.ComUtils;
import com.jeecms.common.util.StrUtils;
import com.jeecms.core.entity.Attachment;
import com.jeecms.core.util.ContentInterface;
import com.jeecms.download.entity.base.BaseDownload;

public class Download extends BaseDownload implements ContentInterface {
	private static final long serialVersionUID = 1L;
	/**
	 * ����ϵͳ������Ե�ַ
	 */
	public static final String UPLOAD_PATH = SPT + "download";
	/**
	 * �ڸ������е����
	 */
	public static final String ATTACHMENT_CTG = "����";

	public void addToAttachments(Attachment attachment) {
		Set<Attachment> attachments = getCoreAttachments();
		if (attachments == null) {
			attachments = new HashSet<Attachment>();
			setCoreAttachments(attachments);
		}
		attachments.add(attachment);
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public Download () {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public Download (java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public Download (
		java.lang.Long id,
		com.jeecms.core.entity.Website website,
		com.jeecms.cms.entity.CmsChannel channel,
		java.lang.Long viewTotal,
		java.lang.Long visitTotal,
		java.lang.Long visitToday,
		java.lang.Long visitWeek,
		java.lang.Long visitMonth,
		java.lang.Long visitQuarter,
		java.lang.Long visitYear,
		java.lang.Integer commentCount,
		java.lang.Boolean hasTitleimg,
		java.lang.Boolean bold,
		java.lang.Boolean draft,
		java.lang.Boolean recommend,
		java.lang.Boolean check,
		java.lang.Boolean reject,
		java.lang.Boolean disabled) {

		super (
			id,
			website,
			channel,
			viewTotal,
			visitTotal,
			visitToday,
			visitWeek,
			visitMonth,
			visitQuarter,
			visitYear,
			commentCount,
			hasTitleimg,
			bold,
			draft,
			recommend,
			check,
			reject,
			disabled);
	}

	/* [CONSTRUCTOR MARKER END] */

	public String desc(int len) {
		String s = getDescription();
		if (StringUtils.isBlank(s)) {
			return "";
		} else {
			return StrUtils.getCn(s, len);
		}
	}

	public String getCtgName() {
		return getChannel().getName();
	}

	public String getCtgUrl() {
		return getChannel().getUrl();
	}

	public float getGrade() {
		float f = getEvaluation() / getCommentCount();
		return f;
	}

	public String getDate(int style) {
		Date date = getReleaseDate();
		return ComUtils.formatDate(date, style);
	}

	public String getImgUrl() {
		String img = getTitleImg();
		if (StringUtils.isBlank(img)) {
			return "";
		} else {
			return getWebsite().getUploadUrlBuf().append(img).toString();
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

	public String getUrl() {
		StringBuilder sb = getWebsite().getWebUrlBuf();
		String path = getChannel().getPath();
		if (!StringUtils.isBlank(path)) {
			sb.append(SPT).append(path);
		}
		sb.append(SPT).append(getId()).append(".").append(
				getWebsite().getSuffix());
		return sb.toString();
	}

	public String getWebName() {
		return getWebsite().getShortName();
	}

	public String getWebUrl() {
		return getWebsite().getWebUrl();
	}

	public String getDownloadUrl() {
		if (getAttachment() == null) {
			return "";
		}
		String path = getAttachment().getRelPath();
		return getWebsite().getResUrl() + path;
	}

	public boolean isTitBold() {
		return getBold();
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

	private boolean ifNew;

	public boolean isIfNew() {
		return ifNew;
	}

	public void setIfNew(boolean ifNew) {
		this.ifNew = ifNew;
	}

}