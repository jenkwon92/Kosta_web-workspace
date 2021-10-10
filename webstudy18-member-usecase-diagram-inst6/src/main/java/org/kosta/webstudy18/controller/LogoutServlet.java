package org.kosta.webstudy18.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogoutServlet
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//getSessin(false) : 기존 세션이 있으면 기존 세션을 리턴, 기존 세션이 없으면 null 반환 
		HttpSession session=request.getSession(false);
		if(session!=null) {
			session.invalidate();//세션을 무효화 한다 			
		}
		response.sendRedirect("index.jsp");
	}
}


















