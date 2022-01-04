<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/resources/css/filmlog/board.css">
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

               <tr>
                   <td>9</td>
                   <td><a href="">추석연휴 일정 및 택배일정 공지</a></td>
                   <td>관리자</td>
                   <td>2021.09.09</td>
                   <td>656</td>
               </tr>

               <tr>
                   <td>8</td>
                   <td><a href="">이준익 감독 작품 자산어보와 함께하는 흑백 필름사진 콘테스트</a></td>
                   <td>관리자</td>
                   <td>2021.09.09</td>
                   <td>656</td>
               </tr>

               <tr>
                   <td>7</td>
                   <td><a href="">2021년 현상필름 수령정책 공지</a></td>
                   <td>관리자</td>
                   <td>2021.09.09</td>
                   <td>656</td>
               </tr>

               <tr>
                   <td>6</td>
                   <td><a href="">필름로그 쇼룸 영업시간 변경 안내</a></td>
                   <td>관리자</td>
                   <td>2021.09.09</td>
                   <td>656</td>
               </tr>

               <tr>
                   <td>5</td>
                   <td><a href="">필름자판기 및 드롭포인트 서비스 안내</a></td>
                   <td>관리자</td>
                   <td>2021.09.09</td>
                   <td>656</td>
               </tr>

               <tr>
                   <td>4</td>
                   <td><a href="">‘현상된 필름’ 화일작업 및 보관에 대한 정책</a></td>
                   <td>관리자</td>
                   <td>2021.09.09</td>
                   <td>656</td>
               </tr>

               <tr>
                   <td>3</td>
                   <td><a href="">현상봉투 및 필름 매거진 폐기 공지</a></td>
                   <td>관리자</td>
                   <td>2021.09.09</td>
                   <td>656</td>
               </tr>

               <tr>
                   <td>2</td>
                   <td><a href="">어떻게하면 사진을 잘찍을까</a></td>
                   <td>박땡땡</td>
                   <td>2021.09.09</td>
                   <td>656</td>
               </tr>

               <tr>
                   <td>1</td>
                   <td><a href="">필름고르는법</a></td>
                   <td>이땡땡</td>
                   <td>2021.09.09</td>
                   <td>656</td>
               </tr>

           </table>

           <div class="write">
               <a href="#">글쓰기</a>
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