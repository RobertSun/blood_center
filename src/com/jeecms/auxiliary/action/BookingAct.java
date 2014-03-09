package com.jeecms.auxiliary.action;

import java.util.ArrayList;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;

import org.dlbc.ws.ArrayOfReserveLinkModesDic;
import org.dlbc.ws.DonAppRecordInfo;
import org.dlbc.ws.NetAppRecordInfo;
import org.dlbc.ws.NetAppReturnInfo;
import org.dlbc.ws.ReserveInfo;
import org.dlbc.ws.ReserveLinkModesDic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;

import com.jeecms.auxiliary.entity.Booking;
import com.jeecms.auxiliary.entity.Msg;
import com.jeecms.auxiliary.manager.BookingMng;
import com.jeecms.common.util.ComUtils;
import com.jeecms.ws.service.NIWebServiceManager;

@SuppressWarnings({ "serial", "unchecked" })
@Scope("prototype")
@Controller("auxiliary.bookingAct")
public class BookingAct extends com.jeecms.auxiliary.AuxiSysAction {
	private static final Logger log = LoggerFactory.getLogger(BookingAct.class);

	public String list() {
		this.pagination = bookingMng.getPage(getWebId(), pageNo, getCookieCount());
		return LIST;
	}

	public String edit() throws DatatypeConfigurationException {
		bean = bookingMng.findById(id);

		// ��װ�ϴ���
		NetAppRecordInfo netAppRecordInfo = checkAppArchives(bean);
		// ��վ���ͨ����ϴ�ԤԼ��¼�ӿ�
		NIWebServiceManager wsMng = new NIWebServiceManager();
		NetAppReturnInfo netAppReturnInfo = wsMng.insertAppInfo(netAppRecordInfo);


		if("0".equals(netAppReturnInfo.getStatus())){
			// ԤԼ�ɹ�
			bean.setAppState(1);
			bean.setErrInfo(netAppReturnInfo.getErrorInfo());
		}else{
			// ԤԼʧ��
			bean.setAppState(-1);
			bean.setErrInfo(netAppReturnInfo.getErrorInfo());
		}

		bean.setCheck(true);
		bean.setCheckTime(ComUtils.now());

		bookingMng.updateDefault(bean);
		log.info("��ѪԤԼ��{}", bean.getName());
		return list();
	}

	/**
	 * ��װ�ϴ���
	 * @param Booking
	 * @return NetAppRecordInfo
	 * @throws DatatypeConfigurationException
	 */
	private NetAppRecordInfo checkAppArchives(Booking booking) throws DatatypeConfigurationException {
		NetAppRecordInfo netAppRecordInfo = new NetAppRecordInfo();
		ReserveInfo reserveInfo = new ReserveInfo();
		ArrayOfReserveLinkModesDic arrayOfReserveLinkModesDic = new ArrayOfReserveLinkModesDic();
		List<ReserveLinkModesDic> reserveLinkModesDics = new ArrayList<ReserveLinkModesDic>();
		DonAppRecordInfo donAppRecordInfo = new DonAppRecordInfo();

		reserveInfo.setIdentityTypeID(booking.getPapersType());
		reserveInfo.setIdentityCode(booking.getPapersNumber());
		reserveInfo.setName(booking.getName());
		reserveInfo.setSexID(booking.getSex());
		reserveInfo.setBirthday(ComUtils.getXMLGregorianCalendar(booking.getBirthday()));
		reserveInfo.setABO("");
		reserveInfo.setRHD("");
		netAppRecordInfo.setReserveInfo(reserveInfo);

		if(booking.getMobile() != null && booking.getMobile().length() > 0){
			// �ֻ� ID=1
			ReserveLinkModesDic reserveLinkModesDic = new ReserveLinkModesDic();
			reserveLinkModesDic.setLinkModeID("1");
			reserveLinkModesDic.setLinkValue(booking.getMobile());
			reserveLinkModesDics.add(reserveLinkModesDic);
		}

		if(booking.getTelephone() != null && booking.getTelephone().length() > 0){
			// �̶��绰 ID=14
			ReserveLinkModesDic reserveLinkModesDic = new ReserveLinkModesDic();
			reserveLinkModesDic.setLinkModeID("14");
			reserveLinkModesDic.setLinkValue(booking.getTelephone());
			reserveLinkModesDics.add(reserveLinkModesDic);
		}

		if(booking.getQq() != null && booking.getQq().length() > 0){
			// QQ���� ID=8
			ReserveLinkModesDic reserveLinkModesDic = new ReserveLinkModesDic();
			reserveLinkModesDic.setLinkModeID("8");
			reserveLinkModesDic.setLinkValue(booking.getQq());
			reserveLinkModesDics.add(reserveLinkModesDic);
		}
		arrayOfReserveLinkModesDic.setReserveLinkModesDic(reserveLinkModesDics);
		netAppRecordInfo.setReserveLinkModes(arrayOfReserveLinkModesDic);

		donAppRecordInfo.setAppCollectPlaceID(booking.getPlace());
		donAppRecordInfo.setAppDonKindID(booking.getDonateBloodType());
		donAppRecordInfo.setAppDonBeginDate(ComUtils.getXMLGregorianCalendar(booking.getStartDate()));
		donAppRecordInfo.setAppDonEndDate(ComUtils.getXMLGregorianCalendar(booking.getEndDate()));
		donAppRecordInfo.setLinkTypeID(reserveLinkModesDics.get(0).getLinkModeID());
		donAppRecordInfo.setPhone(reserveLinkModesDics.get(0).getLinkValue());
		donAppRecordInfo.setNetAppID(ComUtils.formatDate(ComUtils.now(), 5));
		netAppRecordInfo.setDonAppRecordInfo(donAppRecordInfo);

        return netAppRecordInfo;
    }

	public String delete() {
		try {
			for (Booking o : bookingMng.deleteById(ids)) {
				log.info("ԤԼɾ��ɹ�:{}", o.getName());
			}
		} catch (DataIntegrityViolationException e) {
			addActionError("��¼�ѱ����ã�����ɾ��!");
			return SHOW_ERROR;
		}
		return list();
	}

	public boolean validateDelete() {
		if (hasErrors()) {
			return true;
		}
		if (vldBatch()) {
			return true;
		}
		for (Long id : ids) {
			if (vldExist(id)) {
				return true;
			}
			if (vldWebsite(id, null)) {
				return true;
			}
		}
		return false;
	}

	private boolean vldExist(Long id) {
		Booking entity = bookingMng.findById(id);
		if (entity == null) {
			addActionError("��ݲ����ڣ�" + id);
			return true;
		}
		return false;
	}

	private boolean vldWebsite(Long id, Msg bean) {
		Booking entity = bookingMng.findById(id);
		if (!entity.getWebsite().equals(getWeb())) {
			addActionError("ֻ�ܹ��?վ����ݣ�" + id);
			return true;
		}
		if (bean != null) {
			bean.setWebsite(getWeb());
		}
		return false;
	}

	@Autowired
	private BookingMng bookingMng;
	private Booking bean;

	public Booking getBean() {
		return bean;
	}

	public void setBean(Booking bean) {
		this.bean = bean;
	}
}
