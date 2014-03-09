<div class="clear"></div>
<div class="pagenation">
	<p>
[#if lp.firstPage]
	<a class="item" href="#">&laquo; 上一页</a>[#t/]
[#else]
	<a class="item" href="${pageLink}[#if lp.prePage gt 1]_${lp.prePage}[/#if]${pageSuffix}">&laquo; 上一页</a>
[/#if]
[#if pageNo-5 gt 1]
	[#if lp.totalPage gt pageNo+4]
		[#list pageNo-5..pageNo+4 as i]
			[#if i = pageNo]
				<span class="item current">${i}</span>
			[#else]
				<a class="item" href="${pageLink}[#if i gt 1]_${i}[/#if]${pageSuffix}">${i}</a>
			[/#if]
		[/#list]
	[#else]
		[#list lp.totalPage-9..lp.totalPage as i]
			[#if i = pageNo]
				<span class="item current">${i}</span>
			[#else]
				<a class="item" href="${pageLink}[#if i gt 1]_${i}[/#if]${pageSuffix}">${i}</a>
			[/#if]
		[/#list]
	[/#if]
[#else]
	[#if lp.totalPage gt 10]
		[#list 1..10 as i]
			[#if i = pageNo]
				<span class="item current">${i}</span>
			[#else]
				<a class="item" href="${pageLink}[#if i gt 1]_${i}[/#if]${pageSuffix}">${i}</a>
			[/#if]
		[/#list]
	[#else]
		[#list 1..lp.totalPage as i]
			[#if i = pageNo]
				<span class="item current">${i}</span>
			[#else]
				<a class="item" href="${pageLink}[#if i gt 1]_${i}[/#if]${pageSuffix}">${i}</a>
			[/#if]
		[/#list]
	[/#if]
[/#if]
[#if lp.lastPage]
	<a class="item" href="#">下一页 &raquo;</a>
[#else]
	<a class="item" href="${pageLink}_${lp.nextPage}${pageSuffix}">下一页 &raquo;</a>
[/#if]
    </p>
</div>