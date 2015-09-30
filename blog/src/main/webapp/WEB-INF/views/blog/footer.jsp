<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

        <!-- Footer -->
        <footer>
            <div class="row">
                <div class="col-lg-12">
                <c:choose>
                	<c:when test="${logined == null }">
                		
                	</c:when>
                	<c:otherwise>
                		<p align="center"><small>'${logined.bDTO.title }' 블로그 <font color="silver">|</font> ${logined.nickname }</small></p>
                	</c:otherwise>
                </c:choose>
                    <p align="center">
                    	<img src="${pageContext.request.contextPath}/resources/img/welcome(1616).png" class="img-rounded"> 
                    	Copyright &copy; STORY & PICTURE &nbsp;&nbsp;&nbsp;<font color="silver">|</font>&nbsp;&nbsp;&nbsp;<small>201312033 이예진 - 2015 BLOG PROJECT</small>
                    </p>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
        </footer>
