 // This is called with the results from from FB.getLoginStatus().
  function statusChangeCallback(response) {
    console.log('statusChangeCallback');
    console.log(response);
    // response 객체는 현재 로그인 상태를 나타내는 정보를 보여준다. 
    // 앱에서 현재의 로그인 상태에 따라 동작하면 된다.
    // FB.getLoginStatus().의 레퍼런스에서 더 자세한 내용이 참조 가능하다.
    if (response.status === 'connected') {
      // 페이스북을 통해서 로그인이 되어있다.
      var token = response.authResponse.accessToken;
      testAPI();
    
    } else if (response.status === 'not_authorized') {
      // 페이스북에는 로그인 했으나, 앱에는 로그인이 되어있지 않다.
      alert("로그인해야 이용가능한 기능입니다.");
      document.getElementById('status').innerHTML = '2. Please log ' +
        'into this app.';
      
    } else {
      // 페이스북에 로그인이 되어있지 않다. 따라서, 앱에 로그인이 되어있는지 여부가 불확실하다.
      alert("페이스북과 앱에 로그인되어있지 않습니다. 로그인해야 이용가능한 기능입니다.");
      document.getElementById('status').innerHTML = '3. Please log ' +
        'into Facebook.';
      //window.location.href = "/blog/loginForm";
    }
  }
  
  // 이 함수는 누군가가 로그인 버튼에 대한 처리가 끝났을 때 호출된다.
  // onlogin 핸들러를 아래와 같이 첨부하면 된다.
  function checkLoginState() {

	  FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
     
    });
    
//     {
//         status: 'connected', 
//         authResponse: { 
//             accessToken: '...', //사용자가 앱에 접근하는 access token
//             expiresIn:'...', //UNIX 시간으로 토큰이 만기 되어 재생성이 필요한 시기
//             signedRequest:'...', //앱을 사용하는 사용자에 대한 서명된 파라미터 정보
//             userID:'...' //앱을 사용하는 사용자의 ID
//         }
//     }
    
  }
 
  window.fbAsyncInit = function() {
  FB.init({
    appId      : '{501743573321338}',
    cookie     : true,  // 쿠키가 세션을 참조할 수 있도록 허용
    xfbml      : true,  // 소셜 플러그인이 있으면 처리
    version    : 'v2.4' // 버전 2.1 사용
  });
 
  // 자바스크립트 SDK를 초기화 했으니, FB.getLoginStatus()를 호출한다.
  //.이 함수는 이 페이지의 사용자가 현재 로그인 되어있는 상태 3가지 중 하나를 콜백에 리턴한다.
  // 그 3가지 상태는 아래와 같다.
  // 1. 앱과 페이스북에 로그인 되어있다. ('connected')
  // 2. 페이스북에 로그인되어있으나, 앱에는 로그인이 되어있지 않다. ('not_authorized')
  // 3. 페이스북에 로그인이 되어있지 않아서 앱에 로그인이 되었는지 불확실하다.
  //
  // 위에서 구현한 콜백 함수는 이 3가지를 다루도록 되어있다.
 
    FB.getLoginStatus(function(response) {
      statusChangeCallback(response);
      
    });
  
  
 
  };
 
  // SDK를 비동기적으로 호출
  (function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&appId=501743573321338&version=v2.4";
    fjs.parentNode.insertBefore(js, fjs);
  }(document, 'script', 'facebook-jssdk'));
 
  // 로그인이 성공한 다음에는 간단한 그래프API를 호출한다.
  // 이 호출은 statusChangeCallback()에서 이루어진다.
  function testAPI() {
    console.log('Welcome!  Fetching your information.... ');
    FB.api('/me', function(response) 
   {
      console.log('Successful login for: ' + response.name);
      document.getElementById('status').innerHTML =
        'Thanks for logging in, ' + response.name + ', email : '+ response.email + ', id :' + response.id +', birthday :' + response.birthday + '!';
      name = response.name;
      email = response.email;
      id = response.id;
      birthday = response.birthday;
     
    });
    
    function FBBtnLogout(){
        FB.logout(function(response) {
        window.location.reload();
     }); 
    }
    
    
    
    
  }