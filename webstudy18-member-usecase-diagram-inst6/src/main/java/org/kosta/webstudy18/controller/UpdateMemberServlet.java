package org.kosta.webstudy18.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.kosta.webstudy18.model.MemberDAO;
import org.kosta.webstudy18.model.MemberVO;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet("/UpdateMemberServlet")
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(false);
		if(session==null||session.getAttribute("mvo")==null) {//시간이 지나서 끊김//로그인 상태가 아니면 //받아온게 null값
			response.sendRedirect("index.jsp");//index로 보낸다 
			return; // return; keyword는 메서드 실행을 종료
		}		
		//post 방식으로 전송한 데이터는 http request body에 저장되어 별도의 한글처리가 필요하다 
		request.setCharacterEncoding("utf-8");
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		try {
			MemberVO vo=new MemberVO(id,password,name,address);
			MemberDAO.getInstance().updateMember(vo);//db에 회원정보를 수정한다 
			//세션에 저장된 회원정보를 수정한다 
			session.setAttribute("mvo", vo);
			response.sendRedirect("update-result.jsp");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}













