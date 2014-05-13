package com.jeecms.auxiliary.action.front;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;

import org.dlbc.ws.CollectPlaceDic;
import org.dlbc.ws.NetAppReturnInfo;
import org.dlbc.ws.NetSearchTestResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.jeecms.auxiliary.AuxiIndeAction;
import com.jeecms.auxiliary.entity.Booking;
import com.jeecms.auxiliary.entity.BookingSearch;
import com.jeecms.auxiliary.entity.MsgCtg;
import com.jeecms.auxiliary.entity.ReturnMsg;
import com.jeecms.auxiliary.entity.VoteTopic;
import com.jeecms.auxiliary.entity.base.CollectPlace;
import com.jeecms.auxiliary.exception.VoteException;
import com.jeecms.auxiliary.manager.BookingMng;
import com.jeecms.auxiliary.manager.MsgCtgMng;
import com.jeecms.auxiliary.manager.VoteTopicMng;
import com.jeecms.common.struts2.ContextPvd;
import com.jeecms.common.util.ComUtils;
import com.jeecms.ws.service.NIWebServiceManager;

/**
 * ���԰����ģ��
 *
 * @author liufang
 *
 */
@Scope("prototype")
@Controller("auxiliary.auxiIndeAct")
public class AuxiIndeAct extends AuxiIndeAction {

	/**
	 * Booking
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String booking() {
		this.nowDay = ComUtils.now().getDate();
		getPlacesList();
		if(this.returnMsg == null){
			this.returnMsg = new ReturnMsg();
		}
		this.returnMsg.setReturnState("-1");
		this.returnMsg.setReturnMessage("");
		contextPvd.setSessionAttr("save_state", "-1");
		this.booking = new Booking();
		return handleResult("Booking");
	}

	/**
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public String bookingSave() throws Exception {

		this.nowDay = ComUtils.now().getDate();
		getPlacesList();
		if(this.returnMsg == null){
			this.returnMsg = new ReturnMsg();
		}

		if("0".equals(contextPvd.getSessionAttr("save_state"))){
			return "BookingBack";
		}

		NIWebServiceManager wsMng = new NIWebServiceManager();
		NetAppReturnInfo netAppReturnInfo = wsMng.checkAppArchives(booking);
		if(!"0".equals(netAppReturnInfo.getStatus())){
			this.returnMsg.setReturnState("1");
			this.returnMsg.setReturnMessage(netAppReturnInfo.getErrorInfo());
			contextPvd.setSessionAttr("booking_msg_key", this.returnMsg);

			return handleResult("Booking");
		}
		NetAppReturnInfo netAppReturnInfo2 = wsMng.checkAppInterval(booking);
		if(!"0".equals(netAppReturnInfo2.getStatus())){
			this.returnMsg.setReturnState("1");
			this.returnMsg.setReturnMessage(netAppReturnInfo2.getErrorInfo());
			contextPvd.setSessionAttr("booking_msg_key", this.returnMsg);

			return handleResult("Booking");
		}

		contextPvd.setSessionAttr("save_state", "-1");

		this.booking.setCreateTime(ComUtils.now());
		this.booking.setCheck(false);
		this.booking.setAppState(0);
		this.booking.setWebsite(getWeb());

		if(this.bookingMng.save(this.booking) != null){
			this.returnMsg.setReturnState("0");
			this.returnMsg.setReturnMessage("提交成功，请等待审核");
			contextPvd.setSessionAttr("save_state", "0");
		}else{
			this.returnMsg.setReturnState("1");
			this.returnMsg.setReturnMessage("预约失败");
		}
		contextPvd.setSessionAttr("booking_msg_key", this.returnMsg);

		return handleResult("Booking");
	}

	/**
	 * @return
	 */
	public String bookingBack() {
		if(contextPvd.getSessionAttr("booking_msg_key") == null){
			this.returnMsg = new ReturnMsg();
			this.returnMsg.setReturnState("-1");
			this.returnMsg.setReturnMessage("");
		}else{
			this.returnMsg = (ReturnMsg)contextPvd.getSessionAttr("booking_msg_key");
			contextPvd.removeAttribute("booking_msg_key");
		}

		return handleResult("BookingSave");
	}

	/**
	 * @return List<CollectPlace> places;
	 */
	private void getPlacesList() {
		this.places = new ArrayList<CollectPlace>();

		NIWebServiceManager wsMng = new NIWebServiceManager();

		List<CollectPlaceDic> placesDic = wsMng.getCollectPlaceList();

		for(CollectPlaceDic place : placesDic){
			CollectPlace cpd = new CollectPlace();
			cpd.setPlaceId(place.getID());
			cpd.setPlaceName(place.getName());
			this.places.add(cpd);
        }
	}

	/**
	 * @return
	 */
	public String searchTest() {
		if(this.returnMsg == null){
			this.returnMsg = new ReturnMsg();
		}
		this.returnMsg.setReturnState("-1");
		this.returnMsg.setReturnMessage("");
		return handleResult("SearchTest");
	}

