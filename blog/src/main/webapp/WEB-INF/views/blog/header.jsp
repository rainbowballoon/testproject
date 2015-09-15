<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index">
	                <c:out value="${logined.bDTO.title }"></c:out>
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                 	<li>
                        <a href="index">Home</a>
                    </li>
                <c:choose>
                <c:when test="${logined == null }">
                	<li>
                        <a href="joinForm">Join</a>
                    </li>
                    <li>
                        <a href="loginForm">Login</a>
                    </li>
                </c:when>
                <c:otherwise>
                	<c:choose>
                	<c:when test="${logined.no ==  blogpoint.no}">
	                 	<li>
	                        <a href="postWriteForm">Post Write</a>
	                    </li>
	                    <li>
	                        <a href="blogManageForm">Blog management</a>
	                    </li>
	                    <li>
	                        <a href="blogLogout">Logout</a>
	                    </li>
	                     <li>
	                        <a href="boardList">Guest Book</a>
	                    </li>
                    </c:when>
                    <c:otherwise>
	                    <li>
	                        <a href="blogLogout">Logout</a>
	                    </li>
	                     <li>
	                        <a href="boardList">Guest Book</a>
	                    </li>
                    </c:otherwise>
                    </c:choose>
                </c:otherwise>
                </c:choose>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
