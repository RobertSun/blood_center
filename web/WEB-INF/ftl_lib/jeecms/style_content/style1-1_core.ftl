[#--
�б����Ե���Ĳ����У�
��ν����ʽ����䣿��Щ����ʹ����ʽ����ƣ���Щ��Ҫʹ�ò������ƣ�
������ʽ���ɿ���ʽ��
���ⳤ�ȣ�����titLen��
�иߣ�������lineHeight
�»��ߣ�������bottomLine
��ͷ����������ʽ����Ҫ����ͼ�꣩��headMark
ʱ���ʽ��������dateFormat
ʱ��λ�ã�������datePosition��1����2���ң�3��ǰ��
�����ʽ��������ctgForm
�����ʽ����ʽ��ctgClass
���Ӵ򿪷�ʽ��������target
ʹ���������⻹�Ǽ�̱��⣿
--]
<div class="${cssClass}[#if bottomLine=="1"]c1-bline[/#if]"[#if lineHeight!=""] style="padding:${lineHeight}px 0px;"[/#if]>[#rt/]
<div class="f-left">[#rt/]
[#--�б�ͷ--]
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
[#--����--]
[#if dateFormat!="0" && datePosition=="3"]
${ctt.getDate(dateFormat?number)} [#rt/]
[/#if]
[#--���--]
[#if ctgForm=="0"]
[#elseif ctgForm="1"]
<a href="${ctt.ctgUrl}"[#if ctgClass!=""] class="${ctgClass}"[/#if] target="_blank">[${ctt.ctgName}]</a> [#rt/]
[#elseif ctgForm="2"]
<a href="${ctt.webUrl}"[#if ctgClass!=""] class="${ctgClass}"[/#if] target="_blank">[${ctt.webName}]</a> [#rt/]
[/#if]
[#--����--]
<a href="${ctt.url}" title="${ctt.tit(200)}"[#if target=="1"] target="_blank"[/#if]>[#rt/]
[#if showLinkStyle=="1"]
<span style="[#if ctt.titCol?has_content]color:${ctt.titCol};[/#if][#if ctt.titBold]font-weight:bold;[/#if]">${ctt.stit(titLen)}</span>[#rt/]
[#else]
${ctt.stit(titLen)}[#rt/]
[/#if]
</a>[#rt/]
</div>[#rt/]
[#--����--]
[#if dateFormat!="0" && (datePosition=="1" || datePosition="2")]
<div class="[#if datePosition=="2"]f-right[#else]f-left[/#if]">[#rt/]
${ctt.getDate(dateFormat?number)}[#rt/]
</div>[#rt/]
[/#if]
[#--�������--]
<div class="clear"></div>[#rt/]
</div>
