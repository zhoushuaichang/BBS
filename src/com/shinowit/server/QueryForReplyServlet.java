package com.shinowit.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinowit.bbs.BaseDAO.IReplyMsgImpl;
import com.shinowit.entity.ReplyMsg;

/**
 * Servlet implementation class QueryForReplyServlet
 */
public class QueryForReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		int replyId = Integer.valueOf(request.getParameter("replyId"));

		ReplyMsg replyMsg = new IReplyMsgImpl().queryForReply(replyId);

		request.setAttribute("replyMsg", replyMsg);
		request.getRequestDispatcher("/change.jsp?replyId="+replyMsg.getReplyId()).forward(request, response);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		int replyId = (int) request.getAttribute("replyId");

		ReplyMsg replyMsg = new IReplyMsgImpl().queryForReply(replyId);

		request.setAttribute("replyMsg", replyMsg);
		request.getRequestDispatcher(request.getContextPath() + "/change.jsp?replyId="+replyMsg.getReplyId()).forward(request, response);

	}

}
