<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메뉴 관리</title>
</head>
<body>
<div id="page-content-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1>메뉴 관리</h1>
               <table class="table">
               		<tr class="active">
               			<th>메뉴이름</th>
               			<th>메뉴수정/삭제</th>
               			<th>서브메뉴 관리</th>
               		</tr>
               	<c:forEach var="menudto" items="${menuList}">
               		<tr>
               			<td>${menudto.name }</td>
               			<td><a class="btn btn-primary btn-xs" href="menuEditForm?no=${menudto.no }">수정</a>
               				<a class="btn btn-default btn-xs" href="menuDelete?no=${menudto.no }">삭제</a></td>
               			<td><a class="btn btn-primary btn-xs" href="subMenuList?menuno=${menudto.no }">하위메뉴</a></td>
               		</tr>
               	</c:forEach>
               </table>
<!-- 페이지네이션 -->     
     <div align="center">
	  <ul class="pagination">  	
		<li class="disabled"><a href="#" aria-label="Previous">&#x25C0;</a></li>
		  <c:forEach var="pageNum" begin="1" end="${totalCount}">
			<c:set var="sRecNum" value="${(pageNum-1) * perPage }" />
			<c:choose>
				<c:when test="${pageNum != curPage }">
					<li class=""><a href="menuList?sPage=${sRecNum}&ePage=${perPage }">${pageNum}</a></li>
				</c:when>
				<c:otherwise>
					<li class="active"><a href="#">${pageNum}</a></li>
				</c:otherwise>
			</c:choose>	
		</c:forEach>    
		<li class="disabled"><a href="#" aria-label="Next">&#x25B6;</a></li>
	   </ul> 
	</div>
               <a href="menuWriteForm" class="btn btn-primary">메뉴등록</a>
               <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">카테고리 숨기기</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>