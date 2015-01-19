$(function(){
	$("#loginForm").submit(function(){
		if($("input[name=username]").val() == "")
		{
			alert("登录名不能为空");
			$("input[name=username]").focus();
			return false;
		}
		else if($("input[name=password]").val() == "")
		{
			alert("密码不能为空");
			$("input[name=password]").focus();
			return false;
		}
		else if($("input[name=code]").val() == "")
		{
			alert("验证码不能为空");
			$("input[name=code]").focus();
			return false;
		}
		else
		{
			return true;
		}
	});

	$(".btn_res").click(function(){
		history.back();
	});
})