<#--
����Ŀ�б�
	id������ĿID����Ĭ�ϣ���ǰ��ĿID��
	orderBy������ʽ����0�����ȼ�����1�����ȼ�����2�������������3������������򡿣�Ĭ��0��
	isDisplay���Ƿ�ֻ��ȡ��ʾ����Ŀ����0����ȡ���У�1��ֻ��ȡ��ʾ����Ŀ����Ĭ��1��
	hasContent���Ƿ�ֻ��ȡ���������ݵ���Ŀ����0����ȡ���У�1��ֻ��ȡ���������ݵ���Ŀ����Ĭ��0��
	
	linkClass������class
	linkTarget�����Ӵ򿪷�ʽ����0����ǰ���ڣ�1���´��ڡ���Ĭ��0��
		
	style����ǩ�ڲ���ʽ�����ָ��sysContent��userContent���������Ч��
		��1����ͨ�����б�����Ĭ��1��
	
	sysTpl��ʹ��ϵͳģ�塣��0����ʹ�ã�1��ʹ�á���Ĭ��1��
	sysContent��ϵͳ������ʽ����Ĭ��0��
	userContent���Զ���������ʽ�����ָ����ϵͳ������ʽ���������Ч����Ĭ��0��
	sysPage��ϵͳ��ҳ��ʽ����0������ҳ��1����ʽһ��2����ʽ������Ĭ��0��
	userPage���Զ����ҳ��ʽ�����ָ����ϵͳ��ҳ��ʽ���������Ч����0������ҳ��1����ʽһ��2����ʽ������Ĭ��0��
	custom���ַ������顣���ڸ��Ի�������Ĭ�Ͽ����飩
-->
<#macro ChnlList id=chnl.id sysType='article' orderBy='0' isDisplay='1' hasContent='0'
	linkClass='' linkTarget='0'
	isPage='0' count='20' firstResult='0' pageNo=pageNo
	style='1' inner='0' isLoop='1' cssClass='' cssStyle='' showLinkStyle='1'
	sysTpl='1' sysContent='0' userContent='' sysPage='0' userPage='' upSolution='' upWebRes='' pageClass='' pageStyle='' custom=[]>
<#if inner=='0'>
	<#local customs = ''>
	<#list custom as s>
		<#local customs = customs+s>
		<#if s_has_next><#local customs = customs+'|'></#if>
	</#list>
	<@s.action name='ChnlList' namespace='/jeecms/tag/cms' executeResult='true'
		chnlId=id sysType=sysType orderBy=orderBy isDisplay=isDisplay hasContent=hasContent
		linkClass=linkClass linkTarget=linkTarget
		isPage=isPage count=count firstResult=firstResult pageNo=pageNo
		style=style cssClass=cssClass cssStyle=cssStyle showLinkStyle=showLinkStyle
		sysTpl=sysTpl sysContent=sysContent userContent=userContent sysPage=sysPage userPage=userPage pageClass=pageClass pageStyle=pageStyle customs=customs
	/>
<#else>
	<@s.action name='ChnlListInner' namespace='/jeecms/tag/cms' executeResult='false'
		chnlId=id sysType=sysType orderBy=orderBy isDisplay=isDisplay hasContent=hasContent
		isPage=isPage count=count firstResult=firstResult pageNo=pageNo
	/>
	<#if isLoop=='1'>
  		<#list n_pagination.list as item>
			<#nested item,item_index,item_has_next/>
		</#list>
	<#else>
		<#nested n_pagination/>
	</#if>
</#if>
</#macro>

<#--
�����б�
	docId���ĵ�ID��
	docType���ĵ����͡�
	check���Ƿ���ˡ���-1�����У�0��δ��ˣ�1������ˣ�2���������á���Ĭ��2��
	recommend���Ƿ��Ƽ�����-1�����У�0�����Ƽ���1���Ƽ�����Ĭ��-1��
	rcmFirst���Ƽ����ۿ�ǰ��ʾ����0:��1���ǡ���Ĭ��0��
-->
<#macro CommentList docId docType='1' check='2' recommend='-1' rcmFirst='0' orderBy='-1'
	isPage='0' count='20' firstResult='0' pageNo=pageNo
	style='1' inner='0' isLoop='1' cssClass='' cssStyle='' showLinkStyle='true'
	sysTpl='1' sysContent='0' userContent='' sysPage='0' userPage='' upSolution='' upWebRes='' pageClass='' pageStyle='' custom=[]>
<#if inner=='0'>
	<#local customs = ''>
	<#list custom as s>
		<#local customs = customs+s>
		<#if s_has_next><#local customs = customs+'|'></#if>
	</#list>
	<@s.action name='CommentList' namespace='/jeecms/tag/cms' executeResult='true'
		docId=docId docType=docType check=check recommend=recommend rcmFirst=rcmFirst orderBy=orderBy
		isPage=isPage count=count firstResult=firstResult pageNo=pageNo
		style=style cssClass=cssClass cssStyle=cssStyle showLinkStyle=showLinkStyle
		sysTpl=sysTpl sysContent=sysContent userContent=userContent sysPage=sysPage userPage=userPage pageClass=pageClass pageStyle=pageStyle customs=customs
	/>
<#else>
	<@s.action name='CommentListInner' namespace='/jeecms/tag/cms' executeResult='false'
		docId=docId docType=docType check=check recommend=recommend rcmFirst=rcmFirst orderBy=orderBy
		isPage=isPage count=count firstResult=firstResult pageNo=pageNo
	/>
	<#if isLoop=='1'>
  		<#list n_pagination.list as item>
			<#nested item,item_index,item_has_next/>
		</#list>
	<#else>
		<#nested n_pagination/>
	</#if>
</#if>
</#macro>

<#--
ר���б�
-->
<#macro TopicList
	isPage='0' count='20' firstResult='0' pageNo=pageNo
	isLoop='1'>
<@s.action name='TopicListInner' namespace='/jeecms/tag/cms' executeResult='false'
	isPage=isPage count=count firstResult=firstResult pageNo=pageNo
/>
<#if isLoop=='1'>
	<#list n_pagination.list as item>
		<#nested item,item_index,item_has_next/>
	</#list>
<#else>
	<#nested n_pagination/>
</#if>
</#macro>