$(function() {

	//是否删除成功的提示文字span节点
	var msg = $("#msg")[0];
	//删除按钮
	$(":button")[0].onclick = function() {
		submit();
	}
	
	
	var $checkboxs = $(":checkbox");
	function submit() {
		var mids = "";
		var agaxStr;
		for(var i = 0;i<$checkboxs.length;i++) {
			if($($checkboxs[i]).is(':checked')==true) {
				mids = mids + $checkboxs[i].value + ",";
			}
		}

		if (mids=="") {
			alert("请选择！");
		} else {
			var agaxStr = "mids="+mids;
			dleMessages(agaxStr);
		}
	}
		

	//删除选中的行的节点
	function delSelectChild() {
		for(var i = 0;i<$checkboxs.length;i++) {
			if($($checkboxs[i]).is(':checked')==true) {
				//获取选中元素的父节点的父节点，就是一列数据，然后删除
				$checkboxs[i].parentNode.parentNode.remove();
			}
		}
	}
	
		
	// AJAX
	function dleMessages(str) {
		var xhr = new XMLHttpRequest();
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4) {
				if (xhr.responseText == "1") {
					delSelectChild();
					msg.innerText = "✅ 删除成功！";
				} else {
					msg.innerText = "❌ 删除失败！";

				}
			}
		}
		xhr.open("POST","/MessageWall/delmessages",true);
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		xhr.send(str);
	}
	
})