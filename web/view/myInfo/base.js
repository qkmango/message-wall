$(function() {


	var nickname = $("[name='nickname']")[0];
	var sex = $('select')[0];
	var birthday = document.getElementById("birthday");
	var qq = $("[name='qq']")[0];
	var tel = $("[name='tel']")[0];
	var hide = $(":checkbox");

	var submitBtn = $(":button")[0];
	var msg = $("#msg")[0];
	var inputObjs = $("input");
	var select = $("select");


	//检查QQ、Tel、Nickname是否合法
	function checkQQ(qq) {
		if (qq == "") {
			return true;
		}
		if (checkString(qq,5,11,false,"QQ号")) {
			if (isNumber(qq)) {
				return true;
			}
			alert("QQ号：必须全为数字！")
			return false;
		}
		return false;
	}

	function checkTel(tel) {
		if (tel == "" || isTelNum(tel)) {
			return true;
		}
		alert("电话号:不合法!");
		return false;
	}

	function checkNickname(nickname) {
		if (checkString(nickname,4,10,false,"昵称")) {
			return true;
		}
		return false;
	}






	//输入域与复选框值发生改变时，设置提示信息
	$(":checkbox,select").bind("change",function(){
		msg.innerText = "🔄 待更新";
	});

	$(":text").on('input propertychange',function(){
		msg.innerText = "🔄 待更新";
	});



	function submit() {
		if (checkNickname(nickname.value) && (checkQQ(qq.value) && checkTel(tel.value))){
			var hideStr = "";
			for(var i = 0;i<hide.length;i++) {
				if($(hide[i]).is(':checked')==true) {
					hideStr = hideStr + "0";
				} else {
					hideStr = hideStr + "1";
				}
			}

			var agaxStr = "nickname="+nickname.value+"&sex="+sex.value+"&birthday="+birthday.value+"&qq="+qq.value+"&tel="+tel.value+"&hide="+hideStr;
			// alert(agaxStr);
			updateInfo(agaxStr);
		}
	}
	
	
	// AJAX
	function updateInfo(str) {
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
		xhr.open("POST","/MessageWall/updatemybaseinfo",true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(str);
	}

	submitBtn.onclick = function() {
		submit()
	}
	
})