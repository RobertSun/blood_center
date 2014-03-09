package com.jeecms.core.util;

import static com.jeecms.core.Constants.SPT;

import java.io.File;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jeecms.common.util.StrUtils;

/**
 * �ϴ��������ࡣ
 * 
 * ���ϴ�֮ǰ���ϴ�������󱣴���session�У�֮��༭���������ϴ����󽫸����ϴ������ϴ��ļ���
 * 
 * �༭������������ĸ�·����rootPath��ģ������ʱ��Ҫָ����·�����Ա��ϴ�ͼƬ��
 * 
 * �����ϴ�·��
 * 
 * @author liufang
 * 
 */
public class UploadRule implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory.getLogger(UploadRule.class);
	/**
	 * ��session�е�key
	 */
	public static final String KEY = "_upload_rule";

	/**
	 * ������
	 * 
	 * @param rootPath
	 *            ��·��������������ĸ�·�����ϴ�ʱ������Ҫ�ټ������·��
	 * @param pathPrefix
	 *            ·��ǰ׺
	 * @param isGenName
	 *            �Ƿ񴴽�����ļ���
	 * @param hasType
	 *            �Ƿ������ļ����ģ������ʱ����Ҫ�������������Ҫ
	 * @param needClear
	 *            �Ƿ���Ҫ���δʹ�õ��ϴ��ļ�
	 */
	public UploadRule(String rootPath, String pathPrefix, boolean isGenName,
			boolean hasType, boolean needClear) {
		this.rootPath = rootPath;
		this.pathPrefix = pathPrefix;
		this.isGenName = isGenName;
		this.hasType = hasType;
		this.needClear = needClear;
	}

	/**
	 * ������
	 * 
	 * @param rootPath
	 *            ��·��������������ĸ�·�����ϴ�ʱ������Ҫ�ټ������·��
	 * @param isGenName
	 *            �Ƿ񴴽�����ļ���
	 * @param hasType
	 *            �Ƿ������ļ����ģ������ʱ����Ҫ�������������Ҫ
	 */

	public UploadRule(String rootPath, String pathPrefix, boolean isGenName,
			boolean hasType) {
		this(rootPath, pathPrefix, isGenName, hasType, true);
	}

	/**
	 * ������
	 * 
	 * @param rootPath
	 *            ��·��������������ĸ�·�����ϴ�ʱ������Ҫ�ټ������·��
	 * @param isGenName
	 *            �Ƿ񴴽�����ļ���
	 */

	public UploadRule(String rootPath, String pathPrefix, boolean isGenName) {
		this(rootPath, pathPrefix, isGenName, true, true);
	}

	/**
	 * ������
	 * 
	 * @param rootPath
	 *            ��·��������������ĸ�·�����ϴ�ʱ������Ҫ�ټ������·��
	 */

	public UploadRule(String rootPath, String pathPrefix) {
		this(rootPath, pathPrefix, true, true, true);
	}

	/**
	 * ����ļ�ȫ��
	 * 
	 * Ŀ¼ǰ׺/��+����/��+��/�ļ���.suffix
	 * 
	 * @return
	 */
	public String getPathName(String fileName, String suffix, String type) {
		StringBuilder sb = new StringBuilder(getPathPrefix()).append(type)
				.append(genFilePath());
		if (isGenName) {
			sb.append(genFileName());
		} else {
			sb.append(fileName);
		}
		sb.append('.').append(suffix);
		return sb.toString();
	}

	/**
	 * ����ǰ��������·����/2008_2/5_20/��/��_��/��_��/
	 * 
	 * @return
	 */
	public static String genFilePath() {
		StringBuilder sb = new StringBuilder();
		Calendar cal = Calendar.getInstance();
		sb.append(SPT).append(cal.get(Calendar.YEAR)).append('_').append(
				cal.get((Calendar.MONTH)) / 3 + 1).append(SPT).append(
				cal.get(Calendar.MONTH) + 1).append('_').append(
				cal.get(Calendar.DAY_OF_MONTH)).append(SPT);
		return sb.toString();
	}

	/**
	 * ����ļ���
	 * 
	 * 4λ��������ϵ�ǰʱ��
	 * 
	 * @return
	 */
	public static String genFileName() {
		String name = StrUtils.longToN36(System.currentTimeMillis());
		return RandomStringUtils.random(4, StrUtils.N36_CHARS) + name;
	}

	/**
	 * ��ÿ�ͼƬ�ĺ�׺����û��ָ������ʹ��Ĭ�ϵĺ�׺���ϡ�
	 * 
	 * @return
	 */
	public Set<String> getAcceptImg() {
		if (acceptImg == null) {
			acceptImg = new HashSet<String>();
			for (String s : DEF_IMG_ACCEPT) {
				acceptImg.add(s);
			}
		}
		return acceptImg;
	}

	public void addUploadFile(String origName, String fileName,
			String realPath, long size) {
		if (uploadFiles == null) {
			uploadFiles = new HashMap<String, UploadFile>();
		}
		uploadFiles.put(fileName, new UploadFile(origName, fileName, realPath,
				size));
	}

	public void removeUploadFile(String fileName) {
		if (uploadFiles != null) {
			uploadFiles.remove(fileName);
		}
	}

	public Map<String, UploadFile> getUploadFiles() {
		return uploadFiles;
	}

	public void clearUploadFile() {
		if (uploadFiles != null && needClear) {
			for (UploadFile uf : uploadFiles.values()) {
				File file = new File(uf.getRealPath());
				if (file.delete()) {
					log.debug("ɾ��δ��ʹ�õ��ļ���{}", file.getName());
				} else {
					log.warn("ɾ���ļ�ʧ�ܣ�{}", file.getName());
				}
			}
			uploadFiles.clear();
		}
	}

	/**
	 * �Ѿ��ϴ���ͼƬ
	 */
	private Map<String, UploadFile> uploadFiles;

	/**
	 * �����ϴ����ļ���׺
	 */
	private Set<String> acceptImg;
	/**
	 * �༭������������ĸ�·����Ҳ���ϴ��ĸ�·��
	 */
	private String rootPath;

	private String pathPrefix;
	/**
	 * �Ƿ������ļ���
	 */
	private boolean isGenName = true;
	/**
	 * �Ƿ������ļ����ͣ����ڱ༭�����������ʱʹ�ã�
	 */
	private boolean hasType = true;
	/**
	 * �Ƿ���Ҫ����
	 */
	private boolean needClear = true;
	/**
	 * �Ƿ���������ļ�
	 */
	private boolean allowFileBrowsing = true;
	/**
	 * �Ƿ������ϴ��ļ�
	 */
	private boolean allowUpload = true;
	/**
	 * �����ϴ��Ĵ�С��0�������ϴ���-1��������
	 */
	private int allowSize = -1;
	/**
	 * ���ϴ���С
	 */
	private int uploadSize = 0;
	/**
	 * Ĭ�ϵĿ��ϴ��ļ���׺
	 */
	public static final String[] DEF_IMG_ACCEPT = { "jpg", "gif", "jpeg",
			"png", "bmp", };

	public static void main(String[] args) {
		UploadRule rule = new UploadRule("", "", true);
		System.out.println(rule.getPathName("", "jpg", "img"));
	}

	public boolean isGenName() {
		return isGenName;
	}

	public void setGenName(boolean isGenName) {
		this.isGenName = isGenName;
	}

	public void setAcceptImg(Set<String> acceptImg) {
		this.acceptImg = acceptImg;
	}

	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public boolean isHasType() {
		return hasType;
	}

	public void setHasType(boolean hasType) {
		this.hasType = hasType;
	}

	public boolean isNeedClear() {
		return needClear;
	}

	public void setNeedClear(boolean needClear) {
		this.needClear = needClear;
	}

	public static class UploadFile implements java.io.Serializable {
		private static final long serialVersionUID = 1L;

		public UploadFile() {
		}

		public UploadFile(String origName, String fileName, String realPath,
				long size) {
			this.origName = origName;
			this.fileName = fileName;
			this.realPath = realPath;
			this.size = size;
		}

		public String getRelPath(String pathRoot) {
			String real = getRealPath();
			real = StringUtils.replace(real, pathRoot, "");
			real = StringUtils.replace(real, File.separator, "/");
			return real;
		}

		private String origName;
		private String fileName;
		private String realPath;
		private long size;

		public String getOrigName() {
			return origName;
		}

		public void setOrigName(String origName) {
			this.origName = origName;
		}

		public String getFileName() {
			return fileName;
		}

		public void setFileName(String fileName) {
			this.fileName = fileName;
		}

		public String getRealPath() {
			return realPath;
		}

		public void setRealPath(String realPath) {
			this.realPath = realPath;
		}

		public long getSize() {
			return size;
		}

		public void setSize(long size) {
			this.size = size;
		}
	}

	public String getPathPrefix() {
		return pathPrefix;
	}

	public void setPathPrefix(String pathPrefix) {
		this.pathPrefix = pathPrefix;
	}

	public boolean isAllowFileBrowsing() {
		return allowFileBrowsing;
	}

	public void setAllowFileBrowsing(boolean allowFileBrowsing) {
		this.allowFileBrowsing = allowFileBrowsing;
	}

	public int getUploadSize() {
		return uploadSize;
	}

	public void setUploadSize(int uploadSize) {
		this.uploadSize = uploadSize;
	}

	public boolean isAllowUpload() {
		return allowUpload;
	}

	public void setAllowUpload(boolean allowUpload) {
		this.allowUpload = allowUpload;
	}

	public int getAllowSize() {
		return allowSize;
	}

	public void setAllowSize(int allowSize) {
		this.allowSize = allowSize;
	}
}
