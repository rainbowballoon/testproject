<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script type="text/javascript">
	var act = {
			goboardEditForm : function(){
				location.href = "/blog/${bdto.blogno}/boardInfo?no=${bdto.no}";
			}
	}
	
	$(document).ready(function(){
		var useyn = "${bdto.useyn}";
		if(useyn == "Y"){
			$("input:radio[name=useyn][id=useyn1][value=Y]").attr("checked", true);
		}else{
			$("input:radio[name=useyn][id=useyn2][value=N]").attr("checked", true);
		}
	});
</script>

		<div class="col-md-8">
           <h3 class="page-header"><span class="glyphicon glyphicon-menu-right" aria-hidden="true"></span> 방명록</h3>
			<form:form commandName="board_DTO" modelAttribute="board_DTO" name="form" id="form" method="post" action="boardEdit">
			<input type="hidden" name="no" value="${bdto.no }">
			<input type="hidden" name="blogno" value="${blogno }">
			<input type="hidden" name="memberno" value="${memberno }">
				
			<div class="row">	
				<div class="form-group">
					<form:label path="title" class="control-lable">글제목</form:label>
					<form:input path="title" id="title" name="title" class="form-control" placeholder="제목 입력" value="${bdto.title }" />
					<div class="has-error">
						<label class="control-label" for="title">
							<form:errors path="title" class="help-inline"/>
						</label>
	                </div>
				</div>
				<div class="form-group">
					<label for="useyn" class="control-lable">공개여부</label><br>
					<label class="radio-inline">
						<input type="radio" name="useyn" id="useyn1" value="Y" >공개
					</label>
					<label class="radio-inline">
						<input type="radio" name="useyn" id="useyn2" value="N" >비공개
					</label>
				</div>
				<div class="form-group">
					<textarea id="content" class="form-control" rows="10" name="content" 
					placeholder="내용을 입력해주세요" required>${bdto.content }</textarea>
				</div>
<!-- 				<div class="form-group"> -->
<%-- 					<form:textarea path="content" id="content" class="form-control" rows="10" name="content"  --%>
<%-- 					placeholder="내용을 입력해주세요" value="${bdto.content }" ></form:textarea> --%>
<!-- 					<div class="has-error"> -->
<!-- 						<label class="control-label" for="content"> -->
<%-- 	                       <form:errors path="content" class="help-inline"/> --%>
<!-- 	                    </label> -->
<!-- 	                </div> -->
<!-- 				</div> -->
				
				<div class="form-group col-md-12">
					<div class="col-md-12">
						<button type="submit" class="btn btn-primary ">수정완료</button>
						<a href="javascript:act.goboardEditForm()" class="btn btn-default ">뒤로가기</a>
					</div>
				</div>
				
			</div> <!-- end row1 -->
			
			</form:form>
        </div>
