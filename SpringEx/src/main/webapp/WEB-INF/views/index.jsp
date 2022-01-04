<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<% System.out.print("abcd"); %>
</head>

<body>
	<%@ include file="header.jsp" %>
	
	<h1>실행해보자</h1>
	여기서 name은 변수를 이야기함,value속성은 변수의 초기값지정 
	<a href="/sample/member?id=abcd&pw=1234&name=정자바">회원가입</a>
	
	<form action="/sample/memberDTO" method="get">
		<div>id:<input type="text" name="id" value="abcd"></div>      
		<div>pw:<input type="password" name="pw" value="1234"></div>
		<div>name:<input type="text" name="name" value="정자바"></div>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>