<%@ page language="java" contentType="text/html; charset=euc-kr"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>	
<meta charset="UTF-8">
</head>
<title>ID check: Tomorrow is...</title>
</head>
<body>

	<div class="container-login100">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30" >
			<form class="login100-form validate-form">
				<span class="login100-form-title p-b-37">
					ID check
				</span>
	<c:if test="${result==true}">
		<center><font color="red" size="3px">${id}</font><font size="3px">은(는) 이미 사용중인 ID입니다.</font>
		<form method="post" action="${contextPath}/member/idCheck.do">
				<div class="wrap-input100 validate-input m-b-20" >
					<input class="input100" type="text" name="id" id="id" autofocus/>
					<span class="focus-input100"></span></div>
     	<div class="container-login100-form-btn">
					<input type="submit" class="login100-form-btn" value="check">
		</div>
		</form>
		</c:if>
	</center>
	<c:if test="${result==false}">
	 <center><font color="blue" size="3px">${id }</font><font size="3px">은(는) 사용가능한  ID입니다.</font>
	</center>
	</c:if>
	<br>
	<br>
	<div class="container-login100-form-btn">
					<input type="button" class="login100-form-btn" value="OK"  onClick="setId()">
					</div>

	<div id="dropDownSelect1"></div>
	

</body>
</html>
	<script language="javascript">
	function setId()
	{
			// 받을 부모
			window.opener.document.getElementById("id").value="${id}";
			window.opener.document.getElementById("joongbokID").value=1;
			window.close(); //창닫기
	}

	</script>