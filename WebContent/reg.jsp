<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.List"
    pageEncoding="utf-8"%>
    <%
	session.invalidate();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启奥留言板设计案例——注册</title>
<%@ include file="/common/common_head.jsp" %>
<script type="text/javascript">
<%
List<String> msgErrorList=(List<String>)request.getAttribute("msgErrorList");
if(msgErrorList!=null){
	for(String msg:msgErrorList){
		out.println("alert('"+msg+"')");
	}
}
%>
</script>
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
        <div id="log" style="margin-top:10px;">
			<form id="loginForm" action="<%=request.getContextPath() %>/RegServlet" method="post">
        	<div id="ctopd">用户注册</div>
			<div id="cmopd">
				<ul>
					<li><strong class="ltt">登录名：</strong><input type="text" name="username" id="username" class="ltx" value="<%=request.getParameter("username")==null?"":request.getParameter("username")%>"/></li>
					<li><strong class="ltt">登录密码：</strong><input type="password" name="userpass" id="userpass" class="ltx" /></li>
					<li><strong class="ltt">确认密码：</strong><input type="password" name="userpass1" id="userpass1" class="ltx" /></li>
					<li><strong class="ltt">密码保护问题：</strong><input type="text" name="passquestion" id="passquestion" class="ltx" value="<%=request.getParameter("passquestion")==null?"":request.getParameter("passquestion")%>"/></li>
					<li><strong class="ltt">您的答案：</strong><input type="text" name="passanswer" id="passanswer" class="ltx" /></li>
					<li><strong class="ltt">出生日期：</strong><input type="text" name="birthday" id="birthday" class="ltx" onClick="WdatePicker()" value="<%=request.getParameter("birthday")==null?"":request.getParameter("birthday")%>" /></li>
					<li><strong class="ltt">性 别：</strong><input type="radio" name="gender" value="1" checked="checked" />男<input type="radio" name="gender" value="2" />女</li>
					<li><strong class="ltt">昵 称：</strong><input type="text" name="nickname" id="nickname" class="ltx" value="<%=request.getParameter("nickname")==null?"":request.getParameter("nickname")%>" /></li>
					<li><strong class="ltt">密保邮箱：</strong><input type="text" name="email" id="email" class="ltx" value="<%=request.getParameter("email")==null?"":request.getParameter("email")%>"/></li>
					<li><strong class="ltt">验证码：</strong><input type="text" name="code" id="code" class="lty" /><img src="<%=request.getContextPath() %>/validCode.jsp" id="validCode" onClick="checkValidCode()" /></li>
					<li><strong class="ltt">&nbsp;</strong><input type="checkbox" name="agreement" id="agreement" class="ltc" value="1"/>同意服务条款</li>
				</ul>
			</div>
			<div id="cfopd">
				<input type="button" class="btn_sub" value="注册" onclick="return validCheck();" />
				<input type="reset" class="btn_res" value="重置"  />
			</div>
			</form>
        </div>
		<div id="footer">
			<img src="<%=request.getContextPath()%>/images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
</body>
</html>
