var x_1 = 780,y_1 = 60
var xin_1 = true, yin_1 = true
var step_1 = 1
var delay_1 = 25
var obj_1=document.getElementById("ad_2")
function floatAD_1() {
var L_1=T_1=0
var R_1= document.body.clientWidth-obj.offsetWidth
var B_1 = document.body.clientHeight-obj.offsetHeight
obj_1.style.left = x_1 + document.body.scrollLeft
obj_1.style.top = y_1 + document.body.scrollTop
x_1 = x_1 + step_1*(xin_1?1:-1)
if (x_1 < L_1) { xin_1 = true; x_1 = L_1}
if (x_1 > R_1){ xin_1 = false; x_1 = R_1}
y_1 = y_1 + step_1*(yin_1?1:-1)
if (y_1 < T_1) { yin_1 = true; y_1 = T_1 }
if (y_1 > B_1) { yin_1 = false; y_1 = B_1 }
}
var itl_1= setInterval("floatAD_1()", delay_1)
obj_1.onmouseover=function(){clearInterval(itl_1)}
obj_1.onmouseout=function(){itl_1=setInterval("floatAD_1()", delay_1)}


			function hidead_2()
			{
				document.getElementById("ad_2").style.display="none";
			}

