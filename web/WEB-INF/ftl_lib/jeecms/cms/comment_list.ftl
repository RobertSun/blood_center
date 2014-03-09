[#if pagination.list?size gt 0]
[#list pagination.list as c]
	<div class="pl_item">
		<div class="pl_msg">${(c.member.loginName)!'ÄäÃûÍøÓÑ'} ${c.createTime} ·¢±í</div>
		<div class="pl_content">${c.htmlMember}</div>
	</div>
[/#list]
[#if isPage=="1" && pagination.list?size > 0]
	[#if sysPage!="0"]
		[@cms.SysPage style=sysPage cssClass=pageClass cssStyle=pageStyle/]
	[#elseif userPage!=""]
		[@cms.UserPage name=userPage cssClass=pageClass cssStyle=pageStyle solution=upSolution webRes=upWebRes/]
	[/#if]
[/#if]
[/#if]