package com.shinowit.server;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shinowit.bbs.BaseDAO.IMessageImpl;

/**
 * Servlet implementation class DeleteMsg
 */
public class DeleteMsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		int msgId=Integer.valueOf(request.getParameter("msgId"));
		boolean result=new IMessageImpl().deleteMsg(msgId);
		
		if(result){
			request.setAttribute("err_msg", "留言删除成功！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else{
			request.setAttribute("err_msg", "删除失败！");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
		
	}

}
