<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://connect.facebook.net/ko_KR/all.js" type="text/javascript"></script>

		<!-- 페이스북 로그인 -->
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
		 var fabceloginChk = 0; // 오프라인:0, 로그인:1
		 
		  // This is called with the results from from FB.getLoginStatus().
		  function statusChangeCallback(response) {
		    console.log('statusChangeCallback: ');
		    console.log(response);
		    // The response object is returned with a status field that lets the
		    // app know the current login status of the person.
		    // Full docs on the response object can be found in the documentation
		    // for FB.getLoginStatus().
		    if (response.status === 'connected') {
		      loginFB(); // Logged into your app and Facebook.
		      fabceloginChk = 1; // 오프라인:0, 로그인:1
		      document.getElementById('loginbt').innerHTML = "<button type='button' onclick='logoutFB();'>로그아웃</button>"+
		      	"<div id='status'><p>사용자정보 출력</p></div>";

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
		
		 //페이스북 초기화
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
		    if (response.status == 'connected') {
		        console.log('getLoginStatus: '+response.authResponse.accessToken);
		      }
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
		  function loginFB() {
			console.log('Welcome!  Fetching your information.... ');
		    
		    FB.api('/me', function(response) {
		    console.log('Successful login for: ' + response.name);
		    console.log(JSON.stringify(response));
		    
		    document.getElementById('status').innerHTML =
		        'Thanks for logging in, ' + response.name + '!';
	          console.log('myName: ' + response.name);
	          console.log('myEmail: ' + response.email);
	          console.log('myId: ' + response.id);
	          console.log('fabceloginChk: ' +fabceloginChk );
		    });
		    
		    FB.login(function(response) {
		    	if (response.status === 'connected') {
		    	    // 페이스북과 앱에 같이 로그인되어 있다.
		    		console.log('페이스북과 앱에 같이 로그인되어 있다.');
		    	  } else if (response.status === 'not_authorized') {
		    	    // 페이스북에는 로그인 되어있으나, 앱에는 로그인 되어있지 않다.
		    		  console.log('페이스북에는 로그인 되어있으나, 앱에는 로그인 되어있지 않다.');
		    	  } else {
		    	    // 페이스북에 로그인이 되어있지 않아서, 앱에 로그인 되어있는지 불명확하다.
		    		  console.log('페이스북에 로그인이 되어있지 않아서, 앱에 로그인 되어있는지 불명확하다.');
		    	  }
	    	   console.log(response);
	    	 }, {scope: 'user_friends'});
		    
		  }
		  
		  function logoutFB(){
			  if(fabceloginChk == 1){
				  fabceloginChk = 0;
				  FB.logout(function(response) { // 사용자 로그 아웃 이후 콜백처리
				    	console.log('로그아웃 실행: ' + response);
				    });
			  }else{
				  console.log('로그인 상태입니다');
			  }
		  }
		</script>
			
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
			
			<div id='loginbt'>
				<fb:login-button scope='public_profile, email' onlogin='checkLoginState();'></fb:login-button>			
			</div>	
			<div id='status'><p>사용자정보 출력</p></div>
				
	</div>
