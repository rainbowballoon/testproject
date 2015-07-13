<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<!DOCTYPE html>
<html lang="ko">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>사용자 타이틀 설정2</title>

    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="<c:url value="/webjars/bootstrap/3.3.5/dist/css/bootstrap.min.css"/>">
	
    <!-- Custom CSS -->
    <link href="css/blog-home.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>
<%@ include file="header.jsp" %>

    <!-- Page Content -->
    <div class="container">
        <div class="row">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:choose>
	<c:when test="${param.content == null}">
		<jsp:include page="testForm.jsp" />
	</c:when>
	<c:otherwise>
		<jsp:include page="${param.content }" />
	</c:otherwise>
</c:choose>

<%@ include file="BlogSidebarWidgetsColumn.jsp" %>

        </div><!-- /.row -->
        <hr>

<%@ include file="footer.jsp" %>

    </div><!-- /.container -->

    <!-- jQuery -->
	<script src="<c:url value="/webjars/jquery/2.1.4/dist/jquery.min.js"/>"></script>
	
    <!-- Bootstrap Core JavaScript -->
    <script src="<c:url value="/webjars/bootstrap/3.3.5/dist/js/bootstrap.min.js"/>"></script>
</body>

</html>
