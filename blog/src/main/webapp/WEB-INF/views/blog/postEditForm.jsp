<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="${pageContext.request.contextPath }/resources/lib/ckeditor/ckeditor.js"></script>
</head>
<body>

		<div class="col-md-8">
           <h1 class="page-header">포스트 수정하기</h1>

			<form action="postEdit" method="post">
			<input type="hidden" name="blogno" value="${blogno }">
			<input type="hidden" name="no" value="${pdto.no }">
				<div class="form-group">
					<label for="title">글제목</label>
					<input type="text" class="form-control" id="title" name="title" placeholder="제목 입력" value="${pdto.title }">
				</div>
				<div class="form-group">
			  	<label for="subcategoryno">등록 카테고리 <c:out value="${pdto.subcategoryno }"></c:out></label>
				  <select class="form-control" name="subcategoryno">
				     <c:forEach var="subcategorylist" items="${subcategorylist }">
				     <c:choose>                                                                                          
						<c:when test="${pdto.subcategoryno == subcategorylist.no}">
							<option value="${subcategorylist.no }" selected>${subcategorylist.name }</option>
						</c:when>
				     	<c:otherwise>
				     		<option value="${subcategorylist.no }">${subcategorylist.name }</option>
				     	</c:otherwise>
				     </c:choose>
				     </c:forEach>
				  </select>
			  	</div>
				<div class="form-group">
					<textarea class="form-control" rows="10" name="content" placeholder="내용을 입력해주세요">${pdto.content }</textarea>
					 <script>
		                CKEDITOR.replace('content', {
		                	filebrowserUploadUrl: 'file_upload',
		                	toolbar:[
								['Source','-','Save','NewPage','Preview','-','Templates'],
								['Cut','Copy','Paste','PasteText','PasteFromWord','-','Print', 'SpellChecker', 'Scayt'],
								['Undo','Redo','-','Find','Replace','-','SelectAll','RemoveFormat'],
// 								['Form', 'Checkbox', 'Radio', 'TextField', 'Textarea', 'Select', 'Button', 'ImageButton', 'HiddenField'],
								'/',
								['Bold','Italic','Underline','Strike','-','Subscript','Superscript'],
								['NumberedList','BulletedList','-','Outdent','Indent','Blockquote'],
								['JustifyLeft','JustifyCenter','JustifyRight','JustifyBlock'],
								['Link','Unlink','Anchor'],
								['Image','Table','HorizontalRule','Smiley','SpecialChar'],
								'/',
								['Styles','Format','Font','FontSize'],
								['TextColor','BGColor'],
								['Maximize', 'ShowBlocks','-','About']
		                	         ]
		                	
		                });
		            </script>
				</div>
				<div class="form-group">
			  		<label for="topicno">주제분류</label>
					<div class="radio">
						<c:choose>
						<c:when test="${pdto.topicno==1 }">
							<label class="radio-inline">
						      <input type="radio" name="topicno" value="1" checked> 주제1
						    </label>
						</c:when>
						<c:otherwise>
							<label class="radio-inline">
						      <input type="radio" name="topicno" value="1"> 주제1
						    </label>
						</c:otherwise>
						</c:choose>
						
						<c:choose>
						<c:when test="${pdto.topicno==2 }">
							<label class="radio-inline">
						      <input type="radio" name="topicno" value="2" checked> 주제2
						    </label>
						</c:when>
						<c:otherwise>
							<label class="radio-inline">
						      <input type="radio" name="topicno" value="2"> 주제2
						    </label>
						</c:otherwise>
						</c:choose>
						
						<c:choose>
						<c:when test="${pdto.topicno==3 }">
							<label class="radio-inline">
						      <input type="radio" name="topicno" value="3" checked> 주제3
						    </label>
						</c:when>
						<c:otherwise>
							<label class="radio-inline">
						      <input type="radio" name="topicno" value="3"> 주제3
						    </label>
						</c:otherwise>
						</c:choose>
					</div>
					<c:choose>
						<c:when test="${pdto.topicno==0 }">
						<div class="radio">
							<label>
						      <input type="radio" name="topicno" value="0" checked> 주제선택 안함
						    </label>
						</div>
					</c:when>
					<c:otherwise>
						<div class="radio">
							<label>
						      <input type="radio" name="topicno" value="0"> 주제선택 안함
						    </label>
						</div>
					</c:otherwise>
					</c:choose>
				</div>
				<div class="form-group">
				  	<label for="postaccess">포스트 공개여부</label>
					<div class="radio">
				<c:choose>
					<c:when test="${pdto.postaccess==0 }">
						<label class="radio-inline">
					      <input type="radio" name="postaccess" value="0" checked> 공개
					    </label>
					    <label class="radio-inline">
					      <input type="radio" name="postaccess" value="1"> 비공개
					    </label>
					</c:when>
					<c:when test="${pdto.postaccess==1 }">
						<label class="radio-inline">
					      <input type="radio" name="postaccess" value="0"> 공개
					    </label>
					    <label class="radio-inline">
					      <input type="radio" name="postaccess" value="1" checked> 비공개
					    </label>
					</c:when>
				</c:choose>
					</div>
			  </div>
				<button type="submit" class="btn btn-primary">등록하기</button>
				<button type="reset" class="btn btn-default">취소하기</button>
			</form>
        </div>
</body>
</html>