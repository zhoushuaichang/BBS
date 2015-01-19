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
<title>启奥留言板设计案例--留言</title>
<%@ include file="/common/common_head.jsp" %>
<script src="<%=request.getContextPath()%>/js/msgsubmit.js"></script>
</head>
<body>
	<div id="main">
    	<div id="header">
        	<img src="<%=_path%>/images/logo.gif" alt="启奥留言板设计案例" />
            <div>
            	<a href="<%=_path%>/logout.jsp">退出</a>&nbsp;&nbsp;&nbsp;
            </div>
        </div>
        <div id="log">
			<form id="loginForm" method="post" action="<%=request.getContextPath()%>/ReplyServlet">
			<input type="hidden" name="userId" value="<%=userinfo.getUserId()%>"/>
			<input type="hidden" name="msgId" value="<%=request.getParameter("msgId") %>"/>
        	<div id="ctopd">发表回复</div>
			<div id="cmopd">
				<ul>
					<li><strong class="lts">姓名：</strong><label><%out.println(userinfo.getNickName());%></label> </li>
					<li><strong class="lts">邮箱：</strong><label><%out.println(userinfo.getEmail());%></label></li>
					<li><strong class="lts">回复：</strong><textarea name="msgsubmit" id="msgsubmit" class="ltxs"><%=request.getParameter("msgreply")==null?"":request.getParameter("msgreply")%> </textarea></li>
				</ul>
			</div>
			<div id="cfopd">
				<input type="button" class="btn_sub"  value="回复留言" onclick="msgCheck()"/>
				<input type="button" class="btn_res" value="返 回" onclick="javascript:window.history.back();" />
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
