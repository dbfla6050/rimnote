<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/resources/css/filmlog/memberStyle.css">
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
	        <div>
	          <h1>회원가입</h1>
	          <form action="result.html" id="target">
	            <legend>회원가입</legend>
	            <div><label>이름</label><input type="text"></div>
	            <div>
	              <label>아이디</label><input type="text" placeholder=" 8자 이상 12자 이하로 입력해주세요." id="id"><span id="idMsg"></span>
	            </div>
	            <div><label>비밀번호</label><input type="password" placeholder=" 8자 이상 12자 이하로 입력해주세요." id="pass"><span id="passMsg"></span></div>
	            <div><label>비밀번호확인</label><input type="password" id="compare"><p id="compareMsg"></p></div>
	            <div>
	              <label>이메일</label>
	              <input type="text">@
	              <input type="text">
	              <select name="" id="">
	                <option value="">직접입력</option>
	              </select>
	            </div>
	            <div>
	              <label>휴대폰</label>
	              <input type="text" id="lastNum" placeholder=" -을 빼고 입력해주세요.">
	              <button id="num_btn" class="confirmNum">인증번호발송</button>
	            </div>
	            <div>
	              <label>인증번호 입력</label><input type="text" id="passNum" readonly>
	              <button type="button" class="confirm">확인</button>
	            </div>
	            <div class="sub_btn"><input type="submit" id="log" value="저    장"></div>
	        </div>
	      </div><!--containerIn-->
	    </div> <!--#container-->
    
    
</body>
</html>