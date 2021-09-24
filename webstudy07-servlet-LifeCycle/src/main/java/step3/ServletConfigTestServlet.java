package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletConfigTestServlet
 */
public class ServletConfigTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //응답시 한글처리를 위해 charset= utf-8을 지정한다
		PrintWriter out = response.getWriter();
		out.print("<h3>ServletConfig study </h3>");
		String name = this.getServletConfig().getServletName();
		out.println("ServletConfig 로 부터 Servlet Name을 반환받음: "+name );
		String frameworkConfig = getServletConfig().getInitParameter("contextConfigLocation");
		out.println("<hr>framework 설정파일 : "+frameworkConfig);
		out.close();
	}

}
