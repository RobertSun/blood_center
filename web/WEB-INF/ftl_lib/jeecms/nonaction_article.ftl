<#--��������-->
<#macro ArtiContent>
<#include arti.relPath(pageNo) parse=false/>
</#macro>
<#--������һƪ����һƪ
	side����pre����һƪ��next����һƪ��
	notExist�����²�����ʱ����ʾ��Ϣ����Ĭ�ϣ�û���ˣ�
-->
<#macro ArtiSide side titLen="200" notExist="û����">
<#local titLen=titLen?number/>
<#if side=="pre" && arti.pre??>
<a href="${arti.pre.url}" title="${arti.pre.title}">${arti.pre.tit(titLen)}</a>
<#elseif side=="next" && arti.next??>
<a href="${arti.next.url}" title="${arti.next.title}">${arti.next.tit(titLen)}</a>
<#else>
<span>${notExist}</span>
</#if>
</#macro>
