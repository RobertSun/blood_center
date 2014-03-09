package com.jeecms.cms.action;

import static com.jeecms.core.Constants.ENCODING;
import static com.jeecms.core.Constants.FILE_SPT;
import static com.jeecms.core.Constants.SPT;

import java.io.File;
import java.io.FileFilter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.common.util.ComUtils;
import com.jeecms.common.util.Zipper;
import com.jeecms.common.util.Zipper.FileEntry;
import com.jeecms.core.JeeCoreAction;
import com.jeecms.core.util.FileWrap;
import com.jeecms.core.util.UploadRule;

@SuppressWarnings("serial")
@Scope("prototype")
@Controller("core.templateAct")
public class TemplateAct extends JeeCoreAction {
	private static final Logger log = LoggerFactory
			.getLogger(TemplateAct.class);

	public String resMain() {
		return MAIN;
	}

	public String left() {
		String path = getWeb().getTplRootReal(contextPvd.getAppRoot())
				.toString().replace(SPT, FILE_SPT);
		File tplFile = new File(path);
		treeRoot = new FileWrap(tplFile, path, new FileFilter() {
			public boolean accept(File f) {
				if (f.getName().startsWith(".") || f.getName().startsWith("$")) {
					return false;
				} else {
					return true;
				}
			}
		});
		return LEFT;
	}

	public String resLeft() {
		String resPath = contextPvd.getAppRealPath(getWeb().getResRootBuf()
				.toString());
		treeRoot = new FileWrap(new File(resPath), resPath, new FileFilter() {
			public boolean accept(File f) {
				if (f.isDirectory() || f.getName().endsWith(".js")
						|| f.getName().endsWith(".css")
						|| f.getName().endsWith(".html")
						|| f.getName().endsWith(".txt")) {
					return true;
				} else {
					return false;
				}
			}
		});
		return LEFT;
	}

	public String right() {
		return RIGHT;
	}

	public String list() {
		String path = contextPvd.getAppRealPath(getWeb().getTplRoot().append(
				relPath).toString());
		File dir = new File(path);
		subDir = new FileWrap(dir).getChild();
		return LIST;
	}

	public String resList() {
		String path = contextPvd.getAppRealPath(getWeb().getResRootBuf()
				.append(relPath).toString());
		File dir = new File(path);
		subDir = new FileWrap(dir).getChild();
		return LIST;
	}

	public String add() {
		// 设置上传规则
		addUploadRule();
		return ADD;
	}

	public String resAdd() {
		return ADD;
	}

	private boolean saveFile(String path) {
		File tpl = new File(path + relPath + FILE_SPT + tplName);
		try {
			FileUtils.writeStringToFile(tpl, tplContent, ENCODING);
			return true;
		} catch (IOException e) {
			log.error("写入模板失败！", e);
			addActionError("写入模板失败！");
			return false;
		}
	}

	public String save() {
		String path = contextPvd.getAppRealPath(getWeb().getTplRoot()
				.toString());
		if (saveFile(path)) {
			removeUploadRule();
		}
		return list();
	}

	public String resSave() {
		String path = contextPvd.getAppRealPath(getWeb().getResRootBuf()
				.toString());
		saveFile(path);
		return resList();
	}

	private void editFile(String path) {
		File tpl = new File(path);
		tplName = tpl.getName();
		parentPath = relPath.substring(0, relPath.lastIndexOf(FILE_SPT));
		try {
			tplContent = FileUtils.readFileToString(tpl, ENCODING);
		} catch (IOException e) {
			log.error("读取模板文件失败", e);
			addActionError("读取模板文件失败!");
		}
	}

	public String edit() {
		String path = contextPvd.getAppRealPath(getWeb().getTplRoot().append(
				relPath).toString());
		editFile(path);
		// 设置上传规则
		addUploadRule();
		return EDIT;
	}

	public String resEdit() {
		String path = contextPvd.getAppRealPath(getWeb().getResRootBuf()
				.append(relPath).toString());
		editFile(path);
		return EDIT;
	}

	private boolean updateFile(String path) {
		File tpl = new File(path);
		File newFile = tpl;
		if (!tpl.getName().equals(tplName)) {
			newFile = new File(tpl.getParent() + FILE_SPT + tplName);
			tpl.renameTo(newFile);
		}
		try {
			FileUtils.writeStringToFile(newFile, tplContent, ENCODING);
			jsonRoot.put("success", true);
			jsonRoot.put("msg", "保存成功");
			return true;
		} catch (IOException e) {
			log.error("写文件失败", e);
			jsonRoot.put("success", false);
			jsonRoot.put("msg", "写文件失败！");
			return false;
		}
	}

