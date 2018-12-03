package com.connext.registe;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.connext.model.User;
import com.connext.service.impl.SmsService;
import com.connext.service.impl.SmsServiceImpl;

import dao.SmsDao;
import dao.UserDao;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")

public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");
		String password=request.getParameter("passwordtext");
		String code=request.getParameter("codehh");
		String random=request.getParameter("providecode");
		System.out.println(password+"已接收数据");
		System.out.println(phone);
		SmsService smsService = new SmsServiceImpl();
		if(code.equals(random)){
			System.out.println("验证码验证成功，存入数据库准备登录"); 
		    smsService.save(phone,Integer.parseInt(random), password);
			response.sendRedirect("login.jsp");
		}
		response.getWriter().print(random);
	}
	
}
