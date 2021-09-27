package step5;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
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
    //웹컨터이너가 아래 메서드를 호출
    @Override
    //즉 ServletConfig를 할당받지 못했으므로 ServletContext를 사용할 수없다는 것을 확인해보는 코드
    public void init(ServletConfig config) throws ServletException {
    	System.out.println("test를 위해 ServletConfig를 할당받는 init을 오버라이드 한다 "+config.getServletContext());
    	//ServletConfig를 할당받아 초기화하는 작업을 고의로 생략해본다.
    	//다시 할당받는 코드를 명시해본다 
    	super.init(config);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		//String name=getServletConfig().getServletName();
		//out.println("<h3>"+name+"에서 ServletContext를 테스트</h3>");
		String info=getServletConfig().getServletContext().getInitParameter("security");
		out.println("ServletContext로부터 정보를 가져옴:"+info);
		out.close();
	}

}









