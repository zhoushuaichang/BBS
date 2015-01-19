package com.shinowit.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinowit.bbs.BaseDAO.IMessageImpl;
import com.shinowit.bbs.BaseDAO.IReplyMsgImpl;

/**
 * Servlet implementation class DeleteReply
 */
public class DeleteReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int replyId=Integer.valueOf(request.getParameter("reply"));
		boolean result=new IReplyMsgImpl().deleteReply(replyId);
		
		if(result){
			request.setAttribute("err_msg", "回复删除成功！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else{
			request.setAttribute("err_msg", "删除失败！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
