<#--文章内容-->
<#macro ArtiContent>
<#include arti.relPath(pageNo) parse=false/>
</#macro>
<#--文章上一篇、下一篇
	side：【pre：上一篇；next：下一篇】
	notExist：文章不存在时的提示信息。（默认：没有了）
-->
<#macro ArtiSide side titLen="200" notExist="没有了">
<#local titLen=titLen?number/>
<#if side=="pre" && arti.pre??>
<a href="${arti.pre.url}" title="${arti.pre.title}">${arti.pre.tit(titLen)}</a>
<#elseif side=="next" && arti.next??>
<a href="${arti.next.url}" title="${arti.next.title}">${arti.next.tit(titLen)}</a>
<#else>
<span>${notExist}</span>
</#if>
</#macro>
