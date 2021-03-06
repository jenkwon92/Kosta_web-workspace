package org.kosta.webstudy18.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
 * Singleton Design Pattern을 적용 : 시스템 상에서 단 한번 객체 생성해 공유하여 사용하고자 할 때 적용하는 설계 패턴 
 */
public class MemberDAO {
	private static MemberDAO instance=new MemberDAO();
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username="scott";
	private String userpass="tiger";
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return instance;
	}
	//closeAll 오버로딩 2개 만든다 
	public void closeAll(PreparedStatement pstmt,Connection con) throws SQLException {
		if(pstmt!=null)
			pstmt.close();
		if(con!=null)
			con.close();
	}
	public void closeAll(ResultSet rs,PreparedStatement pstmt,Connection con) throws SQLException {
		if(rs!=null)
			rs.close();
		closeAll(pstmt, con);
	}
	public MemberVO findMemberById(String id) throws SQLException {
		MemberVO vo=null;
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			con=DriverManager.getConnection(url, username, userpass);
			String sql="select name,address from member where id=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next())
				vo=new MemberVO(id,null,rs.getString(1),rs.getString(2));
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
}




























