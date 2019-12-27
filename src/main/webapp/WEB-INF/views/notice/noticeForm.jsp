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
	<c:if test="${isNew ==true}">
		<form class="form" method="post" action="${contextPath}/notice/noticeForm.do"/>
	</c:if>
	<c:if test="${isNew ==false}">
		<form class="form" method="post" action="${contextPath}/notice/noticeUpdate.do"/>
		<input type="hidden" name="idx" id="idx" value="${notice.idx}">
	</c:if>
		<div class="inner">
			<div class="field">
				<label for="name">제목</label>
				<c:if test="${ isNew ==true}">
				 <input name="title" id="title" type="text">
				</c:if>
				<c:if test="${isNew ==false}">
				<input type="text" id="title" name="title" value="${notice.title}">
				</c:if>
			</div>
			<div class="field">
				<label for="content">공지 내용</label>
				<c:if test="${ isNew ==true}">
					<textarea name="content" id="content" rows="15"></textarea>
				</c:if>
				<c:if test="${isNew ==false}">
					<textarea name="content" id="content" rows="15">${notice.content }</textarea>
				</c:if>
			</div>
		</div>
		
		<footer>
		<center>
			<input type ="button" class="button" value="목록으로" onclick="location='${contextPath}/notice/noticeList.do'">
		<c:if test="${isNew ==true}">
			<input type="submit" class="button" value="저장하기"/>
		</c:if>
		<c:if test="${isNew ==false}">
			<input type="submit" class="button" value="수정하기"/>
		</c:if>
		</form>
		</center>
</body>
</html>