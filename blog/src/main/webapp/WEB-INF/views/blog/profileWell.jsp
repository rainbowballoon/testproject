<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
	<!-- Side Widget Well -->
<c:choose>
   <c:when test="${logined.no == blogpoint.no}">
      <div class="well" align="center">
      	  <img src="${pageContext.request.contextPath }/profileimage/${logined.bDTO.proimg }" class="img-thumbnail" width="161px">
          <h4><c:out value="${logined.nickname } (${logined.id })"></c:out> </h4>
          <p><c:out value="${logined.bDTO.profile }"></c:out></p>
      </div>
	</c:when>
	<c:otherwise>
	  <div class="well" align="center">
      	  <img src="${pageContext.request.contextPath }/profileimage/${blogpoint.bDTO.proimg }" class="img-thumbnail" width="161px">
          <h4><c:out value="${blogpoint.nickname } (${logined.id }, ${blogpoint.bDTO.proimg })"></c:out> </h4>
          <p><c:out value="${blogpoint.bDTO.profile }"></c:out></p>
      </div>
	</c:otherwise>
</c:choose>
