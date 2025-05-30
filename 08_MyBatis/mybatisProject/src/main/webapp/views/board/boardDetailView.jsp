<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <jsp:include page="../common/menubar.jsp" />

    <div class="outer" align="center">
        <br>
        <h1 align="center">게시판 상세조회</h1>
        <br>

        <table align="center" border="1">
            <tr>
                <td width="100">글번호</td>
                <td width="500">${board.boardNo}</td>
            </tr>
            <tr>
                <td>제목</td>
                <td>${board.boardTitle}</td>
            </tr>
            <tr>
                <td>작성자</td>
                <td>${board.userId}</td>
            </tr>
            <tr>
                <td>조회수</td>
                <td>${board.count}</td>
            </tr>
            <tr>
                <td>작성일</td>
                <td>${board.createDate}</td>
            </tr>
            <tr>
                <td>내용</td>
                <td height="100">
                    ${board.boardContent}
                </td>
            </tr>
        </table>

        <br>

        <table align="center" border="1">
            <tr>
                <th>댓글작성</th>
                <th><textarea></textarea></th>
                <th><button>등록</button></th>
            </tr>
            <tr>
                <td colspan="3"><b>댓글(1)</b></td> <!-- fn:length(list) -->
            </tr>
	            <tr>
	                <th>user03</th>
	                <th>오우 멋지네요</th>
	                <th>24/04/10</th>
	            </tr>
        </table>
    </div>
</body>
</html>