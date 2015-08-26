<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

		<div class="col-md-8">
           <h1 class="page-header">방명록 등록하기</h1>

			<form:form commandName="board_DTO" modelAttribute="board_DTO" action="boardWrite" method="post">
			<input type="hidden" name="blogno" value="${blogno }">
				
			<div class="row">	
				<div class="form-group">
					<label for="title" class="control-lable">글제목 </label>
					<form:input path="title" id="title" name="title" class="form-control" placeholder="제목 입력" />
					<div class="has-error">
						<label class="control-label" for="title">
<!-- 							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> -->
							<form:errors path="title" class="help-inline"/>
						</label>
	                </div>
				</div>
				
				<div class="form-group">
					<form:textarea path="content" class="form-control" rows="10" name="content" placeholder="내용을 입력해주세요" />
					<div class="has-error">
						<label class="control-label" for="content">
<!-- 							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> -->
	                       <form:errors path="content" class="help-inline"/>
	                    </label>
	                </div>
				</div>
				
				<div class="form-group col-md-12">
					<div class="col-md-12">
						<button type="submit" class="btn btn-primary ">등록하기</button>
						<button type="reset" class="btn btn-default ">다시쓰기</button>
					</div>
				</div>
				
			</div> <!-- end row1 -->
			
			</form:form>
        </div>
