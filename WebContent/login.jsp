<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.List"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启奥留言板设计案例--登陆</title>
<%@ include file="/common/common_head.jsp" %>


</head>

<body>
	<div id="main">
    	<div id="header">
        	<img src="<%=request.getContextPath()%>/images/logo.gif" alt="启奥留言板设计案例" />
            <div>
            	<a href="login.jsp">登陆</a>&nbsp;&nbsp;&nbsp;
                <a href="reg.jsp">注册</a>
            </div>
        </div>
        <div id="log">
			<form id="loginForm" action="<%=request.getContextPath()%>/LoginServlet" method="post">
        	<div id="ctopd">用户登录</div>
			<div id="cmopd">
				<ul>
					<li><strong class="ltt">登录名：</strong><input type="text" name="username" id="username" class="ltx" /></li>
					<li><strong class="ltt">密 码：</strong><input type="password" name="userpass" id="userpass" class="ltx" /></li>
					<li><strong class="ltt">验证码：</strong><input type="text" name="code" id="code" class="lty" /><img src="<%=request.getContextPath() %>/validCode.jsp" id="validCode" onclick="checkValidCode()"/></li>
				</ul>
			</div>
			<div id="cfopd">
				<input type="button" class="btn_sub" value="登 录" onclick="return loginCheck()" />
				<input type="reset" class="btn_res" value="重置" />
			</div>
			</form>
        </div>

		<div id="footer">
			<img src="<%=request.getContextPath()%>/images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
    
    <script type="text/javascript">

<%
if(request.getAttribute("msgError")!=null){
	String msg=(String)request.getAttribute("msgError");
	out.println("alert('"+msg+"')");	
}

List<String> msgErrorList=(List<String>)request.getAttribute("msgErrorList");
if(msgErrorList!=null){
	for(String msg:msgErrorList){
		out.println("alert('"+msg+"')");
	}
}
%>

</script>
</body>

</html>
