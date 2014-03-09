[#--
图文列表

图片宽度：picWidth。按百分比显示图片宽度（默认为25；即每个图片占总宽度的25%，每行可放四张图片）；
picHeight:每行图片显示高度。（默认180）；


列表。可以调配的参数有：
如何结合样式表调配？那些可以使用样式表控制，那些需要使用参数控制？
整体样式。可控样式。
标题长度：参数titLen。
行高：参数。lineHeight
下划线：参数。bottomLine
列头：参数；样式（主要控制图标）。headMark
时间格式：参数；dateFormat
时间位置：参数；datePosition【1：左；2：右】
类别形式：参数；ctgForm
类别样式：样式。ctgClass
链接打开方式：参数。target
--]
<dl style="width:${picWidth}%;height:${picHeight}px;[#if !noPicFloat??]float:left;[/#if]padding-right:${rightPadding}px;">
	<dd style="margin-left:0;">[#rt/]
		<a href="${ctt.url}" title="${ctt.tit(200)}"[#if target=="1"] target="_blank"[/#if]>[#t/]
			<img src="${ctt.imgUrl!}" alt="${ctt.tit(200)}" border="0"/>[#t/]
		</a>[#t/]
	</dd>[#lt/]
	<dt>[#rt/]
		<a href="${ctt.url}" title="${ctt.tit(200)}"[#if target=="1"] target="_blank"[/#if]>[#t/]
		[#if showLinkStyle=="1"]
		<span style="[#if ctt.titCol?has_content]color:${ctt.titCol};[/#if][#if ctt.titBold]font-weight:bold;[/#if]">${ctt.stit(titLen)}</span>[#t/]
		[#else]
		${ctt.stit(titLen)}[#t/]
		[/#if]
		</a>[#t/]
	</dt>[#lt/]
</dl>
