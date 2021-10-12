package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy18.model.MemberDAO;
import org.kosta.webstudy18.model.MemberVO;

/**
 * Servlet implementation class IdCheckServlet
 */
@WebServlet("/IdCheckServlet")
public class IdCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = (String) request.getAttribute("id");
		
		try {
			MemberVO vo = MemberDAO.getInstance().findMemberById(id);
			String path = null;
			if(vo==null) {
				path="idcheck-ok.jsp";
			}else {
				path="idcheck-fail.jsp";
			}
			response.sendRedirect(path);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
