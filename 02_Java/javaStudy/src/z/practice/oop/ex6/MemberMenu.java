package z.practice.oop.ex6;

import java.util.Scanner;

public class MemberMenu {
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	public MemberMenu() {
		super();
	}
	public void mainMenu() {
		while(true) {
		System.out.println("최대 등록 가능한 회원 수는"+ mc.SIZE +"명입니다");
		System.out.println("현재 등록된 회원 수는 " + mc.existMemberNum() + "명 입니다");
		
		if(mc.existMemberNum() != 10) {
				System.out.println("1. 새 회원 등록");
				}
		else {
				System.out.println("회원 수가 모두 꽉 찼기 때문에 일부 메뉴만 오픈됩니다.");
				}
				System.out.println("2. 회원 검색");
				System.out.println("3. 회원 정보 수정");
				System.out.println("4. 회원 삭제");
				System.out.println("5. 모두 출력");
				System.out.println("9. 끝내기");
				System.out.print("메뉴 번호 : ");
				
				int choice = sc.nextInt();
				sc.nextLine(); //개행문자 비움
				
				switch(choice) {
				case 1:
					this.insertMember();
					break;
				case 2:
					this.searchMember();
					break;
				case 3:
					this.updateMember();
					break;
				case 4:
					this.deleteMember();
					break;
				case 5:
					this.printAll();
					break;
				case 9:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("잘못된 번호입니다. 다시 입력하세요.");
				}
			}
		}
	public void insertMember() {
		String id,name,password,email;
		char gender;
		int age;
		
		System.out.println("새 회원을 등록합니다.");
		while(true) {
		System.out.print("id : " );
		id = sc.next();
			if(mc.checkId(id)) {
					break;
			}
			else {
					System.out.print("중복된 아이디입니다. 다시 입력해주세요 : ");
			}
		}
		System.out.print("이름 : ");
		name = sc.next();
		
		System.out.print("비밀번호 : ");
		password = sc.next();
		
		System.out.print("이메일 : ");
		email = sc.next();
		
		System.out.print("성별(F/M) : ");
		gender = sc.next().charAt(0);
		if(gender == 'F' || gender =='f' || gender == 'M' || gender =='M' ) {
			System.out.print("성별을 다시 입력하세요 : ");
			gender = sc.next().charAt(0);
		}
		
		System.out.print("나이 : ");
		age = sc.nextInt();
		sc.nextLine();//개행문자 비움
		
		mc.insertMember(id,name,password,email,gender,age);
		}
		
	public void searchMember() {
		System.out.println("1. 아이디로 검색하기");
		System.out.println("2. 이름으로 검색하기");
		System.out.println("3. 이메일로 검색하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int choice = sc.nextInt();
		sc.nextLine(); //개행문자 비움
		
		switch(choice) {
		case 1:
			this. searchId();
			break;
		case 2:
			this.searchName();
			break;
		case 3:
			this.searchEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return;
		default:
			System.out.println("잘못된 번호입니다.");
			return;
		}
	}
	public void searchId() {
		System.out.print("검색할 아이디 입력 : ");
		String id = sc.next();
		
		String memberInfo = mc.searchId(id);
		if(memberInfo == null) {
			System.out.println("검색 결과가 없습니다.");
		}
		else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			System.out.println(memberInfo);
		}
	}
	public void searchName() {
		System.out.print("검색할 이름 입력 : ");
		String name = sc.next();
		
		Member[] mArr = mc.searchName(name);
		if(mArr[0] == null) {
			System.out.println("검색 결과가 없습니다.");
			
		}
		else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(Member mem : mArr) {
				if(mem == null)
					break;
				System.out.println(mem.inform());
			}
		}
	}
	
	public void searchEmail() {
		System.out.print("검색할 이메일 입력 : ");
		String name = sc.next();
		
		Member[] mArr = mc.searchName(name);
		if(mArr[0] == null) {
			System.out.println("검색 결과가 없습니다.");
			
		}
		else {
			System.out.println("찾으신 회원 조회 결과입니다.");
			for(Member mem : mArr) {
				if(mem == null)
					break;
				System.out.println(mem.inform());
			}
		}
	}
	public void updateMember() {
		System.out.println("1. 비밀번호 수정하기");
		System.out.println("2. 이름 수정하기");
		System.out.println("3. 이메일로 수정하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int choice = sc.nextInt();
		sc.nextLine(); //개행문자 비움
		
		switch(choice) {
		case 1:
			this. updateName();
			break;
		case 2:
			this.updatePassword();
			break;
		case 3:
			this.updateEmail();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return;
		default:
			System.out.println("잘못된 번호입니다.");
			return;
		}
	}
	public void updatePassword() {
		String id, pwd;
		
		System.out.println("수정할 회원의 아이디 : ");
		id = sc.next();
		
		System.out.println("수정할 비밀번호 : ");
		pwd = sc.next();
		sc.nextLine();
		
		boolean isUpdate = mc.updatePassword(id, pwd);
		
		if(isUpdate) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}
		else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	public void updateName() {
		String id, name;
		
		System.out.println("수정할 회원의 아이디 : ");
		id = sc.next();
		
		System.out.println("수정할 이름 : ");
		name = sc.next();
		sc.nextLine();
		
		boolean isUpdate = mc.updatePassword(id, name);
		
		if(isUpdate) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}
		else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	public void updateEmail() {
String id, name;
		
		System.out.println("수정할 회원의 아이디 : ");
		id = sc.next();
		
		System.out.println("수정할 이메일 : ");
		name = sc.next();
		sc.nextLine();
		
		boolean isUpdate = mc.updatePassword(id, name);
		
		if(isUpdate) {
			System.out.println("수정이 성공적으로 되었습니다.");
		}
		else {
			System.out.println("존재하지 않는 아이디입니다.");
		}
	}
	public void deleteMember() {
		System.out.println("1. 특정 회원 삭제하기");
		System.out.println("2. 모든 회원 삭제하기");
		System.out.println("9. 메인으로 돌아가기");
		System.out.print("메뉴 번호 : ");
		int choice = sc.nextInt();
		sc.nextLine(); //개행문자 비움
		
		switch(choice) {
		case 1:
			this.deleteOne();
			break;
		case 2:
			this.deleteAll();
			break;
		case 9:
			System.out.println("메인으로 돌아갑니다.");
			return;
		default:
			System.out.println("잘못된 번호입니다.");
			return;
		}
	}
	public void deleteOne() {
		String id;
		System.out.println("삭제할 ID : ");
		id = sc.next();
		
		System.out.println("정말 삭제하시겠습니까(y/n) : ");
		char result = sc.next().toLowerCase().charAt(0);
		
		if(result == 'y') {		//toLowerCase() 대문자<=>소문자 변경 (문자열)함수
			boolean isDelete = mc.delete(id);
			if(isDelete) {
				System.out.println("성공적으로 삭제하였습니다.");
			}
			else {
				System.out.println("존재하지 않는 아이디입니다.");
			}
		}
	}
	public void deleteAll() {
		System.out.println("정말 삭제하시겠습니까(y/n) : ");
		char result = sc.next().toLowerCase().charAt(0);
		if(result == 'y') {		//toLowerCase() 대문자<=>소문자 변경 (문자열)함수
			mc.delete();
			System.out.println("성공적으로 삭제하였습니다.");
		}
	}
	public void printAll() {
		Member[] mArr = mc.printAll();
		for(Member mem : mArr) {
			if(mem == null) {
				break;
			}
			System.out.println(mem.inform());
		}
	}
	
}
