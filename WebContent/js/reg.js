function validCheck(){


	if(!document.getElementById("agreement").checked){
		alert("请同意服务条款后再进行注册！");
		return false;
	}
	
	var username=document.getElementById("username").value
	if(null==username||username.length<1){
		alert("用户名不能为空！！！！！！！！！！！！");
		document.getElementById("username").focus();
		return false;
	}
	
	var password=document.getElementById("userpass").value;
	var password1=document.getElementById("userpass1").value;
	if(password.length==0){
		alert("密码不能为空！！");
		return false;
	}
	if(!(password===password1)){
		alert("两次输入的密码不一致！");
		document.getElementById("userpass").focus();
		return false;
	}
		
	var birthday=document.getElementById("birthday").value;
	if(null==birthday||birthday.length<1){
		alert("请选择出生日期！");
		document.getElementById("birthday").focus();
		return false;
	}
	
	document.forms[0].submit();
}


function checkValidCode(){
	document.getElementById("validCode").src="validCode.jsp";
}