<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://connect.facebook.net/ko_KR/all.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/resources/lib/oauth/facebook.js"></script>

<!-- http://unikys.tistory.com/348 -->
			
	<div class="col-md-8">
       
		<!-- Horizontal Form -->
		<div class="box box-info">
			<div class="box-header with-border">
				<h2 class="page-header">로그인</h2>
			</div><!-- /.box-header -->

			<!-- form start -->
			<form class="form-horizontal" action="blogLogin" method="POST">
			<div class="box-body">
			    <div class="form-group">
					<label for="member_id" class="col-sm-2 control-label">아이디</label>
					<div class="col-sm-8">
						<input type="text" class="form-control" id="member_id" name="member_id" placeholder="아이디">
					</div>
			    </div>
			    <div class="form-group">
					<label for="member_pw" class="col-sm-2 control-label">비밀번호</label>
					<div class="col-sm-8">
						<input type="password" class="form-control" id="member_pw" name="member_pw" placeholder="비밀번호">
					</div>
			    </div>
			    <div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
					  <div class="checkbox">
					    <label><input type="checkbox"> 아이디 기억하기 </label>
					  </div>
					</div>
			    </div>
			 </div><!-- /.box-body -->
			 <div class="box-footer" >
				<button type="submit" class="btn btn-info pull-right col-sm-3">로그인</button>
	<!--
	  아래는 소셜 플러그인으로 로그인 버튼을 넣는다.
	  이 버튼은 자바스크립트 SDK에 그래픽 기반의 로그인 버튼을 넣어서 클릭시 FB.login() 함수를 실행하게 된다.
	-->
 
	<div class="fb-login-button" data-max-rows="2" data-size="xlarge" data-show-faces="false" 
		data-auto-logout-link="true" onlogin="checkLoginState();"></div>
	 
	<div id="status"></div>
	
	<div id="user-info"></div> 
				
	</div>
