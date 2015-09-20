<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- Page Content -->
    <div class="container">
    
<!-- Portfolio Section -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">새로운 포스트 <small>[★NEW POST]</small> </h2>
            </div>
            
        
            <div class="row"> <!-- thumbnail용 row 한줄 3개까지-->
            	<c:forEach items="${imgsrc }" var="imgsrc" begin="0" end="2">
	            <div class="col-md-4 col-sm-6">
		            <div class="thumbnail">
		                <a href="portfolio-item.jsp">
		                    <img src="${imgsrc }" class="img-responsive img-portfolio img-hover" style="width:260px;height:150px;"/>
		                </a>
		            </div>
	            </div>
	            </c:forEach>
	        </div> <!--thumbnail 마지막  -->
	        <div class="row"> <!-- thumbnail용 row 한줄 3개까지-->
            	<c:forEach items="${imgsrc }" var="imgsrc" begin="3" end="5">
	            <div class="col-md-4 col-sm-6">
		            <div class="thumbnail">
		                <a href="portfolio-item.jsp">
		                    <img src="${imgsrc }" class="img-responsive img-portfolio img-hover" style="width:260px;height:150px;"/>
		                </a>
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
        <!-- /.row -->
