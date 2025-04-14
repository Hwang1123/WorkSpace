package movie.menu;

import java.util.ArrayList;
import java.util.Scanner;

import movie.controller.MovieController;
import movie.vo.Movie;

public class MovieMenu {
	private Scanner sc = new Scanner(System.in);
	private MovieController mc = new MovieController();

	public void mainMenu() {

		while (true) {
			System.out.println("======================영화정보 관리=========================");
			System.out.println("1. 영화 추가");
			System.out.println("2. 영화목록 전체 조회");
			System.out.println("3. 영화 정보 변경");
			System.out.println("4. 영화목록 삭제");
			System.out.println("5. 키워드로 영화 찾기");
			System.out.println("6. 영화 시정하기");
			System.out.println("9. 프로그램 종료");
			
			System.out.print("메뉴 번호 입력 : ");			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch (choice) {
			case 1:
				this.insertMovie();
				break;
			case 2:
				this.selectList();
				break;
			case 3:
				this.updateMovie();
				break;
			case 4:
				this.deleteMovie();
				break;
			case 5:
				this.searchMovie();
				break;
			case 6:
				this.playMovie();
				break;
			case 9:
				System.out.println("이용해주셔서 감사합니다. 종료합니다.");
				return;
			default:
				System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
			}
		}
	}

	public void insertMovie() {
		System.out.println("======================영화목록 추가=========================");
		System.out.print("영화제목 : ");
		String Title = sc.nextLine();
		
		System.out.print("장르 : ");
		String Type = sc.nextLine();

		System.out.print("감독 : ");
		String Director = sc.nextLine();

		System.out.print("개봉년도 : ");
		String RelYear = sc.nextLine();
		
		System.out.print("연령제한 : ");
		int AgeLimit = sc.nextInt();

		mc.insertMovie(Title, Type, Director, RelYear, AgeLimit);

	}

	public void selectList() {
		System.out.println("========================영화목록==========================");
		mc.selectList();
	}
	
	public void updateMovie() {
		System.out.println("======================영화정보 변경========================");
		
		System.out.print("정보를 수정할 영화제목을 입력해주세요 : ");
		String title = sc.nextLine();
		
		System.out.println("변경할 정보를 입력해주세요.");
		System.out.print("변경할 장르 : ");
		String type = sc.nextLine();
		
		System.out.print("변경할 감독정보 : ");
		String director = sc.nextLine();
		
		System.out.print("변경할 개봉년도 : ");
		String relyear = sc.nextLine();
		
		System.out.print("변경할 연령제한 : ");
		int AgeLimit = sc.nextInt();
		
		
		mc.updateMovie(title, type, director, relyear, AgeLimit);
	}
	
	public void deleteMovie() {
		System.out.println("======================영화 삭제========================");
		mc.selectList();
		System.out.print("영화제목 입력 : ");
		String title = sc.nextLine();
		mc.deleteMovie(title);
	}
	
	public void searchMovie() {
		System.out.println("===================키워드로 영화 검색====================");
		System.out.print("키워드 입력 : ");
		String keyword = sc.nextLine();
		
		mc.searchMovie(keyword);
	}
	
	public void playMovie() {
		System.out.println("======================영화 시청하기=====================");
		System.out.print("시청할 영화제목 입력 : ");
		String title = sc.nextLine();
		
		System.out.print("시청자의 연령입력 : ");
		int age = sc.nextInt();
		
		sc.nextLine();
		
		mc.playMovie(title, age);
	}

}
