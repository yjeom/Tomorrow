<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

		<title>���� ���� �б� : Tomorrow is...</title>
<meta charset="utf-8" />
</head>
<script type="text/javascript">

function del()
{
	if(confirm("�ش� ���� �����Ͻðڽ��ϱ�?")==true)
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
					<img src="/images/icons/contact.png" width="30px" /><br><br>
							<h3>���� ���� �б�.</h3>
							<p>����� �����ϴ� ������ �����߽��ϴ�.<br>
							 </p>
						
					</p>
				</div>
			</div>
		</div>
		</section>
<br>
	<br><br>
	<div class="inner">
			<div class="field">
					
					<label for="name">���� ����</label>
					<div style="position:absolute">
							<div style="position:relative; top:-40px; left:20px;">
							<img src="/images/icons/alarm.png" width="20px" onclick="report()"/>
						</div></div> 
					<input type="text" size="248" value="${sendWorry.title }" readonly>
			
				<br>
							<label for="contents">���� ����</label>
							<textarea rows="15" readonly>${sendWorry.content }</textarea>
			</div>		
	</div>
			
	<br><br><br>
		
			<center>
	<form name="deleRe" class="form" action="${contextPath }/mail/deleteReceiveReply.do" method="post" onsubmit="return del()">
		<label for="name"><font color="#11214a">�� ��</font></center>
			<div class="inner">
			<div class="field">
					
				<input type="text" size="248" name="title" id="title"  value="Re:[${receiveReply.title}] ������ ����" readonly></div>
			<br>
				<div class="field">
							<label for="content">� ���ΰ� �������?</label>
							<textarea name="content" id="content" rows="15"readonly>${receiveReply.content }</textarea>
				</div>		
			</div>
			
		<br> 
	

				<center>
				
						<input type="submit" class="button" value="�����ϱ�" onclick="javascript:del()">
						<input type="button" class="button" value="�������" onclick="location.href='${contextPath}/mail/receiveReplyList.do'">
						
						<input type="hidden" id="idx" name="idx" value="${receiveReply.idx }">
						
					</center>

	
	</form>
	
	<br><br>

</body>
</html>