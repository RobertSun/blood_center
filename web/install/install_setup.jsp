<%@page contentType="text/html; charset=gbk" language="java" import="com.jeecms.core.util.*,java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>��װ���--JEECMS��װ��</title>
<link href="img/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<%
	String dbHost = request.getParameter("dbHost");
	String dbPort = request.getParameter("dbPort");
	String dbName = request.getParameter("dbName");
	String dbUser = request.getParameter("dbUser");
	String dbPassword = request.getParameter("dbPassword");

	String isCreateDb = request.getParameter("isCreateDb");
	String isCreateTable = request.getParameter("isCreateTable");
	String isInitData = request.getParameter("isInitData");
	String domain = request.getParameter("domain");
	String cxtPath = request.getParameter("cxtPath");
	String port = request.getParameter("port");

	String dbFileName = "/install/db/jeecms-db-2.4.2-final.sql";
	String initFileName = "/install/db/jeecms-init-2.4.2-final.sql";
	String dbXmlFileName = "/WEB-INF/classes/jdbc.properties";
	String webXmlFrom = "/install/config/web.xml";
	String webXmlTo = "/WEB-INF/web.xml";
	//�������ݿ�
	if ("true".equals(isCreateDb)) {
		Install.createDb(dbHost, dbPort, dbName, dbUser, dbPassword);
	} else {
		Install.changeDbCharset(dbHost, dbPort, dbName, dbUser, dbPassword);
	}
	//������
	if ("true".equals(isCreateTable)) {
		String sqlPath = application.getRealPath(dbFileName);
		List<String> sqlList = Install.readSql(sqlPath);
		Install.createTable(dbHost, dbPort, dbName, dbUser, dbPassword,
				sqlList);
	}
	//��ʼ������
	if ("true".equals(isInitData)) {
		String initPath = application.getRealPath(initFileName);
		List<String> initList = Install.readSql(initPath);
		Install.createTable(dbHost, dbPort, dbName, dbUser, dbPassword,
				initList);
	}
	//��������
	Install.updateConfig(dbHost, dbPort, dbName, dbUser, dbPassword,
			domain, cxtPath, port);
	//�������ݿ������ļ�
	String dbXmlPath = application.getRealPath(dbXmlFileName);
	Install
			.dbXml(dbXmlPath, dbHost, dbPort, dbName, dbUser,
					dbPassword);
	//����web.xml
	String webXmlFromPath = application.getRealPath(webXmlFrom);
	String webXmlToPath = application.getRealPath(webXmlTo);
	Install.webXml(webXmlFromPath, webXmlToPath);
%>

<table width="600" align="center"
	style="border: #106DBA 1px solid; margin-top: 8%;">
	<tr>
		<td bgcolor="#D1E9FA">
		<table width="100%" border="0" cellspacing="0" cellpadding="0">
			<tr>
				<td width="27%" height="60" rowspan="2" align="center"><img
					src="img/logo.gif" border="0" /></td>
				<td width="73%" height="30" class="f14b">3��ϵͳ��װ���</td>
			</tr>
			<tr>
				<td height="20" valign="top">&nbsp;&nbsp;&nbsp;&nbsp;��װϵͳ��װ��ɣ�������TOMCAT����</td>
			</tr>
		</table>
		</td>
	</tr>
	<tr>
		<td height="280" align="left" bgcolor="#F0F8FD"
			style="padding: 10px; line-height: 1.7em;">��ϲ����ϵͳ�Ѿ���װ�ɹ���<br />
		������TOMCAT����ֻ������TOMCAT����֮�󣬰�װ������Ч��<br />
		��̨��¼��ַ����վ��·��/login/Jeecms.do��<br />
		��̨����Աadmin������password��</td>
	</tr>
</table>

</body>
</html>
