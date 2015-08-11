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
                            
                            <c:forEach items="${categoryList }" var="categoryList">
                                <a class="list-group-item" href="#">${categoryList.name }</a>
                            </c:forEach>
                            <c:out value="${categoryList }"></c:out>
                            </ul>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
