<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
        <!-- Features Section -->
        <div class="row">
       		 <div class="col-lg-12">
                <h2 class="page-header">인기 포스트 <small>[★HOT POST]</small></h2>
            </div>
       	</div>
       	
       	<div class="row"> <!-- thumbnail용 row 한줄 3개까지-->
            	<c:forEach items="${himgsrc }" var="himgsrc" varStatus="status">
	            <div class="col-md-4 col-sm-6">
		            <div class="thumbnail">
		                <a href="${pageContext.request.contextPath}/postDetail?no=${hotpost[status.index].no}&blogno=${hotpost[status.index].mDTO.no }">
		                    <img src="${himgsrc }" class="img-responsive img-portfolio img-hover"/>
		                </a>
		                <div class="caption">
		                	<h4>[${hotpost[status.index].topicno }] ${hotpost[status.index].title }</h4>
		                	<hr>
        					<p>
        						By <a href="${pageContext.request.contextPath}/${hotpost[status.index].mDTO.no }/index">${hotpost[status.index].mDTO.nickname }</a>
        					</p>
		                </div>
		            </div>
	            </div>
	            </c:forEach>
	        </div> <!--thumbnail 마지막  -->
	        
<%--         <c:forEach items="${himgsrc }" var="himgsrc" varStatus="status"> --%>
<!--         <div class="row"> -->
<!--             <div class="col-md-6"> -->
<%--                 <p><strong>${hotpost[status.index].title }</strong></p> --%>
<%--            		<p>${hotpost[status.index].mDTO.nickname }</p> --%>
<%--                 <p>주제 : [${hotpost[status.index].topicno }]</p> --%>
<!--             </div> -->
<!--             <div class="col-md-6"> -->
<%--                 <img class="img-responsive" src="${himgsrc }" alt=""> --%>
<!--             </div> -->
<!--             <div class="col-lg-12"> -->
<!--             	<hr> -->
<!--             </div> -->
<!--         </div> -->
<!--         /.row -->
<%--         </c:forEach> --%>
     </div>
     	<!-- /. Page Content -->
