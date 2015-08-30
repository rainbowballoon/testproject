<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<body>
	<!-- Blog Entries Column -->
	<div class="col-md-8">
		
		<ol class="breadcrumb">
		   <li><a href="index">Home</a></li>
		   <c:choose>
			   <c:when test="${categoryno != 0 && subcategoryno == 0 }">
			   		<li class="active"><a href="postList?categoryno=${categoryno }">${categoryno }</a></li>
			   </c:when>
			   <c:otherwise>
			   		<li><a href="postList?categoryno=${categoryno }">${categoryno }</a></li>
			   </c:otherwise>
		   </c:choose>
		   <c:choose>
			   <c:when test="${categoryno == 0 && subcategoryno != 0 }">
			   		<li class="active"><a href="postList?subcategoryno=${subcategoryno }">${subcategoryno }</a></li>
			   </c:when>
		   </c:choose>
		</ol>
       
       <!-- postList 시작 -->			
		<c:forEach items="${postList }" var="dto">
			<!-- First Blog Post -->
            <h2>
                <a href="#">${dto.title }</a>
            </h2>
            <br>
            <p align="right"><span class="glyphicon glyphicon-time"></span> 등록시간 [ ${dto.regdate } ]</p>
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
			<p>태그 : 테스트 / 공감(0) 및 덧글(0)</p>
			<ul class="list-group">
			<c:forEach items="${commentsListAll }" var="clist">
				<c:forEach items="${clist}" var = "cdto">
					<c:choose>
						<c:when test="${cdto.postno == dto.no }">
							<li class="list-group-item">
								<span class="glyphicon glyphicon-user" aria-hidden="true">
								</span> ${cdto.memberno } <small>[${cdto.regdate}]</small> : ${cdto.content }
							</li>
						</c:when>
					</c:choose>
				</c:forEach>
			</c:forEach>
			</ul>
	         <form action="commentsPSWrite" method="post">
               <input type="hidden" name="postno" value="${dto.no }">
	              	<table style="width: 100%">
	              	<tr>
	              		<td style="width: 20%">
						<span class="glyphicon glyphicon-user"></span> ${logined.nickname }
		            </td>
		            <td style="width: 80%">
		                <div class="input-group">
					      <input type="text" name="content" class="form-control" placeholder="덧글 내용을 입력해주세요">
					      <span class="input-group-btn">
					        <button class="btn btn-default" type="submit">덧글남기기</button>
					      </span>
					    </div><!-- /input-group -->
					</td>
				</tr>
				</table>
			</form>
	              <hr>
	              <div align="right">
	               <c:choose>
	               	<c:when test="${logined.no ==  blogpoint.no}">
	               		<a class="btn btn-primary" href="postEditForm?no=${dto.no }">수정 <span class="glyphicon glyphicon-chevron-right"></span></a>
	               		<a class="btn btn-default" href="postDelete?no=${dto.no }">삭제 <span class="glyphicon glyphicon-chevron-right"></span></a>
	               	</c:when>
	               </c:choose>
	              </div>
	              <hr>
		</c:forEach>
		

<%-- <c:out value="${requestScope['javax.servlet.forward.request_uri']}"></c:out> --%>
	<!-- Pager -->
	<div align="center">
		<ul class="pagination">
		<c:choose>
			<c:when test="${curPage==1}">
				<li class="previous disabled">
			        <a href="#">&larr; 이전</a>
			    </li>
			</c:when>
			<c:otherwise>
				<li class="previous">
			        <a href="#">&larr; 이전</a>
			    </li>
			</c:otherwise>
		</c:choose>
			<c:forEach var="pageNum" begin="1" end="${totalCount}">
				<c:set var="sRecNum" value="${(pageNum-1) * perPage }" />
				<c:choose>
					<c:when test="${pageNum != curPage }">
							<li><a
								href="${requestScope['javax.servlet.forward.request_uri']}?sPage=${sRecNum }&ePage=${perPage }&categoryno=${categoryno }&subcategoryno=${subcategoryno }">${pageNum}</a>
							</li>
						</c:when>
					<c:otherwise>
						<li class="active">
							<a href="${requestScope['javax.servlet.forward.request_uri']}">${pageNum}</a>
						</li>
					</c:otherwise>
				</c:choose>	
			</c:forEach>    
		    
		    <c:choose>
			<c:when test="${curPage==totalCount}">
				<li class="next disabled">
		        	<a href="#">다음 &rarr;</a>
		    	</li>
			</c:when>
			<c:otherwise>
				<li class="next">
		        	<a href="#">다음 &rarr;</a>
		   		</li>
			</c:otherwise>
			</c:choose>
		    
		</ul>
	</div> <!-- page end -->
	
   	</div>
</body>