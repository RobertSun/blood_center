<#--
留言列表
	ctgId：留言类别。类别ID。（默认全部）
	recommend：是否推荐。【0：全部；2：推荐留言】（默认0）
	orderBy：排序方式。【0：留言时间从新到旧；1：留言时间从旧到新；】（默认0）

	firstResult：第一条记录。（默认0）
	count：记录数。（默认20）
	isPage：是否分页。【0：不分页；1：分页】（默认0）
	pageNo：页号。（默认当前页）

	cssClass：容器class
	cssStyle：容器style
	
	style：标签内部样式。如果指定sysContent或userContent，则该项无效。【1：普通列表；】（默认1）
	
	inner：是否使用标签中直接编写html代码。【0：否；1：是】（默认0）
	isLoop：内容是否循环。【0：不循环；1：循环】（默认1）
	
	sysTpl：使用系统模板。【0：不使用；1：使用】（默认1）
	sysContent：系统内容样式。（默认0）
	userContent：自定义内容文件名。如果指定了系统内容样式，则该项无效。（默认空）
	sysPage：系统分页样式。【0：不分页；1：样式一；2：样式二】（默认0）
	userPage：自定义分页样式文件名。如果指定了系统分页样式，则该项无效。（默认空）
	custom：字符串数组。用于个性化处理。（默认空数组）
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
留言类别列表（inner标签）
	isLoop：内容是否循环。【0：不循环；1：循环】（默认1）
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
留言类别列表（inner标签）
	id：投票ID。（默认为最新投票）
	#inner：是否使用标签中直接编写html代码。【0：否；1：是】（默认0）
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
	inner=1尚未实现
	<#--<#nested n_bean/>-->
</#if>
</#macro>