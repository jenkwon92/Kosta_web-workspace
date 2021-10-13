package org.kosta.webstudy19.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.kosta.webstudy19.model.MockDAO;

public class RegisterCarController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String carInfo = request.getParameter("carInfo");
		MockDAO.getInstance().registerCar(carInfo);
		
		return "registercar-result.jsp";
	}

}
