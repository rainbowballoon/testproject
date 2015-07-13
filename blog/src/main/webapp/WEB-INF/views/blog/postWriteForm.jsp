<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<script src="lib/ckeditor/ckeditor.js"></script>
</head>
<body>

		<div class="col-md-8">
           <h1 class="page-header">포스트 등록하기</h1>

			<form action="writePost" method="post">
			<input type="hidden" name="blogno" value="${blogno }">
				<div class="form-group">
					<label for="title">글제목</label>
					<input type="text" class="form-control" id="title" name="title" placeholder="제목 입력">
				</div>
				<div class="form-group">
			  	<label for="menuno">등록 카테고리</label>
				  <select class="form-control" name="topicno">
				  		<option value="0">test</option>
				     <c:forEach var="subcategorylist" items="${subcategorylist }">
				     	<option value="${subcategorylist.no }">${subcategorylist.name }</option>
				     </c:forEach>
				  </select>
			  	</div>
				<div class="form-group">
					<textarea class="form-control" rows="10" name="content" placeholder="내용을 입력해주세요"></textarea>
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
			  	<label for="opt1">포스트 공개여부</label>
				<div class="checkbox">
				  	<label class="radio-inline">
				      <input type="radio" name="postaccess" value="0" checked> 공개
				    </label>
				    <label class="radio-inline">
				      <input type="radio" name="postaccess" value="1"> 비공개
				    </label>
				</div>
			  </div>
<!-- 				<div class="form-group"> -->
<!-- 					<label for="uploadfile">파일 업로드</label> -->
<!-- 					<input type="file" id="uploadfile" name="uploadfile"> -->
<!-- 					<p class="help-block">파일 첨부하기</p> -->
<!-- 				</div> -->
				<button type="submit" class="btn btn-primary">등록하기</button>
				<button type="reset" class="btn btn-default">취소하기</button>
			</form>
        </div>
</body>
</html>