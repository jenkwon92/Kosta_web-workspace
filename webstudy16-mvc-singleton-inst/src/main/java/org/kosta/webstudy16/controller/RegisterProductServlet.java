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
		//post 방식은 http request body에 데이터가 전달되므로 별도의 한글 처리가 필요하다
		request.setCharacterEncoding("utf-8");
		
		//client가 전송한 상품 정보를 받아온다
		String name = request.getParameter("name");
		String maker = request.getParameter("maker");
		int price = Integer.parseInt(request.getParameter("price"));
		try {
			//productDAO 는 Singleton Design Pattern 적용되어 있으므로 new 생성자로 객체 생성하는 것이 
			//아니라 static 메서드로 객체의 주소값ㅇ르 리턴받아 register메서드를 실행한다
			ProductDAO.getInstance().registerProduct(new ProductVO(name,maker,price));
			//forward 
			response.sendRedirect("register-result.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
