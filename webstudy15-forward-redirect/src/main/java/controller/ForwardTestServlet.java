package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.MockDAO;

/**
 * Servlet implementation class ForwardTestServlet
 */
@WebServlet("/ForwardTestServlet")
public class ForwardTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Model과 연동
		MockDAO dao = new MockDAO();
		dao.regist("상품정보");
		//forward 방식으로 이동
		String path="forward-result.jsp";
		//forward 방식은 기존 request. 와 response 가 유지된 상태로 이동된다
		request.setAttribute("shareInfo", "검색정보");
		request.getRequestDispatcher(path).forward(request, response);
	}
}
