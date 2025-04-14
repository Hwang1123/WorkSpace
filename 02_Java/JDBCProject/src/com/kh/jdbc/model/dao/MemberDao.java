package com.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.jdbc.model.vo.Member;

/*
 	DAO(Date Access Object) : db에 직접적으로 접근해서 사용자의 요청에 맞는 sql문 실행 후 결과 반환(JDBC)
 */

public class MemberDao {

	/*
	 	사용자가 입력한 정보들을 db에 추가시켜주는 메서드
	 	Member m : 사용자가 입력한 값들이 담겨있는 Member객체
	 	insert실행 후 처리된 행 수 리턴
	 */
	public int insertMember(Member m) {
		//필요한 변수 생성
		int result = 0; //처리된 행 수 받아줄 변수
		Connection conn = null; // 연결된 db정보 담는 객체
		PreparedStatement pstmt = null; // sql전달해서 결과값 가져오는 객체
		
		// 실행할 SQL문
		String sql = "INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,?,?,?,?,?,?,?,?,?,SYSDATE)";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDbC","JDBC"); 
	  		conn.setAutoCommit(false);
	  		
	  		pstmt = conn.prepareStatement(sql);
	  		pstmt.setString(1, m.getUserid());
	  		pstmt.setString(2, m.getUserpwd());
	  		pstmt.setString(3, m.getUsername());
	  		pstmt.setString(4, m.getGender());
	  		pstmt.setInt(5, m.getAge());
	  		pstmt.setString(6, m.getEmail());
	  		pstmt.setString(7, m.getPhone());
	  		pstmt.setString(8, m.getAddress());
	  		pstmt.setString(9, m.getHobby());
	  		
	  		result = pstmt.executeUpdate();
	  		
	  		if(result > 0) {
	  			conn.commit();
	  		}
	  		else {
	  			conn.rollback();
	  		}
	  		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	/*
	 	회원의 목록을 반환하는 메서드
	 	ArrayList
	 */
	public ArrayList<Member> selectList(){
		//select문(여러행 조회) -> ReusltSet -> ArrayList담기
		
		ResultSet rset = null;
		ArrayList<Member> list = new ArrayList(); //비어있는 상태
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM MEMBER";
				
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDbC","JDBC"); 
	  		conn.setAutoCommit(false);
	  		
	  		pstmt = conn.prepareStatement(sql);
	  		
	  		rset = pstmt.executeQuery();
	  		
	  		while(rset.next()) {
	  			Member m = new Member();
	  			m.setUserno(rset.getInt("USERNO"));
	  			m.setUserid(rset.getString("USERID"));
	  			m.setUserpwd(rset.getString("USERPWD"));
	  			m.setUsername(rset.getString("USERNAME"));
	  			m.setGender(rset.getString("GENDER"));
	  			m.setAge(rset.getInt("AGE"));
	  			m.setEmail(rset.getString("EMAIL"));
	  			m.setPhone(rset.getString("PHONE"));
	  			m.setAddress(rset.getString("ADDRESS"));
	  			m.setHobby(rset.getString("HOBBY"));
	  			m.setEnrolldate(rset.getDate("ENROLLDATE"));
	  			list.add(m);
	  		}
	  		
	  		//반복문이 끝난 시점
	  		//조회된 데이터가 없다면 list가 비어있을 것이다.
	  		//조회된 데이터가 있다면 list의 크기가 1이상
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		return list;
	}
	/*
	 	userid를 받아 Member를 삭제하는 sql전달
	 	delete문 -> 처리된 행 수(int) -> 트랜잭션 처리
	 */
	 public int deleteMember(String userid) {
		 int result = 0;
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 
		 String sql = "DELETE FROM MEMBER WHERE USERID = ?";
		 
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql); //미완성된SQL
			pstmt.setString(1, userid);
			
			result = pstmt.executeUpdate();
			
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			 try {
				 pstmt.close();
				 conn.close();
			 } catch (SQLException e) {
				e.printStackTrace();
			 }
		 }
		
		return result;	
	}
	 /*
	  	Member객체 m을 통해서 update sql을 전달하는 메서드
	  */
	 public int updateMember(Member m) {
		 //update문 -> 처리된 행 수 : int -> 트랜잭션
		 int result = 0;
		 Connection conn = null;
		 PreparedStatement pstmt = null;
		 
		 String sql = "UPDATE MEMBER SET EMAIL = ?, PHONE = ?, ADDRESS = ?, HOBBY = ? WHERE USERID = ?";
		 
		 try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##JDBC", "JDBC");
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement(sql); //미완성된SQL
			pstmt.setString(1, m.getEmail());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getHobby());
			pstmt.setString(5, m.getUserid());
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	 }
}
	

