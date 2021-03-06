<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.crop{
	    float:left;
	    margin:.5em 10px .5em 0;
	    overflow:hidden; /* this is important */
	    border:0px solid #ccc;
	    height:250px;
	    }
	    /* input values to crop the image: top, right, bottom, left */
	.crop img{margin-top:-19px;}

</style>
    
<!-- Page Content -->
    <div class="container">
    
		<!-- Portfolio Section -->
        <div class="row">
            <div class="col-lg-12">
                <h2 class="page-header">
                	<span class="glyphicon glyphicon-upload" aria-hidden="true"></span> 새로운 포스트 <small><br/></small> 
                </h2>
            </div>
            
<!--             <button class="btn btn-default" id="popbutton">모달출력버튼</button> -->
            
<!--             <div class="modal fade"> -->
<!-- 			  <div class="modal-dialog"> -->
<!-- 			    <div class="modal-content"> -->
<!-- 			        remote ajax call이 되는영역 -->
<!-- 			    </div> -->
<!-- 			  </div> -->
<!-- 			</div> -->
			
            <div class="row"> <!-- thumbnail용 row 한줄 3개까지-->
            	<c:forEach items="${nimgsrc }" var="nimgsrc" begin="0" end="2" varStatus="status">
	            <div class="col-md-4 col-sm-6">
		            <div class="thumbnail">
		                <p class="crop">
		                	<a href="${pageContext.request.contextPath}/postDetail?no=${newpost[status.index].no}&blogno=${newpost[status.index].mDTO.no }">
		                    <img src="${nimgsrc }" class="img-responsive img-portfolio img-hover"/>
		                	</a>
		                </p>
		                <div class="caption" id="popbutton" >
		                	<h4>${newpost[status.index].title }</h4>
		                	<hr>
		                	<h6>
		                		<font color="#9E9E9E">[${newpost[status.index].tDTO.name }]</font> 
		                		<font color="#d4d4d4">&nbsp;&nbsp; / &nbsp;&nbsp;</font>
		                		<font color="#9E9E9E">${newpost[status.index].regdate }</font>
		                	</h6>
        					<p>
        						By <a href="${pageContext.request.contextPath}/${newpost[status.index].mDTO.no }/index">${newpost[status.index].mDTO.nickname }</a>
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
		           		<p class="crop">
		                	<a href="${pageContext.request.contextPath}/postDetail?no=${newpost[status.index].no}&blogno=${newpost[status.index].mDTO.no }">
		                    <img src="${nimgsrc }" class="img-responsive img-portfolio img-hover"/>
		                	</a>
		               	</p>
		                <div class="caption" id="popbutton">
		                	<h4>${newpost[status.index].title }</h4>
		                	<hr>
		                	<h6>
		                		<font color="#9E9E9E">[${newpost[status.index].tDTO.name }]</font> 
		                		<font color="#d4d4d4">&nbsp;&nbsp; / &nbsp;&nbsp;</font>
		                		<font color="#9E9E9E">${newpost[status.index].regdate }</font>
		                	</h6>
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
