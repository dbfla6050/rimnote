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
          <form action="#" method="post" id="target">
            <legend>글수정</legend>
              <table>
              	<tr>
              	<!-- type="hidden"은 사용자한테안보이게 숨기기 데이터는 넘어감 , readonly는 그냥 읽기만가능 -->
                  <td><input type="hidden" name="bno" value="${detail.bno}" class="title" id="tCount"></td>
                </tr>
                <tr>
                  <td><input type="text" name="title" value="${detail.title}" class="title" id="tCount"></td>
                </tr>
                <tr>
                  <td><textarea name="content" id="text" cols="100" rows="15" class="text">${detail.content}</textarea></td>
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