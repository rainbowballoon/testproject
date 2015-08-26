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

	<form name="form" action="/article/list.ok" id="form" method="post" OnSubmit="act.search();">
	<input type="hidden" id="no" name="no" value="${no}" />
		
		<table class="table">
			<tr>
				<td width="650" height="1" colspan="6"></td>
			</tr>
			<tr align="center">
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>작성일</td>
			</tr>        
			<tr>
				<td width="650" height="1" colspan="6" ></td>
			</tr>
		
		
			<c:forEach var="dto" items="${boardList}" varStatus="c" >
			<tr height="22" align="center" onmouseover="this.className='tableOver'" onmouseout="this.className='tableOut'">
				<td width="40" class="grayS" >${dto.no}</td>
				<td align="left" style='padding:2px 10px 0 15px'>
				<c:if test="${dto.relevel>0}">
				<img src="/imgs/ui/blank.gif" border=0 height="1" width="${dto.relevel*10}" />
				<img src="/imgs/ui/icon/re.gif" border="0" />
				</c:if>                         
				<a href="/article/view.ok?articleId=${dto.no}" class="tableA">${dto.title}</a>
				    
				</td>
				<td width="80" >${dto.name}</td>
				<td width="100" class="txtS"><fmt:formatDate value="${dto.regdate}" pattern="yyyy-MM-dd" /></td>
			</tr>
			<tr ><td class="tableL" height="1" colspan="6" width="650"  ></td></tr>
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
					<a href="boardWriteForm"  class="btn btn-primary"><span>글 등 록</span></a>
				</td>
			</tr>
		</table>
	
	</form>
	
   	</div>
</body>