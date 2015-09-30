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
			   var f = document.getElementById("replyform");
			   f.action = "/blog/${bdto.blogno}/commentsBDWrite?no=${bdto.no}";
			   f.submit();
		   },
		   runboardReplyDelete : function(no){
			   //location.href="/blog/${bdto.blogno}/commentsBDDelete?no=${bdto.no}";
			   var f = document.getElementById("replyform");
			   f.action = "/blog/${bdto.blogno}/commentsBDDelete?no="+no;
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
						<th class="active">작성자</th><td width="150">${bdto.mDTO.nickname }</td>
						<th class="active">작성시간</th><td width="150">${bdto.regdate }</td>
					</tr>
					<tr>	
						<th class="active">글제목</th><td colspan="3">${bdto.title }</td>
						<th class="active">수정시간</th><td colspan="2">${bdto.editdate }</td>
					</tr>
					<tr>
						<td colspan="6" style="padding: 20px; height: 200px">${bdto.content }</td>
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
				</form>
				<hr>	 
				
				<div class="panel panel-default">
				<div class="panel-body">
					<p>태그 : 테스트 / 공감(0) 및 덧글(0)</p>
					<form method="post" name="replyform" id="replyform">	
					<input type="hidden" name="blogno" value="${bdto.blogno }">
					<input type="hidden" name="memberno" value="${bdto.memberno }">
					<input type="hidden" name="boardno" value="${bdto.no }">	
					
					<div class="form-group">
						<div class="input-group">
							<span class="input-group-addon" id="basic-addon1">
								<span class="glyphicon glyphicon-user" aria-hidden="true"></span> ${bdto.mDTO.nickname }
							</span>
							<input type="text" name="content" class="form-control" placeholder="덧글 내용을 입력해주세요" required>
							<span class="input-group-btn">
								<a href="javascript:act.runboardReplyWrite()" class="btn btn-primary">덧글 입력</a>
							</span>
						</div><!-- /input-group --> 
					</div> <!-- form group -->
					
					<ul class="list-group">
					<c:forEach items="${commentsList}" var = "cdto">
						<c:choose>
							<c:when test="${cdto.boardno == bdto.no }">
								<li class="list-group-item">
									<span class="glyphicon glyphicon-user" aria-hidden="true">
									</span> ${cdto.memberno } <small>[${cdto.regdate}]</small> : ${cdto.content }
									<a href="javascript:act.runboardReplyDelete(${cdto.no })" class="btn btn-default btn-xs pull-right">삭제</a>
								</li>
							</c:when>
						</c:choose>
					</c:forEach>
					</ul>
<!-- 					<table class="table"> -->
<!-- 						<tr> -->
<!-- 							<td width="200"><span class="glyphicon glyphicon-user" aria-hidden="true"></span> 아이디 [시간]</td> -->
<!-- 							<td width="300"> : 덧글내용</td> -->
<!-- 							<td colspan="2" align="right"> -->
<!-- 								<a href="javascript:act.runboardReplyDelete()"class="btn btn-default btn-xs">삭제</a> -->
<!-- 							</td> -->
<!-- 						</tr> -->
<!-- 					</table> -->
					</form>
				</div>
				</div> <!-- pananel -->
        </div>
