<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>login</title>
</head>
<body>
<form class="login100-form validate-form" action="loginProcess.jsp" method="post">
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
					<input class="input100" type="password" name="password" id="password" placeholder="password">
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
	
</body>
</html>