<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<title>Login</title>
	</head>
	<body>
<form class="login100-form validate-form" action="${contextPath}/member/login.do" method="post">
	<div class="container-login100">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30" >
			<form class="login100-form validate-form">
				<span class="login100-form-title p-b-37">
					Login 
				</span>

				<div class="wrap-input100 validate-input m-b-20" data-validate="Enter username or id">
					<input class="input100" type="text" name="id" id="id" placeholder="username or id">
					<span class="focus-input100"></span>
				</div>

				<div class="wrap-input100 validate-input m-b-25" data-validate = "Enter password">
					<input class="input100" type="password" name="pwd" id="pwd" placeholder="password">
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
				<input type="submit" class="login100-form-btn" value="Login">
				</div>
				<br>
				<br>
				<div class="text-center">
					<a href="index_join.html" class="txt2 hov1"><font="grey">
						Sign Up
					</a>
					/
					<a href="index_pw.html" class="txt2 hov1"><font="grey">
						PW
					</a>
					</font>
				</div>
			</form>
			
		</div>
	</div>
	
	

	<div id="dropDownSelect1"></div>
	


	</body>
</html>