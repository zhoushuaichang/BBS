package com.shinowit.server;

import java.io.IOException;
import java.sql.Date;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.shinowit.bbs.BaseDAO.BaseDAO;
import com.shinowit.bbs.BaseDAO.IUserInfoImpl;
import com.shinowit.entity.UserInfo;

/**
 * Servlet implementation class RegServlet
 */
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/htnl");
		
		List<String> msgErrorList=new ArrayList<String>();
		
		if(request.getParameter("username")==""){
			msgErrorList.add("用户名不能为空");
		}
		if(request.getParameter("userpass")==""){
			msgErrorList.add("密码不能为空");
		}
		if(!request.getParameter("userpass").equals(request.getParameter("userpass1"))){
			msgErrorList.add("两次密码输入不一致");
		}
		
		HttpSession session=request.getSession(true);
		if(!session.getAttribute("rand").equals(request.getParameter("code"))){
			msgErrorList.add("验证码不正确 ");
		}
		if(msgErrorList.size()>0){
			request.setAttribute("msgError", msgErrorList);
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
			return;
		}

		
		
		UserInfo user=new UserInfo();
		user.setSexCode(Byte.valueOf(request.getParameter("gender")));
		user.setUserName(request.getParameter("username"));
		user.setUserPass(request.getParameter("userpass"));
		user.setPassQues(request.getParameter("passquestion"));
		user.setPassAnswer(request.getParameter("passanswer"));
		user.setNickName(request.getParameter("nickname"));
//		
//		Date birthday = null;
//		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
//		try {
//			java.util.Date datee=sdf.parse(request.getParameter("birthday"));
//			birthday=new java.sql.Date(datee.getTime());
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
		user.setBirthday(request.getParameter("birthday"));
		user.setEmail(request.getParameter("email"));

		boolean result=new IUserInfoImpl().create(user);
		if(result){
//			request.setAttribute("msg", "注册成功！请登录！");
			msgErrorList.add("注册成功！请登录");
			request.setAttribute("msgErrorList", msgErrorList);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else{
			msgErrorList.add("用户名被占用，请更换");
			request.setAttribute("msgErrorList", msgErrorList);
			request.getRequestDispatcher("/reg.jsp").forward(request, response);
		}
		
	}

}
