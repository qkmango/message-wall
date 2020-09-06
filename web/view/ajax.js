$(function(){
	
	
	$("input")[0].onclick = function() {
		// 创建对象
		var xhr = new XMLHttpRequest();

		// 注册回调函数
		// 当xhr对象的readyState的值发生改变时时执行此函数
		xhr.onreadystatechange = function(){
			// xhr.readyState == 4时说明服务端响应结束
			if(xhr.readyState == 4) {
				if (xhr.responseText == "true") {
					alert("登陆成功")
				} else {
					error_tip
				}

				
			} else {
				// xhr.status响应状态码
				// alert(xhr.status);
				// alert("else")
			}
		}
		
		
		xhr.open("GET","http://localhost:8080/MessageWall/login",true);
		
		xhr.send()
	}

	
})