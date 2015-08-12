<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 

	<!-- Blog Categories Well -->
                <div class="well">
                    <h4><strong>블로그 카테고리</strong></h4>
                    <hr>
                    <div class="row">
                        <div class="col-lg-12">
                            <ul class="list-group">
                            
                            <c:forEach items="${categoryList }" var="clist">
                                <a class="list-group-item" href="#">
                                	<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> 
                                	<c:out value="${clist.name }"></c:out>
                                </a>
                                <c:forEach items="${subCategoryListAll }" var="sclistAll">
                                <c:forEach items="${sclistAll }" var="sclist">
                                	<c:choose>
                                	<c:when test="${sclist.categoryno == clist.no }">
                                		<a class="list-group-item" href="postList?subcategoryno=${sclist.no }">
	                                	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span> 
	                                	<c:out value="${sclist.name }"></c:out>
	                               		</a>
                                	</c:when>
                                	</c:choose>
	                            </c:forEach>
                                </c:forEach>
                            </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
