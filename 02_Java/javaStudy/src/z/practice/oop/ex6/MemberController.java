package z.practice.oop.ex6;

public class MemberController {
	private Member[] m = new Member[SIZE];
	public static int SIZE = 10;
	
	
	public MemberController() {
		super();
		m[0]= new Member("user1", "김지원", "pass01", "jw@naver.com", 'm', 35);
		m[1]= new Member("user2", "박지원", "pass02", "jw@naver.com", 'm', 12);
		m[2]= new Member("user3", "최지원", "pass03", "jw@naver.com", 'f', 56);
		m[3]= new Member("user4", "이지원", "pass04", "jw@naver.com", 'f', 36);
	}
	public int existMemberNum() {
		int count =0;
		for(int i=0; i<m.length;i++) {
			if(m[i] == null) {
				break;
			}
			count++;
		}
		return count;
	}
	//check하고자 하는 id를 넘겨받아 배열 m에 해당 id를 사용하는 Member가 있는지 검사
	//중복된 id가 있을 경우 사용불가 => return false
	//중복된 id가 없을 경우 사용가능 => return true	
	public Boolean checkId(String inputId) {
		for(Member mem : m) {
			if(mem == null) { //null이 나올때까지 찾았는데 못찾음
				return true;
			}
			if(mem.getId().equals(inputId)) { //동일한 id를 사용하는 member찾음
				return false;
			} 
		}
		return true;
	}
	public void insertMember(String id, String name, String password,
			String email,char gender, int age) {
		for(int i=0;i<m.length;i++) {
			if(m[i] == null) { //빈공간 체크
				m[i] = new Member(id,name,password,email,gender,age); //회원 추가
				return;
			}
		}
	}
	//존재하면 검색된 회원의 정보를 return
	public String searchId(String id) {
		for(Member mem : m) {
			if(mem == null) {
				return null;
			}
			else if(mem.getId().equals(id)) {
				return mem.inform();
			}
		}
		return null;
	}
	//존재하면 검색된 회원의 정보를 return
	 public Member[] searchName(String name) {
		 Member[] mArr = new Member[SIZE];
		 int index = 0;
		 for(Member mem : m) {
			 	if(mem == null) {
			 		break;
			 	}
				if(mem.getName().equals(name)) { //동일한 이름을 찾았을 때
					mArr[index++] = mem;
				}
		 }				
		 return mArr;
	 }
	 public Member[] searchEmail(String email) {
		 Member[] mArr = new Member[SIZE];
		 int index = 0;
		 for(Member mem : m) {
			 	if(mem == null) {
			 		break;
			 	}
				if(mem.getName().equals(email)) { //동일한 이름을 찾았을 때
					mArr[index++] = mem;
				}
		 }				
		 return mArr;
	 }
	 //변경 성공하면 true
	 //변경 실패하면 false
	 public Boolean updatePassword(String id, String password) {
		 for(Member mem : m) {
				if(mem == null) {
					return false;
				}
				else if(mem.getId().equals(id)) {
					mem.setPassword(password);
					return true;
				}
			}
		 return false;
	 }
	 public Boolean updateName(String id,String name) {
		 for(Member mem : m) {
				if(mem == null) {
					return false;
				}
				else if(mem.getId().equals(id)) {
					mem.setName(name);
					return true;
				}
			}
		 return false;
	 }
			 
	 public Boolean updateEmail(String id,String email) {
		 for(Member mem : m) {
				if(mem == null) {
					return false;
				}
				else if(mem.getId().equals(id)) {
					mem.setEmail(email);
					return true;
				}
			}
		 return false;
	 }
			 
	 public Boolean delete(String id) {
		 for(int i=0; i<m.length;i++) {
			 	if(m[i] == null) {
			 		return false;
			 	}
			 	else if(m[i].getId().equals(id)) { //삭제할 id요소 발견
					//m[i] = null;
					
					//i요소의 null이 대입되었기 때문에 뒤에 있는 요소에는 값이 있으면 안됨.
					//그래서 i요소에 null을 넣는 것이 아니라 뒤에 요소를 하나씩 앞으로 당겨준다.
					//발견한 요소 ~ 맨 마지막 요소(null아닌 요소)
					for(int j=i; j<m.length; j++) {
						if(j == m.length - 1) { //마지막 요소는 다음요소가 없기 때문에 null을 직접 대입한다.
							m[j] = null;
							break;
						}
						else if(m[j] == null) {
							break;
						}						
						m[j] = m[j+1];
					}
					return true;
				}
		 	}				
		 return false;
	 }
			 
	 public void delete() {
		 this.m = new Member[SIZE];
	 }
			 
	 public Member[] printAll() {
		 return m;
	 }

	
	
}
