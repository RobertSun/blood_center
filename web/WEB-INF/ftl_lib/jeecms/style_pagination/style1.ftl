<div[#if cssClass!=""] class="${cssClass}"[/#if][#if cssStyle!=""] style="${cssStyle}"[/#if]>
共${lp.totalCount}条记录 ${lp.pageNo}/${lp.totalPage}页
[#if lp.firstPage]&nbsp;<a disabled="disabled">首页</a> <a disabled="disabled">上一页</a>[#t/]
[#else]&nbsp;<a href="${pageLink}${pageSuffix}">首页</a> <a href="${pageLink}[#if lp.prePage gt 1]_${lp.prePage}[/#if]${pageSuffix}">上一页</a>[#t/]
[/#if]
[#if lp.lastPage]&nbsp;<a disabled="disabled">下一页</a> <a disabled="disabled">尾页</a>
[#else]&nbsp;<a href="${pageLink}_${lp.nextPage}${pageSuffix}">下一页</a> <a href="${pageLink}_${lp.totalPage}${pageSuffix}">尾页</a>
[/#if]
&nbsp;第<select onChange="if(this.value==1){location='${pageLink}${pageSuffix}'}else{location='${pageLink}_'+this.value+'${pageSuffix}'}this.disabled='disabled'">
[#list 1..lp.totalPage as i]
  <option value="${i}" [#if lp.pageNo==i]selected="selected"[/#if]>${i}</option>
[/#list]
</select>页
</div>