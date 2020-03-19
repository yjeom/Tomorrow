<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/tomorrow/resources/images/icons/microphone.png" width="30px"  />
					<br> <br>
					<h3>공 지 사 항 (수정)</h3>
						<p>관리자 전용 페이지입니다.<br>
							 </p>	
				</div>
			</div>
		</div>
		</section>
<br><br><br>
	
			<div class="inner">
				<div class="field">
			<form class="form" method="post" action="/notice/noticeUpdate.do">
					<label for="name">수정 제목</label>
					<input type="text" id="title" name="title" value="${notice.title}">
				</div><br><br>
				<div class="field">
					<label for="contents">수정 내용</label>
					<textarea name="content" id="content" rows="15">${notice.content }</textarea>
				</div>
			</div>
			<br><br>
			<footer>
			<center>
			<input type="submit" class="button" value="수정하기">
			<input type="button" value="목록으로" onclick="location.href='${contextPath}/notice/noticeList.do'">
			
			</div>
		</form>
</body>
</html>