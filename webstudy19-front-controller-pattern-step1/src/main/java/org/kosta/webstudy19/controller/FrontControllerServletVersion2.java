package org.kosta.webstudy19.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy19.model.MockDAO;

/**
 * Front Controller Design Pattern 적용 모든 클라이언트의 요청을 하나의 진입점으로 통합하여 처리하는 디자인 패턴
 * FrontControllerServlet : 모든 클라이언트 요청을 처리하는 서블릿
 * 
 * doDistpatch 메서드의 처리 작업이 크므노 기능별로 메서드를 분할하여 호출해 요청을 처리하는 방식으로 구조를 개선
 */
@WebServlet("/FrontController6Servlet")
public class FrontControllerServletVersion2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void findCarByNo(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 차량번호로 차정보검색
		String carNo = request.getParameter("carNo");
		String carInfo = MockDAO.getInstance().findCarInfo(carNo);
		String path = null;
		if (carInfo != null) {
			request.setAttribute("carInfo", carInfo);
			path = "findcar-ok.jsp";
		} else {
			path = "findcar-fail.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);

	}

	protected void findCarListByMaker(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String maker = request.getParameter("maker");
		ArrayList<String> list = MockDAO.getInstance().findCarListByMaker(maker);
		request.setAttribute("carList", list);
		request.getRequestDispatcher("findcarlist-result.jsp").forward(request, response);
	}

	protected void registerCar(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String carInfo = request.getParameter("carInfo");
		MockDAO.getInstance().registerCar(carInfo);
		response.sendRedirect("registercar-result.jsp");
	}

	protected void doDispatch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 차정보 검색
		// String str = null;

		try {
			// 다양한 클라이언트의 요청을 구분하기 위해 command 를 받아온다
			String command = request.getParameter("command");
			if (command.equals("findCarByNo")) {
				this.findCarByNo(request, response);
			} else if (command.equals("findCarListByMaker")) {
				this.findCarListByMaker(request, response);
			} else if (command.equals("registerCar")) {
				this.registerCar(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
			// Exception 발생할 경우 클라이언트에세 error.jsp를 제공한다
			response.sendRedirect("error.jsp");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doDispatch(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// post 방식은 http request body 영역의 별도의 인코딩
		request.setCharacterEncoding("utf-8");
		doDispatch(request, response);
	}

}
