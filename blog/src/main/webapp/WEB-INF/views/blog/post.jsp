<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<title>Insert title here</title>
</head>
<script>
	$(window.document).ready(function(){
	    var target_imgs = $(".thumbnail").find("img");
		var maxWidth = 720; //최대크기
		var temp_height = "";
		
	    target_imgs.load(function(){
	    	var width = $(this).outerWidth(); //현재 너비
	        var height = $(this).outerHeight(); //현재 높이
	        
	        if(width >= 720){
	        	
	        	temp_height = (height * maxWidth) / width; //변경될 세로길이 계산
	        	
	        	$(this).css("width", "720");
	        	$(this).css("height", temp_height);
	        	
	        }
	    });
	
	    for(var i=0 ; target_imgs && i<target_imgs.length ; i++)
	    {
	         var width = target_imgs.eq(i).outerWidth();
	         if(width >= 700){
	        	 target_imgs.eq(i).css("width", "720");
	        	 target_imgs.eq(i).css("height", temp_height);
	         }
	    }
	});
</script>
<body>
            <!-- Blog Entries Column -->
            <div class="col-md-8">
<!--                 <h1 class="page-header"> -->
<!--                     Page Heading -->
<!--                     <small>Secondary Text</small> -->
<!--                 </h1> -->
            <ol class="breadcrumb">
                <li><a href="index">Home</a>
                </li>
                <li class="active">Contact</li>
       		</ol>			
			<c:forEach items="${postList }" var="dto">
				<!-- First Blog Post -->
                <h2>
                    <a href="#">${dto.title }</a>
                </h2>
                <p class="lead">
                              작성자 : <a href="index.php">${dto.blogno }</a>
                </p>
                <p><span class="glyphicon glyphicon-time"></span> 포스트 등록시간 [ ${dto.regdate } ]</p>
                <hr>
                	<div class="container-fluid">
		              <div class="row">
						  <div class="thumbnail">
						    	 ${dto.content }
						  </div>
					  </div>
					</div>
				<p>태그 : 테스트 / 공감(0) 및 덧글(0)</p>
				
                <form action="replyWrite" method="post">
                <div class="row">
	                <div class="col-lg-1">
	                	<img src="${pageContext.request.contextPath }/profileimage/reply_50.png" class="img-thumbnail" width="50px">
		            </div> 
		            <div class="col-lg-11">  
		                <div class="input-group">
					      <input type="text" class="form-control" placeholder="덧글 내용을 입력해주세요">
					      <span class="input-group-btn">
					        <button class="btn btn-default" type="button">COMMENT</button>
					      </span>
					    </div><!-- /input-group -->
					</div>
				</div>
<!-- 	                <table border="0"> -->
<!-- 	                	<tr> -->
<%-- 	                		<td><img src="${pageContext.request.contextPath }/profileimage/reply_50.png" class="img-thumbnail" width="50px"></td> --%>
<!-- 	                		<td> -->
<!-- 								<textarea rows="2" cols="78" name="content" style="resize: none;" placeholder="내용을 입력해주세요"></textarea> -->
<!-- 							</td> -->
<!-- 	                		<td> -->
<!-- 	                			<button class="btn btn-lg">COMMENT</button> -->
<!-- 	                		</td> -->
<!-- 	                	</tr> -->
<!-- 	                </table> -->
				</form>
                <hr>
                <c:choose>
                	<c:when test="${logined.no ==  blogpoint.no}">
                		<a class="btn btn-primary" href="postEditForm?no=${dto.no }">수정 <span class="glyphicon glyphicon-chevron-right"></span></a>
                		<a class="btn btn-default" href="#">삭제 <span class="glyphicon glyphicon-chevron-right"></span></a>
                	</c:when>
                </c:choose>
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
						<li>
							<a href="${requestScope['javax.servlet.forward.request_uri']}?sPage=${sRecNum }&ePage=${perPage }">${pageNum}</a>
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
	</div>
            </div>
 
</body>
</html>