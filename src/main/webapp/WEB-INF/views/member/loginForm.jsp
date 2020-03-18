<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="403210077688-ecf91157obf28bf5vlsioauhmbh73ip8.apps.googleusercontent.com">
<html>
<c:if test='${not empty msg }'>
<script>
window.onload=function()
{
  result();
}
function result(){
	alert("${msg}");
}
</script>
</c:if>
<head>
		<title>Login</title>
	</head>
	<body>

<form class="login100-form validate-form" action="${contextPath}/member/login.do" method="post">
	<div class="container-login100">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30" >
			<form class="login100-form validate-form">
				<span class="login100-form-title p-b-37">
					로그인
				</span>

				<div class="wrap-input100 validate-input m-b-20" data-validate="Enter username or id">
					<input class="input100" type="text" name="id" id="id" placeholder="아이디">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
					<input class="input100" type="password" name="pwd" id="pwd" placeholder="비밀번호">
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
				<input type="submit" class="login100-form-btn" value="로그인">
				</div>
				<br>
				<div class="text-center">
					<a href="${contextPath}/member/joinForm.do" class="txt2 hov1"><font="grey">
						회원가입
					</font>
					</a>
					
				</div>
			</form>
			<center>

			<a href="${googleURL }" class="txt2 hov1"><font="grey">
			<img width="234" height="54" src="/tomorrow/resources/images/icons/googleLogin.PNG"/>
			</a>
			<a href="${naverURL }" class="txt2 hov1"><img height="50" src="https://static.nid.naver.com/oauth/big_g.PNG"/></a>
			<a href="${kakaoURL }" class="txt2 hov1"><img width="234" height="48" src="/tomorrow/resources/images/icons/kakaoLogin.png"/></a>		
			</center>	
		</div>
	</div>



	</body>
</html>