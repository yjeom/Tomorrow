<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Notice</title>
</head>
<body>
		<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/images/icons/microphone.png" width="30px"  />
					<br> <br>
					<h3>공지사항 읽기</h3>
						<p>꼭 알려야 할 사항들이니 주의 깊게 읽어주세요.<br>
							 </p>	
				</div>
			</div>
		</div>
		</section>
<br><br><br>
	
			<div class="inner">
				<div class="field">
					<label for="name">제목</label>
					<input type="text" id="title" name="title" value="${notice.title }" readonly>
				</div><br><br>
				<div class="field">
					<label for="contents">공지 내용</label>
					<textarea name="content" id="content" rows="15" readonly>${notice.content } </textarea>
				</div>
			</div>
			<br>
				<center>
	<c:if test="${not empty member and member.id eq 'rhksflwk'}">
	
		<input type ="button" class="button" value="목록으로" onclick="location='${contextPath}/notice/noticeList.do'">
		<input type ="button" class="button" value="수정하기" onclick="location='${contextPath}/notice/noticeForm.do?idx=${notice.idx}'">
		<input type ="button" class="button" value="삭제하기" onclick="location='${contextPath}/notice/noticeDelete.do?idx=${notice.idx }'">
	</c:if>

<br>
<br>

			<footer>
</body>
</html>