package com.kh.jdbc.controller;

import java.util.ArrayList;

import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.view.MemberMenu;

/*
 	Controller : view를 통해서 사용자가 요청한 기능에 대해 처리하는 객체
 				 해당 메서드로 전달된 데이터[가공처리후] Dao로 전달하여 호출
 				 Dao로부터 반환받은 결과에 따라서 성공/실패 여부를 판단하여 응답화면결정 -> view메서드 호출
 */

public class MemberController {
	private MemberDao md = new MemberDao();
	
	/*
	 	사용자의 추가요청을 처리하는 메서드
	 	userid~hobby : 사용자가 입력한 입력한 정보들을 매게변수로 받음
	 */
	public void insertMember(String userid, String userpwd, String username, String gender,
			String age, String phone,  String email, String address, String hobby) {
		//view로부터 전달받은 값을 바로 dao쪽으로 전달 X
		//어딘가에 담아서 전달(Member 객체)
		
		Member m = new Member(userid, userpwd, username, gender, Integer.parseInt(age), email, phone, address, hobby);
		
		int result = md.insertMember(m);
		
		if(result > 0) {
			//성공화면
			new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다.");
		}
		else {
			//실패화면
			new MemberMenu().displayfail("회원을 추가하는데 실패하였습니다.");
		}
	}
	
	
	/*
	 	회원을 모두 조회하는 메서드
	 */
	public void selectList() {
		ArrayList<Member> list = md.selectList();
		
		//조회된 결과에 따라서 사용자가 보게될 응답화면
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("전체 조회결과가 없습니다.");
		}
		else {
			new MemberMenu().displayMemverList(list);
		}
	}
	
	/*
	 	회원을 삭제하는 메서드
	 */
	public void deleteMember(String userid) {
		int result = md.deleteMember(userid);
		
		if (result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원정보를 삭제하였습니다.");
		}
		else {
			new MemberMenu().displayfail("회원정보를 삭제하는데 실패하였습니다.");
		}
	}
	/*
	 	userid, email, phone, address, hobby를 전달받아
	 	Member를 수정하는 메서드
	 */
	public void updateMember(String userid, String email, String phone, 
			String address, String hobby ) {
		Member m = new Member();
		m.setUserid(userid);
		m.setEmail(email);
		m.setPhone(phone);
		m.setAddress(address);
		m.setHobby(hobby);
		
		int result = md.updateMember(m);
		if(result > 0) {
			new MemberMenu().displaySuccess("성공적으로 회원정보를 수정하였습니다.");
		}
		else {
			new MemberMenu().displaySuccess("회원정보를 수정하는데 실패하였습니다.");
		}
		
	}
		
}
