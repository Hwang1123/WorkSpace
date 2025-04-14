package movie.dao;

import static movie.template.MovieTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import movie.vo.Movie;

public class MovieDao {
	
	public int insertMovie(Movie movie, Connection conn) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "INSERT INTO MOVIE VALUES(?,?,?,?,?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie.getTitle());
			pstmt.setString(2, movie.getType());
			pstmt.setString(3, movie.getDirector());
			pstmt.setString(4, movie.getRelYear());
			pstmt.setInt(5, movie.getAgeLimit());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public ArrayList<Movie> selectList(Connection conn){
		ResultSet rset = null;
		ArrayList<Movie> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM MOVIE ORDER BY TITLE";
		
		try {
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
					
			while(rset.next()) {
				Movie movie = new Movie();
				//movie.setMovNo(rset.getInt("MOVNO"));
				movie.setTitle(rset.getString("TITLE"));
				movie.setType(rset.getString("TYPE"));
				movie.setDirector(rset.getString("DIRECTOR"));
				movie.setRelYear(rset.getString("RELYEAR"));
				movie.setAgeLimit(rset.getInt("AGELIMIT"));
				
				list.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}
	
	public int updateMovie(Movie movie, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE MOVIE SET TYPE = ?, DIRECTOR = ?, RELYEAR = ?, AGELIMIT = ? WHERE TITLE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, movie.getType());
			pstmt.setString(2, movie.getDirector());
			pstmt.setString(3, movie.getRelYear());
			pstmt.setInt(4, movie.getAgeLimit());
			pstmt.setString(5, movie.getTitle());
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public int deleteMovie(String title, Connection conn) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql ="DELETE FROM MOVIE WHERE TITLE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}
	
	public ArrayList<Movie> searchMovie(String keyword, Connection conn){
		
		
		ArrayList<Movie> list = new ArrayList<Movie>();
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		String sql = "SELECT * FROM MOVIE WHERE TITLE LIKE '%' || ? || '%'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, keyword);
			
			rset = pstmt.executeQuery();
			
			while(rset.next()) {
				Movie movie = new Movie();
				movie.setTitle(rset.getString("TITLE"));
				movie.setType(rset.getString("TYPE"));
				movie.setDirector(rset.getString("DIRECTOR"));
				movie.setRelYear(rset.getString("RELYEAR"));
				movie.setAgeLimit(rset.getInt("AGELIMIT"));
				list.add(movie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
		
	}
	
	
	public int playMovie(String title, Connection conn){
		
		int agelimit = 0;
		PreparedStatement pstmt = null;
		ResultSet rset = null; 
		
		String sql = "SELECT AGELIMIT FROM MOVIE WHERE TITLE = ?";
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				agelimit = rset.getInt("AGELIMIT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		
		return agelimit;
	}
}
