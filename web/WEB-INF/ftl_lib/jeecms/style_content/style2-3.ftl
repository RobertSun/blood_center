[#--
--]
[#assign RLID = list.hashCode()/]
[#if RLID<0][#assign RLID = 0-RLID/][/#if]
<div id="roll-${RLID}" style="width:100%;overflow:hidden;" onmouseover="clearInterval(proll${RLID}.pevent)" onmouseout="proll${RLID}.pevent=setInterval(function(){proll${RLID}.roll.call(proll${RLID})},proll${RLID}.speed)">
	<table width="100%" align="left" cellpadding="0" cellspacing="0" border="0"><tr>
	<td id="roll-orig-${RLID}" style="white-space:nowrap;">
	[#list list as ctt]
[#--ÈÕÆÚ--]
[#if dateFormat!="0"]
${ctt.getDate(dateFormat?number)} [#rt/]
[/#if]
[#--Á´½Ó--]
<a href="${ctt.url}" title="${ctt.tit(200)}"[#if target=="1"] target="_blank"[/#if]>[#rt/]
<span style="[#if ctt.titCol?has_content]color:${ctt.titCol};[/#if][#if ctt.titBold]font-weight:bold;[/#if]">${ctt.stit(titLen)}</span>[#rt/]
</a> &nbsp; [#rt/]
	[/#list]
	</td>
	<td id="roll-copy-${RLID}" style="white-space:nowrap;"></td>
	</tr></table>
</div>
<script type="text/javascript">
var proll${RLID}=new JCore.LeftRoller(${RLID},${rollSpeed},${rollSpan});
</script>