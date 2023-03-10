<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="cpath" value="${pageContext.request.contextPath }" />    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.body {
		width: 1920px;
		height: 1080px;
		margin: 0px;
		padding: 0px;		
	}
	
	.topimg > a > img {
		width: 100%;
		height: 100px;
	}
	
	.topmenu {
		background: rgb(2,0,36);
		background: linear-gradient(74deg, rgba(2,0,36,1) 0%, rgba(31,72,129,1) 45%, rgba(255,255,255,1) 72%);
	}
	
	.topmenu > a {
		color: white;
		text-decoration: none;
		font-size: 30px;
		font-weight: bold;
		margin: 20px;
	}
	
	.topmenu > span {
		color: black;
	}
	
	form > p:nth-child(5) {
		font-size: 5px;
	}
	
	.center {
		margin: 5px 10px;
	}
	
	table {
		border-collapse: collapse;
		margin
	}
	
	th {
		background-color: black;
		color: white;
	}
	
	th, td {
		border-bottom: 1px solid black;
		padding: 5px 10px;
	}
</style>
</head>
<body>


	<div class="wrap">
		<div>
			<div class="topimg"><a href="${cpath }"><img src="${cpath }/resources/광고.jpg"></a></div>
		</div>
		<div class="topmenu">
			<a href="${cpath }">HOME</a>
			<a href="${cpath }/${loginComplete == null ? 'login' : 'logout'}">${loginComplete == null ? 'LOGIN' : 'LOGOUT' }</a>
			<a href="${cpath }/signup">SIGNUP</a>
			<span style="visibility: ${loginComplete == null ? 'hidden' : 'visible'}">${loginComplete.userNick }님 어서오세요!</span>
		</div>
	</div>
