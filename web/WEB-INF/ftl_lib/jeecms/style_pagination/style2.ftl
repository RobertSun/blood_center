[#if lp.totalPage gt 1]
<div[#if cssClass!=""] class="${cssClass}"[/#if][#if cssStyle!=""] style="${cssStyle}"[/#if]>
	[#if !lp.firstPage]
		<a href="${pageLink}[#if lp.prePage gt 1]_${lp.prePage}[/#if]${pageSuffix}">[上一页]</a>[#t/]
	[/#if]
	[#list 1..lp.totalPage as i]
		<a href="${pageLink}[#if i gt 1]_${i}[/#if]${pageSuffix}">[[#t/]
		[#if lp.pageNo == i]<span class="p2-crr">${i}</span>[#else]${i}[/#if]]</a>&nbsp;[#t/]
	[/#list]
	[#if !lp.lastPage]
		<a href="${pageLink+'_'+lp.nextPage+pageSuffix}">[下一页]</a>[#lt/]
	[/#if]
</div>
[/#if]