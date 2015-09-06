<%@ page import="java.sql.*,java.text.SimpleDateFormat,java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!-- http://www.slideshare.net/hanmomhanda/spring-mvc-fullflow -->
<!-- http://wiki.gurubee.net/pages/viewpage.action?pageId=11829301 -->
<script type="text/javascript">
    var act = {
        goWriteForm : function(){ 
            var f = document.getElementById("form");
            f.action = '/blog/boardWriteForm';
            f.submit();
        },
        search : function(){ 
            document.form.submit();
        }
    }
</script>       
<body onload="showMessage('${msg}');">
	<!-- Blog Entries Column -->
	<div class="col-md-8">

	<h3 class="page-header"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 방명록</h3>

	<form name="form" action="/article/list.ok" id="form" method="post" OnSubmit="act.search();">
	<input type="hidden" id="no" name="no" value="${no}" />
		<!-- 			<tr ><td class="tableL" height="1" colspan="6" width="650"  ></td></tr> -->
		<table class="table table-hover ">
			<thead>
				<tr class="active">
					<th width="100">번호</th>
					<th width="300">제목</th>
					<th width="150">작성자</th>
					<th width="100">작성일</th>
				</tr>    
			</thead>    
			<c:forEach var="dto" items="${boardList}" varStatus="c" >
			<tr style="cursor: pointer;" onClick="location.href='boardInfo?no=${dto.no}'">
				<td>${dto.no}</td>
				<td>
					<c:if test="${dto.relevel>0}">
						<img src="/imgs/ui/blank.gif" border=0 height="1" width="${dto.relevel*10}" />
						<img src="/imgs/ui/icon/re.gif" border="0" />
					</c:if>                         
					${dto.title} 
	<%
		// 최신 게시글 new 표시 날짜 계산
		Date dt = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		String today = sdf.format(dt);
	%>
	<c:set var="today" value="<%=today%>"/>
	<fmt:parseDate var="dateTempParse" value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
	<fmt:formatDate value="${dateTempParse}" pattern="yyyyMMdd" var="regdate"/>
	
       				<c:if test="${today eq regdate }">
       					<span class="label label-info">New</span>
       				</c:if>
       				<c:if test="${dto.cbdDTO.cbdcount != 0 }">
						<span class="badge">${dto.cbdDTO.cbdcount }</span>	
					</c:if>
				</td>
				<td><span class="glyphicon glyphicon-user" aria-hidden="true"></span> ${dto.memberno}</td>
				<td> 
					<fmt:parseDate var="dateTempParse" value="${dto.regdate}" pattern="yyyy-MM-dd HH:mm:ss"/>
					<fmt:formatDate value="${dateTempParse}" pattern="yyyy-MM-dd"/>
				</td>
			</tr>
			</c:forEach>
			<tr height=22><td colspan="7" align="center" >${pageLink}</td></tr>
		</table>
     
		<table class="table">
			<tr>
				<td width="650" height="1" colspan="6"></td>
			</tr>
<!-- 			<tr> -->
<!-- 				<td> -->
<!-- 					<select name="searchKey" class="combobox"> -->
<%-- 					<option value="CONTENT" <c:if test="${searchKey=='CONTENT'}">selected</c:if>>내용</option> --%>
<%-- 					<option value="TITLE"  <c:if test="${searchKey=='TITLE'}">selected</c:if>>제목</option>                  --%>
<%-- 					<option value="NAME"  <c:if test="${searchKey=='NAME'}">selected</c:if>>작성자</option>  --%>
<!-- 					</select> -->
				
<%-- 					<input type="text" name="searchValue" value="${searchValue}" /> --%>
<!-- 					<a href="javascript:act.search();"  class="btn btn-default"><span>검 색</span></a>             -->
<!-- 				</td> -->
<!-- 				<td align="right"> -->
<!-- 					<a href="javascript:act.goWriteForm();"  class="btn btn-default"><span>글 등 록</span></a> -->
<!-- 				</td> -->
<!-- 			</tr> -->
			<tr>
				<td>
					<select name="searchKey">
						<option value="CONTENT" <c:if test="${searchKey=='CONTENT'}">selected</c:if>>내용</option>
						<option value="TITLE"  <c:if test="${searchKey=='TITLE'}">selected</c:if>>제목</option>                 
						<option value="NAME"  <c:if test="${searchKey=='NAME'}">selected</c:if>>작성자</option> 
					</select>
					<input type="text" name="searchValue" value="${searchValue}" />
					<a href="javascript:act.search();"  class="btn btn-default"><span>검 색</span></a>
			  	</td>
			  	<td align="right">
<!-- 					<a href="javascript:act.goWriteForm();"  class="btn btn-default"><span>글 등 록</span></a> -->
					<a href="boardWriteForm"  class="btn btn-primary"><span>글 등록</span></a>
				</td>
			</tr>
		</table>
	
	</form>
	
   	</div>
</body>