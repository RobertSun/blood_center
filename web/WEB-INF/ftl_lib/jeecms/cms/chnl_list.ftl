<ul>
<#list list as chnl>
<li><a href="${chnl.url}" class="${linkClass}"<#if linkTarget=="1"> target="_blank"</#if>>${chnl.name}</a></li>
</#list>
</ul>