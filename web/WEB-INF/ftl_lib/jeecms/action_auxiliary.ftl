<#--
�����б�
	ctgId������������ID����Ĭ��ȫ����
	recommend���Ƿ��Ƽ�����0��ȫ����2���Ƽ����ԡ���Ĭ��0��
	orderBy������ʽ����0������ʱ����µ��ɣ�1������ʱ��Ӿɵ��£�����Ĭ��0��

	firstResult����һ����¼����Ĭ��0��
	count����¼������Ĭ��20��
	isPage���Ƿ��ҳ����0������ҳ��1����ҳ����Ĭ��0��
	pageNo��ҳ�š���Ĭ�ϵ�ǰҳ��

	cssClass������class
	cssStyle������style
	
	style����ǩ�ڲ���ʽ�����ָ��sysContent��userContent���������Ч����1����ͨ�б�����Ĭ��1��
	
	inner���Ƿ�ʹ�ñ�ǩ��ֱ�ӱ�дhtml���롣��0����1���ǡ���Ĭ��0��
	isLoop�������Ƿ�ѭ������0����ѭ����1��ѭ������Ĭ��1��
	
	sysTpl��ʹ��ϵͳģ�塣��0����ʹ�ã�1��ʹ�á���Ĭ��1��
	sysContent��ϵͳ������ʽ����Ĭ��0��
	userContent���Զ��������ļ��������ָ����ϵͳ������ʽ���������Ч����Ĭ�Ͽգ�
	sysPage��ϵͳ��ҳ��ʽ����0������ҳ��1����ʽһ��2����ʽ������Ĭ��0��
	userPage���Զ����ҳ��ʽ�ļ��������ָ����ϵͳ��ҳ��ʽ���������Ч����Ĭ�Ͽգ�
	custom���ַ������顣���ڸ��Ի�������Ĭ�Ͽ����飩
-->
<#macro MsgList method="/jeecms/tag/auxiliary" ctgId="" recommend="0" orderBy="0"
	isPage="0" count="20" firstResult="0" pageNo=pageNo
	style="1" inner="0" isLoop="1" sysTpl="1" cssClass="" cssStyle="" custom=[]
	sysContent="0" userContent="" sysPage="0" userPage="">
<#if inner=="0">
	<@s.action name="MsgList" namespace=method executeResult="true"
		ctgId=ctgId recommend=recommend orderBy=orderBy
		isPage=isPage count=count firstResult=firstResult pageNo=pageNo
		style=style sysTpl=sysTpl cssClass=cssClass cssStyle=cssStyle custom=custom
		sysContent=sysContent userContent=userContent sysPage=sysPage userPage=userPage
		/>
<#else>
	<@s.action name="MsgListInner" namespace="/jeecms/tag/auxiliary" executeResult="false"
		ctgId=ctgId recommend=recommend orderBy=orderBy
		isPage=isPage count=count firstResult=firstResult pageNo=pageNo
		/>
	<#if isLoop=="1">
  		<#list n_pagination.list as item>
			<#nested item,item_index,item_has_next/>
		</#list>
	<#else>
		<#nested n_pagination/>
	</#if>
</#if>
</#macro>

<#--
��������б�inner��ǩ��
	isLoop�������Ƿ�ѭ������0����ѭ����1��ѭ������Ĭ��1��
-->
<#macro MsgCtgList isLoop="1">
<@s.action name="MsgCtgListInner" namespace="/jeecms/tag/auxiliary" executeResult="false"/>
<#if isLoop=="1">
	<#list n_list as item>
		<#nested item,item_index,item_has_next/>
	</#list>
<#else>
	<#nested n_list/>
</#if>
</#macro>

<#--
��������б�inner��ǩ��
	id��ͶƱID����Ĭ��Ϊ����ͶƱ��
	#inner���Ƿ�ʹ�ñ�ǩ��ֱ�ӱ�дhtml���롣��0����1���ǡ���Ĭ��0��
-->
<#macro VoteTopic id="-1"
	style="1" inner="0" sysTpl="1" cssClass="" cssStyle="" custom=[]>
<#if inner=="0">
	<#local customs = "">
	<#list custom as s>
		<#local customs = customs+s>
		<#if s_has_next><#local customs = customs+"|"></#if>
	</#list>
	<@s.action name="VoteTopic" namespace="/jeecms/tag/auxiliary" executeResult="true"
		topicId=id
		style=style sysTpl=sysTpl cssClass=cssClass cssStyle=cssStyle customs=customs
	>
	</@s.action>
<#else>
	inner=1��δʵ��
	<#--<#nested n_bean/>-->
</#if>
</#macro>