<%@page import="com.kh.common.JDBCTemplate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Insert title here</title>
</head>
<body>
	<%--
		C(insert)R(select)U(update)D(delete)
		*회원 서비스
		로그인(R), 회원가입(C), 마이페이지(R), 정보수정(U), 회원탈퇴(U), 아이디중복체크(R)
		
		*공지사항
		공지사항 목록 조회(R), 상세조회(R), 게시글 작성(C), 게시글 수정(U), 게시글 삭제(D)
		
		*일반게시판
		공지사항 목록 조회(R), 상세조회(R), 게시글 작성(C), 게시글 수정(U), 게시글 삭제(D), 댓글 작성(C), 댓글 목록 조회(R)
		
		*사진게시판
		게시글 작성 - 첨부파일 업로드(C), 게시판 리스트 조회(R), 상세조회(R)
	 --%>
	 
	 <%-- <% JDBCTemplate.getConnection(); %> --%>
	 
	 <%@ include file="views/common/menubar.jsp" %>
	 <%-- <jsp:forward page="views/board/boardListView.jsp" /> --%>
</body>
</html>