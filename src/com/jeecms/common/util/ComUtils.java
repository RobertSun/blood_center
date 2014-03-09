package com.jeecms.common.util;

import java.io.File;
import java.io.FilenameFilter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * ���ø���
 *
 * ��һЩ��ɢ�ı�ݷ�����
 *
 * @author liufang
 *
 */
public class ComUtils {
	public static final String JSESSION_COOKIE = "JSESSIONID";
	public static final String JSESSION_URL = "jsessionid";

	/**
	 * ��õ�ǰʱ�䡣����freemarker�����ڱ����о������ͣ�����ʹ��timestamp��
	 *
	 * @return
	 */
	public static java.sql.Timestamp now() {
		return new java.sql.Timestamp(System.currentTimeMillis());
	}

	/**
	 * ��ʽ�����ڡ�yyyy-MM-dd
	 *
	 * @param date
	 * @return
	 */
	public static String dateFormat(Date date) {
		return format.format(date);
	}

	/**
	 * ��ʽ�����ڡ�yyyy-MM-dd hh-mm-ss
	 *
	 * @param date
	 * @return
	 */
	public static String dataFormatWhole(Date date) {
		return formatw.format(date);
	}

	public static String formatDate(Date date, int style) {
		if (date == null) {
			return "";
		}
		switch (style) {
		case 5:
			return formatws.format(date);
		case 4:
			return formats.format(date);
		case 3:
			return formatm.format(date);
		case 2:
			return format.format(date);
		default:
			return formatw.format(date);
		}
	}

	public static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	public static final DateFormat formatw = new SimpleDateFormat(
			"yyyy-MM-dd HH:mm:ss");
	public static final DateFormat formatm = new SimpleDateFormat("MM-dd HH:mm");
	public static final DateFormat formats = new SimpleDateFormat("MM-dd");
	public static final DateFormat formatws = new SimpleDateFormat("yyyyMMddHHmmss");
	public static FilenameFilter DIR_FILE_FILTER = new FilenameFilter() {
		public boolean accept(File dir, String name) {
			if (dir.isDirectory()) {
				return true;
			} else {
				return false;
			}
		}
	};

	/**
	 * date -> XMLGregorianCalendar
	 *
	 * @param date
	 * @return XMLGregorianCalendar
	 * @throws DatatypeConfigurationException
	 */
	@SuppressWarnings("static-access")
	public static XMLGregorianCalendar getXMLGregorianCalendar(java.util.Date date) throws DatatypeConfigurationException
	{
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		DatatypeFactory dtf = DatatypeFactory.newInstance();
		return dtf.newXMLGregorianCalendar(
		calendar.get(calendar.YEAR),
		calendar.get(calendar.MONTH)+1,
		calendar.get(calendar.DAY_OF_MONTH),
		calendar.get(calendar.HOUR),
		calendar.get(calendar.MINUTE),
		calendar.get(calendar.SECOND),
		calendar.get(calendar.MILLISECOND),
		calendar.get(calendar.ZONE_OFFSET)/(1000*60));
	}
}
