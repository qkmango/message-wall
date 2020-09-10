$(function() {
	
	function submit() {
		var nickname = $("[name='nickname']")[0];
		var sex = $("input:radio:checked")[0];
		var birthday = document.getElementById("birthday");
		var qq = $("[name='qq']")[0];
		var tel = $("[name='tel']")[0];
		var hide = $(":checkbox");
		var form = $(".basicinfo")[0];
		var json = {
			'email': $(hide[0]).is(':checked')==true?'0':'1',
			"sex":$(hide[1]).is(':checked')==true?'0':'1',
			"birthday":$(hide[2]).is(':checked')==true?'0':'1',
			"qq":$(hide[3]).is(':checked')==true?'0':'1',
			"tel":$(hide[4]).is(':checked')==true?'0':'1',
			};
		var agaxStr = "nickname="+nickname.value+"&sex="+sex.value+"&birthday="+birthday.value+"&qq="+qq.value+"&tel="+tel.value+"&json="+JSON.stringify(json);
		updateInfo(agaxStr);
	}
	
	
	// AJAX
	function updateInfo(str) {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4) {
				if (xhr.responseText == "1") {
					$("#msg").innerHTML("<font style='color:green;'>✔更新成功！</font>");
				} else {
					$("#msg").innerHTML("<font style='color:red;'>✖更新失败！</font>");
				}
			}
		}
		xhr.open("POST","http://localhost:8080/MessageWall/test",true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(str);
	}

})