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
							<c:out value="${logined.bDTO.cDTO }"></c:out>
							<!-- 여기서 모르겠는부분: bDTO.cDTO하면 마지막 값만 검색됨. 리스트채로 얻으려면 어떻게..? -->
                            </ul>
                        </div>
                    </div>
                    <!-- /.row -->
                </div>
