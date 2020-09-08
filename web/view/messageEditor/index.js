$(function() {
	var $panel = $(".panel");
	var $panel_heading = $(".panel-heading");
	var $radios = $(":radio");
	var $anony = $(":checkbox");
	var $nickname = $(".nickname");
	var nickname = $nickname[0].innerText;
	var $submit = $(":button");
	var flag = false;
	
	
	
	$radios.click(function() {
		$panel[0].className = "panel panel-heading-style-" + this.value;
		$panel_heading[0].className = "panel-heading panel-heading-style-" + this.value;
	});
	
	$anony.click(function() {
		if(!flag) {
			$nickname[0].innerText = "匿名发布"
			flag = !flag;
		} else {
			$nickname[0].innerText = nickname;
			flag = !flag;
		}
		
	})
	
	$submit.click(function() {
		$("#msg")[0].value = $("#msgTextarea").val();
		// alert($("#msgTextarea").val())?
		alert($("#msg").val())
		$("form")[0].submit()
	})
	
})