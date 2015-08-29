<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript">
   var act = {
		   goboardEditForm : function(){
			   location.href="/blog/${bdto.blogno}/boardEditForm?no=${bdto.no}";
		   },
		   goboardList : function(){
			   location.href = "/blog/${bdto.blogno}/boardList";
		   },
		   runboardDelete : function(){
			   var f = document.getElementById("form");
			   if(confirm("정말 삭제하시겠습니까?")){
				   f.action = "/blog/${bdto.blogno}/boardDelete?no=${bdto.no}";
				   f.submit();
			   }else{
				   return;
			   }
		   },
		   runboardReplyWrite : function(){
			   var f = document.getElementById("form");
			   f.action = "/blog/${bdto.blogno}/boardReplyWrite?no=${bdto.no}";
			   f.submit();
		   },
		   runboardReplyDelete : function(){
			   var f = document.getElementById("form");
			   f.action = "/blog/${bdto.blogno}/boardReplyDelete?no=${bdto.no}";
			   f.submit();
		   }
   }
    
</script>

		<div class="col-md-8">
           <h3 class="page-header"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 방명록</h3>
			<form method="post" name="form" id="form">
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
							<a href="javascript:act.goboardList();" class="btn btn-default btn-sm">목록으로</a>
						</td>
						<td colspan="5" align="right">
							<a href="javascript:act.goboardEditForm();" class="btn btn-primary btn-sm">수정</a>
							<a href="javascript:act.runboardDelete();" class="btn btn-default btn-sm">삭제</a>
						</td>
					</tr>
				</table>
				
				<hr>	 
					   
				<div class="input-group">
					<input type="text" name="content" class="form-control" placeholder="덧글 내용을 입력해주세요">
					<span class="input-group-btn">
					<a href="javascript:act.runboardReplyWrite()" class="btn btn-default">덧글남기기</a>
					</span>
				</div><!-- /input-group --> 
				
				<table class="table">
					<tr>
						<td width="200"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 아이디 [시간]</td>
						<td width="300"> : 덧글내용</td>
						<td colspan="2" align="right">
							<a href="javascript:act.runboardReplyDelete()"class="btn btn-default btn-xs">삭제</a>
						</td>
					</tr>
				</table>
			</form>
        </div>
