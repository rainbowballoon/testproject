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
                <a class="navbar-brand" href="main"> 
                	<c:choose>
                		<c:when test="${logined == null}">WELCOME! BLOG PROJECT</c:when>
                		<c:otherwise>[ ${logined.nickname }]님 </c:otherwise>
                	</c:choose> 
                </a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="about">블로그에 대해서</a>
                    </li>
            <c:choose>
			<c:when test="${logined == null}">
                    <li>
                        <a href="joinForm">블로그 가입하기</a>
                    </li>
                    <li>
                        <a href="loginForm" >로그인</a>
                    </li>
             </c:when>
             <c:otherwise>
             		 <li>
                        <a href="logout">로그아웃</a>
                    </li>
                     <li>
                        <a href="${logined.no }/index">내블로그 가기</a>
                    </li>
             </c:otherwise>
             </c:choose>
<!--                     <li> -->
<!--                         <a href="services">Services</a> -->
<!--                     </li> -->
<!--                     <li> -->
<!--                         <a href="products">Products</a> -->
<!--                     </li> -->
<!--                     <li> -->
<!--                         <a href="contact">Contact</a> -->
<!--                     </li> -->
<!--                     <li class="dropdown"> -->
<!--                         <a href="#" class="dropdown-toggle" data-toggle="dropdown">Portfolio <b class="caret"></b></a> -->
<!--                         <ul class="dropdown-menu"> -->
<!--                             <li> -->
<!--                                 <a href="portfolio-1-col">1 Column Portfolio</a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="portfolio-2-col">2 Column Portfolio</a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="portfolio-3-col">3 Column Portfolio</a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="portfolio-4-col">4 Column Portfolio</a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="portfolio-item">Single Portfolio Item</a> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                     </li> -->
<!--                     <li class="dropdown"> -->
<!--                         <a href="#" class="dropdown-toggle" data-toggle="dropdown">Blog <b class="caret"></b></a> -->
<!--                         <ul class="dropdown-menu"> -->
<!--                             <li> -->
<!--                                 <a href="blog-home-1.jsp">Blog Home 1</a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="blog-home-2.jsp">Blog Home 2</a> -->
<!--                             </li> -->
<!--                             <li> -->
<!--                                 <a href="blog-post.jsp">Blog Post</a> -->
<!--                             </li> -->
<!--                         </ul> -->
<!--                     </li> -->
<!--                     
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
