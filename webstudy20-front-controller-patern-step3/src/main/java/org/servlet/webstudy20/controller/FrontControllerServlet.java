package org.servlet.webstudy20.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class frontControllerServlet
 */
@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String command = request.getParameter("command");
			// System.out.println(getServletName()+" "+command);
			Controller controller = null;
			// 개별 컨트롤러 객체 생성 로직
			
			if(command.equals("findCustomerById"))
				controller = new FindCustomerByIdController();
			else if (command.equals("registerCustomer"))
				controller = new RegisterCustomerController();
			String path = controller.execute(request, response);
			if(path.startsWith("redirect:"))  //redirect 으로 시작되는 path 이면
				response.sendRedirect(path.substring(9));
			else
				request.getRequestDispatcher(path).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // http request body에 한글 처리
		doDispatch(request, response);
	}

}
