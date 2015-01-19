function gotopage(maxPageNumber){
	
	var pageNumValue=document.getElementById("pageNum").value;
	
	if ((null==pageNumValue) || (pageNumValue.length<1)){
		alert('请输入要转到哪一页!');
		document.getElementById("pageNum").focus();
		return false;
	}
	if ((pageNumValue>maxPageNumber) || (pageNumValue<1)){
		alert('请输入正确的跳转页号!');
		document.getElementById("pageNum").focus();
		return false;
		
	}
	window.location.href="index.jsp?pageNum="+pageNumValue;
}