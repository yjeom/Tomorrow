<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<title>���� ���� �б� : Tomorrow is...</title>
<meta charset="utf-8" />
<script type="text/javascript">
function del()
{
	if(confirm("���� �����Ͻðڽ��ϱ�?")==true)
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
					<h3>���� ���� �б�</h3>
						<p>���� ���´� ������ �ٽ� �о�� �����?<br>
							 </p>	
				</div>
			</div>
		</div>
		</section>
<br><br><br>
	<form name="delForm" class="form" method="post" action="${contextPath }/mail/deleteSendReply.do"  onsubmit="return del()">
			<div class="inner">
				<div class="field">
					<label for="name">���� ����</label>
					<input type="text" id="title" name="title" value="${sendReply.title }" readonly>
				</div><br><br>
				<div class="field">
					<label for="content">���� ����</label>
					<textarea name="content" id="content" rows="15" readonly>${sendReply.content }</textarea>
				</div>
			</div>

			<center><br>
			<input type="submit" class="button" value="�����ϱ� "/>
			<input type="hidden" id="idx" name="idx" value="${sendReply.idx }">

			 <input type="button" class="button" value="������� " onclick="location.href='${contextPath}/mail/sendReplyList.do'"/></center></footer><br>
			</div>
		</form>
	
</body>

</html>