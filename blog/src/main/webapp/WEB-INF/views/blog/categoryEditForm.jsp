<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Page Content -->
<div class="col-md-8">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1>카테고리 수정</h1>
             <form action="categoryEdit" method="post">
             	<input type="hidden" name="no" value="${categorydto.no }">
               	<table class="table table-hover">
               		<tr>
               			<td class="active">카테고리 이름</td>
               			<td><input type="text" name="name" value="${categorydto.name }"></td>
               		</tr>
               	</table>
             <input type="submit" value="수정 완료" class="btn btn-primary">
             <a href="categoryList" class="btn btn-default">카테고리 목록으로</a>
             </form>
             
        	</div>
    	</div>
	</div>
</div>
