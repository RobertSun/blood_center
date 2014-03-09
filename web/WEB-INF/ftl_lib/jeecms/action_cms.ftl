<#--
子栏目列表
	id：父栏目ID。（默认：当前栏目ID）
	orderBy：排序方式。【0：优先级升序；1：优先级降序；2：点击次数升序；3：点击次数降序】（默认0）
	isDisplay：是否只获取显示的栏目。【0：获取所有；1：只获取显示的栏目】（默认1）
	hasContent：是否只获取可以有内容的栏目。【0：获取所有；1：只获取可以有内容的栏目】（默认0）
	
	linkClass：链接class
	linkTarget：链接打开方式。【0：当前窗口；1：新窗口】（默认0）
		
	style：标签内部样式。如果指定sysContent或userContent，则该项无效。
		【1：普通链接列表；】（默认1）
	
	sysTpl：使用系统模板。【0：不使用；1：使用】（默认1）
	sysContent：系统内容样式。（默认0）
	userContent：自定义内容样式。如果指定了系统内容样式，则该项无效。（默认0）
	sysPage：系统分页样式。【0：不分页；1：样式一；2：样式二】（默认0）
	userPage：自定义分页样式。如果指定了系统分页样式，则该项无效。【0：不分页；1：样式一；2：样式二】（默认0）
	custom：字符串数组。用于个性化处理。（默认空数组）
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
评论列表
	docId：文档ID。
	docType：文档类型。
	check：是否审核。【-1：所有；0：未审核；1：已审核；2：根据配置】（默认2）
	recommend：是否推荐。【-1：所有；0：不推荐；1：推荐】（默认-1）
	rcmFirst：推荐评论靠前显示。【0:否；1：是】（默认0）
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
专题列表
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