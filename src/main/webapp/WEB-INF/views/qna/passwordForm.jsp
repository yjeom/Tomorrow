<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
		
<!-- Banner -->
		<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/images/icons/question.png" width="30px" /><br><br>
							<h3>QnA</h3>
							<p>비밀 꼭 지키겠습니다.<br>
							 </p>
						
					</p>
				</div>
			</div>
		</div>
		</section>
<br><br>
<c:choose>
	<c:when test="${isLogOn!=null and member.id=='rhksflwk'}">
	    <script type="text/javascript">
    location.href = "${contextPath}/qna/getQna.do?idx=${idx}";
   </script>
   </c:when>
   <c:otherwise>
   <form action="${contextPath}/qna/passwordForm.do" method="post">
<p align="center">비밀번호 4자리를 입력해주세요
<br><br>
<input type="password" name="pwd" id="pwd" style="width:30% ;" >
<br>
<br>
<input type="submit" value="확인" ></p>
<input type="hidden" name="idx" value="${idx}">
</form>
</c:otherwise>
</c:choose>
</table>
</body>
</html>