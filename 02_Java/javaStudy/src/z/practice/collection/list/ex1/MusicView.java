package z.practice.collection.list.ex1;

import java.util.Scanner;

public class MusicView {
	private Scanner sc = new Scanner(System.in);
	private MusicController mc = new MusicController();
	
	
	public void mainMenu() {
		
		while(true) {
			System.out.println("******* 메인 메뉴 *******");
			System.out.println("1. 마지막 위치에 곡 추가"); // addList() 실행
			System.out.println("2. 첫 위치에 곡 추가"); // addAtZero()
			System.out.println("3. 전체 곡 목록 출력"); // printAll()
			System.out.println("4. 특정 곡 검색"); // searchMusic()
			System.out.println("5. 특정 곡 삭제"); // removeMusic()
			System.out.println("6. 특정 곡 정보 수정"); // setMusic()
			System.out.println("7. 곡명 오름차순 정렬"); // ascTitle()
			System.out.println("8. 가수명 내림차순 정렬"); // descSinger()
			System.out.println("9. 종료"); // “종료” 출력 후 main()으로 리턴
			System.out.print("메뉴 번호 선택 : "); //>> 입력 받음
			// 메뉴 화면 반복 실행 처리
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				addList();
				break;
			case 2:
				addAtZero();
				break;
			case 3:
				printAll();
				break;
			case 4:
				searchMusic();
				break;
			case 5:
				removeMusic();
				break;
			case 6:
				setMusic();
				break;
			case 7:
				ascTitle();
				break;
			case 8:
				descSinger();
				break;
			case 9:
				System.out.println("종료");
				return;
				default:
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
				
			}
		}

	}
	
	public void addList() {
		System.out.println("****** 마지막 위치에 곡 추가 ******");
		// 곡 명과 가수 명을 사용자에게 입력 받는다.
		String title, singer;
		System.out.print("곡 명 입력 : ");
		title = sc.next();
		System.out.print("가수 명 입력 : ");
		singer = sc.next();
		
		Music music = new Music(title, singer);
		
		//mc.addList(music);
		
		if(mc.addList(music) == 1) {
			System.out.println("추가성공");
		}
		else {
			System.out.println("추가실패");
		}
		
		// MusicController에 addList()를 이용해서 입력한 정보를 넘기고
		// 추가 성공 시 “추가 성공”, 추가 실패 시 “추가 실패” 콘솔창에 출력
	}
	
	public void addAtZero() {
		System.out.println("****** 첫 위치에 곡 추가 ******");
		// 곡 명과 가수 명을 사용자에게 입력 받는다.
		String title, singer;
		System.out.print("곡 명 입력 : ");
		title = sc.next();
		System.out.print("가수 명 입력 : ");
		singer = sc.next();
		
		Music music = new Music(title, singer);
		
		//mc.addAtZero(music);
		
		if(mc.addAtZero(music) == 1) {
			System.out.println("추가성공");
		}
		else {
			System.out.println("추가실패");
		}
		
	}
	
	public void printAll() {
		System.out.println("****** 전체 곡 목록 출력 ******");
		System.out.println(mc.printAll());
		
	}
	
	public void searchMusic() {
		System.out.println("****** 특정 곡 검색 ******");
		System.out.print("검색할 곡 명 입력 : ");
		String title = sc.next();
		
		if(mc.searchMusic(title) != null) {
			System.out.println("검색한 곡은 " +mc.searchMusic(title));
		}
		else {
			System.out.println("검색한 곡은 없습니다.");
		}
	}
	
	public void removeMusic() {
		System.out.println("****** 특정 곡 삭제 ******");
		System.out.print("삭제할 곡 명 입력 : ");
		String title = sc.next();
		
		if(mc.removeMusic(title) != null) {
			System.out.println("삭제되었습니다. ");
		}
		else {
			System.out.println("삭제할 곡이 없습니다.");
		}
	}
	
	public void setMusic() {
		System.out.println("****** 특정 곡 정보 수정 ******");
		System.out.print("수정할 곡 명 검색 : ");
		String title = sc.next();
		
		
		if(mc.searchMusic(title) != null) {
			System.out.print("수정할 곡 명 입력 : ");
			title = sc.next();
			System.out.print("수정할 가수 명 입력 : ");
			String singer = sc.next();
			
			Music music = new Music(title, singer);
			
			mc.setMusic(title, music);
			
			System.out.println(mc.searchMusic(title) + "의 값이 수정되었습니다. ");
		}
		else {
			System.out.println("수정할 곡이 없습니다.");
		}
		
		// 사용자에게 수정할 곡을 입력 하여 MusicController에 setMusic으로 검색 할 수 있게
		// 값을 넘기며 수정할 곡 명과 가수 명을 받아 setMusic으로 값을 넘긴다.
		// 검색 결과 값이 없으면 “수정할 곡이 없습니다.”, 검색 결과 값이 있고
		// 수정 했으면 “000(곡 명, 가수 명)의 값이 변경 되었습니다.” 콘솔 창에 출력

	}
	
	public void ascTitle() {
		
		System.out.println("****** 곡 명 오름차순 정렬 ******");
		int res = mc.ascTitle();
		if(res == 1) {
			System.out.println("정렬 성공");
		}
		else {
			System.out.println("정렬 실패");
		}
		
	}
	
	public void descSinger() {
		
		System.out.println("****** 가수명 내림차순 정렬 ******");
		int res = mc.descSinger();
		if(res == 1) {
			System.out.println("정렬 성공");
		}
		else {
			System.out.println("정렬 실패");
		}
	}
	
	
}
