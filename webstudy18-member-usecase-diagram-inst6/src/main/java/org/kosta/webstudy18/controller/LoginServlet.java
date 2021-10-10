package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy18.model.MemberDAO;
import org.kosta.webstudy18.model.MemberVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//client가 보낸 id와 password를 받는다 
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		try {
			MemberVO vo=MemberDAO.getInstance().login(id, password);
			String url=null;
			if(vo==null) {//아이디 또는 패스워드가 일치하지 않을 때
				url="login-fail.jsp";
			}else {//아이디와 패스워드가 일치할 때 
				HttpSession session=request.getSession();//getSession() : 기존 세션이 있으면 기존 세션 리턴, 없으면 새로 생성해서 리턴 
				session.setAttribute("mvo", vo);//세션에 인증정보를 할당한다 
				url="index.jsp";
			}
			response.sendRedirect(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}















