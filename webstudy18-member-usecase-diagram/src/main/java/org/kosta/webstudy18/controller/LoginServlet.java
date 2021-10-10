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

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("memberId");
		String pass = request.getParameter("memberPass");

		try {
			MemberVO vo = MemberDAO.getInstance().login(id, pass);
			String url = null;
			if (vo != null) {
				HttpSession session = request.getSession();
				session.setAttribute("MemberVO", new MemberVO(vo.getId(), null, vo.getName(), vo.getAddress()));
				url = "index.jsp";
			} else {
				url = "login-fail.jsp";
			}
			response.sendRedirect(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
