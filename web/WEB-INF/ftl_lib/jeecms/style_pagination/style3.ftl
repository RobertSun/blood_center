<div class="pg-3">
	<span class="total">共${lp.totalPage}页</span>
[#if lp.firstPage]
	<span class="disabled"> |<  首页</span><span class="disabled"> <  上一页</span>[#t/]
[#else]
	<a href="${pageLink}${pageSuffix}"> |<  首页</a>
	<a href="${pageLink}[#if lp.prePage gt 1]_${lp.prePage}[/#if]${pageSuffix}"> <  上一页</a>
[/#if]
[#if pageNo-5 gt 1]
	[#if lp.totalPage gt pageNo+4]
		[#list pageNo-5..pageNo+4 as i]
			[#if i = pageNo]
				<span class="current">${i}</span>
			[#else]
				<a href="${pageLink}[#if i gt 1]_${i}[/#if]${pageSuffix}">${i}</a>
			[/#if]
		[/#list]
	[#else]
		[#list lp.totalPage-9..lp.totalPage as i]
			[#if i = pageNo]
				<span class="current">${i}</span>
			[#else]
				<a href="${pageLink}[#if i gt 1]_${i}[/#if]${pageSuffix}">${i}</a>
			[/#if]
		[/#list]
	[/#if]
[#else]
	[#if lp.totalPage gt 10]
		[#list 1..10 as i]
			[#if i = pageNo]
				<span class="current">${i}</span>
			[#else]
				<a href="${pageLink}[#if i gt 1]_${i}[/#if]${pageSuffix}">${i}</a>
			[/#if]
		[/#list]
	[#else]
		[#list 1..lp.totalPage as i]
			[#if i = pageNo]
				<span class="current">${i}</span>
			[#else]
				<a href="${pageLink}[#if i gt 1]_${i}[/#if]${pageSuffix}">${i}</a>
			[/#if]
		[/#list]
	[/#if]
[/#if]
[#if lp.lastPage]	
	<span class="disabled"> 下一页  ></span><span class="disabled"> 尾页  >|</span>
[#else]
	<a href="${pageLink}_${lp.nextPage}${pageSuffix}">下一页  > </a>
	<a href="${pageLink}_${lp.totalPage}${pageSuffix}">尾页  >| </a>
[/#if]
</div>