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
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="/resources/js/filmlog/list.js"></script>
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

			<form id="actionForm" action="/filmlog/board/list" method="get">
	           <div class="search">
	           	   <input type="text" name="pageNum" value="${pageMaker.cri.pageNum}">
		           <input type="text" name="amount" value="${pageMaker.cri.amount}">
		           
		           <select name="search" class="s-text">
		           		<option value="T">제목</option>
						<option value="C">내용</option>
						<option value="W">작성자</option>
						<option value="TC">제목+내용</option>
						<option value="TCW">제목+내용+작성자</option>
		           </select>
	               <input type="text" name="keyword" class="s-text" value="${pageMaker.cri.keyword}">
	               <input type="submit" value="검색" class="button">
	           </div>
	           
	           <div>
	           		<ul>
	           			<!-- 만약 prev가 true면 띄우고 false면 띄우지마라 -->
	           			<c:if test="${pageMaker.prev}">
	           				<li id="dataTable_prev" class="paginate_button">
	           					<!-- startPage에 -1을 시켜주면 앞으로 넘어간다 -->
	           					<a href="${pageMaker.startPage-1}">이전</a>
	           				</li>
	           			</c:if>
	           			
	           			<!-- 게시판페이지번호 -->
						<!-- startPage에서  endPage까지 num을 가지고옴-->
						<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
							<li class="paginate_button">
								<!--Num와 pageMaker.cri.amount값을 리스트컨트롤러로 보내라 -->
								<a href="${num}">${num}</a>
							</li>
						</c:forEach>
						
						<c:if test="${pageMaker.next}">
							<li id="dataTable_next" class="paginate_button">
								<!-- endPage에 +1을 시켜주면 11로 넘어간다 -->
								<a href="${pageMaker.endPage+1}">다음</a>
							</li>
						</c:if>
	           		</ul>
	           </div>
           </form>
       </section>
   </div> <!--#container-->
   
   <%@ include file="footer.jsp" %>
   
</body>
</html>