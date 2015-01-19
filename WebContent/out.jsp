
<%@ page language="java" contentType="text/html; charset=utf-8" import="java.util.List,com.shinowit.entity.SessionListForLogin"
    pageEncoding="utf-8"%>
<%@ include file="/common/check_login_statue.jsp"%>

<%
String sid=(String)request.getParameter("sid");
List<HttpSession> current_session_list=SessionListForLogin.getSession();
int size=current_session_list.size();
for(int i=0;i<size;i++){
	HttpSession sesion=current_session_list.get(i);
	if(sid.equals(sesion.getId())){
		session.invalidate();
		SessionListForLogin.getSession().remove(sesion);
	}
}
if(current_session_list.size()<size){
	request.setAttribute("outMsg", "已成功踢出！");
	request.getRequestDispatcher("/showlogin.jsp").forward(request, response);
}else{
	request.setAttribute("outMsg", "踢出失败！");
	response.sendRedirect("/showlogin.jsp");
}

%>
