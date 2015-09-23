<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>2015 블로그 프로젝트</title>

    <!-- Bootstrap Core CSS -->
	<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.5/dist/css/bootstrap.min.css"/>">
	
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath }/resources/css/modern-business.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath }/resources/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<%@ include file="header.jsp" %>

<%@ include file="slide.jsp" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${param.content == null}">
<%-- 		<jsp:include page="intro.jsp" /> --%>
		<jsp:include page="postNewSection.jsp" />
		<jsp:include page="postHotSection.jsp" />
		<jsp:include page="calltoaction.jsp" />
	</c:when>
	<c:otherwise>
		<jsp:include page="${param.content }" />
		<c:choose>
			<c:when test="${param.content eq 'postDetail.jsp' }">
				<jsp:include page="postNewSection.jsp" />
			</c:when>
		</c:choose>
	</c:otherwise>
</c:choose>
<!--     Page Content -->
<!--     <div class="container"> -->

<!--         Marketing Icons Section -->
<!--         <div class="row"> -->
<!--             <div class="col-lg-12"> -->
<!--                 <h1 class="page-header"> -->
<!--                     Welcome to Modern Business -->
<!--                 </h1> -->
<!--             </div> -->
<!--             <div class="col-md-4"> -->
<!--                 <div class="panel panel-default"> -->
<!--                     <div class="panel-heading"> -->
<!--                         <h4><i class="fa fa-fw fa-check"></i> Bootstrap v3.2.0</h4> -->
<!--                     </div> -->
<!--                     <div class="panel-body"> -->
<!--                         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, optio corporis quae nulla aspernatur in alias at numquam rerum ea excepturi expedita tenetur assumenda voluptatibus eveniet incidunt dicta nostrum quod?</p> -->
<!--                         <a href="#" class="btn btn-default">Learn More</a> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--             <div class="col-md-4"> -->
<!--                 <div class="panel panel-default"> -->
<!--                     <div class="panel-heading"> -->
<!--                         <h4><i class="fa fa-fw fa-gift"></i> Free &amp; Open Source</h4> -->
<!--                     </div> -->
<!--                     <div class="panel-body"> -->
<!--                         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, optio corporis quae nulla aspernatur in alias at numquam rerum ea excepturi expedita tenetur assumenda voluptatibus eveniet incidunt dicta nostrum quod?</p> -->
<!--                         <a href="#" class="btn btn-default">Learn More</a> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--             <div class="col-md-4"> -->
<!--                 <div class="panel panel-default"> -->
<!--                     <div class="panel-heading"> -->
<!--                         <h4><i class="fa fa-fw fa-compass"></i> Easy to Use</h4> -->
<!--                     </div> -->
<!--                     <div class="panel-body"> -->
<!--                         <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Itaque, optio corporis quae nulla aspernatur in alias at numquam rerum ea excepturi expedita tenetur assumenda voluptatibus eveniet incidunt dicta nostrum quod?</p> -->
<!--                         <a href="#" class="btn btn-default">Learn More</a> -->
<!--                     </div> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->
<!--         /.row -->

<%-- <%@ include file="portfolio.jsp" %> --%>
<!--         Portfolio Section -->
<!--         <div class="row"> -->
<!--             <div class="col-lg-12"> -->
<!--                 <h2 class="page-header">Portfolio Heading</h2> -->
<!--             </div> -->
<!--             <div class="col-md-4 col-sm-6"> -->
<!--                 <a href="portfolio-item.jsp"> -->
<!--                     <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt=""> -->
<!--                 </a> -->
<!--             </div> -->
<!--             <div class="col-md-4 col-sm-6"> -->
<!--                 <a href="portfolio-item.jsp"> -->
<!--                     <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt=""> -->
<!--                 </a> -->
<!--             </div> -->
<!--             <div class="col-md-4 col-sm-6"> -->
<!--                 <a href="portfolio-item.jsp"> -->
<!--                     <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt=""> -->
<!--                 </a> -->
<!--             </div> -->
<!--             <div class="col-md-4 col-sm-6"> -->
<!--                 <a href="portfolio-item.jsp"> -->
<!--                     <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt=""> -->
<!--                 </a> -->
<!--             </div> -->
<!--             <div class="col-md-4 col-sm-6"> -->
<!--                 <a href="portfolio-item.jsp"> -->
<!--                     <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt=""> -->
<!--                 </a> -->
<!--             </div> -->
<!--             <div class="col-md-4 col-sm-6"> -->
<!--                 <a href="portfolio-item.jsp"> -->
<!--                     <img class="img-responsive img-portfolio img-hover" src="http://placehold.it/700x450" alt=""> -->
<!--                 </a> -->
<!--             </div> -->
<!--         </div> -->
<!--         /.row -->

<%-- <%@ include file="features.jsp" %> --%>
<!--         Features Section -->
<!--         <div class="row"> -->
<!--             <div class="col-lg-12"> -->
<!--                 <h2 class="page-header">Modern Business Features</h2> -->
<!--             </div> -->
<!--             <div class="col-md-6"> -->
<!--                 <p>The Modern Business template by Start Bootstrap includes:</p> -->
<!--                 <ul> -->
<!--                     <li><strong>Bootstrap v3.2.0</strong> -->
<!--                     </li> -->
<!--                     <li>jQuery v1.11.0</li> -->
<!--                     <li>Font Awesome v4.1.0</li> -->
<!--                     <li>Working PHP contact form with validation</li> -->
<!--                     <li>Unstyled page elements for easy customization</li> -->
<!--                     <li>17 HTML pages</li> -->
<!--                 </ul> -->
<!--                 <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Corporis, omnis doloremque non cum id reprehenderit, quisquam totam aspernatur tempora minima unde aliquid ea culpa sunt. Reiciendis quia dolorum ducimus unde.</p> -->
<!--             </div> -->
<!--             <div class="col-md-6"> -->
<!--                 <img class="img-responsive" src="http://placehold.it/700x450" alt=""> -->
<!--             </div> -->
<!--         </div> -->
<!--         /.row -->

<hr>

<%-- <%@ include file="calltoaction.jsp" %> --%>
<!--         Call to Action Section -->
<!--         <div class="well"> -->
<!--             <div class="row"> -->
<!--                 <div class="col-md-8"> -->
<!--                     <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Molestias, expedita, saepe, vero rerum deleniti beatae veniam harum neque nemo praesentium cum alias asperiores commodi.</p> -->
<!--                 </div> -->
<!--                 <div class="col-md-4"> -->
<!--                     <a class="btn btn-lg btn-default btn-block" href="#">Call to Action</a> -->
<!--                 </div> -->
<!--             </div> -->
<!--         </div> -->

<%@ include file="footer.jsp" %>

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>
<%--     <script src="<c:url value="/webjars/jquery/2.1.4/dist/jquery.min.js"/>"></script> --%>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath }/resources/js/bootstrap.min.js"></script>
<%-- 	<script src="<c:url value="/webjars/bootstrap/3.3.5/dist/js/bootstrap.min.js"/>"></script> --%>

    <!-- Script to Activate the Carousel -->
    <script>
    $('.carousel').carousel({
        interval: 5000 //changes the speed
    })
    </script>

</body>

</html>
