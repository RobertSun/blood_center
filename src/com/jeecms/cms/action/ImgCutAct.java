package com.jeecms.cms.action;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.common.util.ImageScale;

/**
 * Í¼Æ¬¼ô²ÃAction
 * 
 * @author liufang
 * 
 */
@SuppressWarnings("serial")
@Scope("prototype")
@Controller("core.imgCutAct")
public class ImgCutAct extends com.jeecms.core.JeeCoreAction {
	private static final Logger log = LoggerFactory.getLogger(ImgCutAct.class);

	/**
	 * ´ò¿ªÍ¼Æ¬¼ôÇÐÆ÷
	 * 
	 * @return
	 */
	public String imgAreaSelect() {
		return SUCCESS;
	}

	/**
	 * ¼ô²ÃÍ¼Æ¬
	 * 
	 * @return
	 */
	public String imgCut() {
		String real = contextPvd.getAppRealPath(getWeb().getUploadRoot()
				+ imgSrcPath);
		try {
			File srcFile = new File(real);
			BufferedImage bufImg = ImageIO.read(srcFile);
			// ÐèÒª¼ô²ÃÍ¼Æ¬
			if (imgWidth > 0) {
				bufImg = bufImg.getSubimage(getLen(imgTop), getLen(imgLeft),
						getLen(imgWidth), getLen(imgHeight));
			}
			ImageScale.resizeFix(bufImg, srcFile, reMinWidth, reMinHeight);
			log.info("Í¼Æ¬¼ô²Ã³É¹¦£º{}", real);
			return SUCCESS;
		} catch (IOException e) {
			error = "¼ô²ÃÍ¼Æ¬Ê§°Ü!";
			log.error("¼ô²ÃÍ¼Æ¬³ö´í", e);
			return SUCCESS;
		}
	}

	private int getLen(int len) {
		return Math.round(len / imgScale);
	}

	private String imgSrcRoot;
	private String imgSrcPath;
	private int zoomWidth;
	private int zoomHeight;

	private int reMinWidth;
	private int reMinHeight;
	private float imgScale;
	private int imgWidth;
	private int imgHeight;
	private int imgTop;
	private int imgLeft;

	private int uploadNum = 1;

	private String error;

	public String getImgSrcRoot() {
		return imgSrcRoot;
	}

	public void setImgSrcRoot(String imgSrcRoot) {
		this.imgSrcRoot = imgSrcRoot;
	}

	public String getImgSrcPath() {
		return imgSrcPath;
	}

	public void setImgSrcPath(String imgSrcPath) {
		this.imgSrcPath = imgSrcPath;
	}

	public int getZoomWidth() {
		return zoomWidth;
	}

	public void setZoomWidth(int zoomWidth) {
		this.zoomWidth = zoomWidth;
	}

	public int getZoomHeight() {
		return zoomHeight;
	}

	public void setZoomHeight(int zoomHeight) {
		this.zoomHeight = zoomHeight;
	}

	public int getReMinWidth() {
		return reMinWidth;
	}

	public void setReMinWidth(int reMinWidth) {
		this.reMinWidth = reMinWidth;
	}

	public int getReMinHeight() {
		return reMinHeight;
	}

	public void setReMinHeight(int reMinHeight) {
		this.reMinHeight = reMinHeight;
	}

	public float getImgScale() {
		return imgScale;
	}

	public void setImgScale(float imgScale) {
		this.imgScale = imgScale;
	}

	public int getImgWidth() {
		return imgWidth;
	}

	public void setImgWidth(int imgWidth) {
		this.imgWidth = imgWidth;
	}

	public int getImgHeight() {
		return imgHeight;
	}

	public void setImgHeight(int imgHeight) {
		this.imgHeight = imgHeight;
	}

	public int getImgTop() {
		return imgTop;
	}

	public void setImgTop(int imgTop) {
		this.imgTop = imgTop;
	}

	public int getImgLeft() {
		return imgLeft;
	}

	public void setImgLeft(int imgLeft) {
		this.imgLeft = imgLeft;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getUploadNum() {
		return uploadNum;
	}

	public void setUploadNum(int uploadNum) {
		this.uploadNum = uploadNum;
	}

}
