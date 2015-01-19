<%@ page language="java" contentType="text/html; charset=utf-8" import="com.shinowit.entity.UserInfo"
    pageEncoding="utf-8"%>
<%
    UserInfo user=(UserInfo)session.getAttribute("userInfo");
    	if(user==null){
    		response.sendRedirect("./login.jsp");
    	}
    %>