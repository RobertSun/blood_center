[#--
ͼ���б�

ͼƬ��ȣ�picWidth�����ٷֱ���ʾͼƬ��ȣ�Ĭ��Ϊ25����ÿ��ͼƬռ�ܿ�ȵ�25%��ÿ�пɷ�����ͼƬ����
picHeight:ÿ��ͼƬ��ʾ�߶ȡ���Ĭ��180����


�б����Ե���Ĳ����У�
��ν����ʽ����䣿��Щ����ʹ����ʽ����ƣ���Щ��Ҫʹ�ò������ƣ�
������ʽ���ɿ���ʽ��
���ⳤ�ȣ�����titLen��
�иߣ�������lineHeight
�»��ߣ�������bottomLine
��ͷ����������ʽ����Ҫ����ͼ�꣩��headMark
ʱ���ʽ��������dateFormat
ʱ��λ�ã�������datePosition��1����2���ҡ�
�����ʽ��������ctgForm
�����ʽ����ʽ��ctgClass
���Ӵ򿪷�ʽ��������target
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
