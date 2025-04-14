package movie.controller;


import java.util.ArrayList;
import static movie.template.MovieTemplate.*;

import movie.service.MovieService;
import movie.vo.Movie;

public class MovieController {
	private MovieService ms = new MovieService();
	
	public void insertMovie(String title, String type, String director, String relyear, int agelimit) {
		//view로부터 전달받은 값을 바로 dao쪽으로 전달 X
		//어딘가에 담아서 service로 전달
		
		
		Movie movie = new Movie(title, type, director, relyear, agelimit);
		
		int result = ms.insertMovie(movie);
		
		if(result > 0) {
			System.out.println("영화 추가 성공");
			return;
		}
		else {
			System.out.println("영화 추가 실패");
			return;
		}
	}
	
	public void selectList() {
		ArrayList<Movie> list = ms.selectList();
		
		if(list.isEmpty()) {
			System.out.println("영화 목록이 없습니다.");
		}
		else {
			for(Movie movie : list) {
				System.out.println(movie);
			}
			
		}
	}
	
	public void updateMovie(String title, String type, String director, String relyear, int agelimit) {
		
		Movie movie = new Movie();
		movie.setTitle(title);
		movie.setType(type);
		movie.setDirector(director);
		movie.setRelYear(relyear);
		movie.setAgeLimit(agelimit);
		
		int result = ms.updateMovie(movie);
		
		if(result > 0) {
			System.out.println("성공적으로 영화정보가 변경되었습니다.");
		}
		else {
			System.out.println("영화정보 변경에 실패하였습니다.");
		}
	}
	
	public void deleteMovie(String title) {
		int result = ms.deleteMovie(title);
		
		if(result > 0) {
			System.out.println("성공적으로 영화가 삭제되었습니다.");
		}
		else {
			System.out.println("영화 삭제에 실패하였습니다.");
		}
	}
	
	public void searchMovie(String keyword) {
		ArrayList<Movie> list = ms.searchMovie(keyword);
		if(list.isEmpty()) {
			System.out.println(keyword + "에 해당하는 검색 결과가 없습니다.");
		}
		else {
			for(Movie movie : list)
			System.out.println(movie);
		}
	}
	
	public void playMovie(String title, int age) {
		
		ArrayList<Movie> list = ms.searchMovie(title);
		int agelimit = ms.playMovie(title);
		
		if(list.isEmpty()) {
			System.out.println(title + "에 해당하는 검색 결과가 없습니다.");
		}
		else {
			System.out.println(list);
			
			if( agelimit == 19 && age < 19) {
				System.out.println("청소년 관람불가 영화로 시청하실 수 없습니다.");
			}
			else if (agelimit == 15 && age <15 ) {
				System.out.println("보호자와 함께 시청하십시오");
			}
			else {
				System.out.println("즐거운 영화시청 되십시오");
			}
		}
		
		
	}
	
}
