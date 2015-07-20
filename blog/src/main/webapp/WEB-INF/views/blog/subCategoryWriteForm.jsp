<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Content -->
    <div class="col-md-8">
	    <div class="container-fluid">
	        <div class="row">
	            <div class="col-lg-12">
	                <h1>서브카테고리 등록</h1>
	             <form action="subCategoryWrite" method="post">
	             <input type="hidden" name="categoryno" value="${categoryno }">
	               <table class="table table-hover">
	               		<tr>
	               			<td class="active">서브카테고리 이름</td>
	               			<td><input type="text" name="name" maxlength="20"></td>
	               		</tr>
	               </table>
	             <input type="submit" value="등록완료" class="btn btn-primary">
	             <a href="subCategoryList?categoryno=${categoryno }" class="btn btn-default">목록으로</a>
	             </form>
	             
	        </div>
	    </div>
	</div>
</div>