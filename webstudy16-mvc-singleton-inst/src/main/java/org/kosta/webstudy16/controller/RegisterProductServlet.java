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
 * Servlet implementation class RegisterProductServlet
 */
@WebServlet("/RegisterProductServlet")
public class RegisterProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String name = request.getParameter("name");
		String maker = request.getParameter("maker");
		int price = Integer.parseInt(request.getParameter("price"));
		try {
			ProductDAO.getInstance().registerProduct(new ProductVO(name,maker,price));
			
			response.sendRedirect("register-result.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
