<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta charset="utf-8" />

<script type="text/javascript">
function secret_(){ 
	
	document.getElementById("secretPwd").innerHTML = "<p align='center'><input type='password' id='pwd' name='pwd' style='width:30%;'><br>비밀번호 4자리를 입력해주세요</p>" ;
} 
function secret2_(){ 
		document.getElementById("secretPwd").innerHTML = " " ;
		
	} 
function inputCheck() {
	
	if (document.getElementById("title").value=="") {
		alert("제목을 입력해주세요");
		document.getElementById("title").focus();
		return false;
	}
	if (document.getElementById("content").value=="") {
		alert("내용을 입력해주세요.");
		document.getElementById("content").value = "";
		document.getElementById("content").focus();
		return false;
	}
	if(document.getElementById("secret_yn").value=="yes"){
		if(document.getElementById("pwd").value.length !=4)
		{
			alert("비밀번호는 4자리를 입력해주세요.");
			document.getElementById("pwd").value = "";
			document.getElementById("pwd").focus();
			return false;
		}
		}
}

</script>
<title>QnA 작성 : Tomorrow is...</title>
</head>

</head>
<body>

		
<!-- Banner -->
		<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/tomorrow/resources/images/icons/question.png" width="30px" /><br>
							<h3>QnA 작성</h3>
							<p>문의 사항은 언제든 환영입니다.<br>
							 </p>
						
					</p>
				</div>
			</div>
		</div>
		</section>
<br><br>
<br>
<c:choose>
	<c:when test="${isNew==true }">
		<form name="form" class="form" method="post" action="${contextPath}/qna/insertQna.do" onsubmit = "return inputCheck()">
	</c:when>
	<c:otherwise>
	<form name="form" class="form" method="post" action="${contextPath}/qna/updateQna.do" onsubmit = "return inputCheck()">
	</c:otherwise>
</c:choose>
	
<div class="inner">
			<div class="field">
					
					<label for="name">문의 제목</label>
					<td><textarea rows="3" cols="250" name="title" id="title">${qna.title }</textarea>
				<br><br>
					<label for="name">문의 내용</label>
					<textarea rows="10" cols="250" name="content" id="content">${qna.content}</textarea>
				<br><br>
					<label for="name"><font color="#11214a">비밀로 할까요?</font>&nbsp;
   					 <input type="radio" name="secret_yn" value="1" onclick="secret_()" />YES
    				<input type="radio" name="secret_yn" value="0" onclick="secret2_()"  checked/>NO</label>
    
			
			<input type="hidden" name="writer_idx" value="${member.idx}">
			<input type="hidden" name="idx" value="${qna.idx}">
			<div id="secretPwd"></div>
			</div>
			
			<center>
				
					<br> <br>
			<c:choose>
				<c:when test="${isNew==true}">
				<input type="submit" value="작성완료">
				</c:when>
				<c:otherwise>
				<input type="submit" value="수정하기" >
				</c:otherwise>
			</c:choose>	
					<input type="button" class = "button" value="목록으로" onclick="location.href='${contextPath}/qna/qnaList.do'"> 
						
				</div>

			</center>
		</div>
</form>
	
<script type="text/javascript">
		window.history.forward();
		function noBack() {
			window.history.forward();

		}
</script>
</body>
</html>