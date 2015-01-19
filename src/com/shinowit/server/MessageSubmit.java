package com.shinowit.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinowit.bbs.BaseDAO.IMessageImpl;
import com.shinowit.entity.Message;
import com.shinowit.entity.UserInfo;

/**
 * Servlet implementation class MessageSubmit
 */
public class MessageSubmit extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession(true);
		UserInfo userinfo=(UserInfo)session.getAttribute("userInfo");
		
		Message message=new Message();
		message.setUserId(userinfo.getUserId());
		message.setMsgContent(request.getParameter("msgsubmit"));
		
		boolean result=new IMessageImpl().create(message);
		if(result){
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else{
			session.setAttribute("msgSubErr", "留言失败，请重新留言");
			session.setAttribute("msgtext", request.getParameter("msgsubmit"));
			response.sendRedirect(request.getContextPath()+"/edit.jsp");
		}
	}

}
