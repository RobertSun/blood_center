[#--
--]
[#assign noPicFloat=true/]
[#assign RLID = list.hashCode()/]
[#if RLID<0][#assign RLID = 0-RLID/][/#if]
<div id="roll-${RLID}" style="width:100%;overflow:hidden;white-space:nowrap;" onmouseover="clearInterval(proll${RLID}.pevent)" onmouseout="proll${RLID}.pevent=setInterval(function(){proll${RLID}.roll.call(proll${RLID})},proll${RLID}.speed)">
	<table width="100%" align="left" cellpadding="0" cellspacing="0" border="0"><tr>
	<td id="roll-orig-${RLID}">
		<table width="100%" cellpadding="0" cellspacing="0" border="0"><tr>
[#list list as ctt]
<td sytle="height:${rollLineHeight}px;">
[#include 'style1-2_core.ftl'/]
</td>
[/#list]
		</tr></table>
	</td>
	<td id="roll-copy-${RLID}"></td>
	</tr></table>
</div>
<script type="text/javascript">
var proll${RLID}=new JCore.LeftRoller(${RLID},${rollSpeed},${rollSpan});
</script>