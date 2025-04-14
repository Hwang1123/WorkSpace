<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>사진게시판-글목록</title>
  <style>
    #boardList {text-align:center;}
    #boardList>tbody>tr:hover {cursor:pointer;}

    #pagingArea {width:fit-content; margin:auto;}

    #searchForm {
      width:80%;
      margin:auto;
    }
    #searchForm>* {
      float:left;
      margin:5px;
    }
    .select {width:20%;}
    .text {width:53%;}
    .searchBtn {width:20%;}
  </style>
</head>
<body>

<jsp:include page="../common/header.jsp" />

<div class="content">
  <br><br>
  <div class="innerOuter" style="padding:5% 10%;">
    <h2>사진 게시판</h2>
    <br>
    <!-- 로그인 후 상태일 경우만 보여지는 글쓰기 버튼 -->
    <c:if test="${not empty loginUser}">
      <a class="btn btn-secondary" style="float:right;" href="enrollForm.pb">글쓰기</a>
      <br>
    </c:if>

    <br>
    <div class="list-area">

      <c:choose>
        <c:when test="${not empty list}">
          <c:forEach var="b" items="${list}">

            <div class="thumbnail" align="center" onclick="location.href='${pageContext.request.contextPath}/detail.pb?bno=${b.boardNo}'">
              <img width="200px" height="150px" src="${b.changeName}" alt="썸네일이미지">
              <p>
                <span>No. ${b.boardNo} ${b.boardTitle}</span><br>
                조회수 : ${b.count}
              </p>
            </div>

          </c:forEach>
        </c:when>
        <c:otherwise>
          <h1 align="center">게시글이 없습니다.</h1>
        </c:otherwise>
      </c:choose>
    </div>

    <br>

    <div id="pagingArea">
      <ul class="pagination">

        <c:choose>
          <c:when test="${ pi.currentPage eq 1 }">
            <li class="page-item disabled"><a class="page-link" href="#">Previous</a></li>
          </c:when>
          <c:otherwise>
            <li class="page-item"><a class="page-link" href="list.pb?cpage=${pi.currentPage - 1}">Previous</a></li>
          </c:otherwise>
        </c:choose>

        <c:forEach var="p" begin="${ pi.startPage }" end="${ pi.endPage }">
          <li class="page-item"><a class="page-link" href="list.pb?cpage=${p}">${p}</a></li>
        </c:forEach>

        <c:choose>
          <c:when test="${ pi.currentPage eq pi.maxPage }">
            <li class="page-item disabled"><a class="page-link" href="#">Next</a></li>
          </c:when>
          <c:otherwise>
            <li class="page-item"><a class="page-link" href="list.pb?cpage=${pi.currentPage + 1}">Next</a></li>
          </c:otherwise>
        </c:choose>

      </ul>
    </div>

    <br clear="both"><br>

    <form id="searchForm" action="" method="get" align="center">
      <div class="select">
        <select class="custom-select" name="condition">
          <option value="writer">작성자</option>
          <option value="title">제목</option>
          <option value="content">내용</option>
        </select>
      </div>
      <div class="text">
        <input type="text" class="form-control" name="keyword">
      </div>
      <button type="submit" class="searchBtn btn btn-secondary">검색</button>
    </form>
    <br><br>
  </div>
  <br><br>

</div>

<jsp:include page="../common/footer.jsp" />

</body>
</html>