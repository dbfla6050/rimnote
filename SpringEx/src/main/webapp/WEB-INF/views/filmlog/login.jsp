<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" type="text/css" href="/resources/css/filmlog/login.css">
	<meta charset="UTF-8">
	<title>Filmlog</title>
</head>
<body>
	<%@ include file="board/header.jsp" %>

     <div id="container">
        <div id="loginBox">
            <form action="" id="login">
                <div id="box">
                    <div id="id">
                        <p class="subTxt1">
                            id
                            <a href="">아이디를 잊으셨나요?</a>
                        </p>
                        <p>
                            <input type="text" id="inputBox">
                            <input type="checkbox" id="idCheck">
                            <span>id 저장</span>
                        </p>
                        
                    </div>
                    <div id="password" >
                        <p class="subTxt2">
                            Password
                        </p>
                        <p>
                            <input type="password" id="inputBox">
                        </p>
                    </div>
                </div>
                <button class="btnLogin" type="submit">LOGIN</button>
            </form>
        </div>
        
    </div> <!--#container-->

	<%@ include file="board/footer.jsp" %>
</body>
</html>