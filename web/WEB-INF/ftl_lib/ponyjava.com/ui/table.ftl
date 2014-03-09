<#macro table cols normalOperate=[] batchOperate=[] wholeOptName="" wholeOptAction="" keepParams=[] gotoPageAction="Com_list"
  actionSuffix=".do" keyId="id" batchId="ids" wholeId="wids" value=pagination isPagination=true rowIndex=true operateCol="����" checkRight="true"
  width="100%">
<script language="javascript">
  <#list normalOperate as operate>
var ${operate["action"]} = {action:"${operate["action"]+actionSuffix}"<#if operate['confirm']??>,msg:"${operate['confirm']}"</#if>};
  </#list>
function _gotoPage(pageNo) {
	try{
		var tableForm = document.getElementById('tableForm');
		tableForm.pageNo.value = pageNo;
		<#if gotoPageAction!="">
		tableForm.action="${gotoPageAction + actionSuffix}";
		</#if>
		tableForm.onsubmit=null;
		tableForm.submit();
	} catch(e) {
		alert('gotoPage(pageNo)��������򲻴���');
	}
}
function _operate(op,id) {
	if(op.msg && !confirm(op.msg)) {
		return;
	}
	var tableForm = document.getElementById('tableForm');
	tableForm.onsubmit=null;
	tableForm.action=op.action;
	tableForm.${keyId}.value = id;
	tableForm.submit();
}
function _validateBatch() {
	var batchChecks = document.getElementsByName('${batchId}');
	var hasChecked = false;
	for(var i=0; i<batchChecks.length; i++) {
		if(batchChecks[i].checked) {
			hasChecked = true;
			break;
		}
	}
	if(!hasChecked) {alert('��ѡ��Ҫ���������ݣ�')};
	return hasChecked;
}
</script>
<form id="tableForm" method="post" onsubmit="return _validateBatch();">
<table class="pn-ltable" width="${width}" cellspacing="1" cellpadding="0" border="0">
<thead class="pn-lthead">
<tr>
<#if batchOperate?size gt 0>
	<th width="20px"><input type="checkbox" id="allCheck" value="checkbox" onclick="Pn.checkBox('${batchId}',this.checked);"/></th>
</#if>
<#if rowIndex>
	<th width="20px">#</th>
</#if>
<#list cols as col>
	<th>${col["label"]}</th>
</#list>
<#if normalOperate?size != 0>
	<th>${operateCol}</th>
</#if>
</tr>
</thead>
<tbody class="pn-ltbody">
<#if isPagination>
	<#if value.list??>
		<#assign pageList=value.list>
	</#if>
<#else>
  <#assign pageList=value>
</#if>
<#if pageList?? && pageList?size gt 0>
<#list pageList as row>
<tr onmouseover="Pn.LTable.lineOver(this);" onmouseout="Pn.LTable.lineOut(this);" onclick="Pn.LTable.lineSelect(this);">
	<#if batchOperate?size gt 0>
	<td><input type="checkbox" name="${batchId}" value="${row[keyId]}"/></td>
	</#if>
	<#if rowIndex>
	<td>${row_index+1}</td>
	</#if>
	<#list cols as col>
	<td<#if col['width']??> width="${col['width']}"</#if><#if col['title']??> title="${(col['title']?eval)!}"</#if>><#rt/>
		<#if col['length']??><div style="width:${col['length']}px;overflow-x:hidden;word-break:keep-all;text-overflow:ellipsis;" title="${(col['name']?eval)!?html}"></#if><#t/>
		<#if col['type']?? && col['type']=='input'>
			<input type="text" name="${col['inputName']}" value="${(col['name']?eval)!}" size="${col['size']!7}" onfocus="this.select();" onkeypress="if(event.keyCode==13){this.blur();return false;}"/><#t/>
		<#else>
			<#if (col['name']?eval)??><#if col['escape']!true>${(col['name']?eval)!?html}<#else>${(col['name']?eval)!}</#if><#else>${col['default']!}</#if><#t/>
		</#if>
		<#if col['length']??></div></#if><#t/>
	</td><#lt/>
	</#list>
	<td class="pn-lopt"><#rt/>
	<#if wholeOptName!=""><input type="hidden" name="${wholeId}" value="${row[keyId]}"/></#if><#t/>
	<#list normalOperate as operate>
		<#local opDisabled = operate['displayExp']?? && !operate['displayExp']?eval />
		<@p.operateRight operate=operate['action'] checkRight=checkRight><a<#if opDisabled> disabled="disabled" style="background-color:#CCCCCC;"<#else> href="javascript:_operate(${operate['action']},'${row[keyId]}');"</#if> class="pn-loperator">
		<#if operate['ifcheck']??>
		<#if operate['ifcheck']?eval>
		${operate["othname"]}
		<#else>
		${operate["name"]}
		</#if>
		<#else>
		${operate["name"]}
		</#if>
		</a><#if operate_has_next>��</#if></@p.operateRight><#t/>
	</#list><#t/>
	</td><#lt/>
</tr>
</#list>
</#if>
</tbody>
</table>
<#if !pageList?? || pageList?size <= 0>
<div class="pn-lnoresult">û��������ݣ�</div>
<#else>
<input type="hidden" name="${keyId}"/>
<@p.hidden name="pageNo" />
<#list keepParams as keep>
<@p.hidden name="${keep}" />
</#list>
<#list Parameters?keys as pkey>
  <#if pkey!=keyId && pkey!=batchId && !keepParams?seq_contains(pkey) && pkey?starts_with('query')>
    <@p.hidden name="${pkey}" />
  </#if>
</#list>
<#if isPagination>
<div class="pn-sp">
	<div class="pn-sp-left">�� ${value.totalCount} �� &nbsp;ÿҳ
	<input type="text" value="${value.pageSize}" size="2" onfocus="this.select();" onblur="new Pn.Cookie().set(Pn.Cookie.countPerPage,this.value,10*365*24*60*60);" onkeypress="if(event.keyCode==13){$(this).blur();return false;}"/> ��</div>
	<div class="pn-sp-right">
		<input type="button" value="�� ҳ" onclick="_gotoPage('1');"<#if value.firstPage> disabled="disabled"</#if>/>&nbsp;
		<input type="button" value="��һҳ" onclick="_gotoPage('${value.prePage}');"<#if value.firstPage> disabled="disabled"</#if>/>&nbsp;
		<input type="button" value="��һҳ" onclick="_gotoPage('${value.nextPage}');"<#if value.lastPage> disabled="disabled"</#if>/>&nbsp;
		<input type="button" value="β ҳ" onclick="_gotoPage('${value.totalPage}');"<#if value.lastPage> disabled="disabled"</#if>/> &nbsp;
		��ǰ ${value.pageNo}/${value.totalPage} ҳ &nbsp;ת���� <input type="text" id="_goPs" size="2" onfocus="this.select();" onkeypress="if(event.keyCode==13){$('#_goPage').click();return false;}"/> ҳ
		<input id="_goPage" type="button" value="ת" onclick="_gotoPage($('#_goPs').val());"<#if value.totalPage==1> disabled="disabled"</#if>/>
	</div>
	<div class="clear"></div>
</div>
</#if>
<#include "table-batchoperate.ftl" />
</#if>
</form>
</#macro>