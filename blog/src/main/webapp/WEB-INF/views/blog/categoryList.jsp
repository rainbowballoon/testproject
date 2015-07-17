<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Content -->
    <div class="col-md-8">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1>카테고리 목록</h1>
               <table class="table">
               		<tr class="active">
               			<th>카테고리 이름</th>
               			<th>카테고리 수정/삭제</th>
               			<th>서브카테고리 관리</th>
               		</tr>
               	<c:forEach var="categoryList" items="${categoryList}">
               		<tr>
               			<td>${categoryList.name }</td>
               			<td><a class="btn btn-primary btn-xs" href="categoryEditForm?no=${categoryList.no }">카테고리 수정</a>
               				<a class="btn btn-default btn-xs" href="categoryDelete?no=${categoryList.no }">카테고리 삭제</a></td>
               			<td><a class="btn btn-primary btn-xs" href="subCategoryList?categoryno=${categoryList.no }">서브 카테고리</a></td>
               		</tr>
               	</c:forEach>
               </table>

               <a href="categoryWriteForm" class="btn btn-primary">카테고리 등록</a>

            </div>
        </div>
    </div>
</div>