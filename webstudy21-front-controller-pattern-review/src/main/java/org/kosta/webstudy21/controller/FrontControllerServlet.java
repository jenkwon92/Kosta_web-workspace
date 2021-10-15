package org.kosta.webstudy21.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontControllerServlet
 */
@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/*
	 * client가 전송한 command 를 받아온다 (이 command를 이용해 요청을 처리할 Controller 객체를 생성하게 된다)
	 * HandlerMapping(컨트롤러 객체 생성을 전담하는 객체) 를 이용해 Controller 객체를 리턴받는다
	 * Controller 객체를 실행한다 (Controller interface의 abstract method인 execute()실행)
	 * 실행 후 반환하는 view path를 이용해 forward방식 또는 redirect 방식으로 클라이언트에게 응답한다
	 * 
	 *
	 */
	protected void doDispatch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doDispatch(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//http request body의 데이터를 인코딩 : 한글처리
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}

}
