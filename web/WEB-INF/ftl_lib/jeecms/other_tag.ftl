<#--FLASHµ÷ÓÃ-->
<#macro Flash path width='748' height='120'>
<#if !path?starts_with('/')><#assign path='/'+path></#if>
<script type="text/javascript">JCore.showFlash("${root+path}",${width},${height})</script>
</#macro>