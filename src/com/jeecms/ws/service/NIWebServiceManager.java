package com.jeecms.ws.service;

import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.dlbc.ws.CollectPlaceDic;
import org.dlbc.ws.NIWebService;
import org.dlbc.ws.NIWebServiceSoap;
import org.dlbc.ws.NetAppRecordInfo;
import org.dlbc.ws.NetAppReturnInfo;
import org.dlbc.ws.NetSearchTestResultInfo;
import org.dlbc.ws.handler.HeaderHandlerResolver;

import com.jeecms.auxiliary.entity.Booking;
import com.jeecms.common.util.ComUtils;

public class NIWebServiceManager {
	private NIWebService service;
	private NIWebServiceSoap port;
	
	public NIWebServiceManager(){
		if(this.service == null){
			this.service = new NIWebService();
			this.service.setHandlerResolver(new HeaderHandlerResolver());
		}
		if(this.port == null){
			this.port = this.service.getNIWebServiceSoap();
		}
	}
	
	/**
	 * 验证网上预约人员是否满足预约要求
	 * @param Booking
	 * @return NetAppReturnInfo
	 * @throws DatatypeConfigurationException, DatatypeConfigurationException
	 */
	public NetAppReturnInfo checkAppArchives(Booking booking) throws DatatypeConfigurationException,DatatypeConfigurationException {
        NetAppReturnInfo netAppReturnInfo = port.checkAppArchives(booking.getPapersType(), booking.getPapersNumber(), 
        		booking.getName(), booking.getSex(), ComUtils.getXMLGregorianCalendar(booking.getBirthday()));
        return netAppReturnInfo;
    }
	
	/**
	 * 验证网上预约记录是否满足献血间隔
	 * @param Booking
	 * @return NetAppReturnInfo
	 * @throws DatatypeConfigurationException, DatatypeConfigurationException
	 */
	public NetAppReturnInfo checkAppInterval(Booking booking) throws DatatypeConfigurationException,DatatypeConfigurationException {
        NetAppReturnInfo netAppReturnInfo = port.checkAppInterval(booking.getPapersType(), booking.getPapersNumber(), 
        		booking.getName(), booking.getSex(), ComUtils.getXMLGregorianCalendar(booking.getBirthday()), 
        		booking.getDonateBloodType(), ComUtils.getXMLGregorianCalendar(booking.getStartDate()), 
        		ComUtils.getXMLGregorianCalendar(booking.getEndDate()));
        return netAppReturnInfo;
    }
	
	/**
	 * 网站审核通过后上传预约记录接口
	 * @param NetAppRecordInfo
	 * @return NetAppReturnInfo
	 * @throws 
	 */
	public NetAppReturnInfo insertAppInfo(NetAppRecordInfo netAppRecordInfo) {
		NetAppReturnInfo netAppReturnInfo = port.insertAppInfo(netAppRecordInfo);
        return netAppReturnInfo;
    }
	
	/**
	 * 获取献血管理系统所有采血地点列表
	 * @param 
	 * @return List<CollectPlaceDic>
	 * @throws 
	 */
	public List<CollectPlaceDic> getCollectPlaceList() {
		List<CollectPlaceDic> places = port.getCollectPlaceList().getCollectPlaceDic();
        return places;
    }
	
	/**
	 * 根据献血码获取检验结果验证码
	 * @param String donCode
	 * @return NetSearchTestResultInfo
	 * @throws 
	 */
	public NetSearchTestResultInfo getTestResultSearchVerifyCodeByDonCode(String donCode) {
		NetSearchTestResultInfo netSearchTestResultInfo = port.getTestResultSearchVerifyCodeByDonCode(donCode);
        return netSearchTestResultInfo;
    }
	
	/**
	 * 根据献血码、验证码获取检验结果
	 * @param String donCode
	 * @param String verifyCode
	 * @return NetSearchTestResultInfo
	 * @throws 
	 */
	public NetSearchTestResultInfo getTestResultByDonCode(String donCode, String verifyCode) {
		NetSearchTestResultInfo netSearchTestResultInfo = port.getTestResultByDonCode(donCode, verifyCode);
        return netSearchTestResultInfo;
    }
	
	/**
	 * 根据证件类型、证件号码获取检验结果验证码
	 * @param String idTypeID
	 * @param String idCode
	 * @return NetSearchTestResultInfo
	 * @throws 
	 */
	public NetSearchTestResultInfo getTestResultSearchVerifyCodeByIdCode(String idTypeID, String idCode) {
		NetSearchTestResultInfo netSearchTestResultInfo = port.getTestResultSearchVerifyCodeByIdCode(idTypeID, idCode);
        return netSearchTestResultInfo;
    }
	
	/**
	 * 根据证件类型、证件号码获取检验结果
	 * @param String idTypeID
	 * @param String idCode
	 * @param String verifyCode
	 * @return NetSearchTestResultInfo
	 * @throws 
	 */
	public NetSearchTestResultInfo getTestResultByIdCode(String idTypeID, String idCode, String verifyCode) {
		NetSearchTestResultInfo netSearchTestResultInfo = port.getTestResultByIdCode(idTypeID, idCode, verifyCode);
        return netSearchTestResultInfo;
    }
}
