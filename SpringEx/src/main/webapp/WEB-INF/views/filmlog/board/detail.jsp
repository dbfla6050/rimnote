<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/resources/css/filmlog/detail.css">
	<meta charset="UTF-8">
	<title>Filmlog</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	
    <div id="container">
       <div class="containerIn">
           <section class="slide">
               <div class="slide-img">
                   	슬라이드
                   <!-- <img src="./img/slide.PNG" alt=""> -->
               </div>
           </section>
           <div class="contents">
               <h3>자유게시판</h3>
               <div class="btn_m"><a href="/filmlog/board/remove?bno=${detail.bno}">삭제</a></div>
               <table>
                   <tr>
                       <th>${detail.title}</th>
                   </tr>
                   <tr>
                       <td class="writer">
                           <span>작성자 : 한국인 </span>
                           <span class="w_r">등록일 : 2020-12-25 20:00</span>
                           <span class="w_rr">조회수 : 100</span>
                       </td>
                   </tr>
                   <tr class="con">
                       <td>
                           ${detail.content}
                       </td>
                   </tr>
               </table>
               <div class="btn">
                   <div class="btn_r"><a href="/filmlog/board/modify?bno=${detail.bno}">수정</a></div>
                   <div class="btn_l"><a href="/filmlog/board/list">목록보기</a></div>
               </div>
               <div class="beforeAfter">
                   <ul>
                       <li>
                           <a href="#">
                               <span class="ba_l">이전글</span>
                               <span class="ba_r">뭐시기 뭐시기 뭐시기</span>
                           </a>
                       </li>
                       <li>
                           <a href="#">
                               <span class="ba_l">다음글</span>
                               <span class="ba_r">요시기 요시기 요시기</span>
                           </a>
                       </li>
                   </ul>
               </div>
           </div>
       </div><!--containerIn-->
   </div> <!--#container-->

	<%@ include file="footer.jsp" %>
</body>
</html>