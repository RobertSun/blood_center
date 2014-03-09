package com.jeecms.cms.entity;

import java.util.Calendar;
import java.util.Date;

import com.jeecms.cms.entity.base.BaseCmsMember;
import com.jeecms.core.entity.Member;

public class CmsMember extends BaseCmsMember {
	private static final long serialVersionUID = 1L;
	public static final int UPLOAD_KEY = 100;

	/**
	 * 增加已上传大小
	 * 
	 * @param size
	 */
	public void addUploadSize(int size) {
		if (size < 0) {
			return;
		}
		if (isToday()) {
			setUploadSize(0);
			setUploadStatDate(new Date());
		}
		setUploadSize(getUploadSize() + size);
		setUploadTotalSize(getUploadTotalSize() + size);
	}

	public int getUploadToday() {
		int size = getUploadSize();
		if (isToday()) {
			return size;
		} else {
			setUploadSize(0);
			setUploadStatDate(new Date());
			return 0;
		}
	}

	private boolean isToday() {
		Calendar origCal = Calendar.getInstance();
		origCal.setTime(getUploadStatDate());
		int origDay = origCal.get(Calendar.DAY_OF_YEAR);
		Calendar nowCal = Calendar.getInstance();
		int nowDay = nowCal.get(Calendar.DAY_OF_YEAR);
		return origDay == nowDay;
	}

	/**
	 * 获得登录名
	 * 
	 * @return
	 */
	public String getLoginName() {
		Member member = getMember();
		if (member == null) {
			return null;
		} else {
			return member.getLoginName();
		}
	}

	/**
	 * 会员是否禁用。不但取决于会员本身状态，还取决于user状态。
	 * 
	 * @return
	 */
	public Boolean getMemberDisabled() {
		Boolean b = getDisabled();
		if (b == null || b == true) {
			return b;
		} else {
			return getMember().getMemberDisabled();
		}
	}

	/* [CONSTRUCTOR MARKER BEGIN] */
	public CmsMember() {
		super();
	}

	/**
	 * Constructor for primary key
	 */
	public CmsMember(java.lang.Long id) {
		super(id);
	}

	/**
	 * Constructor for required fields
	 */
	public CmsMember(java.lang.Long id, com.jeecms.core.entity.Website website,
			com.jeecms.cms.entity.CmsMemberGroup group,
			java.lang.Boolean disabled) {

		super(id, website, group, disabled);
	}

	/* [CONSTRUCTOR MARKER END] */

}