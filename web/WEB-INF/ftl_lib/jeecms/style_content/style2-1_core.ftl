[#--
ͼ���б������б����Ϲ���
��ʾ����߶ȣ�rollDisplayHeight
�������иߣ�rollLineHeight
����������rollCols
�����ٶȣ�rollSpeed
����ͣ��ʱ�䣺rollSleepTime
����������rollCount
������ȣ�rollSpan
�Ƿ�ͣ�٣�isSleep
--]
[#assign noPicFloat=true/]
[#assign RLID = list.hashCode()/]
[#if RLID<0][#assign RLID = 0-RLID/][/#if]
<div id="roll-${RLID}" style="overflow:hidden;height:${rollDisplayHeight}px;" onmouseover="clearInterval(proll${RLID}.pevent)" onmouseout="proll${RLID}.pevent=setInterval(function(){proll${RLID}.roll.call(proll${RLID})},proll${RLID}.speed)">
	<div id="roll-orig-${RLID}">
		<table width="100%" cellpadding="0" cellspacing="0" border="0">
		[#assign tableCellCount = list?size]
		[#if tableCellCount<rollCols]
			[#assign tableCellCount = rollCols/]
		[#elseif tableCellCount%rollCols != 0]
			[#assign tableCellCount = tableCellCount+(rollCols-tableCellCount%rollCols)/]
		[/#if]
		[#list 0..tableCellCount-1 as i]
		[#if i%rollCols==0]<tr>[/#if]<td height="${rollLineHeight}"[#if i==0] id="roll-line-${RLID}"[/#if][#if i<rollCols] width="${100/rollCols}%"[/#if]>[#rt/]
			[#if i gte list?size]
			&nbsp;[#t/]
			[#else]			
				[#assign ctt=list[i]/]
				[#include style_core/][#t/]
			[/#if]
		</td>[#if i%rollCols==rollCols-1]</tr>[/#if][#lt/]
		[/#list]
		</table>
	</div>
	<div id="roll-copy-${RLID}"></div>
</div>
<script type="text/javascript">
var proll${RLID}=new JCore.UpRoller(${RLID},${rollSpeed},[#if isSleep=="1"]true[#else]false[/#if],${rollSleepTime},${rollCount},${rollSpan},${rollLineHeight});
</script>
