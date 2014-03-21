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
	 * ��֤����ԤԼ��Ա�Ƿ�����ԤԼҪ��
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
	 * ��֤����ԤԼ��¼�Ƿ�������Ѫ���
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
	 * ��վ���ͨ����ϴ�ԤԼ��¼�ӿ�
	 * @param NetAppRecordInfo
	 * @return NetAppReturnInfo
	 * @throws 
	 */
	public NetAppReturnInfo insertAppInfo(NetAppRecordInfo netAppRecordInfo) {
		NetAppReturnInfo netAppReturnInfo = port.insertAppInfo(netAppRecordInfo);
        return netAppReturnInfo;
    }
	
	/**
	 * ��ȡ��Ѫ����ϵͳ���в�Ѫ�ص��б�
	 * @param 
	 * @return List<CollectPlaceDic>
	 * @throws 
	 */
	public List<CollectPlaceDic> getCollectPlaceList() {
		List<CollectPlaceDic> places = port.getCollectPlaceList().getCollectPlaceDic();
        return places;
    }
	
	/**
	 * �����Ѫ���ȡ��������֤��
	 * @param String donCode
	 * @return NetSearchTestResultInfo
	 * @throws 
	 */
	public NetSearchTestResultInfo getTestResultSearchVerifyCodeByDonCode(String donCode) {
		NetSearchTestResultInfo netSearchTestResultInfo = port.getTestResultSearchVerifyCodeByDonCode(donCode);
        return netSearchTestResultInfo;
    }
	
	/**
	 * �����Ѫ�롢��֤���ȡ������
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
	 * ���֤�����͡�֤�������ȡ��������֤��
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
	 * ���֤�����͡�֤�������ȡ������
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
