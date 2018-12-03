package com.connext.registe;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.connext.model.User;
import com.connext.service.impl.SmsServiceImpl;

import dao.SmsDao;
import dao.UserDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LS")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text2 = request.getParameter("lformetext");
		String password2=request.getParameter("lpasswordtext");
		UserDao ud=new UserDao();
		if(ud.ifexist(text2)==0) {
			System.out.println("数据库中存在账号");
			response.sendRedirect("MessageList.jsp"); 
	} 
	}
}
