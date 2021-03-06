<%@ page language="java" contentType="text/html; charset=EUC-KR"   pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test='${isLogOn==true}'>
<script>
window.onload=function()
{
	var report = '<c:out value="${member.report_count}"/>';
	var check = '<c:out value="${member.report_check}"/>';
	var contextPath= '<c:out value="${contextPath}"/>';
	if(5<=report && report<10 && check==0)
		{
			alert("현재 회원님은 5회 이상 신고가 들어왔습니다. \n10회 이상시 자동으로 탈퇴처리 됩니다.");
			location.href=contextPath+"/member/reportCheck.do";

		}
	if(7<=report && report<10 && check==1)
		{

				alert("현재 회원님은 7회 이상 신고가 들어왔습니다. \n10회 이상시 자동으로 탈퇴처리 됩니다.");
				location.href=contextPath+"/member/reportCheck.do";

	    }
	
 if(report>=10){
		alert("현재 회원님은 10회 이상 신고가 들어와 회원님의 계정을 삭제하겠습니다.");
		location.href=contextPath+"/member/removeMember.do";

	}
}
function result(){
	alert("${msg}");
}
</script>
</c:if>
<script type="text/javascript">
var contextPath= '<c:out value="${contextPath}"/>';
function logout()
{
	if(confirm("로그아웃 하시겠습니까?")==true)
{

	location.href=contextPath+"/member/logout.do";
}
	else
{
	return;
}
}
function sendMail(){
		location.href=contextPath+"/mail/sendWorryList.do";
}
function receiveMail(){
		location.href=contextPath+"/mail/receiveWorryList.do";
}
function diary(){
		location.href=contextPath+"/diary/diaryList.do";
}
</script>
<head>


		<title>Tomorrow is...</title>

	</head>
	<body >
	

		<!-- Banner -->
			<section id="banner">
				<div class="inner">

					<div class="flex">

						<div>
						<c:choose>
							<c:when test="${newWorry >0}">
							<input type="image" src="/tomorrow/resources/images/icons/new.gif" width="40px" onclick="location.href='javascript:receiveMail()'">
							</c:when>
							<c:otherwise>
							<input type="image" src="/images/icons/contact.png" width="40px" onclick="location.href='javascript:receiveMail()'"/>
							</c:otherwise>
						</c:choose>
						
							<h3>받은 편지함</h3>
							<p>새로 받은 편지를 확인해보세요.</p>
							
						</div>

						<div>
							<input type="image" src="/images/icons/paper-plane.png" width="40px" onclick="location.href='javascript:sendMail()'"/>
							<h3>보낸 편지함</h3>
							<p>내가 보내 고민을 확인해보세요.</p>							
						</div>

						<div>
							<input type="image" src="/images/icons/like.png" width="40px"  onclick="location.href='javascript:diary()'"/>
							<h3>To. 오늘의 나</h3>
					    	<p>오늘의 나는 어떤 하루였나요?</p>
						</div>
					</div>
			<c:choose>
				<c:when test="${isLogOn==true and not empty member}">
					<footer>
						<input type="button" class="button" value="myPage" onclick="location.href='${contextPath}/member/myPage.do'" >
						
					</footer>
				</c:when>
				<c:otherwise>
					<footer>
						<input type="button" class="button" value="Login" onclick="location.href='${contextPath}/member/loginForm.do'" >
						
					</footer>
				</c:otherwise>
			</c:choose>
				</div>
			</section>


		<!-- Three -->
			<section id="three" class="wrapper align-center">
				<div class="inner">
					<div class="flex flex-2">
						<article>
							<div class="image round">
								<img src="/images/mail_black.jpg" alt="Pic 01" /><br><br>
							</div>
						
							<p>몸이든 마음이든 비우면 시원하고 편안해집니다.<br/>반대로 안에 오랫동안 간직하고 있으면<br/>몸이든 마음이든 병이 납니다.<br />뭐든 비워야 좋습니다.<br/><font size="2px">#혜민스님, 멈추면 비로소 보이는 것들</font>
							<br/>
							<footer>
								<a href="${contextPath }/mail/sendWorryForm.do" class="button">고민 비우기</a>
							</footer>
						</article>
						<article>
							<div class="image round">
								<img src="/images/photo_black.png" alt="Pic 02" /><br><br>
							</div>
						
							<p>몸멋있는 사람은 아무렇게나 살아도 멋있다.<br/>안 씻는 사람은 안 씻어도 멋있다.<br />일생 정리정돈 못하는 사람은 그게 멋이다.<br/>아등바등 살아가는 너같은 사람은 그대로도 멋이다.<br/>
							<font size="2px">#이병률, 끌림</font>
							<footer>
								<a href="${contextPath }/diary/diaryForm.do" class="button">To.오늘의 나</a>
							</footer>
						</article>
						
					</div>
				</div>
			</section>

		


	</body>
</html>