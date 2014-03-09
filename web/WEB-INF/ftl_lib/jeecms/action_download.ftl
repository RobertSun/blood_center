<#--
下载列表（自定义内容）
	chnlId：栏目ID。（默认：当前栏目ID）
	searchKey：搜索标题、tags和描述。用于搜索页。（默认空）
	topLevel：固定。【0：所有；1：不固定；2：固定】（默认0）
	orderBy：排序方式。【0：发布时间降序；1：发布时间升序；2：固顶降序；3：置顶降序；4：日点击降序；5：周点击降序；6：月点击降序；7：季点击降序；8：年点击降序；9：总点击降序】（默认0）
	recommend：是否推荐。【0：全部；1：推荐文章】（默认0）

	style：标签内部样式。如果指定sysContent或userContent，则该项无效。【1：普通列表；】（默认1）
-->
<#macro DownloadList chnlId=chnl.id attr='' searchKey='' hasImg='0' recommend='0' readThisWeb='1' websId='0' topLevel='0' orderBy='0'
	titLen='20' target='0' headMark='0' lineHeight='' bottomLine='0' ctgForm='0' ctgClass='' dateFormat='0' datePosition='1'
	picWidth='24.9' picHeight='110'
	rollDisplayHeight='28' rollLineHeight='28' rightPadding='20' rollCols='1' rollSpeed='1' isSleep='1' rollSleepTime='50' rollCount='1' rollSpan='1'
	flashWidth='296' flashHeight='200' textHeight='20'
	isPage='0' count='20' firstResult='0' pageNo=pageNo
	style='1' inner='0' isLoop='1' cssClass='' cssStyle='' showLinkStyle='1'
	sysTpl='1' sysContent='0' userContent='' sysPage='0' newday='0' userPage='' upSolution='' upWebRes='' pageClass='' pageStyle='' custom=[]>
<#if inner=='0'>
	<#local customs = ''>
	<#list custom as s>
		<#local customs = customs+s>
		<#if s_has_next><#local customs = customs+'|'></#if>
	</#list>
	<@s.action name='DownloadList' namespace='/download/tag' executeResult='true'
		chnlId=chnlId attr=attr searchKey=searchKey hasImg=hasImg recommend=recommend readThisWeb=readThisWeb websId=websId topLevel=topLevel orderBy=orderBy
		titLen=titLen target=target headMark=headMark lineHeight=lineHeight bottomLine=bottomLine ctgForm=ctgForm ctgClass=ctgClass dateFormat=dateFormat datePosition=datePosition
		picWidth=picWidth picHeight=picHeight
		rollDisplayHeight=rollDisplayHeight rollLineHeight=rollLineHeight rightPadding=rightPadding rollCols=rollCols rollSpeed=rollSpeed isSleep=isSleep rollSleepTime=rollSleepTime rollCount=rollCount rollSpan=rollSpan
		flashWidth=flashWidth flashHeight=flashHeight textHeight=textHeight
		isPage=isPage count=count firstResult=firstResult pageNo=pageNo
		style=style cssClass=cssClass cssStyle=cssStyle showLinkStyle=showLinkStyle
		sysTpl=sysTpl sysContent=sysContent userContent=userContent sysPage=sysPage newday=newday userPage=userPage pageClass=pageClass pageStyle=pageStyle customs=customs
		/>
<#else>
	<@s.action name='DownloadListInner' namespace='/download/tag' executeResult='false'
		chnlId=chnlId searchKey=searchKey hasImg=hasImg recommend=recommend websId=websId topLevel=topLevel orderBy=orderBy
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

<#macro DownSortList chnlId=chnl.id typeId='0' status='0' attr='' searchKey='' hasImg='0' orderBy='0'
	titLen='20' target='0' headMark='0' lineHeight='' bottomLine='0' ctgForm='0' ctgClass='' dateFormat='0' datePosition='1'
	picWidth='24.9' picHeight='110'
	rollDisplayHeight='28' rollLineHeight='28' rightPadding='20' rollCols='1' rollSpeed='1' isSleep='1' rollSleepTime='50' rollCount='1' rollSpan='1'
	flashWidth='296' flashHeight='200' textHeight='20'
	isPage='0' count='20' firstResult='0' pageNo=pageNo
	style='1' inner='0' isLoop='1' cssClass='' cssStyle='' showLinkStyle='1'
	sysTpl='1' sysContent='0' userContent='' sysPage='0' newday='0' userPage='' upSolution='' upWebRes='' pageClass='' pageStyle='' custom=[]>
	<#local customs = ''>
	<#list custom as s>
		<#local customs = customs+s>
		<#if s_has_next><#local customs = customs+'|'></#if>
	</#list>
	<@s.action name='DownSortList' namespace='/download/tag' executeResult='true'
		chnlId=chnlId attr=attr searchKey=searchKey hasImg=hasImg typeId=typeId status=status orderBy=orderBy
		titLen=titLen target=target headMark=headMark lineHeight=lineHeight bottomLine=bottomLine ctgForm=ctgForm ctgClass=ctgClass dateFormat=dateFormat datePosition=datePosition
		picWidth=picWidth picHeight=picHeight
		rollDisplayHeight=rollDisplayHeight rollLineHeight=rollLineHeight rightPadding=rightPadding rollCols=rollCols rollSpeed=rollSpeed isSleep=isSleep rollSleepTime=rollSleepTime rollCount=rollCount rollSpan=rollSpan
		flashWidth=flashWidth flashHeight=flashHeight textHeight=textHeight
		isPage=isPage count=count firstResult=firstResult pageNo=pageNo
		style=style cssClass=cssClass cssStyle=cssStyle showLinkStyle=showLinkStyle
		sysTpl=sysTpl sysContent=sysContent userContent=userContent sysPage=sysPage newday=newday userPage=userPage pageClass=pageClass pageStyle=pageStyle customs=customs
		/>
</#macro>