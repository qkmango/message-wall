$(function() {
	// 重置按钮
	var reset = $(":reset");
	// 自定义头像的base64字符串
	var base64Str = new Object("");
	// 自定义头像，文件输入域
	var $img_upload = $("#img_upload");
	// 添加函数
	$img_upload.change(toBase64);
	// 自定义头像的img显示
	var diyAvatarImg = document.getElementById('img');
	// 更新按钮
	var button = $(":button")[0];
	
	
	button.onclick = function() {
		// 选中的头像的value值
		var checkedValue = $('input[name="avatar"]:checked').val();
		if ((typeof checkedValue) == "undefined") {
			alert("请选择头像！")
		} else {
			if(checkedValue != "0") {
				upAvatar(checkedValue);
			} else {
				if(base64Str == "") {
					alert("请上传自定义头像，或选择其他头像！")
				} else {
					upAvatar(base64Str);
				}
			}
		}
	}
	

	// $img_upload改变时调用方法
	function toBase64 (e) {
		var file = $img_upload[0].files[0];
		if(!/image\/\w+/.test(file.type)){
			alert("请确保文件为图像类型");
			reset.click();
			return false;
		}
		var reader = new FileReader();
		reader.onload = (function (file) {
			return function (e) {
				base64Str = this.result;
				compress(base64Str, 100, 5);
				return this.result;
			};
		})(e.target.files[0]);
		reader.readAsDataURL(e.target.files[0]);
	}
	
	// 压缩base64
	function compress(base64String, w, quality) {
		var getMimeType = function (urlData) {
			var arr = urlData.split(',');
			var mime = arr[0].match(/:(.*?);/)[1];
			return mime;
		};
		var newImage = new Image();
		var imgWidth, imgHeight;

		var promise = new Promise(resolve => newImage.onload = resolve);
		newImage.src = base64String;
		return promise.then(() => {
			imgWidth = newImage.width;
			imgHeight = newImage.height;
			var canvas = document.createElement("canvas");
			var ctx = canvas.getContext("2d");
			if (Math.max(imgWidth, imgHeight) > w) {
				if (imgWidth > imgHeight) {
					canvas.width = w;
					canvas.height = w * imgHeight / imgWidth;
				} else {
					canvas.height = w;
					canvas.width = w * imgWidth / imgHeight;
				}
			} else {
				canvas.width = imgWidth;
				canvas.height = imgHeight;
			}
			ctx.clearRect(0, 0, canvas.width, canvas.height);
			ctx.drawImage(newImage, 0, 0, canvas.width, canvas.height);
			var base64 = canvas.toDataURL(getMimeType(base64String), quality);
			var len = base64.length;
			base64Str = base64;
			console.log(base64);
			alert(base64.length);
			alert(base64Str.length);
			diyAvatarImg.src = base64;
			return base64;
		});
	}
	
	//	AJAX 更新密码
		function upAvatar(avatar) {
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
			xhr.open("POST","http://localhost:8080/MessageWall/chavatar",true);
			xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			xhr.send("avatar="+avatar);
		}
	
	
	
	
	
	
})