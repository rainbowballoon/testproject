<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

		<div class="col-md-8">
           <h3 class="page-header"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 방명록</h3>
			<form action="boardEdit" method="post">
			<input type="hidden" name="blogno" value="${bdto.blogno }">
			<input type="hidden" name="memberno" value="${bdto.memberno }">
			<input type="hidden" name="no" value="${bdto.no }">				
			
				<table class="table table-condensed">
					<tr>
						<th class="active">번호</th><td width="100">${bdto.no }</td>
						<th class="active">작성자</th><td width="150">${bdto.memberno }</td>
						<th class="active">작성시간</th><td width="150">${bdto.regdate }</td>
					</tr>
					<tr>	
						<th class="active">글제목</th><td colspan="5">${bdto.title }</td>
					</tr>
					<tr>
						<td colspan="6" style="padding: 20px">${bdto.content }</td>
					</tr>
					<tr>
						<td colspan="1" align="left">
							<a href="javascript:history.go(-1)" class="btn btn-default btn-xs">목록으로</a>
						</td>
						<td colspan="5" align="right">
							<button class="btn btn-primary btn-xs">수정</button>
							<button class="btn btn-default btn-xs">삭제</button>
						</td>
					</tr>
				</table>
				
				<hr>	 
					   
				<div class="input-group">
					<input type="text" name="content" class="form-control" placeholder="덧글 내용을 입력해주세요">
					<span class="input-group-btn">
					<button class="btn btn-default" type="submit">덧글남기기</button>
					</span>
				</div><!-- /input-group --> 
				
				<table class="table">
					<tr>
						<td width="200"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 아이디 [시간]</td>
						<td width="300"> : 덧글내용</td>
						<td colspan="2" align="right">
							<button class="btn btn-default btn-xs">삭제</button>
						</td>
					</tr>
				</table>
			
			</form>
        </div>
