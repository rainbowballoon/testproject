<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

		<div class="col-md-8">
           <h1 class="page-header">방명록 등록하기</h1>

			<form:form modelAttribute="bdto" autocomplete="off" action="boardWrite" method="post">
			<input type="hidden" name="blogno" value="${blogno }">
					
				<div class="form-group">
					<label for="title">글제목 </label>
					<form:input type="text" path="title" id="title" name="title" class="form-control" placeholder="제목 입력" />
					<div class="has-error">
                        <form:errors path="title" class="help-inline"/>
                    </div>
				</div>
				<div class="form-group">
					<textarea class="form-control" rows="10" name="content" placeholder="내용을 입력해주세요"></textarea>
					<div class="has-error">
                        <form:errors path="content" class="help-inline"/>
                    </div>
				</div>
				
			<button type="submit" class="btn btn-primary">등록하기</button>
			<button type="reset" class="btn btn-default">취소하기</button>
			</form:form>
        </div>
