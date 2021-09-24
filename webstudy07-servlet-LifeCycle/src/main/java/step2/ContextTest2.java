package step2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ContextTest2
 */
public class ContextTest2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContextTest2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8"); //응답시 한글처리를 위해 charset= utf-8을 지정한다
		PrintWriter out = response.getWriter();
		String name = getServletConfig().getServletName();
		out.print("<h3>"+name+"에서 ServletContext를 테스트</h3>");
		String info =getServletConfig().getServletContext().getInitParameter("security");
		out.println("ServletContext 로부터 정보를 가져옴 : "+info);
		out.close();
	}

}
