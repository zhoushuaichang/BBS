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
 * Servlet implementation class ChangeServlet
 */
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession(true);
		String postMsgContent=request.getParameter("msgsubmit");
		int replyId=Integer.valueOf(request.getParameter("reply"));
		
		
		String sql="update  ReplyMsg set replyDate=getdate(),replyContent=? where replyId=?";
		
		int i=BaseDAO.update(sql, new Object[]{postMsgContent,replyId}, new int[]{Types.VARCHAR,Types.INTEGER});
		if (i>0){
			response.sendRedirect(request.getContextPath()+"/index.jsp");
		}else{
			request.setAttribute("err_msg", "修改留言失败,请重新修改!");
			session.setAttribute("msgreply", request.getParameter("msgsubmit"));
			request.getRequestDispatcher("/change.jsp").forward(request, response);
		}
	}

}
