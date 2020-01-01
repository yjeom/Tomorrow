<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<c:if test='${not empty msg }'>
<script>
window.onload=function()
{
  result();
}
function result(){
	alert("${msg}");
}
</script>
<script type="text/javascript">
function logout()
{
	if(confirm("로그아웃 하시겠습니까?")==true)
{

	location.href="${contextPath}/member/logout.do";
}
	else
{
	return;
}
}


</script>
</c:if>
<head>


		<title>Tomorrow is...</title>

	</head>
	<body>


		<!-- Banner -->
			<section id="banner">
				<div class="inner">

					<div class="flex">

						<div>
							<input type="image" src="/images/icons/contact.png" width="40px" onclick="location.href='MenuCheck.jsp'"/>
							<h3>받은 편지함</h3>
							<p>새로 받은 편지를 확인해보세요.</p>
							
						</div>

						<div>
							<input type="image" src="/images/icons/paper-plane.png" width="40px" onclick="location.href='MenuCheck.jsp'"/>
							<h3>보낸 편지함</h3>
							<p>내가 보내 고민을 확인해보세요.</p>							
						</div>

						<div>
							<input type="image" src="/images/icons/like.png" width="40px"  onclick="location.href='MenuCheck.jsp'"/>
							<h3>To. 오늘의 나</h3>
					    	<p>오늘의 나는 어떤 하루였나요?</p>
						</div>
					</div>
			<c:choose>
				<c:when test="${isLogOn==true and not empty member}">
					<footer>
						<input type="button" class="button" value="Logout" onclick="location.href='javascript:logout()'" >
						
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
								<a href="MenuCheck.jsp" class="button">고민 비우기</a>
							</footer>
						</article>
						<article>
							<div class="image round">
								<img src="/images/photo_black.png" alt="Pic 02" /><br><br>
							</div>
						
							<p>몸멋있는 사람은 아무렇게나 살아도 멋있다.<br/>안 씻는 사람은 안 씻어도 멋있다.<br />일생 정리정돈 못하는 사람은 그게 멋이다.<br/>아등바등 살아가는 너같은 사람은 그대로도 멋이다.<br/>
							<font size="2px">#이병률, 끌림</font>
							<footer>
								<a href="MenuCheck.jsp" class="button">To.오늘의 나</a>
							</footer>
						</article>
						
					</div>
				</div>
			</section>

		


	</body>
</html>