	public String update() {
		String path = contextPvd.getAppRealPath(getWeb().getTplRoot().append(
				relPath).toString());
		if (updateFile(path)) {
			removeUploadRule();
		}
		return SUCCESS;
	}

	public String resUpdate() {
		String path = contextPvd.getAppRealPath(getWeb().getResRootBuf()
				.append(relPath).toString());
		updateFile(path);
		return SUCCESS;
	}

	private void renameFile(String path) {
		File tpl = new File(path);
		if (!origName.equals(tplName)) {
			boolean b = tpl.renameTo(new File(tpl.getParent() + FILE_SPT
					+ tplName));
			if (!b) {
				jsonRoot.put("success", false);
			}
		}
		jsonRoot.put("success", true);
	}

	public String rename() {
		String path = contextPvd.getAppRealPath(getWeb().getTplRoot().append(
				relPath).append(SPT).append(origName).toString());
		renameFile(path);
		return SUCCESS;
	}

	public String resRename() {
		String path = contextPvd.getAppRealPath(getWeb().getResRootBuf()
				.append(relPath).append(SPT).append(origName).toString());
		renameFile(path);
		return SUCCESS;
	}

	private void deleteFile(String path) {
		File tpl = new File(path);
		if (FileUtils.deleteQuietly(tpl)) {
			addActionError("删除成功！");
		} else {
			addActionError("删除失败！");
		}
	}

	public String delete() {
		String path = contextPvd.getAppRealPath(getWeb().getTplRoot().append(
				relPath).append(SPT).append(tplName).toString());
		deleteFile(path);
		return list();
	}

	public String resDelete() {
		String path = contextPvd.getAppRealPath(getWeb().getResRootBuf()
				.append(relPath).append(SPT).append(tplName).toString());
		deleteFile(path);
		return resList();
	}

	public String createDir() {
		String path = contextPvd.getAppRealPath(getWeb().getTplRoot().append(
				relPath).append(SPT).append(dirName).toString());
		File dir = new File(path);
		dir.mkdir();
		return list();
	}

	public String resCreateDir() {
		String path = contextPvd.getAppRealPath(getWeb().getResRootBuf()
				.append(relPath).append(SPT).append(dirName).toString());
		File dir = new File(path);
		dir.mkdir();
		return resList();
	}

	public String resUpload() {
		return "upload";
	}

	public String resUploadSubmit() {
		String path = contextPvd.getAppRealPath(getWeb().getResRootBuf()
				.append(relPath).append(SPT).toString());
		if (resFile != null) {
			try {
				for (int i = 0; i < resFile.length; i++) {
					FileUtils.copyFile(resFile[i], new File(path + FILE_SPT
							+ resFileFileName[i]));
				}
				addActionMessage("上传成功！");
			} catch (IOException e) {
				addActionError("上传失败！" + e.getMessage());
			}
		}
		return resList();
	}

	public String solutionEdit() {
		// 数据库和目录中都有的模板套件才显示
		// 数据库中模板方案
		solMap = getWeb().getSolutions();
		// 模板目录中模板方案
		dirMap = new LinkedHashMap<String, String[]>();
		String path = contextPvd.getAppRealPath(getWeb().getTplRoot()
				.toString());
		File[] tplFiles = new File(path).listFiles(ComUtils.DIR_FILE_FILTER);
		for (File f : tplFiles) {
			if (solMap.containsKey(f.getName())) {
				dirMap.put(f.getName(), f.list(ComUtils.DIR_FILE_FILTER));
			}
		}
		return "solution";
	}

	public String solutionUpdate() {
		Map<String, String> smap = getWeb().getSolutions();
		for (String key : smap.keySet()) {
			String s = solMap.get(key);
			if (s != null) {
				smap.put(key, s);
			}
		}
		addActionMessage("操作成功");
		return solutionEdit();
	}

	public String exportTpl() {
		solSet = new LinkedHashSet<String>();
		solMap = getWeb().getSolutions();
		String path = contextPvd.getAppRealPath(getWeb().getTplRoot()
				.toString());
		File[] sysDirs = new File(path).listFiles(ComUtils.DIR_FILE_FILTER);
		for (File sysDir : sysDirs) {
			if (solMap.containsKey(sysDir.getName())) {
				for (File sol : sysDir.listFiles(ComUtils.DIR_FILE_FILTER)) {
					solSet.add(sol.getName());
				}
			}
		}
		return "exportTpl";
	}

