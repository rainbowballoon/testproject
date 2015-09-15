<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
	<!-- Side Widget Well -->
      <div class="well" align="center">
      	  <img src="${pageContext.request.contextPath }/profileimage/${logined.bDTO.proimg }" class="img-thumbnail" width="161px">
          <h4><c:out value="${logined.nickname } (${logined.id })"></c:out> </h4>
          <p><c:out value="${logined.bDTO.profile }"></c:out> <a href="profileForm" class="btn btn-default btn-xs">Edit</a></p>
      </div>
