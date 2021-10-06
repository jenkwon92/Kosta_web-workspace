package org.kosta.webstudy16.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy16.model.ProductDAO;
import org.kosta.webstudy16.model.ProductVO;

/**
 * Servlet implementation class FindProductByIdServlet
 */
@WebServlet("/FindProductByIdServlet")
public class FindProductByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("productId");
		try {
			ProductDAO dao = ProductDAO.getInstance();
			ProductVO vo = dao.findProductById(id);
			String path = null;
			if (vo == null) { // 아이디에 대한 회원정보가 존재하지 않으면
				path = "find-fail.jsp";
			} else { // 존재하면
				path = "find-ok.jsp";
				request.setAttribute("ProductVO", vo);
			}
			request.getRequestDispatcher(path).forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