	/**
	 * @return
	 */
	public String searchTestResult() {
		if(this.returnMsg == null){
			this.returnMsg = new ReturnMsg();
		}
		if(this.bookingSearch == null){
			return "SearchBack";
		}

		NIWebServiceManager wsMng = new NIWebServiceManager();
		NetSearchTestResultInfo netSearchTestResultinfo = new NetSearchTestResultInfo();
		if("1".equals(this.bookingSearch.getSearchType())){
			netSearchTestResultinfo = wsMng.getTestResultByDonCode(bookingSearch.getDonCode(), bookingSearch.getVerifyCodeDon());
		}else if("2".equals(this.bookingSearch.getSearchType())){
			netSearchTestResultinfo = wsMng.getTestResultByIdCode(bookingSearch.getIdTypeID(), bookingSearch.getIdCode(), bookingSearch.getVerifyCodeID());
		}

		if("0".equals(netSearchTestResultinfo.getStatus())){
			if("0".equals(netSearchTestResultinfo.getTestResultID())){
				this.returnMsg.setReturnMessage("���鲻�ϸ�!");
			}else if("1".equals(netSearchTestResultinfo.getTestResultID())){
				this.returnMsg.setReturnMessage("����ϸ�!");
			}else{
				this.returnMsg.setReturnMessage("�޼�����!");
			}
		}else{
			this.returnMsg.setReturnMessage(netSearchTestResultinfo.getErrorInfo());
		}
		this.returnMsg.setReturnState(netSearchTestResultinfo.getStatus());
		this.returnMsg.setArcID(netSearchTestResultinfo.getTestResultID());
		contextPvd.setSessionAttr("search_msg_key", this.returnMsg);

		return handleResult("SearchTest");
	}

	/**
	 * @return
	 */
	public String bookingSearchBack() {
		if(contextPvd.getSessionAttr("search_msg_key") == null){
			this.returnMsg = new ReturnMsg();
			this.returnMsg.setReturnState("-1");
			this.returnMsg.setReturnMessage("");
		}else{
			this.returnMsg = (ReturnMsg)contextPvd.getSessionAttr("search_msg_key");
			contextPvd.removeAttribute("search_msg_key");
		}

		return handleResult("SearchTestResult");
	}

	public String guestbook() {
		if (!getConfig().getMsgIsOpen()) {
			addActionMessage("���԰��ѹر�");
			return showMessage();
		}
		ctgList = msgCtgMng.getList(getWebId());

		if (null == msgCtgId && ctgList.size() > 0) {

			msgCtg = ctgList.get(0);
		} else {

			for (MsgCtg ctg : ctgList) {
				if (ctg.getId().equals(msgCtgId)) {
					msgCtg = ctg;
				}
			}
		}

		return handleResult("Guestbook");
	}

    private Long[] getItems(List<String> votes){
        Long[] items = new Long[votes.size()];
        for(int i=0; i < items.length; i ++){
            items[i] = Long.valueOf(votes.get(i));
        }
        return items;
    }
	public String voteResult() {
        beans = new ArrayList<VoteTopic>();
		Cookie cookie = contextPvd.getCookie(getWeb().getCookieKey());
		String cookieValue = null;
		if (cookie != null) {
			cookieValue = cookie.getValue();
		}
		try {
            Iterator<String> ids = items.keySet().iterator();
            while(ids.hasNext()){
                String id = ids.next();
                List<String> _votes = items.get(id);
                Long[] votes = getItems(_votes);
                beans.add(voteTopicMng.vote(Long.valueOf(id), votes, getMemberId(),
                            contextPvd.getRemoteIp(), cookieValue));
            }
		} catch (VoteException e) {
			error = e.getMessage();
		}
		return handleResult("VoteResult");
	}

	@Autowired
	private ContextPvd contextPvd;
	@Autowired
	private MsgCtgMng msgCtgMng;
	private List<MsgCtg> ctgList;

	@Autowired
	private VoteTopicMng voteTopicMng;
	@SuppressWarnings("unused")
	private VoteTopic bean;
    private List<VoteTopic> beans;
	private Long topicId;
	private Long[] voteItems;

    private Map<String, List<String>> items;

	private String error;
	private Long msgCtgId;
	private MsgCtg msgCtg;

	@Autowired
	private BookingMng bookingMng;
	private Booking booking;
	private BookingSearch bookingSearch;

	private int nowDay;
	private List<CollectPlace> places;

	private String msgId = "-1";
	private String msgStr = "";

	private ReturnMsg returnMsg;

	public ReturnMsg getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(ReturnMsg returnMsg) {
		this.returnMsg = returnMsg;
	}

	public BookingSearch getBookingSearch() {
		return bookingSearch;
	}

	public void setBookingSearch(BookingSearch bookingSearch) {
		this.bookingSearch = bookingSearch;
	}

	public String getMsgId() {
		return msgId;
	}

	public void setMsgId(String msgId) {
		this.msgId = msgId;
	}

	public String getMsgStr() {
		return msgStr;
	}

	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	public List<CollectPlace> getPlaces() {
		return places;
	}

	public void setPlaces(List<CollectPlace> places) {
		this.places = places;
	}

	public int getNowDay() {
		return nowDay;
	}

	public void setNowDay(int nowDay) {
		this.nowDay = nowDay;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public List<MsgCtg> getCtgList() {
		return ctgList;
	}

//	public VoteTopic getBean() {
//		return bean;
//	}
//
//	public void setBean(VoteTopic bean) {
//		this.bean = bean;
//	}

	public Long getTopicId() {
		return topicId;
	}

	public void setTopicId(Long topicId) {
		this.topicId = topicId;
	}

	public Long[] getVoteItems() {
		return voteItems;
	}

	public void setVoteItems(Long[] voteItems) {
		this.voteItems = voteItems;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Long getMsgCtgId() {
		return msgCtgId;
	}

	public void setMsgCtgId(Long msgCtgId) {
		this.msgCtgId = msgCtgId;
	}

	public MsgCtg getMsgCtg() {
		return msgCtg;
	}

	public void setMsgCtg(MsgCtg msgCtg) {
		this.msgCtg = msgCtg;
	}

    public Map<String, List<String>> getItems() {
        return items;
    }

    public void setItems(Map<String, List<String>> items) {
        this.items = items;
    }

    public List<VoteTopic> getBeans() {
        return beans;
    }
}