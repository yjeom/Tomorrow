<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<script type="text/javascript">
var contextPath= '<c:out value="${contextPath}"/>';
function inputCheck()
{
	if(document.sendWorry.title.value=="")
		{
			alert("고민의 제목을 입력해주세요.");
			document.sendWorry.title.focus();
			return false;
		}
	if(document.sendWorry.contents.value=="")
	{
		alert("고민의 내용을 입력해주세요.");
		document.sendWorry.contents.focus();
		return false;
	}
	
}


</script>


<title>고민 보내기 : Tomorrow is...</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet" href="assets/css/main.css" />
<link href="//fonts.googleapis.com/css?family=Pattaya&subset=latin"
	rel="stylesheet" type="text/css">
		<link rel="icon" type="image/png" href="images/icons/favicon_main.ico"/>
</head>
<body>
	<!-- Banner -->
		<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/tomorrow/resources/images/icons/chat.png" width="30px"  />
					<br><br>
					<h3>고민 작성하기</h3>
						<p>당신의 고민은 무엇인가요?<br>
							 </p>	
				</div>
			</div>
		</div>
		</section>
	<form name="sendWorry" class="form" method="post" action="${contextPath}/mail/sendWorry.do" onsubmit="return inputCheck()" />
	



		<br> <br><br>
		<div class="inner">
			<div class="field">
				<label for="name">고민 제목</label> <input name="title" id="title" type="text">
			</div><br><br>
			<div class="field">
				<label for="content">마음 속 고민을 자유롭게 적어보세요.</label>
				<textarea name="content" id="content" rows="15"></textarea>
			</div>
		</div>
		<br>
		<center>
			<input type="submit" class="button" value="비워내기"/>
			<input type="hidden" id="reply_yn" name="reply_yn" value=0>
			<input type="hidden" id="sender_idx" name="sender_idx" value="${member.idx}">
			

		</center>


</form>
</body>
</html>