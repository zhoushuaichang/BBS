package com.shinowit.server;

import java.io.IOException;
import java.sql.Types;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinowit.bbs.BaseDAO.BaseDAO;

/**
 * Servlet implementation class ReplyServlet
 */
public class ReplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession(true);
		String postMsgContent=request.getParameter("msgsubmit");
		int currentLoginUserId=Integer.valueOf(request.getParameter("userId"));
		int msgId=Integer.valueOf(request.getParameter("msgId"));

		
		String sql="insert into ReplyMsg(userId,replyDate,msgId,replyContent) values (?,getdate(),?,?)";
		
		int i=BaseDAO.update(sql, new Object[]{currentLoginUserId,msgId,postMsgContent}, new int[]{Types.INTEGER,Types.INTEGER,Types.VARCHAR});
		if (i>0){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			request.setAttribute("err_msg", "回复留言失败,请重新回复!");
			session.setAttribute("msgreply", request.getParameter("msgsubmit"));
			request.getRequestDispatcher("/reply.jsp").forward(request, response);
		}
	}

}
