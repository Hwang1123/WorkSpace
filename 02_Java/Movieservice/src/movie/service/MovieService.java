package movie.service;


import static movie.template.MovieTemplate.close;
import static movie.template.MovieTemplate.commit;
import static movie.template.MovieTemplate.getConnection;
import static movie.template.MovieTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;



import movie.dao.MovieDao;
import movie.vo.Movie;

public class MovieService {
	private MovieDao md = new MovieDao();
//	1) 저장기능
	public int insertMovie(Movie movie) {
		Connection conn = getConnection();
		int result = md.insertMovie(movie, conn);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Movie> selectList(){
		Connection conn = getConnection();
		ArrayList<Movie> list = new MovieDao().selectList(conn);
		close(conn);
		
		return list;
	}
	
	public int updateMovie(Movie movie) {
		Connection conn = getConnection();
		int result = new MovieDao().updateMovie(movie, conn);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public int deleteMovie(String title) {
		Connection conn = getConnection();
		int result = new MovieDao().deleteMovie(title, conn);
		
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);
		}
		close(conn);
		return result;
	}
	
	public ArrayList<Movie> searchMovie(String keyword){
		Connection conn = getConnection();
		ArrayList<Movie> list = new MovieDao().searchMovie(keyword, conn);
		
		close(conn);
		return list;
	}
	
	public int playMovie(String title){
		Connection conn = getConnection();
		int agelimit = new MovieDao().playMovie(title, conn);
		
		close(conn);
		return agelimit;
	} 
	
	
	
//	2) 삭제기능
//	3) 추가기능
//	4) 수정기능
//	5) 검색기능
//	6) 전체출력기능
}
