  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/assets/css/main.css" />
		<link href="//fonts.googleapis.com/css?family=Pattaya&subset=latin" rel="stylesheet" type="text/css">
		<link rel="icon" type="image/png" href="/images/icons/favicon_main.ico"/>
<title>헤더</title>
</head>
<body>
<c:choose>
	<c:when test="${member.id=='rhksflwk'}">
						<header id="header">
				<div class="inner">
					<a href="Home.jsp" class="logo">Tomorrow is...</a>
						<a href="admin_report.jsp">신고관리</a>
						<a href="3.QnA.jsp">QnA</a>
						<a href="4.notice_list.jsp">Notice</a>
						<a href="${contextPath}/member/logout.do"><font color="red">Logout</a> </font>
				</div>
			</header>
		</c:when>
	<c:when test="${member.id!='rhksflwk' }">
			<header id="header">
				<div class="inner">
					<a href="Home.jsp" class="logo">Tomorrow is...</a>
						<a href="MenuCheck.jsp">받은 편지함</a>
						<a href="MenuCheck.jsp">보낸 편지함</a>
						<a href="MenuCheck.jsp">To.오늘의 나</a>
						<a href="3.QnA.jsp">QnA</a>
						<a href="4.notice_list.jsp">Notice</a>
				</div>
			</header>
	</c:when>
</c:choose>
</body>
</html>