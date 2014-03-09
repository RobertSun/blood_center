<#--
包含页面
	可以包含当前目录、方案、甚至其他站点的页面。
eg：
包含当前目录文件：[@cms.Include name="mypage.html"/]
包含当前方案文件：
	[@cms.Include name="mypage.html" solution="mysolution"/]
	或[@cms.Include name="/mysolution/mypage.html"/]
包含其他站点文件：（站群版）
	[@cms.Include name="mypage.html" solution="mysolution" webRes="sina_com_www"/]
	或[@cms.Include name="/mysolution/mypage.html" webRes="sina_com_www"/]
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
当前位置
homepage：首页显示方式。【1：站点简称；自定义】（默认：'首页'）。
title：内容页显示方式。【0：不显示；1：显示内容标题；自定义】（默认：'正文'）。
split：分割符号。（默认：>)。
target：是否原窗口打开。【0：原窗口打开；1：新窗口打开】（默认：0）。
class：链接class。
style：链接style。
-->
<#macro Position 
	homepage='首页' title='正文' split='>' target='0' class='' style=''>
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
用户内容样式调用标签
name：内容样式文件名称。
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
用户分页样式调用标签
name：分页样式文件名称。
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
系统内容样式调用标签
style：系统样式编号。
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
系统内容样式包含标签
style：系统样式编号。
-->
<#macro SysContentInclude style>
<#include "/WEB-INF/ftl_lib/jeecms/style_content/style${style}.ftl"/>
</#macro>

<#--
系统分页样式调用标签
style：系统样式编号。
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
