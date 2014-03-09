[#--
列表。可以调配的参数有：
如何结合样式表调配？那些可以使用样式表控制，那些需要使用参数控制？
整体样式。可控样式。
标题长度：参数titLen。
行高：参数。lineHeight
下划线：参数。bottomLine
列头：参数；样式（主要控制图标）。headMark
时间格式：参数；dateFormat
时间位置：参数；datePosition【1：左；2：右】
类别形式：参数；ctgForm
类别样式：样式。ctgClass
链接打开方式：参数。target
使用完整标题还是简短标题？
--]
<div class="c1-body">
[#list list as ctt]
[#include "style1-1_core.ftl"/]
[/#list]
</div>
