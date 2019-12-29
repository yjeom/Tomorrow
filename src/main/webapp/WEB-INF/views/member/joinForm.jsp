<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">

function idCheck() {
	if (document.regFrm.id.value== "") {
		alert("아이디를 입력해 주세요.");
		document.regFrm.id.focus();
		return;
	}
	
		var uid = document.regFrm.id.value;
		var url = "confirmId.jsp?id=" + uid;
		window.open(url, "IDCheck","left=600, top=100, width=500, height=400, resizable=no, toolbar=no, manubar=no ");
	
	
}

function check() {
	if (document.regFrm.id.value== "") {
		alert("아이디를 입력해 주세요.");
		document.regFrm.id.focus();
		return false;
	}
	if (document.regFrm.joongbokID.value == 0) {
		alert("아이디를 중복체크 해주세요.");
		return false;
	}	
	if (document.regFrm.password.value=="") {
		alert("비밀번호를  입력하세요");
		document.regFrm.password.focus();
		return false;
	}
	
	if (document.regFrm.password.value.length<6) {
		alert("비밀번호는 6자리 이상입니다.");
		document.regFrm.password.value="";
		document.regFrm.password.focus();
		return false;
	}
	if (document.regFrm.password.value == document.regFrm.id.value) {
		alert("비밀번호는 아이디와 동일할 수 없습니다.");
		document.regFrm.password.value="";
		document.regFrm.password.focus();
		return false;
	}

	
	if (document.regFrm.email.value=="") {
		alert("이메일을 입력하세요.");
		document.regFrm.email.focus();
		return false;
	}

	if(document.regFrm.email.value.indexOf("@")<0)
		{
		alert("이메일의 형식이 잘못되었습니다.");
		document.regFrm.email.focus();
		return false;
		}
	
	
	
}


</script>
	<meta charset="UTF-8">
</head>

<body>	
 <form name="regFrm" method="post" onsubmit="return check()" action="joinProcess.jsp">
	<div class="container-login100">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30" >
			<form class="login100-form validate-form">
				<span class="login100-form-title p-b-37">
					Join 
				</span><br>
				<div class="text-right">
					<a href="javascript:idCheck()" class="txt2 hov1"><font color="grey" size="2px">
					ID check
					</a></font>
				</div>
				<div class="wrap-input100 validate-input m-b-20" >
					<input class="input100" type="text" name="id"   id="id" placeholder="username or id">
					<span class="focus-input100"></span>
						<input type="hidden" id="joongbokID" name="joongbokID" value=0>	
					
				</div>

				<div class="wrap-input100 validate-input m-b-25"  >
					<input class="input100" type="password" name="password" placeholder="password (more than 6 letters)">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-25" >
					<input class="input100" type="text" name="email" placeholder="e-mail">
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
					<input type="submit" class="login100-form-btn" value="Sign Up">
					</div>
			</form>

			
		</div>
	</div>
	
</form>
<title>회원가입 : Tomorrow is...</title>
</head>
<body>
<script type="text/javascript">
		window.history.forward();
		function noBack() {
			window.history.forward();

		}

         </script>
</body>
</html>