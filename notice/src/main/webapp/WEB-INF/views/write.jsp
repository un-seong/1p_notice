<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<form method="POST">
	<select name="category">
		<option value="">==카테고리==</option>
		<option value="일반">일반</option>
		<option value="JAVA">JAVA</option>
		<option value="JSP">JSP</option>
		<option value="SPRING">SPRING</option>
	</select>
	<input type="text" name="title" placeholder="제목">
	<p>
		<textarea rows="30" cols="50" name="memo" style="resize: none" ></textarea>
	</p>
	<p><input type="hidden" name="pwcheck" value="${loginComplete.userpw }"></p>
	<p><input type="submit" value="등록"></p>
</form>

</body>
</html>