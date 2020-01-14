<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<title>보낸 답장 읽기 : Tomorrow is...</title>
<meta charset="utf-8" />
<script type="text/javascript">
function del()
{
	if(confirm("글을 삭제하시겠습니까?")==true)
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
					<img src="/images/icons/paper-plane.png" width="35px"  />
					<br><br>
					<h3>보낸 답장 읽기</h3>
						<p>내가 보냈던 위로을 다시 읽어보니 어떤가요?<br>
							 </p>	
				</div>
			</div>
		</div>
		</section>
<br><br><br>
	<form name="delForm" class="form" method="post" action="${contextPath }/mail/deleteSendReply.do"  onsubmit="return del()">
			<div class="inner">
				<div class="field">
					<label for="name">답장 제목</label>
					<input type="text" id="title" name="title" value="${sendReply.title }" readonly>
				</div><br><br>
				<div class="field">
					<label for="content">답장 내용</label>
					<textarea name="content" id="content" rows="15" readonly>${sendReply.content }</textarea>
				</div>
			</div>

			<center><br>
			<input type="submit" class="button" value="삭제하기 "/>
			<input type="hidden" id="idx" name="idx" value="${sendReply.idx }">

			 <input type="button" class="button" value="목록으로 " onclick="location.href='${contextPath}/mail/sendReplyList.do'"/></center></footer><br>
			</div>
		</form>
	
</body>

</html>