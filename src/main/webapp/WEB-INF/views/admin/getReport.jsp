<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8" />
</head>
<script type="text/javascript">

function report(){
	if(confirm("해당 회원을 신고하시겠습니까?\n신고후 해당 신고물은 삭제 됩니다")==true)
		return true;
	 else
	return false;
	
}

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
</script>
	</head>
	
<body>
		
<!-- Banner -->
		<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/images/icons/alarm_rhksflwk.png" width="30px" /><br><br>
							<h3>신 고 관 리</h3>
							 </p>
			</div>
			</div>
		</div>
		</section>
<br>
	<br><br>
	
	<div class="inner">
			<div class="field">
					
					<label for="name">신고된 제목</label>
					
					<input type="text" size="248" value="${report.title }" readonly>
			
				<br>
							<label for="content">신고된 내용</label>
							<textarea rows="15" readonly>${report.content}</textarea>
						</div>		
			</div><br>
	<footer>
						<center>
			<form name="delForm" class="form" action="${contextPath}/mail/deleteReceiveReport.do" method="post" onsubmit="return del()">
			<input type="submit" class="button" value="삭제하기" >
			</form>
			<form name="reportForm" class="form" action="${contextPath}/admin/reportMember.do" method="post" onsubmit="return report()">
				<input type="hidden" id="member_idx" name="member_idx" value="${report.sender_idx }">
				<input type="hidden" id="receive_idx" name="receive_idx" value="${report.idx }"> 
				<input type="submit" class="button" value="신고하기" >
			</form>
			<input type="button" class="button" value="돌아가기" onclick="location.href='${contextPath}/admin/reportList'">
						</center>
						<br><br>
					</footer>
										
</body>
</html>