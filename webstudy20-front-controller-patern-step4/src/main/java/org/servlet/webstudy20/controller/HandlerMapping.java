package org.servlet.webstudy20.controller;
/**
 * 
 *	실제 컨트롤러 로직을 수행할 객체를 생성하는 클래스
 */
public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getInstance() {
		return instance;
	}
	
	public Controller create(String command) {
		Controller controller = null;
		if(command.equals("findCustomerById"))
			controller = new FindCustomerByIdController();
		else if (command.equals("registerCustomer"))
			controller = new RegisterCustomerController();
		else if (command.equals("updateCustomer"))
			controller = new UpdateCustomerController();
		return controller;
	}
}
