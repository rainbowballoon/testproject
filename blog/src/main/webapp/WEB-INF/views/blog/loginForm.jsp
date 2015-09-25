<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script src="http://connect.facebook.net/ko_KR/all.js" type="text/javascript"></script>

<script type="text/javascript">  
	//페이스북 SDK 초기화   
	window.fbAsyncInit = function() {  
	    FB.init({appId: '642097975932715', status: true, cookie: true,xfbml: true});      
	};  
	      
	(function(d){  
	   var js, id = 'facebook-jssdk', ref = d.getElementsByTagName('script')[0];  
	   if (d.getElementById(id)) {return;}  
	   js = d.createElement('script'); js.id = id; js.async = true;  
	   js.src = "//connect.facebook.net/ko_Ko/all.js";  
	   ref.parentNode.insertBefore(js, ref);  
	 }(document));     
	              
	function facebooklogin() {  
		//페이스북 로그인 버튼을 눌렀을 때의 루틴.  
        FB.login(function(response) {  
            var fbname;  
            var accessToken = response.authResponse.accessToken;  
            FB.api('/me', function(user) {  
                fbname = user.name;  
                //response.authResponse.userID  
                $.post("./php/fbloginprocess.php", { "userid": user.id, "username": fbname, "fbaccesstoken":accessToken},  
                function (responsephp) {  
                    //댓글을 처리한 다음 해당 웹페이지를 갱신 시키기 위해 호출.  
                    location.replace('/index');  
                });      
            });   
        }, {scope: 'publish_stream,user_likes'}); 
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
			
			<div onclick="facebooklogin()" style="cursor: pointer;">  
			    <button type="button">페이스북 로그인</button> 
			</div>  
			 
			<div id="status">
			</div>
				
	</div>
