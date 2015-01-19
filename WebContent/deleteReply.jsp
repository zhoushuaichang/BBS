<%@page import="com.shinowit.entity.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.*"
    pageEncoding="utf-8"%>
<%@ include file="/common/check_login_statue.jsp" %>    
<% 
String _path=request.getContextPath();
UserInfo userinfo=(UserInfo)session.getAttribute("userInfo");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>启奥留言板设计案例_修改</title>
<%@ include file="/common/common_head.jsp" %>
<script src="<%=request.getContextPath()%>/js/msgsubmit.js"></script>
</head>
<body>
	<div id="main">
    	<div id="header">
        	<img src="<%=_path%>/images/logo.gif" alt="启奥留言板设计案例" />
            <div>
            <a>欢迎<%=userinfo.getUserName() %></a>&nbsp;&nbsp;&nbsp;
            	<a href="<%=_path%>/logout.jsp">安全退出</a>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
        <div id="log">
			<form id="loginForm" method="post" action="<%=request.getContextPath()%>/DeleteReply">
			<input type="hidden" name="reply" value="<%=request.getParameter("replyId") %>"/>
			
        	<div id="ctopd">删除此回复？</div>
			
			<div id="cfopd">
				<input type="submit" class="btn_sub"  value="确认删除" />
				<input type="button" class="btn_res" value="取 消" onclick="javascript:window.history.back();" />
			</div>
			</form>
        </div>
		<div id="footer">
			<img src="<%=_path%>/images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
<script type="text/javascript">
<%
  if (request.getAttribute("err_msg")!=null){
	  out.println("alert('"+request.getAttribute("err_msg")+"');");
  }
%>
</script>    
</body>
</html>