	public String exportTplSubmit() {
		if (solSet == null || solSet.isEmpty()) {
			addActionError("请选择要导出的模板");
			return exportTpl();
		}
		String path = contextPvd.getAppRealPath(getWeb().getTplRoot()
				.toString());
		// 模板 系统目录集
		File[] sysDirs = new File(path).listFiles(ComUtils.DIR_FILE_FILTER);
		List<FileEntry> fileEntrys = new ArrayList<FileEntry>();
		String prefix = null;
		for (File sysDir : sysDirs) {
			for (File solDir : sysDir.listFiles(ComUtils.DIR_FILE_FILTER)) {
				if (solSet.contains(solDir.getName())) {
					prefix = sysDir.getName() + "-";
					fileEntrys.add(new FileEntry("", prefix, solDir));
				}
			}
		}
		solMap = getWeb().getSolutions();
		path = contextPvd.getAppRealPath(getWeb().getResRootBuf().toString());
		File[] solDirs = new File(path).listFiles(ComUtils.DIR_FILE_FILTER);
		for (File solDir : solDirs) {
			if (!solSet.contains(solDir.getName())) {
				continue;
			}
			for (File sysDir : solDir.listFiles()) {
				fileEntrys.add(new FileEntry(solDir.getName() + SPT + "${root}"
						+ SPT + solDir.getName(), sysDir));
			}

		}
		HttpServletResponse response = contextPvd.getResponse();
		response.setContentType("application/zip");
		response.addHeader("Content-disposition", "filename=template.zip");
		try {
			Zipper.zip(response.getOutputStream(), fileEntrys);
		} catch (IOException e) {
			log.error("导出模板失败！", e);
		}
		return null;
	}

	public String importTpl() {
		return "importTpl";
	}

	@SuppressWarnings("unchecked")
	public String importTplSubmit() {
		if (tplsFile == null) {
			addActionError("请上传模板文件！");
			return "importTpl";
		}
		if (!tplsFileFileName.toLowerCase().endsWith(".zip")) {
			addActionError("请使用zip格式的模板压缩包！");
		}
		String tplPath = contextPvd.getAppRealPath(getWeb().getTplRoot()
				.toString());
		String resPath = contextPvd.getAppRealPath(getWeb().getResRootBuf()
				.toString());
		try {
			ZipFile zip = new ZipFile(tplsFile);
			Enumeration<ZipEntry> en = zip.getEntries();
			ZipEntry entry = null;
			String name = null;
			String fileName = null;
			File outFile = null;
			File pfile = null;
			byte[] buf = new byte[1024];
			int len = 0;
			InputStream is = null;
			OutputStream os = null;
			int index = -1;
			int findex = -1;
			int mindex = -1;
			while (en.hasMoreElements()) {
				entry = en.nextElement();
				if (!entry.isDirectory()) {
					name = entry.getName();
					log.debug("解压zip文件：{}", name);
					// 模板还是资源
					if ((index = name.indexOf("${root}")) != -1) {
						fileName = resPath + name.substring(index + 7);
					} else {
						findex = name.indexOf(SPT);
						index = name.lastIndexOf(SPT);
						mindex = name.indexOf('-', index);
						// 系统/方案/文件
						fileName = tplPath + name.substring(index, mindex)
								+ FILE_SPT + name.substring(0, findex + 1)
								+ name.substring(mindex + 1);
					}
					fileName = fileName.replace(SPT, FILE_SPT);
					log.debug("解压地址：{}", fileName);
					outFile = new File(fileName);
					pfile = outFile.getParentFile();
					if (!pfile.exists()) {
						pfile.mkdirs();
					}
					try {
						is = zip.getInputStream(entry);
						os = new FileOutputStream(outFile);
						while ((len = is.read(buf)) != -1) {
							os.write(buf, 0, len);
						}
					} finally {
						if (is != null) {
							is.close();
							is = null;
						}
						if (os != null) {
							os.close();
							os = null;
						}
					}
				}
			}
			addActionMessage("导入模板成功");
		} catch (IOException e) {
			log.error("导入模板时IO错误！", e);
			addActionError("导入模板时IO错误！");
		}
		return "importTpl";
	}

