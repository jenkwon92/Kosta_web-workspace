package step1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LifeCycleServlet
 */
public class LifeCycleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public LifeCycleServlet() {
        super();
        System.out.println("LifeCycleServlet 객체 생성");
    }
	@Override
		public void init() throws ServletException {
			System.out.println("init() 실행");
		}    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.println("<h3>LifeCycleServlet service 계열 메서드 doGet method 실행</h3>");
		out.close();		
	}
	@Override
		public void destroy() {
			System.out.println("destroy() 실행");
		}
}






