package z.practice.io.ex1;

import java.util.Scanner;

public class FileMenu {
	private Scanner sc = new Scanner(System.in);
	private FileController fc = new FileController();
	
	public void mainMenu() {
		while(true) {
			System.out.println("***** My Note *****");
			System.out.println("1. 노트 새로 만들기"); 
			System.out.println("2. 노트 열기"); 
			System.out.println("3. 노트 열어서 수정하기"); 
			System.out.println("9. 끝내기"); 
			System.out.print("메뉴 번호 : ");
			
			int choice = sc.nextInt();
			sc.nextLine();//개행문자 비움
			switch(choice) {
				case 1:
					fileSave();
					break;
				case 2:
					fileOpen();
					break;
				case 3:
					fileEdit();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					return;
				default :
					System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
					
			}
		}
		
	}
	public void fileSave() {
		/*
		 	StringBuilder
		 	가변분자열을 처리하는 클래스이다. 문자열을 수정할 때 새로운 객체를 생성하지 않고
		 	내부 버퍼를 이용해서 성능을 최적화한다.(String과 비슷한 역할을 함)
		 */
		StringBuilder sb = new StringBuilder();
		
		
		while(true) {
			
			System.out.println("파일에 저장할 내용을 입력하세요.");
			System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
			System.out.print("내용 : ");
			
			String infile = sc.nextLine();
			
			
			if(infile.equals("ex끝it")) {
				while(true) {
					System.out.print("저장할 파일 명을 입력해주세요(ex. myFile.txt) : ");
					String filename = sc.next();
					
					if(fc.checkName(filename)) {
						System.out.print("이미 존재하는 파일입니다. 덮어쓰시겠습니까?(y/n) : ");
						char isPass = sc.next().charAt(0);
						if(isPass == 'y') {
							fc.fileSave(filename, sb);
							return; 
						}
					}
					else {
						fc.fileSave(filename, sb);
						return;
					}
				}
			}	
			sb.append(infile);
		}
	}
	public void fileOpen() {
		System.out.println("오픈할 파일 명 : ");
		String filename = sc.next();
		
		if(fc.checkName(filename)) {
			StringBuilder sb = fc.fileOpen(filename);
			System.out.println(sb.toString());
		}
		else {
			System.out.println("없는 파일입니다.");
		}
		
	}
	public void fileEdit() {
		System.out.print("수정할 파일 명 : ");
		String filename = sc.next();
		sc.nextLine();
		
		if(fc.checkName(filename)) { //있을 때
			StringBuilder sb = new StringBuilder();
			while(true) {
				System.out.println("파일에 저장할 내용을 입력하세요.");
				System.out.println("ex끝it 이라고 입력하면 종료됩니다.");
				System.out.print("내용 : ");
				
				String infile = sc.nextLine();
				if(infile.equals("ex끝it")) {
					fc.fileEdit(filename, sb);
					return;
				}
				sb.append(infile);
			}
			
		} else { //없을 때
			System.out.println("없는 파일입니다.");
		}
	}
}
