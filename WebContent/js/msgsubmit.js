function msgCheck(){
	
	var message=document.getElementById("msgsubmit").value
	if(null==message||message.length<1){
		alert("留言不能为空！");
		document.getElementById("msgsubmit").focus();
		return false;
	}


	document.forms[0].submit();
}


