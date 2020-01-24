<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript">
function check() {
	
	if (document.regFrm.pwd.value=="") {
		alert("비밀번호를  입력하세요");
		document.regFrm.pwd.focus();
		return false;
	}
	if (document.regFrm.pwd.value!=document.regFrm.pwdCheck.value) {
		alert("비밀번호확인이 입력하신 비밀번호와 일치하지 않습니다");
		document.regFrm.pwdCheck.focus();
		return false;
	}
	if (document.regFrm.email.value=="") {
		alert("이메일을 입력하세요.");
		document.regFrm.email.focus();
		return false;
	}
	if (document.regFrm.pwd.value.length<6) {
		alert("비밀번호는 6자리 이상입니다.");
		document.regFrm.pwd.value="";
		document.regFrm.pwd.focus();
		return false;
	}
	document.regFrm.submit();
}
function remove(){
	ok=confirm("탈퇴시 회원님에 대한 정보가 모두 사라집니다\n그래도 탈퇴하시겠습니까?");
	if(ok){
		document.del.submit();
	}
	
}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="/assets/css/main.css" />
<link href="//fonts.googleapis.com/css?family=Pattaya&subset=latin" rel="stylesheet" type="text/css">
<title>Insert title here</title>
</head>
<body>
<header id="header">
	<div class="inner">
		<a href="${contextPath}/home.do" class="logo">Tomorrow is...</a>
	</div>
</header>
<form name="regFrm" method="post" onsubmit="return check()" action="${contextPath }/member/updateMember.do">
<div class="container-login100">
		<div class="wrap-login100 p-l-55 p-r-55 p-t-80 p-b-30" >
			<form class="login100-form validate-form">
				<span class="login100-form-title p-b-37">
					Modify 
				</span>
				<div class="wrap-input100 validate-input m-b-20"  data-validate="Enter username or id">
					<span class="focus-input100 "></span>
					아이디<input class="input100" type="text" name="id" value="${member.id }" readonly>
				</div>

				<div class="wrap-input100 validate-input m-b-25"  data-validate="Enter password">
					비밀번호<input class="input100" type="password" name="pwd" value="">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-25"  data-validate="Enter password Check">
					비밀번호 확인<input class="input100" type="password" name="pwdCheck" value="">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-25" data-validate="Enter email">
					이메일<input class="input100" type="text" name="email" value="${member.email }">
					<span class="focus-input100"></span>
				</div>
				<div class="wrap-input100 validate-input m-b-25" data-validate="">
					경고횟수<input class="input100" type="text" name="report_count" value="${member.report_count }" readonly>
					<span class="focus-input100"></span>
				</div>

				<div class="container-login100-form-btn">
					<input type="submit" class="login100-form-btn" value="수정완료"></div>
					<input type="hidden" name="idx" value="${member.idx }">
					<br>
					<br>
					
					<div class="text-center">
					<a href="javascript:remove()" class="txt2 hov1">
					<font color="grey">회원탈퇴</font>	</a>	
					
					
					</div>
			</form>
<form name="del" action="${contextPath }/member/removeMember.do" method="post">
						<input type="hidden" name="idx" value="${member.idx }">
					</form>
			
		</div>
	</div>
	
	


</body>
</html>