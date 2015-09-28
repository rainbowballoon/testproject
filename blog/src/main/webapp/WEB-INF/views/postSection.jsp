<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Page Content -->
    <div class="container">
    
		<!-- Portfolio Section -->
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header">${topicpost[0].tDTO.name } <small>테스트</small> </h3>
            </div>
            
        
            <div class="row"> <!-- thumbnail용 row 한줄 3개까지-->
            	<c:forEach items="${timgsrc }" var="timgsrc" begin="0" end="2" varStatus="status">
	            <div class="col-md-4 col-sm-6">
		            <div class="thumbnail">
		                <a href="${pageContext.request.contextPath}/postDetail?no=${topicpost[status.index].no}&blogno=${topicpost[status.index].mDTO.no }">
		                    <img src="${timgsrc }" class="img-responsive img-portfolio img-hover"/>
		                </a>
		                <div class="caption">
		                	<h4>[${topicpost[status.index].topicno }] ${topicpost[status.index].title }</h4>
<%-- 		                	<p>${newpost[status.index].content }</p> --%>
		                	<hr>
        					<p>
        						By <a href="${pageContext.request.contextPath}/${topicpost[status.index].mDTO.no }/index">${topicpost[status.index].mDTO.nickname }</a>
        					</p>
		                </div>
		            </div>
	            </div>
	            </c:forEach>
	        </div> <!--thumbnail 마지막  -->
	        <div class="row"> <!-- thumbnail용 row 한줄 3개까지-->
            	<c:forEach items="${nimgsrc }" var="nimgsrc" begin="3" end="5" varStatus="status">
	            <div class="col-md-4 col-sm-6">
		            <div class="thumbnail">
<%-- 		                <a href="${pageContext.request.contextPath}/${newpost[status.index].mDTO.no }/postList"> --%>
		                <a href="${pageContext.request.contextPath}/postDetail?no=${newpost[status.index].no}&blogno=${newpost[status.index].mDTO.no }">
		                    <img src="${nimgsrc }" class="img-responsive img-portfolio img-hover"/>
		                </a>
		                <div class="caption">
		                	<h4>[${newpost[status.index].topicno }] ${newpost[status.index].title }</h4>
<%-- 		                	<p>${newpost[status.index].content }</p> --%>
		                	<hr>
        					<p>
        						By <a href="${pageContext.request.contextPath}/${newpost[status.index].mDTO.no }/index">${newpost[status.index].mDTO.nickname }</a>
        					</p>
		                </div>
		            </div>
	            </div>
	            </c:forEach>
	        </div> <!--thumbnail 마지막  -->
	    
	        
<!--             <div class="row"> thumbnail용 row -->
<!-- 	            <div class="col-md-4 col-sm-6"> -->
<!-- 		            <div class="thumbnail"> -->
<!-- 		                <a href="portfolio-item.jsp"> -->
<!-- 		                    <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt=""> -->
<!-- 		                </a> -->
<!-- 		            </div> -->
<!-- 	            </div> -->
<!-- 	            <div class="col-md-4 col-sm-6"> -->
<!-- 	            	<div class="thumbnail"> -->
<!-- 		                <a href="portfolio-item.jsp"> -->
<!-- 		                    <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt=""> -->
<!-- 		                </a> -->
<!-- 		            </div> -->
<!-- 	            </div> -->
<!-- 	            <div class="col-md-4 col-sm-6"> -->
<!-- 		           	<div class="thumbnail"> -->
<!-- 		                <a href="portfolio-item.jsp"> -->
<!-- 		                    <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt=""> -->
<!-- 		                </a> -->
<!-- 		            </div> -->
<!-- 	            </div> -->
<!-- 	        </div>   -->
	        <!--thumbnail 마지막  -->
	    </div>
        <!-- /.row -->
