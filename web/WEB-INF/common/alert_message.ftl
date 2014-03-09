<script language="javascript">
$(function(){
<#list actionMessages+actionErrors as msg>
alert("${msg}");
</#list>
});
</script>