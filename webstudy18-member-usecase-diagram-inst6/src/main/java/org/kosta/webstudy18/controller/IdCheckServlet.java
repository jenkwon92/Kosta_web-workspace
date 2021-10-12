package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy18.model.MemberDAO;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/IdCheckServlet")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		try {
			boolean  result =MemberDAO.getInstance().idCheck(id);
			String path = null;
			if(result == false) { //아이디 존재하지 않음
				path="idcheck-ok.jsp";
			}else { //아이디 존재
				path="idcheck-fail.jsp";
			}
			request.getRequestDispatcher(path).forward(request, response);
			//session 이용하지않고 reqeust 이용하기때문에 클라이언트가 보낸 아이디 이용하기 떄문에 
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
