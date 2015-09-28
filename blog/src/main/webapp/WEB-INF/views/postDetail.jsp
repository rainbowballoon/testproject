<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="container">
	<div class="row">
	<div class="col-lg-10">
<!-- Blog Post -->
	<hr>
<!--        <div align="right"> -->
<%--         <c:choose> --%>
<%--         	<c:when test="${logined.no ==  blogpoint.no}"> --%>
<%-- 			<a class="btn btn-primary" href="${pageContext.request.contextPath}/${dto.memberno}/postList">해당 블로그 놀러가기 <span class="glyphicon glyphicon-chevron-right"></span></a> --%>
<%--             <a class="btn btn-default" href="${pageContext.request.contextPath}/index">돌아가기 <span class="glyphicon glyphicon-chevron-right"></span></a>        	 --%>
<%--             </c:when> --%>
<%--         </c:choose> --%>
<!--        </div> -->
<!--      <hr> -->
          <h2>
              <a href="#">${dto.title }</a>
          </h2>
          <br>
          <p align="right"><span class="glyphicon glyphicon-time"></span> 등록시간 [ 
          	<fmt:parseDate var="dateTempParse" value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
			<fmt:formatDate value="${dateTempParse}" pattern="yyyy-MM-dd HH:mm"/>
          	]</p>
          <hr>
          <div class="container-fluid">
            <div class="row">
		  <div class="thumbnail">
		    	 ${dto.content }
		  </div>
	  </div>
	</div>
	<hr>

<!-- 덧글 -->
	<form method="post" name="replyform" id="replyform" action="${dto.memberno }/commentsPSWrite">	
		<input type="hidden" name="blogno" value="${dto.blogno }">
		<input type="hidden" name="memberno" value="${dto.memberno }">
		<input type="hidden" name="postno" value="${dto.no }">	
	
	<div class="panel panel-default">
	<div class="panel-body">
	<p><small>태그 : 테스트 / 공감(0) 및 덧글(${commentsCount[status.index] })</small></p>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">
					<span class="glyphicon glyphicon-user" aria-hidden="true"></span> ${logined.nickname }
				</span>
				<input type="text" name="content" class="form-control" placeholder="덧글 내용을 입력해주세요" required>
				<span class="input-group-btn">
					<button type="submit" class="btn btn-default">덧글남기기</button>
				</span>
			</div><!-- /input-group -->
		</div> <!-- form group -->
		<ul class="list-group">
				<c:forEach items="${commentsList }" var="cdto">
						<c:choose>
							<c:when test="${cdto.postno == dto.no }">
								<li class="list-group-item">
									<span class="glyphicon glyphicon-user" aria-hidden="true">
									</span> ${cdto.mDTO.nickname }<small>[
												<fmt:parseDate var="dateTempParse" value="${cdto.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
												<fmt:formatDate value="${dateTempParse}" pattern="yyyy-MM-dd HH:mm"/>
																]</small> : ${cdto.content }
									<a href="commentsPSDelete?no=${cdto.no }&postno=${dto.no }" class="btn btn-default btn-xs pull-right">삭제</a>
								</li>
							</c:when>
						</c:choose>
				</c:forEach>
				</ul>
			</div>
			</div> <!-- pananel -->
			
			</form>
            <hr>
            <div align="right">
             		<a class="btn btn-primary" href="${pageContext.request.contextPath}/${dto.memberno}/postList">해당 블로그 놀러가기 <span class="glyphicon glyphicon-chevron-right"></span></a>
             		<a class="btn btn-default" href="${pageContext.request.contextPath}/index">돌아가기 <span class="glyphicon glyphicon-chevron-right"></span></a>
            </div>
            <hr>
	</div>
	</div>
</div>