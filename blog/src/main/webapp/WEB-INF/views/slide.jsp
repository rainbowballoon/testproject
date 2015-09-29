<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!-- Header Carousel -->
    <header id="myCarousel" class="carousel slide">
        <!-- Indicators -->
        <ol class="carousel-indicators">
        	<c:forEach items="${himgsrc }" var="himgsrc" begin="0" end="0" varStatus="status">
        	<li data-target="#myCarousel" data-slide-to="${status.index }" class="active"></li>
        	</c:forEach>
        	<c:forEach items="${himgsrc }" var="himgsrc" begin="1" end="4" varStatus="status">
        	<li data-target="#myCarousel" data-slide-to="${status.index }"></li>
        	</c:forEach>
<!-- 	            <li data-target="#myCarousel" data-slide-to="0" class="active"></li> -->
<!-- 	            <li data-target="#myCarousel" data-slide-to="1"></li> -->
<!-- 	            <li data-target="#myCarousel" data-slide-to="2"></li> -->
<!-- 	            <li data-target="#myCarousel" data-slide-to="3"></li> -->
	        
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner">
        	<c:forEach items="${himgsrc }" var="himgsrc" begin="0" end="0" varStatus="status">
        	<div class="item active">
                <div class="fill" style="background-image:url('${himgsrc }');"></div>
                <div class="carousel-caption" style="background-color: rgba(234, 234, 234, 0.15);">
                    <h2><a id="slide" href="${pageContext.request.contextPath}/${hotpost[status.index].mDTO.no }/index">
                    	${hotpost[status.index].title }
                    	</a>
                    </h2>
                    <p><a id="slide" href="${pageContext.request.contextPath}/${hotpost[status.index].mDTO.no }/index">
	                    By ${hotpost[status.index].mDTO.nickname }
	                    </a>
                    </p>
                </div>
            </div>
            </c:forEach>
            <c:forEach items="${himgsrc }" var="himgsrc" begin="1" end="4" varStatus="status">
            <div class="item">
                <div class="fill" style="background-image:url('${himgsrc }');"></div>
                <div class="carousel-caption" style="background-color: rgba(234, 234, 234, 0.15);">
                    <h2>${hotpost[status.index].title }</h2>
                    <p><a id="slide" href="${pageContext.request.contextPath}/${hotpost[status.index].mDTO.no }/index">
                    	By ${hotpost[status.index].mDTO.nickname }
                    	</a>
                    </p>
                </div>
            </div>
            </c:forEach>
<!--             <div class="item"> -->
<!--                 <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Two');"></div> -->
<!--                 <div class="carousel-caption"> -->
<!--                     <h2>Caption 2</h2> -->
<!--                 </div>                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              -->
<!--             </div> -->
<!--             <div class="item"> -->
<!--                 <div class="fill" style="background-image:url('http://placehold.it/1900x1080&text=Slide Three');"></div> -->
<!--                 <div class="carousel-caption"> -->
<!--                     <h2>Caption 3</h2> -->
<!--                 </div> -->
<!--             </div> -->
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#myCarousel" data-slide="prev">
            <span class="icon-prev"></span>
        </a>
        <a class="right carousel-control" href="#myCarousel" data-slide="next">
            <span class="icon-next"></span>
        </a>
    </header>
<style type="text/css">
	#slide:link {text-decoration: none; color: #ffffff;}
	#slide:visited {text-decoration: none; color: #ffffff;}
	#slide:active {text-decoration: none; color: #ffffff;}
	#slide:hover {text-decoration: inherit; color: #ffffff;}
</style>