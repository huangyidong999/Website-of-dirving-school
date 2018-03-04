package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.UserDao;
import com.bean.User;

public class SignUpServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		this.doPost(request, response);
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String profession = request.getParameter("profession");
		String address = request.getParameter("address");
		String remark = request.getParameter("remark");
		String tel = request.getParameter("tel");
		String type = request.getParameter("type");
		User user = new User();
		user.setAddress(address);
		user.setUserName(name);
		user.setEmail(email);
		user.setProfession(profession);
		user.setRemark(remark);
		user.setTel(tel);
		user.setType(type);
		
		UserDao userdao = new UserDao();
		int i =userdao.registUser(user);
		if(i>0){
			request.getRequestDispatcher("index.html").forward(request, response);
		}else{
			request.getRequestDispatcher("about.html").forward(request, response);
		}
	}

	

}
