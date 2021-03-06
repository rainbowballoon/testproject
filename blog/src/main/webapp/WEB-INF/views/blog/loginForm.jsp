<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://connect.facebook.net/ko_KR/all.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath }/resources/lib/oauth/facebook.js"></script>

<!-- http://unikys.tistory.com/348 -->
	<div class="col-md-8">
    
    <div class="container">
	<div class="row">
		<form class="col-md-8" action="blogLogin" method="POST">
			<div class="center-block">
					<img src="${pageContext.request.contextPath}/resources/img/welcome_login.png" 
					class="img-rounded" width="100%">
			</div>
			<hr/>
		    <div class="form-group">
		        <input type="text" class="form-control input-lg" id="member_id" name="member_id" placeholder="아이디">
		    </div>
		    <div class="form-group">
		        <input type="password" class="form-control input-lg" id="member_pw" name="member_pw" placeholder="비밀번호">
		    </div>
		    <div class="form-group">
		        <button class="btn btn-primary btn-lg btn-block">
		        	<span class="glyphicon glyphicon-log-in" aria-hidden="true"></span>&nbsp; Sign In
		        </button>
		    </div>
		    <hr/>
		    <div class="row text-center">
		        <div class="col-md-4 col-sm-12">
		            <button type="button" onclick="facebooklogin();" class="btn btn-primary btn-lg btn-block">Facebook</button>
		        </div>
		        <div class="col-md-4 col-sm-12">
		            <button type="button" class="btn btn-info btn-lg btn-block">Twitter</button>
		        </div>
		        <div class="col-md-4 col-sm-12">
		            <button type="button" class="btn btn-danger btn-lg btn-block">Google+</button>
		        </div>
		    </div>
		</form>	
		
				<!--
				  아래는 소셜 플러그인으로 로그인 버튼을 넣는다.
				  이 버튼은 자바스크립트 SDK에 그래픽 기반의 로그인 버튼을 넣어서 클릭시 FB.login() 함수를 실행하게 된다.
				-->
<!-- 				<div class="fb-login-button" data-max-rows="2" data-size="xlarge" data-show-faces="false"  -->
<!-- 					data-auto-logout-link="true" onlogin="checkLoginState();"></div> -->
<!-- 				<div id="status"></div> -->
<!-- 				<div id="user-info"></div>  -->
				
<!-- 				<p>사용자정보 출력</p> -->
<!-- 				<div align="left"> -->
<!-- 				    <img id="image"/> -->
<!-- 				    <div id="name"></div> -->
<!-- 				    <div id="id"></div> -->
<!-- 				</div> -->
	</div>
	</div>
	
	</div><!-- /.col-md-8 -->
