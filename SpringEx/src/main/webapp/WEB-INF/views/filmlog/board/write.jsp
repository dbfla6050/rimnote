<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/resources/css/filmlog/write.css">
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
        <div class="write">
        	<!--post방식은 form태그를 통해서 컨트롤러filmlog/board/write를 실행시킨다--> 
          <form action="/filmlog/board/write" method="post" id="target">
            <legend>글쓰기</legend>
              <table>
                <tr>
                  <td><input type="text" name="title" placeholder="제목을 입력해주세요." class="title" id="tCount"></td>
                </tr>
                <tr>
                  <td><textarea name="content" id="text" cols="100" rows="15" placeholder="내용을 입력해주세요." class="text"></textarea></td>
                </tr>
              </table>
              <p class="countTitle"><span id="countTi"></span>/100</p>
              <p class="countText"><span id="countT"></span>/2000</p>
              <input type="submit" value="등록" class="sub">
          </form>
        </div>  
      </div><!--containerIn-->
    </div> <!--#container-->
	
	<%@ include file="footer.jsp" %>
</body>
</html>