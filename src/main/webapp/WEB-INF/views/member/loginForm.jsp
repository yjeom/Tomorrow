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

		<!-- Banner -->
	<section id="banner">
		<div class="inner">

			<div class="flex">
					LOGIN
				<form  action="loginProcess.jsp" method="post">
					<input  type="text" name="id" id="id" placeholder="username or id">
						</form>
						
						
					<footer>
						<input type="button" class="button" value="Login" onclick="location.href='${contextPath}/member/loginForm.do'" >
						
					</footer>
				</div>
			</section>



	</body>
</html>