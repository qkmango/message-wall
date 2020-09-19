
$(function() {

	// 检查Email并且显示错误提示信息
	function checkEmail(str) {
		if(isValidEmail(str)) {
			email_errorTip.innerText = "";
			return true;
		} else {
			email_errorTip.innerText = "电子邮件不合法";
			return false;
		}
	}
	// 检查password并且显示错误提示信息
	function checkPassword(str) {
		if(isValidPassword(str)) {
			password_errorTip.innerText = "";
			return true;
		} else {
			password_errorTip.innerText = "密码不合法";
			return false;
		}
	}
	
	// 判断password是否相等并显示提示信息
	function checkPasswordEqul(str1,str2) {
		if(isEqual(str1,str2)) {
			passwordConfirm_errorTip.innerText = "";
			return true;
		} else {
			passwordConfirm_errorTip.innerText = "确认密码不相等";
			return false;
		}
	}

	//判断昵称是否合法
	function checkNickname(str) {
		if (str.length >= 2 & str.length <=10) {
			nickname_errorTip.innerText = "";
			return true;
		} else {
			nickname_errorTip.innerText = "确保用户名长度在[2,10]之间";
			return false
		}
	}
	
	var $inputs = $("input");
	var email = $inputs[0];
	var nickname = $inputs[1]
	var password = $inputs[2];
	var passwordConfirm = $inputs[3];
	var button = $inputs[4];
	var $error_tips = $(".error_tip");
	var email_errorTip = $error_tips[0];
	var nickname_errorTip = $error_tips[1];
	var password_errorTip = $error_tips[2];
	var passwordConfirm_errorTip = $error_tips[3];
	
	


	email.onblur = function() {
		checkEmail(email.value);
	}
	
	password.onblur = function() {
		checkPassword(password.value);
	}
	
	passwordConfirm.onblur = function() {
		checkPasswordEqul(password.value,passwordConfirm.value);
	}

	nickname.onblur = function() {
		checkNickname(nickname.value);
	}

	button.onclick = function() {
		if((checkEmail(email.value) & checkNickname(nickname.value)) & (checkPassword(password.value) & checkPasswordEqul(password.value,passwordConfirm.value))) {
			canRegister(email.value, password.value,nickname.value);
		}
	}





	//	AJAX 判断是否创建新用户成功
	function canRegister(emailValue,passwordvalue,nicknameValue) {

		// alert(nicknameValue)

		// 创建对象
		var xhr = new XMLHttpRequest();
		// 注册回调函数
		// 当xhr对象的readyState的值发生改变时时执行此函数
		xhr.onreadystatechange = function(){
			// xhr.readyState == 4时说明服务端响应结束
			if(xhr.readyState == 4) {
				if (xhr.responseText == "1") {
					alert("注册成功");
					window.location = "/MessageWall/messagewall";
				} else {
					alert("用户已存在")
					email_errorTip.innerHTML = "此Email已注册，可直接<a href='../login/'>登陆</a>";
				}
			}
		}
		xhr.open("POST","/MessageWall/register",true);
		// 如果想要使用post提交数据,必须添加此行
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		// 请求体中发送数据
		xhr.send("email="+emailValue+"&password="+passwordvalue+"&nickname="+nicknameValue);
	}
})