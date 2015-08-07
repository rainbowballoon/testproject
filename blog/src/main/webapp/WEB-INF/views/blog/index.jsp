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

    <title>사용자 타이틀 설정</title>

    <!-- Bootstrap Core CSS -->
	<link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.5/dist/css/bootstrap.min.css"/>">
	
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath }/resources/css/blog-home.css" rel="stylesheet">
	
	<script src="<c:url value="/webjars/jquery/2.1.4/dist/jquery.min.js"/>"></script>
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
		    
		    //2015-08-02
		    
		    
			for( var i = 0 ; i < $(".thumbnail").length ; i++ )
			{	
		    	if( parseInt($(".thumbnail").eq(i).css('height')) < 150 )
			    {
			    	$(".thumbnail").eq(i).css('height', "150");
			    }
		    	$(".thumbnail").eq(i).css('border', "0");
			}
		    
		});
	</script>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${logined.bDTO.themeno == 1}">
		<link href="${pageContext.request.contextPath }/resources/themecss/candy-box.css" rel="stylesheet">
	</c:when>
	<c:when test="${logined.bDTO.themeno == 2}">
		<link href="${pageContext.request.contextPath }/resources/themecss/autumn-dawn.css" rel="stylesheet">
	</c:when>
	<c:when test="${logined.bDTO.themeno == 3}">
		<link href="${pageContext.request.contextPath }/resources/themecss/pastel-stream.css" rel="stylesheet">
	</c:when>
	<c:otherwise>
	
	</c:otherwise>
</c:choose>	

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<%@ include file="header.jsp" %>
    <!-- Navigation -->
<!--     <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"> -->
<!--         <div class="container"> -->
            <!-- Brand and toggle get grouped for better mobile display -->
<!--             <div class="navbar-header"> -->
<!--                 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> -->
<!--                     <span class="sr-only">Toggle navigation</span> -->
<!--                     <span class="icon-bar"></span> -->
<!--                     <span class="icon-bar"></span> -->
<!--                     <span class="icon-bar"></span> -->
<!--                 </button> -->
<!--                 <a class="navbar-brand" href="#">Start Bootstrap</a> -->
<!--             </div> -->
<!--             Collect the nav links, forms, and other content for toggling -->
<!--             <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> -->
<!--                 <ul class="nav navbar-nav"> -->
<!--                     <li> -->
<!--                         <a href="#">About</a> -->
<!--                     </li> -->
<!--                     <li> -->
<!--                         <a href="#">Services</a> -->
<!--                     </li> -->
<!--                     <li> -->
<!--                         <a href="#">Contact</a> -->
<!--                     </li> -->
<!--                 </ul> -->
<!--             </div> -->
            <!-- /.navbar-collapse -->
<!--         </div> -->
        <!-- /.container -->
<!--     </nav> -->

    <!-- Page Content -->
    <div class="container">

        <div class="row">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${param.content == null }">
		<jsp:include page="testForm.jsp" />
	</c:when>
	<c:when test="${param.content eq 'post.jsp' }">
		<jsp:include page="${param.content }" />
		<jsp:include page="BlogSidebarWidgetsColumn.jsp" />
	</c:when>
	<c:otherwise>
		<jsp:include page="${param.content }" />
	</c:otherwise>
</c:choose>
        </div>
        <!-- /.row -->

        <hr>

<%@ include file="footer.jsp" %>
        <!-- Footer -->
<!--         <footer> -->
<!--             <div class="row"> -->
<!--                 <div class="col-lg-12"> -->
<!--                     <p>Copyright &copy; Your Website 2014</p> -->
<!--                 </div> -->
                <!-- /.col-lg-12 -->
<!--             </div> -->
            <!-- /.row -->
<!--         </footer> -->

    </div>
    <!-- /.container -->

  	<!-- jQuery -->
	<script src="<c:url value="/webjars/jquery/2.1.4/dist/jquery.min.js"/>"></script>
	
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/webjars/bootstrap/3.3.5/dist/js/bootstrap.min.js"/>"></script>
</body>

</html>
