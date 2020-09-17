// 更改密码JS
$(function() {
	// alert()
	var $inputs = $(":password");
	// 原密码、新密码、确认密码
	var old_pwd = $inputs[0];
	var new_pwd = $inputs[1];
	var confirm_pwd = $inputs[2];
	
	var $error_tips = $(".error_tip");
	var old_et = $error_tips[0];
	var new_et = $error_tips[1];
	var con_et = $error_tips[2];
	
	var button = $(":button")[0];
	var msg = $("#msg")[0];
	
	
	// 检查密码
	function checkPassword(value,errorTipObj) {
		if(isValidPassword(value)) {
			errorTipObj.innerText = ""
			return true;
		} else {
			errorTipObj.innerText = "密码不合法！"
			return false;
		}
	}
	
	// 检查确认密码
	function checkConfirmPassword(value1,value2,errorTipObj) {
		if(value1 == value2) {
			errorTipObj.innerText = "";
			return true;
		} else {
			errorTipObj.innerText = "确认密码与新密码不一样！";
			return false;
		}
	}
	
	// 注册onblur事件
	old_pwd.onblur = function() {
		checkPassword(this.value,old_et);
	}
	
	new_pwd.onblur = function() {
		checkPassword(this.value,new_et);
	}
	
	confirm_pwd.onblur = function() {
		checkConfirmPassword(new_pwd.value,confirm_pwd.value,con_et);
	}
	
	
	button.onclick = function() {
		if(checkPassword(old_pwd.value,old_et) & 
			(checkPassword(new_pwd.value,new_et) & 
			checkConfirmPassword(new_pwd.value,confirm_pwd.value,con_et))) {

			if (old_pwd.value==new_pwd.value) {
				alert("旧密码与新密码相同！");
			} else {
				updatePwd(old_pwd.value,new_pwd.value);
			}
		}
	}
	
	
//	AJAX 更新密码
	function updatePwd(oldPassword, newPassword) {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4) {
				if (xhr.responseText == "1") {
					msg.innerText = "✅ 更新成功！";
				} else {
					msg.innerText = "❌ 更新失败！";
				}
			}
		}
		xhr.open("POST","/MessageWall/chpwd",true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send("oldpwd="+oldPassword+"&newpwd="+newPassword);
	}

	
	
	
})