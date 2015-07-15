<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${logined != null}">		
		<script>location.href="${logined.no}/readPost"</script>
	</c:when>
	<c:otherwise>
		<script>
			alert("아이디와 비밀번호가 잘못되었습니다.");
			location.href="loginForm";
		</script>
	</c:otherwise>
</c:choose> 
