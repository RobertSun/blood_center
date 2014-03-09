<#--
����ҳ��
	���԰�����ǰĿ¼����������������վ���ҳ�档
eg��
������ǰĿ¼�ļ���[@cms.Include name="mypage.html"/]
������ǰ�����ļ���
	[@cms.Include name="mypage.html" solution="mysolution"/]
	��[@cms.Include name="/mysolution/mypage.html"/]
��������վ���ļ�����վȺ�棩
	[@cms.Include name="mypage.html" solution="mysolution" webRes="sina_com_www"/]
	��[@cms.Include name="/mysolution/mypage.html" webRes="sina_com_www"/]
-->
<#macro Include name solution="" webRes="" sysType="include">
<#if webRes=="">
	<#if solution=="">
		<#if name?starts_with("/")>
			<#include "${tplBase}/${sysType}${name}"/>
		<#else>
			<#include "${tplBase}/${sysType}/${name}"/>
		</#if>
	<#else>
		<#include "${tplBase}/${sysType}/${solution}/${name}"/>
	</#if>
<#else>
	<#if solution=="">
		<#include "${UserBase+webRes}/${sysType}${name}"/>
	<#else>
		<#include "${UserBase+webRes}/${sysType}/${solution}/${name}"/>
	</#if>
</#if>
</#macro>

<#--
��ǰλ��
homepage����ҳ��ʾ��ʽ����1��վ���ƣ��Զ��塿��Ĭ�ϣ�'��ҳ'����
title������ҳ��ʾ��ʽ����0������ʾ��1����ʾ���ݱ��⣻�Զ��塿��Ĭ�ϣ�'����'����
split���ָ���š���Ĭ�ϣ�>)��
target���Ƿ�ԭ���ڴ򿪡���0��ԭ���ڴ򿪣�1���´��ڴ򿪡���Ĭ�ϣ�0����
class������class��
style������style��
-->
<#macro Position 
	homepage='��ҳ' title='����' split='>' target='0' class='' style=''>
<#local c=chnl/>
<#local chnlList=[]/>
<#list 1..100 as i>
	<#local chnlList=[c]+chnlList/>
	<#if c.parent??>
		<#local c=c.parent/>
	<#else>
		<#break/>
	</#if>
</#list>
<#list chnlList as c>
	<#if c_index==0>
		<a href="${chnl.website.webUrl}"<#t/>
		<#if target=='1'> target="_blank"</#if><#if class!=''> class="${class}"</#if><#if style!=''> style="${style}"</#if>><#t/>
		<#if homepage=='1'>${chnl.website.shortName}<#else>${homepage}</#if></a> ${split?html} <#t/>
	<#else>
		<a href="${c.url}"<#t/>
		<#if target=='1'> target="_blank"</#if><#if class!=''> class="${class}"</#if><#if style!=''> style="${style}"</#if>><#t/>
		${c.name}</a><#if c_has_next> ${split?html} </#if><#t/>
	</#if>	
</#list>
<#if arti??>
	<#if title=='0' || title==''><#elseif title=='1'> ${split?html} ${arti.contentTitle}<#else> ${split?html} ${title}</#if><#t/>
</#if>
</#macro>

<#--
�û�������ʽ���ñ�ǩ
name��������ʽ�ļ����ơ�
-->
<#macro UserContent name solution="" webRes="">
<#if pagination??>
	<#local lp=pagination/>
<#elseif n_pagination??>
	<#local lp=n_pagination/>
<#else>
	<#return/>
</#if>
<@Include name=name solution=solution webRes=webRes sysType="style_pagination"/>
</#macro>

<#--
�û���ҳ��ʽ���ñ�ǩ
name����ҳ��ʽ�ļ����ơ�
-->
<#macro UserPage name cssClass="" cssStyle="" solution="" webRes="">
<#if pagination??>
	<#local lp=pagination/>
<#elseif n_pagination??>
	<#local lp=n_pagination/>
<#else>
	<#return/>
</#if>
<@Include name=name solution=solution webRes=webRes sysType="style_pagination"/>
</#macro>

<#--
ϵͳ������ʽ���ñ�ǩ
style��ϵͳ��ʽ��š�
-->
<#macro SysContent style list=pagination.list
	cssClass=cssClass cssStyle=cssStyle showLinkStyle=showLinkStyle
	titLen=titLen target=target headMark=headMark lineHeight=lineHeight bottomLine=bottomLine ctgForm=ctgForm ctgClass=ctgClass dateFormat=dateFormat datePosition=datePosition
	picWidth=picWidth picHeight=picHeight
	rollDisplayHeight=rollDisplayHeight rollLineHeight=rollLineHeight rightPadding=rightPadding rollCols=rollCols rollSpeed=rollSpeed isSleep=isSleep rollSleepTime=rollSleepTime rollCount=rollCount rollSpan=rollSpan
	flashWidth=flashWidth flashHeight=flashHeight textHeight=textHeight
>
<#include "/WEB-INF/ftl_lib/jeecms/style_content/style${style}.ftl"/>
</#macro>

<#--
ϵͳ������ʽ������ǩ
style��ϵͳ��ʽ��š�
-->
<#macro SysContentInclude style>
<#include "/WEB-INF/ftl_lib/jeecms/style_content/style${style}.ftl"/>
</#macro>

<#--
ϵͳ��ҳ��ʽ���ñ�ǩ
style��ϵͳ��ʽ��š�
-->
<#macro SysPage style cssClass="" cssStyle="">
<#if pagination??>
	<#local lp=pagination/>
<#elseif n_pagination??>
	<#local lp=n_pagination/>
<#else>
	<#return/>
</#if>
<#include "/WEB-INF/ftl_lib/jeecms/style_pagination/style${style}.ftl"/>
</#macro>
