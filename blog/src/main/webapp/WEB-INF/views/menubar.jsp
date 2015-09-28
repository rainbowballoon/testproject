<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

	<div class="container">
		<div id='cssmenu'>
			<ul>
		<c:choose>
			<c:when test="${empty topicno }"><li class='active'><a href='index'>전체</a></li></c:when>
			<c:otherwise><li><a href='index'>전체</a></li></c:otherwise>
		</c:choose>	
		<c:choose>
			<c:when test="${topicno == 1 }"><li class='active'><a href='postSection?topicno=1'>엔터테인먼트 · 예술</a></li></c:when>
			<c:otherwise><li><a href='postSection?topicno=1'>엔터테인먼트 · 예술</a></li></c:otherwise>
		</c:choose>
		<c:choose>	
			<c:when test="${topicno == 2 }"><li class='active'><a href='postSection?topicno=2'>지식 · 동향</a></li></c:when>
			<c:otherwise><li><a href='postSection?topicno=2'>지식 · 동향</a></li></c:otherwise>
		</c:choose>
		<c:choose>	
			<c:when test="${topicno == 3 }"><li class='active'><a href='postSection?topicno=3'>취미 · 여가 · 여행</a></li></c:when>
			<c:otherwise><li><a href='postSection?topicno=3'>취미 · 여가 · 여행</a></li></c:otherwise>
		</c:choose>
		<c:choose>	
			<c:when test="${topicno == 4 }"><li class='active'><a href='postSection?topicno=4'>생활 · 노하우 · 쇼핑</a></li></c:when>
			<c:otherwise><li><a href='postSection?topicno=4'>생활 · 노하우 · 쇼핑</a></li></c:otherwise>
		</c:choose>
		<c:choose>	
			<c:when test="${topicno == 0 }"><li class='active'><a href='postSection?topicno=0'>기타</a></li></c:when>
			<c:otherwise><li><a href='postSection?topicno=0'>기타</a></li></c:otherwise>
		</c:choose>
			
<!-- 			   <li class='active'><a href='postSection'>전체</a></li> -->
<!-- 			   <li><a href='postSection?topicno=1'>엔터테인먼트 · 예술</a></li> -->
<!-- 			   <li><a href='postSection?topicno=2'>지식 · 동향</a></li> -->
<!-- 			   <li><a href='postSection?topicno=3'>취미 · 여가 · 여행</a></li> -->
<!-- 			   <li><a href='postSection?topicno=4'>생활 · 노하우 · 쇼핑</a></li> -->
<!-- 			   <li><a href='postSection?topicno=0'>기타</a></li> -->
			</ul>
		</div>
	</div>