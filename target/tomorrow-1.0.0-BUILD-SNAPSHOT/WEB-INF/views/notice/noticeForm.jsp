<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%
  request.setCharacterEncoding("UTF-8");
%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>NoticeForm</title>
</head>
<body>
		<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/images/icons/microphone.png" width="30px"  />
					<br>
					<br>
					<h3>공 지 사 항 (관리자)</h3>
						<p>관리자 전용 페이지입니다..<br>
							 </p>	
				</div>
			</div>
		</div>
		</section>


		<br> <br>
		<form class="form" method="post" action="${contextPath}/notice/noticeForm.do"/>
		<div class="inner">
			<div class="field">
				<label for="name">제목</label>
				 <input name="title" id="title" type="text">
			</div>
			<div class="field">
				<label for="content">공지 내용</label>
				<textarea name="content" id="content" rows="15"></textarea>
			</div>
		</div>
		
		<footer>
		<center>
			<input type ="button" class="button" value="목록으로" onclick="location='${contextPath}/notice/noticeList.do'">
		
			<input type="submit" class="button" value="저장하기"/>
		</form>
		</center>
</body>
</html>