[#--
列表。可以调配的参数有：
如何结合样式表调配？那些可以使用样式表控制，那些需要使用参数控制？
整体样式。可控样式。
标题长度：参数titLen。
行高：参数。lineHeight
下划线：参数。bottomLine
列头：参数；样式（主要控制图标）。headMark
时间格式：参数；dateFormat
时间位置：参数；datePosition【1：左；2：右；3：前】
类别形式：参数；ctgForm
类别样式：样式。ctgClass
链接打开方式：参数。target
使用完整标题还是简短标题？
--]
<div class="${cssClass}[#if bottomLine=="1"]c1-bline[/#if]"[#if lineHeight!=""] style="padding:${lineHeight}px 0px;"[/#if]>[#rt/]
<div class="f-left">[#rt/]
[#--列表头--]
[#if headMark=="0"]
[#elseif headMark?index_of(".") != -1]
<img src="${root+headMark}" align="middle" class="img-vm" border="0"/> [#rt/]
[#elseif headMark="1"]
&middot; [#rt/]
[#elseif headMark="2"]
<span style="color:red">&middot;</span> [#rt/]
[#elseif headMark="3"]
<img src="${sysResRoot}/com_tag/head-mark3.gif" align="middle" class="img-vm" border="0"/> [#rt/]
[#elseif headMark="4"]
<img src="${sysResRoot}/com_tag/head-mark4.gif" align="middle" class="img-vm" border="0"/> [#rt/]
[/#if]
[#--日期--]
[#if dateFormat!="0" && datePosition=="3"]
${ctt.getDate(dateFormat?number)} [#rt/]
[/#if]
[#--类别--]
[#if ctgForm=="0"]
[#elseif ctgForm="1"]
<a href="${ctt.ctgUrl}"[#if ctgClass!=""] class="${ctgClass}"[/#if] target="_blank">[${ctt.ctgName}]</a> [#rt/]
[#elseif ctgForm="2"]
<a href="${ctt.webUrl}"[#if ctgClass!=""] class="${ctgClass}"[/#if] target="_blank">[${ctt.webName}]</a> [#rt/]
[/#if]
[#--链接--]
<a href="${ctt.url}" title="${ctt.tit(200)}"[#if target=="1"] target="_blank"[/#if]>[#rt/]
[#if showLinkStyle=="1"]
<span style="[#if ctt.titCol?has_content]color:${ctt.titCol};[/#if][#if ctt.titBold]font-weight:bold;[/#if]">${ctt.stit(titLen)}</span>[#rt/]
[#else]
${ctt.stit(titLen)}[#rt/]
[/#if]
</a>[#rt/]
</div>[#rt/]
[#--日期--]
[#if dateFormat!="0" && (datePosition=="1" || datePosition="2")]
<div class="[#if datePosition=="2"]f-right[#else]f-left[/#if]">[#rt/]
${ctt.getDate(dateFormat?number)}[#rt/]
</div>[#rt/]
[/#if]
[#--清除浮动--]
<div class="clear"></div>[#rt/]
</div>
