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

function del()
{
	if(confirm("해당 글을 삭제하시겠습니까?")==true)
{

	return true;
}else
{
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
							<h3>받은 답장 읽기.</h3>
							<p>당신을 위로하는 답장이 도착했습니다.<br>
							 </p>
						
					</p>
				</div>
			</div>
		</div>
		</section>
<br>
	<br><br>
		
			<center>
		<label for="name"><font color="#11214a">답 장</font></center>
			<div class="inner">
			<div class="field">
					<div style="position:absolute">
					  <div style="position:relative; top:-40px; left:20px;">
					  <form name="reportForm" action="${contextPath }/mail/reportReply.do" method="post">
						<button type="button" class="report" onclick="location.href='javascript:report()'"><img src="/images/icons/alarm.png"width="20px" />
						 신고하기
						</button>
						<input type="hidden" name="idx" id="idx" value="${receiveReply.idx }">
						<input type="hidden" name="sender_idx" id="sender_idx" value="${receiveReply.sender_idx }">
						<input type="hidden" name="receiver_idx" id="receiver_idx" value=1>
						<input type="hidden" name="title" id="title" value="${receiveReply.title}">
						<input type="hidden" name="content" id="content" value="${receiveReply.content}">
						<input type="hidden" name="reply_yn" id="reply_yn" value="${receiveReply.reply_yn}">
						<input type="hidden" name="reporter_idx" id="reporter_idx" value="${member.idx }">
					</form>
					 </div></div> 
				<input type="text" size="248" name="title" id="title"  value="Re:[${receiveReply.title}] 위로의 답장" readonly></div>
			<br>
				<div class="field">
							<label for="content">답장을 받고 조금 위로가 되셨나요?</label>
							<textarea name="content" id="content" rows="15"readonly>${receiveReply.content }</textarea>
				</div>		
			</div>
			
		<br> 
	
	<form name="deleRe" class="form" action="${contextPath }/mail/deleteReceiveReply.do" method="post" onsubmit="return del()">
				<center>
				
						<input type="submit" class="button" value="삭제하기" >
						<input type="button" class="button" value="목록으로" onclick="location.href='${contextPath}/mail/receiveReplyList.do'">
						
						<input type="hidden" id="idx" name="idx" value="${receiveReply.idx }">
						
					</center>

	
	</form>
	
	<br><br>

</body>
</html>