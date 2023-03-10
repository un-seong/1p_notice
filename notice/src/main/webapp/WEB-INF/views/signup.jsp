<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<p><input type="text" name="userid" placeholder="아이디" required autofocus></p>
	<p><input type="password" name="userpw" placeholder="비밀번호" required></p>
	<p><input type="text" name="userNick" placeholder="닉네임"  required></p>
	<p>
		<label><input type="radio" name="gender" value="남성">남성</label>
		<label><input type="radio" name="gender" value="여성">여성</label>
	</p>
	<p><input type="text" name="phone" placeholder="전화번호" required> 번호만 입력하세요</p>
	<p><input type="submit" value="가입하기"></p>
</form>

</body>
</html>