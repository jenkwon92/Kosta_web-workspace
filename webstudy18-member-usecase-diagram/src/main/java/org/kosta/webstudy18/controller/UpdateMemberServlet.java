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
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
	
		MemberVO vo =(MemberVO) session.getAttribute("MemberVO"); 
		try {
			vo.setName(request.getParameter("memberName"));
			vo.setPassword(request.getParameter("memberPass"));
			vo.setAddress(request.getParameter("memberAddress")); 
			MemberDAO.getInstance().updateMember(vo);
			request.setAttribute("MemberVO", vo);
			response.sendRedirect("update-result.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
