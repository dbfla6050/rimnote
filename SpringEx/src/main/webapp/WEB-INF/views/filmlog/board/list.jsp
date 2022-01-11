<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/resources/css/filmlog/list.css">
	<meta charset="UTF-8">
	<title>Filmlog</title>
</head>
<body>
	<%@ include file="header.jsp" %>

   <div id="container">
       <section class="slide">
           <div class="slide-img">
               	슬라이드
           </div>
       </section>

       <section class="board">
           <h2>자유게시판</h2>
           <table>
               <tr>
                   <th>번호</th>
                   <th>제목</th>
                   <th>작성자</th>
                   <th>작성일</th>
                   <th>조회수</th>
               </tr>
               
               <!-- "${list}" : 배열이 들어옴(배열이 저장되있는 함수)
                      var="board" : 변수이름정함(변수에 배열저장시킴)-->
			   <c:forEach items="${list}" var="board">
               <tr>
                   <td>${board.bno}</td>
                   <td><a href="/filmlog/board/detail?bno=${board.bno}">${board.title}</a></td>
                   <td>${board.writer}</td>
                   <td>${board.regdate}</td>
                   <td>${board.cnt}</td>
               </tr>
               </c:forEach>

           </table>

           <div class="write">
               <a href="/filmlog/board/write">글쓰기</a>
           </div>

           <div class="search">
               <label><input type="radio" name="board" checked>제목</label>
               <label><input type="radio" name="board">내용</label>
               <input type="text" class="s-text">
               <button>검색</button>
           </div>
       </section>
   </div> <!--#container-->
   
   <%@ include file="footer.jsp" %>
   
</body>
</html>