<div class="pg-3">	
[#if lp.firstPage]
	
[#else]
	<a href="${pageLink}${pageSuffix}"> |<</a>
	<a href="${pageLink}[#if lp.prePage gt 1]_${lp.prePage}[/#if]${pageSuffix}"> < </a>
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
	
[#else]
	<a href="${pageLink}_${lp.nextPage}${pageSuffix}"> > </a>
	<a href="${pageLink}_${lp.totalPage}${pageSuffix}"> >| </a>
[/#if]
<span class="total">��${lp.totalPage}ҳ</span>
</div>