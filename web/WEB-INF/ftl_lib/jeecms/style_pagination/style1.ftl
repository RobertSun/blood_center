<div[#if cssClass!=""] class="${cssClass}"[/#if][#if cssStyle!=""] style="${cssStyle}"[/#if]>
��${lp.totalCount}����¼ ${lp.pageNo}/${lp.totalPage}ҳ
[#if lp.firstPage]&nbsp;<a disabled="disabled">��ҳ</a> <a disabled="disabled">��һҳ</a>[#t/]
[#else]&nbsp;<a href="${pageLink}${pageSuffix}">��ҳ</a> <a href="${pageLink}[#if lp.prePage gt 1]_${lp.prePage}[/#if]${pageSuffix}">��һҳ</a>[#t/]
[/#if]
[#if lp.lastPage]&nbsp;<a disabled="disabled">��һҳ</a> <a disabled="disabled">βҳ</a>
[#else]&nbsp;<a href="${pageLink}_${lp.nextPage}${pageSuffix}">��һҳ</a> <a href="${pageLink}_${lp.totalPage}${pageSuffix}">βҳ</a>
[/#if]
&nbsp;��<select onChange="if(this.value==1){location='${pageLink}${pageSuffix}'}else{location='${pageLink}_'+this.value+'${pageSuffix}'}this.disabled='disabled'">
[#list 1..lp.totalPage as i]
  <option value="${i}" [#if lp.pageNo==i]selected="selected"[/#if]>${i}</option>
[/#list]
</select>ҳ
</div>