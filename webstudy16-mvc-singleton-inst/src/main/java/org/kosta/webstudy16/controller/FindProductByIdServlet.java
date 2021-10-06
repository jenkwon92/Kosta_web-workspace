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
			//  ProductVO vo = ProductDAO.getInstance().findProductById(id);  //강사님 코드
			String path = null;
			if (vo == null) {
				path = "find-fail.jsp";
			} else {
				path = "find-ok.jsp";
				request.setAttribute("ProductVO", vo);
			}
			request.getRequestDispatcher(path).forward(request, response);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
