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
      
        <!-- Features Section -->
        <div class="row">
       		 <div class="col-lg-12">
                <h2 class="page-header"><span class="glyphicon glyphicon-heart-empty" aria-hidden="true"></span> 인기 포스트 <small></small></h2>
            </div>
       	</div>
       	
       	<div class="row"> <!-- thumbnail용 row 한줄 3개까지-->
            	<c:forEach items="${himgsrc }" var="himgsrc" varStatus="status">
	            <div class="col-md-4 col-sm-6">
		            <div class="thumbnail">
		            	<p class="crop">
			                <a href="${pageContext.request.contextPath}/postDetail?no=${hotpost[status.index].no}&blogno=${hotpost[status.index].mDTO.no }">
			                    <img src="${himgsrc }" class="img-responsive img-portfolio img-hover"/>
			                </a>
		                </p>
		                <div class="caption">
		                	<h4>${hotpost[status.index].title }</h4>
		                	<hr>
        					<h6>
        						<font color="#9E9E9E">[${hotpost[status.index].tDTO.name }]</font> 
		                		<font color="#d4d4d4">&nbsp;&nbsp; / &nbsp;&nbsp;</font>
		                		<font color="#9E9E9E">${hotpost[status.index].regdate }</font>
        					</h6>
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
