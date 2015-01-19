
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="com.shinowit.entity.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.List,com.shinowit.entity.SessionListForLogin"
    pageEncoding="utf-8"%>
 <%@ include file="/common/check_login_statue.jsp"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<%
UserInfo userinfo=(UserInfo)session.getAttribute("userInfo");
int ss=userinfo.getUserId();
List<HttpSession> current_session_list=SessionListForLogin.getSession();
out.println("<table><tr><td>用户名</td><td>IP</td><td>登录时间</td></tr>");

for(int i=0;i<current_session_list.size();i++){
		HttpSession current_session=current_session_list.get(i);
		String ip=(String)current_session.getAttribute("ip");
		Date d=(Date)current_session.getAttribute("login_time");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date=sdf.format(d);
		UserInfo currentUserInfo=(UserInfo)current_session.getAttribute("userInfo");

		out.println("<tr><td>"+currentUserInfo.getUserName()+"</td><td>"+ip+"</td><td>"+date+"</td>");
		if(ss!=((UserInfo)current_session.getAttribute("userInfo")).getUserId()){
		out.println("<td><a href=\""+request.getContextPath()+"/out.jsp?sid="+current_session.getId()+"\">踢出</a></td></tr>");
		}

		
	}
out.println("</table>");
%>
</body>
</html>