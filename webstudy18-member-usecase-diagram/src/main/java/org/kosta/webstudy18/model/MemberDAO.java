package org.kosta.webstudy18.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private static MemberDAO instance=new MemberDAO();
	//private String driver="orcle.jdbc.OracleDriver";
	private String url="jdbc:oracle:thin:@127.0.0.1:1521:xe";
	private String username="scott";
	private String userpass = "tiger";
	
	private MemberDAO() {}
	public static MemberDAO getInstance() {
		return instance;
	}
	
	public void closeAll(PreparedStatement pstmt, Connection con) throws SQLException {
		if(pstmt!=null) {
			pstmt.close();
		}
		if(con!=null) {
			con.close();
		}
	}
	
	public void closeAll(ResultSet rs, PreparedStatement pstmt, Connection con) throws SQLException {
		if(rs!=null) {
			rs.close();
			closeAll(pstmt, con);
		}
	}
	
	public MemberVO findMemberById(String id) throws SQLException {
		MemberVO vo = null;
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,username,userpass);
			String sql = "SELECT id,name,address FROM member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(rs.getString(1), null, rs.getString(2), rs.getString(3));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
	
	public MemberVO login(String id, String password) throws SQLException {
		MemberVO vo = null;
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,username,userpass);
			String sql = "SELECT name,address FROM member WHERE id=? AND password=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(id,password,rs.getString(1),rs.getString(2));
			}
		}finally {
			closeAll(rs,pstmt, con);
		}
		return vo;
	}
	
	public ArrayList<MemberVO> findMemberListByAddress(String address) throws SQLException {
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		try {	
			con = DriverManager.getConnection(url,username,userpass);
			String sql = "SELECT id,name,address FROM member WHERE address=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, address);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberVO(rs.getString(1),null,rs.getString(2),rs.getString(3)));
			}
		}finally {
			closeAll(rs,pstmt, con);
		}
		return list;
	}
	
	public void updateMember(MemberVO vo) throws SQLException {
		Connection con= null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url,username,userpass);
			String sql = "UPDATE member SET name=? ,password=? , address=? WHERE id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getAddress());
			pstmt.setString(4, vo.getId());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public void registerMember (MemberVO vo) throws SQLException{
		Connection con =null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(url, username, userpass);
			String sql = "INSERT INTO member(id, password, name, address) VALUES(?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getAddress());
			pstmt.executeUpdate();
		}finally {
			closeAll(pstmt, con);
		}
	}
	
	public MemberVO idCheckServlet(String id) throws SQLException {
		MemberVO vo =null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(url,username, userpass);
			String sql = "SELECT name,address FROM member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo = new MemberVO(id,rs.getString(1),null, rs.getString(2));
			}
		}finally {
			closeAll(rs, pstmt, con);
		}
		return vo;
	}
}
