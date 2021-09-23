package step3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PostTestServlet
 */
public class PostTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostTestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식일때는 요청 정보에 대한 별도의 한글 처리가 필요하다
		request.setCharacterEncoding("utf-8");
		//아래는 응답시 한글처리를 위해 charset=utf-8 을 명시한다
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("PostTestServlet doPost");
		String info = request.getParameter("location");
		String nick = request.getParameter("nick");
		out.println("지역명: "+info+"   별명: "+nick);
		out.close();
	}

}
