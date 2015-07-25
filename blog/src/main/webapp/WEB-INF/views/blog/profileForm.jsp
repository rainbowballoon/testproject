<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- Page Content -->
    <div class="col-md-8">
    <div class="container-fluid">
        <div class="row">
            <div class="col-lg-12">
                <h1>블로그 정보</h1>
               
              <form action="profileWrite" method="POST" enctype="multipart/form-data">
                	<div class="control-group form-group">
                        <div class="controls">
                            <label>블로그 제목:</label>
                            <input type="text" class="form-control" name="title" placeholder="블로그제목" maxlength="50"
                            value="${profiledto.title }" required>
                            <p class="help-block">한글, 영문, 숫자 혼용가능 (한글기준 25자이내)</p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>별명:</label>
                            <input type="text" class="form-control" name="nickname" required placeholder="닉네임" maxlength="20"
                            value="${profiledto }">
                            <p class="help-block">닉네임으로 사용할 별명입니다. 한글, 영문, 숫자 혼용가능 (한글기준 10자 이내)</p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>소개글:</label>
                            <br>
                            <textarea name="profile" rows="8" cols="30" placeholder="소개글" maxlength="400">${profiledto.profile }</textarea>
                            <p class="help-block">블로그 프로필 영역의 프로필사진 아래에 반영됩니다. 한글기준 200자 이내</p>
                        </div>
                    </div>
                    <div class="control-group form-group">
                        <div class="controls">
                            <label>블로그 프로필 사진:</label><br>
                            <img src="${pageContext.request.contextPath }/profileimage/${profiledto.proimg }" class="img-thumbnail" width="161px">
                            <input type="file" class="form-control" name="proimg" >
                            <p class="help-block">프로필 사진은 가로 161px 썸네일로 생성됩니다 (썸네일이 축소/확대되어 적용될 수 있습니다)</p>
                        </div>
                    </div>
                    
                    <div id="success"></div>
                    <!-- For success/fail messages -->
                    <button type="submit" class="btn btn-primary">확인</button>
                    <button type="reset" class="btn btn-default">다시입력</button>
                </form>
            </div>
        </div>
    </div>
</div>