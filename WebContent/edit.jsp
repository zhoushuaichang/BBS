<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@ include file="/common/check_login_statue.jsp" %>
 <%UserInfo userinfo=(UserInfo)session.getAttribute("userInfo");%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启奥留言板设计案例</title>
<link href="<%=request.getContextPath()%>/css/style.css" rel="stylesheet" type="text/css" />
<script src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script src="<%=request.getContextPath()%>/js/myjs.js"></script>
<script src="<%=request.getContextPath()%>/js/msgsubmit.js"></script>
<script >
<% String msgSubErr=(String)session.getAttribute("msgSubErr");
	if(msgSubErr!=null){
		out.println("alert('"+msgSubErr+"')");
	}
%>
</script>
</head>

<body>
	<div id="main">
    	<div id="header">
        	<img src="<%=request.getContextPath()%>/images/logo.gif" alt="启奥留言板设计案例" />
            <div>
            <a>欢迎<%=userinfo.getUserName() %></a>&nbsp;&nbsp;&nbsp;
                <a href="<%=request.getContextPath() %>/logout.jsp">安全退出</a>
            </div>
        </div>
        <div id="log">
			<form id="loginForm" action="<%=request.getContextPath() %>/MessageSubmit" method="post">
        	<div id="ctopd">编辑留言</div>
			<div id="cmopd">
				<ul>
					<li><strong class="lts">姓名：</strong><label name="loginName" id="loginName"><%=userinfo.getUserName() %></label></li>
					<li><strong class="lts">邮箱：</strong><label name="loginEmail" id="loginEmail"><%=userinfo.getEmail()  %></label></li>
					<li><strong class="lts">回复：</strong><textarea name="msgsubmit" id="msgsubmit" class="ltxs"><%=(session.getAttribute("msgtext")==null)?"":session.getAttribute("msgtext") %></textarea></li>
				</ul>
			</div>
			<div id="cfopd">
				<input type="button" class="btn_sub" value="提 交" onclick="msgCheck()" />
				<input type="button" class="btn_res" value="返 回" />
			</div>
			</form>
        </div>
		<div id="footer">
			<img src="<%=request.getContextPath()%>/images/logof.gif" alt="唐山市启奥职业培训学校" />
		</div>
    </div>
</body>
</html>