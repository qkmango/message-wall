// 验证是否为有效的email，返回boolean值
function isValidEmail(str) {
	if(/(^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$)/.test(str)){
	　　return true;
	} else {
		return false;
	}
}


// 判断密码是否合法
// 长度6-20个字符，包括大写字母、小写字母、数字、下划线至少两种
function isValidPassword(str) {
	if(str.length<6||str.length>20){
	  return false;
	}
	if(/[^a-zA-Z0-9_]/.test(str)){
	  return false;
	}
	if(/(^[a-z]+$|^[A-Z]+$|^\d+$|^_+$)/.test(str)){
	  return false;
	}
	return true;
}


//判断字符串是否在min和max之间，并且是否可存在空格
//strName是存入字符串的名字，在提示的时候使用
function checkString(str,min,max,space,strName) {
	var len = str.length;
	if (len>=min & len <= max) {
		if (space || (str.indexOf(" ") == -1)) {
			return true;
		} else {
			alert(strName + "：存在空格！");
			return false;
		}
	} else {
		alert(strName + "：长度不在["+min+","+max+"]之间！");
		return false;
	}
}

//判断是否为数字的函数
function isNumber(str) {
	var regPos = /^\d+(\.\d+)?$/; //非负浮点数
	// var regNeg = /^(-(([0-9]+\.[0-9]*[1-9][0-9]*)|([0-9]*[1-9][0-9]*\.[0-9]+)|([0-9]*[1-9][0-9]*)))$/; //负浮点数
	if(regPos.test(str)) {
		return true;
	} else {
		return false;
	}
}


// 判断两个值是否相等
function isEqual(str1,str2) {
	if(str1 === str2) {
		return true;
	} else {
		return false;
	}
}


// 判断是否为手机号码
function isTelNum(str) {
	if(/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/.test(str)) {
		return true;
	}
	return false;
}