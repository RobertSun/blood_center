function Bpass(e){
			
			if (e=='BloodNo'){
				document.getElementById("BloodCard").className="m-Stable m-none";
				document.getElementById("BloodNo").className="m-Stable";
			}
			if (e=='BloodCard'){
				document.getElementById("BloodCard").className="m-Stable";
				document.getElementById("BloodNo").className="m-Stable m-none";
			}
			
		}