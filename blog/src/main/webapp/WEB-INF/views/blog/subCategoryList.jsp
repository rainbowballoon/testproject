<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Content -->
    <div class="col-md-8">
	    <div class="container-fluid">
	        <div class="row">
	            <div class="col-lg-12">
	                <h1>서브카테고리 관리</h1>
	               <table class="table">
	               		<tr class="active">
	               			<th>서브카테고리 이름</th>
	               			<th>서브카테고리 수정/삭제</th>
	               		</tr>
	               	<c:forEach var="subCategorydto" items="${subCategoryList}" varStatus="status">
	               		<tr>
	               			<td>${subCategorydto.name }</td>
	               			<td><a class="btn btn-primary btn-xs" href="subCategoryEditForm?no=${subCategorydto.no }&categoryno=${subCategorydto.categoryno}">수정</a>
	               				<a class="btn btn-default btn-xs" href="subCategoryDelete?no=${subCategorydto.no }&categoryno=${subCategorydto.categoryno}">삭제</a></td>
	               		</tr>
	               	</c:forEach>
	               </table>
	
	               <a href="subCategoryWriteForm?categoryno=${categoryno }" class="btn btn-primary">서브 카테고리 등록</a>
	               <a href="categoryList" class="btn btn-default">카테고리 목록으로</a>
	            </div>
	        </div>
	    </div>
</div>
