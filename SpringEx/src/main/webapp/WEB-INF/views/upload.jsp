<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- enctype="multipart/form-data" : 파일업로드나 이미지업로드를 서버로 전송할때 사용-->
	<!-- multiple : 파일여러개 선택가능 -->
	<form action="uploadAction" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile" multiple>
		<input type="submit" value="전송">
	</form>

</body>
</html>