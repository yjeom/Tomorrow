<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<title>���� ���� �б� : Tomorrow is...</title>
<meta charset="utf-8" />
</head>
<script type="text/javascript">

function inputCheck()
{
	var isLogOn='<c:out value="${isLogOn}"/>';
	if(isLogOn ==''||isLogOn==null){
		alert("���Ǹ���� �α׾ƿ��Ǿ����ϴ�.�ٽ� �α����� �̿����ּ���"+isLogOn);
		location.href="${contextPath}/member/loginForm.do";
		return false;
	}
	else if(document.sendReply.contents.value=="")
		{
			alert("������ �Է��ϼ���.");
			document.sendReply.contents.focus();
			return false;
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
							<h3>���� ���� �б�</h3>
							<p>����� ���ΰ� �ʿ��� �����Դϴ�.<br>
							 </p>
				</div>
			</div>
		</div>
		</section>
<br>
	<br><br>
	<div class="inner">
			<div class="field">
					
					<label for="name">���� ����</label>
					<div style="position:absolute">
							<div style="position:relative; top:-40px; left:20px;">
							<img src="/images/icons/alarm.png" width="20px" onclick="report()"/>
						</div></div> 
					<input type="text" size="248" value="${receiveWorry.title }" readonly>
			
				<br>
							<label for="contents">���� ����</label>
							<textarea rows="15" readonly>${receiveWorry.content }</textarea>
			</div>		
	</div>
			
	<br><br><br>
		
			<center>
	<form name="sendReply" class="form" action="${contextPath }/mail/sendReply.do" method="post" onsubmit="return inputCheck()">
		<label for="name"><font color="#11214a">�� ��</font></center>
			<div class="inner">
			<div class="field">
					
				<input type="text" size="248" name="title" id="title"  value="Re:[${receiveWorry.title}] ������ ����" readonly></div>
			<br>
				<div class="field">
							<label for="content">� ���ΰ� �������?</label>
							<textarea name="content" id="content" rows="15"></textarea>
				</div>		
			</div>
			
		<br> 
	

				<footer>
						<center><input type="submit" class="button" value="�����ϱ�">
						<input type="button" class="button" value="�������" onclick="location='${contextPath}/mail/receiveWorryList.do'">
						</center>
					<input type="hidden" id="idx" name="idx" value="${receiveWorry.idx }"> 
					<input type="hidden" id="receiver_idx" name="receiver_idx" value="${receiveWorry.sender_idx }"> 
					<input type="hidden" id="sender_idx" name="sender_idx" value="${member.idx}"> 
					<input type="hidden" id="mail_idx" name="mail_idx" value="${receiveWorry.mail_idx }"> 
					<input type="hidden" id="reply_yn" name="reply_yn" value=1>
						
					</footer>

	
	</form>

</body>
</html>