	private void addUploadRule() {
		// 设置上传规则
		UploadRule rule = new UploadRule(getWeb().getResRoot(), "", false,
				false, false);
		uploadRuleId = rule.hashCode();
		contextPvd.setSessionAttr(UploadRule.KEY + uploadRuleId, rule);
	}

	private void removeUploadRule() {
		// 清除上传规则
		contextPvd.removeAttribute(UploadRule.KEY + uploadRuleId);
	}

	private Map<String, Object> jsonRoot = new HashMap<String, Object>();
	private FileWrap treeRoot;
	private FileWrap resRoot;
	private String relPath;
	private String parentPath;
	private String tplContent;
	private String tplName;
	private String dirName;
	private String origName;
	private List<FileWrap> subDir;

	private File[] resFile;
	private String[] resFileContentType;
	private String[] resFileFileName;

	private File tplsFile;
	private String tplsFileContentType;
	private String tplsFileFileName;

	private Map<String, String[]> dirMap;
	private Map<String, String> solMap;
	private Set<String> solSet;
	private InputStream inputStream;

	private int uploadRuleId;

	public FileWrap getTreeRoot() {
		return treeRoot;
	}

	public void setTreeRoot(FileWrap treeRoot) {
		this.treeRoot = treeRoot;
	}

	public String getTplContent() {
		return tplContent;
	}

	public void setTplContent(String tplContent) {
		this.tplContent = tplContent;
	}

	public String getTplName() {
		return tplName;
	}

	public void setTplName(String tplName) {
		this.tplName = tplName;
	}

	public String getRelPath() {
		return relPath;
	}

	public void setRelPath(String relPath) {
		this.relPath = relPath;
	}

	public Map<String, Object> getJsonRoot() {
		return jsonRoot;
	}

	public void setJsonRoot(Map<String, Object> jsonRoot) {
		this.jsonRoot = jsonRoot;
	}

	public List<FileWrap> getSubDir() {
		return subDir;
	}

	public void setSubDir(List<FileWrap> subDir) {
		this.subDir = subDir;
	}

	public String getOrigName() {
		return origName;
	}

	public void setOrigName(String origName) {
		this.origName = origName;
	}

	public String getDirName() {
		return dirName;
	}

	public void setDirName(String dirName) {
		this.dirName = dirName;
	}

	public String getParentPath() {
		return parentPath;
	}

	public void setParentPath(String parentPath) {
		this.parentPath = parentPath;
	}

	public FileWrap getResRoot() {
		return resRoot;
	}

	public void setResRoot(FileWrap resRoot) {
		this.resRoot = resRoot;
	}

	public java.io.File[] getResFile() {
		return resFile;
	}

	public void setResFile(java.io.File[] resFile) {
		this.resFile = resFile;
	}

	public String[] getResFileContentType() {
		return resFileContentType;
	}

	public void setResFileContentType(String[] resFileContentType) {
		this.resFileContentType = resFileContentType;
	}

	public String[] getResFileFileName() {
		return resFileFileName;
	}

	public void setResFileFileName(String[] resFileFileName) {
		this.resFileFileName = resFileFileName;
	}

	public Map<String, String[]> getDirMap() {
		return dirMap;
	}

	public void setDirMap(Map<String, String[]> dirMap) {
		this.dirMap = dirMap;
	}

	public Map<String, String> getSolMap() {
		return solMap;
	}

	public void setSolMap(Map<String, String> solMap) {
		this.solMap = solMap;
	}

	public Set<String> getSolSet() {
		return solSet;
	}

	public void setSolSet(Set<String> solSet) {
		this.solSet = solSet;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public File getTplsFile() {
		return tplsFile;
	}

	public void setTplsFile(File tplsFile) {
		this.tplsFile = tplsFile;
	}

	public String getTplsFileContentType() {
		return tplsFileContentType;
	}

	public void setTplsFileContentType(String tplsFileContentType) {
		this.tplsFileContentType = tplsFileContentType;
	}

	public String getTplsFileFileName() {
		return tplsFileFileName;
	}

	public void setTplsFileFileName(String tplsFileFileName) {
		this.tplsFileFileName = tplsFileFileName;
	}

	public int getUploadRuleId() {
		return uploadRuleId;
	}

	public void setUploadRuleId(int uploadRuleId) {
		this.uploadRuleId = uploadRuleId;
	}
}
