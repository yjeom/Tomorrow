  <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%> 
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html>
<html>

<script type="text/javascript">
var contextPath= '<c:out value="${contextPath}"/>';
function logout()
{
	if(confirm("로그아웃 하시겠습니까?")==true){

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
		location.href="${contextPath}/diary/diaryList.do";
}
</script>
<style>
		input[type="submit"].tag,
		input[type="reset"].tag,
		input[type="button"].tag,
		button.tag,
		.button.tag {
			color:red !important;
			border-radius: 10px;
			font-size: 0.85em;
			box-shadow: inset 0 0 0 1px #ffffff;
			line-height: 1;
			height:1.75em;
			text-align: center;
			display: inline-block;	
			clear:both;
			
		}
			input[type="submit"].tag:hover,
			input[type="reset"].tag:hover,
			input[type="button"].tag:hover,
			button.tag:hover,
			.button.tag:hover {
				background-color: transparent;
				color:#6cc091 !important;
			}
button.report,
.button.report{
	color:red !important;
  background-color: transparent;
  box-shadow: inset 0 0 0 1px transparent;
  font-size: 0.75em;
}
button.report:hover,
.button.report:hover{
	background-color: transparent;
	font-weight: bold;
}
.btn_image {
  width: 20px;
  height: 20px;
}

</style>
<head>
  <meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="/assets/css/main.css" />
		<link href="//fonts.googleapis.com/css?family=Pattaya&subset=latin" rel="stylesheet" type="text/css">
		<link rel="icon" type="image/png" href="/images/icons/favicon_main.ico"/>
		
<title>헤더</title>
</head>
<body>
<c:choose>
	<c:when test="${isLogOn==true and member.id eq 'rhksflwk'}">
						<header id="header">
				<div class="inner">
					<a href="${contextPath}/admin/adminHome.do" class="logo">Tomorrow is...</a>
						<a href="${contextPath }/admin/reportList.do">신고관리</a>
						<a href="${contextPath}/qna/qnaList.do">QnA</a>
						<a href="${contextPath}/notice/noticeList.do">Notice</a>
						<a href="javascript:logout()"><font color="red">Logout</a> </font>
				</div>
			</header>
		</c:when>
	<c:when test="${member.id ne 'rhksflwk' }">
			<header id="header">
				<div class="inner">
					<a href="${contextPath}/" class="logo">Tomorrow is...</a>
						<a href="javascript:receiveMail()">받은 편지함</a>
						<a href="javascript:sendMail()">보낸 편지함</a>
						<a href="javascript:diary()">To.오늘의 나</a>
						<a href="${contextPath}/qna/qnaList.do">QnA</a>
						<a href="${contextPath}/notice/noticeList.do">Notice</a>
					<c:choose>
						<c:when test="${not empty member and isLogOn==true}">
							<a href="javascript:logout()"><font color="red">Logout</a> </font>
						</c:when>
						<c:otherwise>
							<a href="${contextPath}/member/loginForm.do">Login</a>
						</c:otherwise>
					</c:choose>	
				</div>
			</header>
	</c:when>
</c:choose>
</body>
</html>