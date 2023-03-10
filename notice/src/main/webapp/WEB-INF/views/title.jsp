<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>

<c:set var="dto" value="${dto }" />

<div><a href="${cpath }/delete"><button>삭제</button></a></div>
<div>
	<div>${dto.today }</div>

	<div>
		<div>${dto.category }</div>
		<img src="${cpath }/resources/본문광고.png" width="150px;">
		<div>${dto.title }</div>
		<div><pre>${dto.memo }</pre></div>
	</div>

</div>헤

	

</body>
</html>