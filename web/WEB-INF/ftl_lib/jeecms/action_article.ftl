<#--
�����б��Զ������ݣ�
	chnlId����ĿID����Ĭ�ϣ���ǰ��ĿID��
	searchKey���������⡢tags����������������ҳ����Ĭ�Ͽգ�
	topLevel���̶�����0�����У�1�����̶���2���̶�����Ĭ��0��
	orderBy������ʽ����0������ʱ�併��1������ʱ������2���̶�����3���ö�����4���յ������5���ܵ������6���µ������7�����������8����������9���ܵ�����򡿣�Ĭ��0��
	recommend���Ƿ��Ƽ�����0��ȫ����1���Ƽ����¡���Ĭ��0��

	style����ǩ�ڲ���ʽ�����ָ��sysContent��userContent���������Ч����1����ͨ�б�����Ĭ��1��
-->
<#macro ArtiList chnlId=(chnl.id)!'' attr='' searchKey='' hasImg='0' recommend='0' topLevel='0' orderBy='0'
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
	<@s.action name='ArtiList' namespace='/jeecms/tag/article' executeResult='true'
		chnlId=chnlId attr=attr searchKey=searchKey hasImg=hasImg recommend=recommend topLevel=topLevel orderBy=orderBy
		titLen=titLen target=target headMark=headMark lineHeight=lineHeight bottomLine=bottomLine ctgForm=ctgForm ctgClass=ctgClass dateFormat=dateFormat datePosition=datePosition
		picWidth=picWidth picHeight=picHeight
		rollDisplayHeight=rollDisplayHeight rollLineHeight=rollLineHeight rightPadding=rightPadding rollCols=rollCols rollSpeed=rollSpeed isSleep=isSleep rollSleepTime=rollSleepTime rollCount=rollCount rollSpan=rollSpan
		flashWidth=flashWidth flashHeight=flashHeight textHeight=textHeight
		isPage=isPage count=count firstResult=firstResult pageNo=pageNo
		style=style cssClass=cssClass cssStyle=cssStyle showLinkStyle=showLinkStyle
		sysTpl=sysTpl sysContent=sysContent userContent=userContent sysPage=sysPage newday=newday userPage=userPage pageClass=pageClass pageStyle=pageStyle customs=customs
		/>
<#else>
	<@s.action name='ArtiListInner' namespace='/jeecms/tag/article' executeResult='false'
		chnlId=chnlId searchKey=searchKey hasImg=hasImg recommend=recommend topLevel=topLevel orderBy=orderBy
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