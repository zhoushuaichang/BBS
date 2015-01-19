<%@page import="java.util.List"%>
<%@page import="com.shinowit.entity.*,com.shinowit.bbs.BaseDAO.*"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/common/check_login_statue.jsp"%>
<%
	UserInfo userinfo=(UserInfo)session.getAttribute("userInfo");
%>

<%
	IMessage messageDao=new IMessageImpl();

int currentPageIndex=1; //当前要显示第x页
int pageSize=2;//每页显示多少条记录

if (request.getParameter("pageNum")!=null){
	currentPageIndex=Integer.valueOf(request.getParameter("pageNum"));
}
List<Message> msgList=messageDao.queryForPage(pageSize, currentPageIndex);

PageInfo pageInfo=messageDao.getPageInfo(pageSize, currentPageIndex);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<script src="<%=request.getContextPath()%>/js/index.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>启奥留言板设计案例</title>
<link href="<%=request.getContextPath()%>/css/style.css"
	rel="stylesheet" type="text/css" />
</head>

<body>
	<div id="main">
		<div id="header">
			<img src="<%=request.getContextPath()%>/images/logo.gif"
				alt="启奥留言板设计案例" />
			<div>
				<a>欢迎<%=userinfo.getUserName()%></a>&nbsp;&nbsp;&nbsp; 
				<a href="<%=request.getContextPath()%>/logout.jsp">安全退出</a>
			</div>
		</div>

		<div id="content">

			<div id="cheader"></div>
			<div id="cmenu">
				<a href="<%=request.getContextPath()%>/edit.jsp">【我要留言】</a> 
				<a	href="">【查看所有留言】</a>
			</div>

			<%
				for (int msgIndex=0;msgIndex<msgList.size();msgIndex++){
				  Message msgInfo=msgList.get(msgIndex);
				  String userHead=request.getContextPath()+"/images/templogo.gif";
				  if((msgInfo.getUser().getPic()!=null)&&(msgInfo.getUser().getPic().trim().length()>0)){
					  userHead=request.getContextPath()+msgInfo.getUser().getPic();
				  }
			%>
			<div class="ccon">
				<div class="info">
					<img src="<%=userHead %>" alt="" />
					<strong><%=msgInfo.getUser().getNickName()%></strong> 
					<span><%=msgInfo.getMsgDateString()%></span>
				</div>
				<div class="liuy">
					<div class="liuyan">
						<%=msgInfo.getMsgContent()%>
					<div class="com">
							<a href="<%=request.getContextPath()%>/reply.jsp?msgId=<%=msgInfo.getMsgId()%>">回复此留言</a>&nbsp;&nbsp;&nbsp;
							<%
								if (userinfo.getUserId()==msgInfo.getUserId()){
							%>
							<a href="<%=request.getContextPath()%>/deleteMsg.jsp?msgId=<%=msgInfo.getMsgId()%>">删除</a>
							<% } %>
						</div>
 					</div>

					<%
						for (int replyIndex=0;replyIndex<msgInfo.getReplyList().size();replyIndex++){
									  ReplyMsg replyMsg=msgInfo.getReplyList().get(replyIndex);
					%>

					<div class="huifu">
						<font class="hf">[回复]</font>回复人：
						<%=replyMsg.getReplayUserInfo().getNickName()%>
						回复时间:<%=replyMsg.getReplyTimeString()%>
						<br />回复内容:<%=replyMsg.getReplyContent()%>
						<%
							if (userinfo.getUserId()==replyMsg.getUserId()){
						%>
						<div class="com">
							<a href="<%=request.getContextPath()%>/QueryForReplyServlet?replyId=<%=replyMsg.getReplyId()%>">修改此回复</a>&nbsp;&nbsp;&nbsp;
							<a href="<%=request.getContextPath()%>/deleteReply.jsp?replyId=<%=replyMsg.getReplyId()%>">删除</a>
						</div>
						<% }else{ 
							out.print("<br /><br />");
						} %>
					</div>
					<% } %>
				</div>
			</div>
			<% } %>

			<div class="page">
				共
				<%=pageInfo.getRecordCount()%>条留言 / 分
				<%=pageInfo.getPageCount()%>
				页显示 / 当前第 <%=currentPageIndex%> 页 / 
				<input type="text" name="pageNum" id="pageNum" value="<%=currentPageIndex%>" style="width: 20px;" /> 
				<input type="button" value="Go" onclick="gotopage(<%=pageInfo.getPageCount()%>)" />
				<% if (pageInfo.havePriorPage()){ %>
				<a href="<%=request.getContextPath()%>/index.jsp?pageNum=<%=currentPageIndex-1%>" style="color: black;">前一页</a>
				<% } %>
				<% if (pageInfo.haveNextPage()){ %>
				<a href="<%=request.getContextPath()%>/index.jsp?pageNum=<%=currentPageIndex+1%>" style="color: black;">后一页</a>
				<% } %>
			</div>
			<div id="cfooter"></div>
		</div>

		<div id="footer">
			<img src="<%=request.getContextPath()%>/images/logof.gif"
				alt="唐山市启奥职业培训学校" />
		</div>
	</div>
	<script type="text/javascript">
<%if (request.getAttribute("err_msg")!=null){
	  out.println("alert('"+request.getAttribute("err_msg")+"');");
  }%>
</script>
</body>
</html>
