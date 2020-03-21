<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<title>받은 고민 읽기 : Tomorrow is...</title>
<meta charset="utf-8" />
</head>
<script type="text/javascript">
var contextPath= '<c:out value="${contextPath}"/>';
function inputCheck(){
	if(document.sendReply.contents.value=="")
		{
			alert("내용을 입력하세요.");
			document.sendReply.contents.focus();
			return false;
		}
}
function report(){
	var ok=confirm("이 편지를 신고하시겠습니까?\n신고후에 편지는 자동으로 삭제됩니다.");
	if(ok){
		document.reportForm.submit();
	}
}
</script>
	</head>
	
<body>
		
<!-- Banner -->
		<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/images/icons/contact.png" width="30px" /><br><br>
							<h3>받은 고민 읽기</h3>
							<p>당신의 위로가 필요한 고민입니다.<br>
							 </p>
				</div>
			</div>
		</div>
		</section>
<br>
	<br><br>
	<div class="inner">
			<div class="field">
					
					<label for="name">고민 제목</label>
					<div style="position:absolute">
					  <div style="position:relative; top:-40px; left:20px;">
					  <form name="reportForm" action="${contextPath }/mail/reportWorry.do" method="post">
						<button type="button" class="report" onclick="location.href='javascript:report()'"><img src="/tomorrow/resources/images/icons/alarm.png"width="20px" />
						 신고하기
						</button>
						<input type="hidden" name="idx" id="idx" value="${receiveWorry.idx }">
						<input type="hidden" name="sender_idx" id="sender_idx" value="${receiveWorry.sender_idx }">
						<input type="hidden" name="receiver_idx" id="receiver_idx" value=1>
						<input type="hidden" name="title" id="title" value="${receiveWorry.title}">
						<input type="hidden" name="content" id="content" value="${receiveWorry.content}">
						<input type="hidden" name="reply_yn" id="reply_yn" value="${receiveWorry.reply_yn}">
						<input type="hidden" name="reporter_idx" id="reporter_idx" value="${member.idx }">
					</form>
					 </div></div> 
					<input type="text" size="248" value="${receiveWorry.title }" readonly>
			
				<br>
							<label for="contents">고민 내용</label>
							<textarea rows="15" readonly>${receiveWorry.content }</textarea>
			</div>		
	</div>
	<br><br><br>
		
			<center>
	<form name="sendReply" class="form" action="${contextPath }/mail/sendReply.do" method="post" onsubmit="return inputCheck()">
		<label for="name"><font color="#11214a">답 장</font></center>
			<div class="inner">
			<div class="field">
					
				<input type="text" size="248" name="title" id="title"  value="Re:[${receiveWorry.title}] 위로의 답장" readonly></div>
			<br>
				<div class="field">
							<label for="content">어떤 위로가 좋을까요?</label>
							<textarea name="content" id="content" rows="15"></textarea>
				</div>		
			</div>
			
		<br> 
	

						<center><input type="submit" class="button" value="답장하기">
						<input type="button" class="button" value="목록으로" onclick="location='${contextPath}/mail/receiveWorryList.do'">
						</center>
					<input type="hidden" id="idx" name="idx" value="${receiveWorry.idx }"> 
					<input type="hidden" id="receiver_idx" name="receiver_idx" value="${receiveWorry.sender_idx }"> 
					<input type="hidden" id="sender_idx" name="sender_idx" value="${member.idx}"> 
					<input type="hidden" id="reply_yn" name="reply_yn" value=1>
					<input type="hidden" id="receiveWorry_content" name="receiveWorry_content" value="${receiveWorry.content}">
	
	</form>
	<br><br><br>

</body>
</html>