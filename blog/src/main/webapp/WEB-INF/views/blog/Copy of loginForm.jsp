<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

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
			 <div class="box-footer">
			 
			 
			 <!-- 네이버 로그인 -->
			 <!-- Javascript SDK -->
			 <script type="text/javascript" src="${pageContext.request.contextPath }/resources/lib/oauth/naverLogin_implicit-1.0.2.js"></script>
			 <!-- Jquery cookie -->
			 <script type="text/javascript" charset="utf-8" src="${pageContext.request.contextPath }/resources/js/carhartl-jquery-cookie-92b7715/jquery.cookie.js"></script>
			 <!-- Jquery -->
			 <script src="${pageContext.request.contextPath }/resources/js/jquery.js"></script>	
			 
			<!-- Basic Setup -->
			<script type="text/javascript">
			function generateState() {
				// CSRF 방지를 위한 state token 생성 코드
				// state token은 추후 검증을 위해 세션에 저장 되어야 합니다.
				var oDate = new Date();
				return oDate.getTime();
			}
			function saveState(state) {
				$.removeCookie("state_token");
				$.cookie("state_token", state);
			}
			
			// 아래 정보는 개발자 센터에서 애플리케이션 등록을 통해 발급 받을 수 있습니다. 
// 			var naver = NaverAuthorize({
// 				client_id : "aXYGJWGbq7TvLhGwR1Es",
// 				client_secret : "xohhWgMbcf",
// 				redirect_uri : "http://localhost:8090/blog/"
// 			});
// 			$("#NaverIdLoginBTN").click( function () {
// 				var state = generateState();
// 				saveState(state);
// 				naver.login(state);
// 			});
			</script>

			<script type="text/javascript">
			var tokenInfo = { access_token:"" , refresh_token:"" };
			function checkLoginState() {
				var state = $.cookie("state_token");
				if(naver.checkAuthorizeState(state) === "connected") {
					//정상적으로 Callback정보가 전달되었을 경우 Access Token발급 요청 수행
					naver.getAccessToken(function(data) {
						var response = data._response.responseJSON;
						if(response.error === "fail") {
							//access token 생성 요청이 실패하였을 경우에 대한 처리
						    return ; 
						}
						tokenInfo.access_token = response.access_token;
						tokenInfo.refresh_token = response.refresh_token;
						console.log("success to get access token", response);
					});
				} else {
					//Callback으로 전달된 데이터가 정상적이지 않을 경우에 대한 처리
					return ;
				}
			}
			</script>

			<div id="naver_id_login">
				<button onclick='NaverIdLoginBTN()' class="btn btn-default">네이버 로그인</button>
			</div>  <!-- 버튼이 들어갈 위치 선언-->

			<script type="text/javascript">
				var naver_id_login = new naver_id_login("aXYGJWGbq7TvLhGwR1Es", "xohhWgMbcf");
				naver_id_login.setButton("green", 3, 40);
				naver_id_login.setDomain(".service.com");
				naver_id_login.setState("abcdefghijkmnopqrst");
				naver_id_login.setPopup();
				naver_id_login.init_naver_id_login();
				
			</script>
			
			
			
			<!-- 페이스북 로그인 -->
<!-- 			http://hijigoo.tistory.com/entry/%EC%9B%B9%ED%8E%98%EC%9D%B4%EC%A7%80%EC%97%90-Facebook-API-%EC%97%B0%EB%8F%99%ED%95%98%EA%B8%B0-4%EC%9E%A5-Logout%EB%B2%84%ED%8A%BC-%EB%A7%8C%EB%93%A4%EA%B8%B0  -->
			<div id="fb-root"></div>

			<script>
			(function(d, s, id) {
			  var js, fjs = d.getElementsByTagName(s)[0];
			  if (d.getElementById(id)) return;
			  js = d.createElement(s); js.id = id;
			  js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.4&appId=642097975932715";
			  fjs.parentNode.insertBefore(js, fjs);
			}(document, 'script', 'facebook-jssdk'));
			</script>
			
			
			<script>
			  // This is called with the results from from FB.getLoginStatus().
			  function statusChangeCallback(response) {
			    console.log('statusChangeCallback');
			    console.log(response);
			    // The response object is returned with a status field that lets the
			    // app know the current login status of the person.
			    // Full docs on the response object can be found in the documentation
			    // for FB.getLoginStatus().
			    if (response.status === 'connected') {
			      // Logged into your app and Facebook.
			      testAPI();
			    } else if (response.status === 'not_authorized') {
			      // The person is logged into Facebook, but not your app.
			      document.getElementById('status').innerHTML = 'Please log ' +
			        'into this app.';
			    } else {
			      // The person is not logged into Facebook, so we're not sure if
			      // they are logged into this app or not.
			      document.getElementById('status').innerHTML = 'Please log ' +
			        'into Facebook.';
			    }
			  }
			
			  // This function is called when someone finishes with the Login
			  // Button.  See the onlogin handler attached to it in the sample
			  // code below.
			  function checkLoginState() {
			    FB.getLoginStatus(function(response) {
			      statusChangeCallback(response);
			    });
			  }
			
			  window.fbAsyncInit = function() {
			  FB.init({
			    appId      : '{642097975932715}',
			    cookie     : true,  // enable cookies to allow the server to access 
			                        // the session
			    xfbml      : true,  // parse social plugins on this page
			    version    : 'v2.4' // use version 2.2
			  });
			
			  // Now that we've initialized the JavaScript SDK, we call 
			  // FB.getLoginStatus().  This function gets the state of the
			  // person visiting this page and can return one of three states to
			  // the callback you provide.  They can be:
			  //
			  // 1. Logged into your app ('connected')
			  // 2. Logged into Facebook, but not your app ('not_authorized')
			  // 3. Not logged into Facebook and can't tell if they are logged into
			  //    your app or not.
			  //
			  // These three cases are handled in the callback function.
			
			  FB.getLoginStatus(function(response) {
			    statusChangeCallback(response);
			  });
			
			  };
			
			  // Load the SDK asynchronously
			  (function(d, s, id) {
			    var js, fjs = d.getElementsByTagName(s)[0];
			    if (d.getElementById(id)) return;
			    js = d.createElement(s); js.id = id;
			    js.src = "//connect.facebook.net/en_US/sdk.js";
			    fjs.parentNode.insertBefore(js, fjs);
			  }(document, 'script', 'facebook-jssdk'));
			
			  // Here we run a very simple test of the Graph API after login is
			  // successful.  See statusChangeCallback() for when this call is made.
			  function testAPI() {
			    console.log('Welcome!  Fetching your information.... ');
			    FB.api('/me', function(response) {
			      console.log('Successful login for: ' + response.name);
			      document.getElementById('status').innerHTML =
			        'Thanks for logging in, ' + response.name + '!';
			    });
			  }
			</script>
			
			<!--
			  Below we include the Login Button social plugin. This button uses
			  the JavaScript SDK to present a graphical Login button that triggers
			  the FB.login() function when clicked.
			-->
			
<!-- 			<div class="fb-login-button" data-max-rows="1" data-size="large" data-show-faces="false" data-auto-logout-link="false"></div> -->
			<fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
			</fb:login-button>
			
			<div id="status">
				<p>사용자정보 출력</p>
			</div>

      
		   <button type="submit" class="btn btn-info pull-right col-sm-3">로그인</button>
			   
			 </div><!-- /.box-footer -->
			</form>
		</div><!-- /.box -->
	</div>
