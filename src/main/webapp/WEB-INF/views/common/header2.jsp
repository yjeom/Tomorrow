  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html>
<html>
<style>
#header .logo {
			color: #ffffff !important;
		}


</style>
<head>
  <meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/assets/css/main.css" />
		<link href="//fonts.googleapis.com/css?family=Pattaya&subset=latin" rel="stylesheet" type="text/css">
		<link rel="icon" type="image/png" href="/images/icons/favicon_main.ico"/>
		
<title>헤더</title>
</head>
<body>
						<header id="header">
				<div class="inner">
						<a href="${contextPath}/" class="logo">Tomorrow is...</a>
				</div>
			</header>
</body>
</html>