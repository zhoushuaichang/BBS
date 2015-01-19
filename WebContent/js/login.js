function loginCheck(){
	
	var username=document.getElementById("username").value
	if(null==username||username.length<1){
		alert("用户名不能为空！！！！！！！！！！！！");
		document.getElementById("username").focus();
		return false;
	}
	
	var password=document.getElementById("userpass").value;
	if(password.length==0){
		alert("密码不能为空！！");
		return false;
	}

	var validCode=document.getElementById("code").value;
	if((validCode==null)||(validCode.length<4)){
		alert('请输入正确的验证码！');
		return false;
	}
	
	document.forms[0].submit();
}

function checkValidCode(){
	document.getElementById("validCode").src="validCode.jsp";
}