<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>


<div class="center">
	<form method="POST">
		<select name="category">
			<option value="">==카테고리==</option>
			<option value="일반">일반</option>
			<option value="JAVA">JAVA</option>
			<option value="JSP">JSP</option>
			<option value="SPRING">SPRING</option>
		</select>
		<input type="submit" value="검색">
	</form>
	<div><a href="${cpath }/write">글쓰기</a></div>
	
<table>
	<tr>
		<th>번호</th>
		<th>카테고리</th>
		<th>제목</th>
		<th>등록일</th>
	</tr>
	<c:forEach var="list" items="${list }">
	<tr>
		<td>${list.idx }</td>
		<td>${list.category }</td>
		<td><a href="${cpath }/title/${list.idx}">${list.title }</a></td>
		<td>${list.today }</td>
	</tr>	
	</c:forEach>
</table>
</div>
</body>
</html>