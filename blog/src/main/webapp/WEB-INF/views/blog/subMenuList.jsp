<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>하위메뉴 관리</title>
</head>
<body>
<div id="page-content-wrapper">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1>하위메뉴 관리</h1>
               <table class="table">
               		<tr class="active">
               			<th>하위메뉴 이름</th>
               			<th>하위메뉴 수정/삭제</th>
               		</tr>
               	<c:forEach var="subMenudto" items="${subMenuList}">
               		<tr>
               			<td>${subMenudto.name }</td>
               			<td><a class="btn btn-primary btn-xs" href="subMenuEditForm?no=${subMenudto.no }&menuno=${subMenudto.menuno}">수정</a>
               				<a class="btn btn-default btn-xs" href="subMenuDelete?no=${subMenudto.no }&menuno=${subMenudto.menuno}">삭제</a></td>
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
					<li class=""><a href="subMenuList?sPage=${sRecNum}&ePage=${perPage }&menuno=${menuno}">${pageNum}</a></li>
				</c:when>
				<c:otherwise>
					<li class="active"><a href="#">${pageNum}</a></li>
				</c:otherwise>
			</c:choose>	
		</c:forEach>    
		<li class="disabled"><a href="#" aria-label="Next">&#x25B6;</a></li>
	   </ul> 
	</div>
               <a href="subMenuWriteForm?menuno=${menuno }" class="btn btn-primary">서브메뉴 등록</a>
               <a href="menuList" class="btn btn-default">메뉴목록으로 돌아가기</a>
               <br><br>
               <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">카테고리 숨기기</a>
            </div>
        </div>
    </div>
</div>
</body>
</html>