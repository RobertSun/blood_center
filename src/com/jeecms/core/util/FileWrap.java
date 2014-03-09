package com.jeecms.core.util;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FileWrap {
	private File file;
	private String rootName;
	private FileFilter filter;
	private List<FileWrap> child;

	public void setChild(List<FileWrap> child) {
		this.child = child;
	}

	public FileWrap(File file) {
		this(file, null);
	}

	public FileWrap(File file, String rootName) {
		this(file, rootName, null);
	}

	public FileWrap(File file, String rootName, FileFilter filter) {
		this.file = file;
		this.rootName = rootName;
		this.filter = filter;
	}

	// public FileWrap(File file, String rootName, )

	public java.sql.Timestamp getLastModified() {
		return new java.sql.Timestamp(file.lastModified());
	}

	public long getSize() {
		return file.length() / 1024L + 1;
	}

	public String getName() {
		return file.getName();
	}

	public String getTreeName() {
		return getName();
	}

	public boolean isDirectory() {
		return file.isDirectory();
	}

	public String getRelPath() {
		String path = getFile().getAbsolutePath();
		int index = path.indexOf(rootName) + rootName.length();
		// String relPath = path.substring(index).replaceAll("\\\\", "/");
		String relPath = path.substring(index);
		return relPath;
	}

	public String getType() {
		if (file.isDirectory()) {
			return "文件夹";
		} else {
			String fname = file.getName();
			String ext = fname.substring(fname.lastIndexOf(".") + 1);
			return ext + " 文件";
		}
	}

	public String getIco() {
		if (file.isDirectory()) {
			return "folder.gif";
		}
		String fname = file.getName();
		int extIndex = fname.lastIndexOf(".");
		if (extIndex == -1) {
			return "unknow.gif";
		}
		String ext = fname.substring(extIndex);
		if (ext.equalsIgnoreCase(".jpg") || ext.equalsIgnoreCase(".jpeg")) {
			return "jpg.gif";
		} else if (ext.equalsIgnoreCase(".gif")) {
			return "gif.gif";
		} else if (ext.equalsIgnoreCase(".html")
				|| ext.equalsIgnoreCase(".htm")) {
			return "html.gif";
		} else if (ext.equalsIgnoreCase(".swf")) {
			return "swf.gif";
		} else if (ext.equalsIgnoreCase(".txt")) {
			return "txt.gif";
		} else {
			return "unknow.gif";
		}
	}

	public List<FileWrap> getChild() {
		if (this.child != null) {
			return this.child;
		}
		File[] files;
		if (filter == null) {
			files = getFile().listFiles();
		} else {
			files = getFile().listFiles(filter);
		}
		List<FileWrap> list = new ArrayList<FileWrap>();
		if (files != null) {
			Arrays.sort(files, new FileComparator());
			for (File f : files) {
				FileWrap fw = new FileWrap(f, rootName, filter);
				list.add(fw);
			}
		}
		return list;
	}

	public boolean isTreeLeaf() {
		return getFile().isFile();
	}

	public File getFile() {
		return this.file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public static class FileComparator implements Comparator<File> {
		public int compare(File o1, File o2) {
			if (o1.isDirectory() && !o2.isDirectory()) {
				return -1;
			} else if (!o1.isDirectory() && o2.isDirectory()) {
				return 1;
			} else {
				return o1.compareTo(o2);
			}
		}
	}
}
