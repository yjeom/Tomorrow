<%@ page language="java" contentType="text/html; charset=EUC-KR"
	import="java.util.Date"
	pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="today" value="<%=new Date() %>"/>
<fmt:formatDate value="${today}" pattern="yyyy" var="today_year" />
<fmt:formatDate value="${today}" pattern="MM" var="today_month" />
<fmt:formatDate value="${today}" pattern="dd" var="today_day" />

<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
function inputCheck()
{
	if(document.regFrm.answer.value=="")
		{
		alert("�亯�� �Է����ּ���.");
			document.regFrm.answer.focus();
			return false;
		}
	if(document.regFrm.bad.value=="")
	{
	alert("���� �� ���� �� ���Ҵ� ���� �Է����ּ���.");
		document.regFrm.bad.focus();
		return false;
	}

	if(document.regFrm.good.value=="")
	{
	alert("���� �� ���� ���Ҵ� ���� �Է����ּ���.");
		document.regFrm.good.focus();
		return false;
	}
	if(document.regFrm.decide.value=="")
	{
	alert("������ ������ �Է����ּ���.");
		document.regFrm.decide.focus();
		return false;
	}
	


}
</script>
<head>
</head>


	<body>

	<!-- Banner -->
	<section id="banner">
	<div class="inner">
		<div class="flex">
			<div>
				<img src="/images/icons/like.png" width="30px" />
				<br>
				<br>
		<c:choose>
		 	<c:when test="${not empty readDiary }">
		 		<h3>From. ���� ���� ��</h3>
				<p>���� ���� ��  ���� � ����ΰ���?<br></p>
		 	</c:when>
		 	<c:otherwise>
		 		<h3>To. ������ ��</h3>
				<p>���� �Ϸ�� ��ſ��� � �Ϸ翴����?<br></p>	
		 	</c:otherwise>
		</c:choose>
			
			</div>
		</div>
	</div>
	</section>

			<br><br><br>
			
		<c:choose>
			<c:when test="${not empty updateDiary}">
				<form name="regFrm" method="post" action="${contextPath }/diary/updateDiary.do" onsubmit="return inputCheck()">
			</c:when>
			<c:otherwise>
				<form name="regFrm" method="post" action="${contextPath }/diary/insertDiary.do" onsubmit="return inputCheck()">
			</c:otherwise>
		</c:choose>	
				<div class="inner">
			<div class="field">
				<label for="question" style=text-align:left>Q. �� �� �� ��</label>
				<c:choose>
					<c:when test="${not empty readDiary}">
						<textarea rows="2" name="question" id="question"  text-align="center" style="overflow:hidden" readonly>${readDiary.question }
						</textarea>
					</c:when>
					<c:when test="${not empty updateDiary}">
						<textarea rows="2" name="question" id="question"  text-align="center" style="overflow:hidden" readonly>${updateDiary.question }
						</textarea>
					</c:when>
					<c:otherwise>
						<textarea rows="2" name="question" id="question"  text-align="center" style="overflow:hidden" readonly>${question}
						</textarea>
					</c:otherwise>
				</c:choose>	
			<br>
					<label for="answer" style=text-align:left>A. �� �� �� ��</label>
						<c:choose>
					<c:when test="${not empty readDiary }">
						<textarea rows="2"  name="answer" id="answer" text-align="center"  style="overflow:hidden" readonly>${readDiary.answer }</textarea>
					</c:when>
					<c:when test="${not empty updateDiary}">
						<textarea rows="2"  name="answer" id="answer" text-align="center"  style="overflow:hidden">${updateDiary.answer}</textarea>
					</c:when>
					<c:otherwise>
						<textarea rows="2"  name="answer" id="answer" text-align="center"  style="overflow:hidden"></textarea>
					</c:otherwise>
				</c:choose>	
	<br><br><br><br><br><br>
		
			<center>
				<label for="name"><font color="#11214a">
				<c:choose>
					<c:when test="${not empty readDiary }">${readDiary.regdate} �� ���</c:when>
					<c:when test="${not empty updateDiary}">${updateDiary.regdate } �� ���</c:when>
					<c:otherwise>${today_year }�� ${today_month }�� ${today_day }���� ���</c:otherwise>
				</c:choose>	
				
				</font></center>
			
				
			
					
				<label for="bad" style=text-align:left>���� �� ���� �� ���Ҵ� ����?</label>
				<c:choose>
					<c:when test="${not empty readDiary }">
					<textarea rows="2"  name="bad" id="bad" text-align="center"  style="overflow:hidden" readonly>${readDiary.bad }</textarea>
					</c:when>
					<c:when test="${not empty updateDiary}">
					<textarea rows="2"  name="bad" id="bad" text-align="center"  style="overflow:hidden" >${updateDiary.bad }</textarea>
					</c:when>
					<c:otherwise>
						<textarea rows="2"  name="bad" id="bad" text-align="center"  style="overflow:hidden" ></textarea>
					</c:otherwise>
				</c:choose>	
				<br>
			
				<label for="good" style=text-align:left>���� �� ���� ���Ҵ� ����?</label>
				<c:choose>
					<c:when test="${not empty readDiary }">
						<textarea rows="2" name="good" id="good" text-align="center"  style="overflow:hidden" readonly>${readDiary.good}</textarea>
					</c:when>
					<c:when test="${not empty updateDiary}">
						<textarea rows="2" name="good" id="good" text-align="center"  style="overflow:hidden">${updateDiary.good}</textarea>
					</c:when>
					<c:otherwise>
						<textarea rows="2" name="good" id="good" text-align="center"  style="overflow:hidden"></textarea>
					</c:otherwise>
				</c:choose>	
				<br>
		
				<label for="decide" style=text-align:left>������ ������?</label>
				<c:choose>
					<c:when test="${not empty readDiary }">
						<textarea rows="2"  name="resolution" id="resolution" text-align="center"  style="overflow:hidden" readonly>${readDiary.resolution}</textarea>
					</c:when>
					<c:when test="${not empty updateDiary}">
						<textarea rows="2"  name="resolution" id="resolution" text-align="center"  style="overflow:hidden">${updateDiary.resolution}</textarea>
					</c:when>
					<c:otherwise>
						<textarea rows="2"  name="resolution" id="resolution" text-align="center"  style="overflow:hidden"></textarea>
					</c:otherwise>
				</c:choose>	
				</div></div>

		<center>
		
				<br>
			
							
		<c:choose>
			<c:when test="${not empty readDiary }">
				<input type="button" value="�����ϱ�" onclick="location.href='${contextPath}/diary/updateForm.do?idx=${readDiary.idx }'">
			</c:when>
			<c:when test="${not empty updateDiary}">
				<input type="submit" class="button" value="����">
				<input type="hidden" id="question_idx" name="question_idx" value="${updateDiary.question_idx }">
				<input type="hidden" id="member_idx" name="member_idx" value="${member.idx }">
				<input type="hidden" id="idx" name="idx" value="${updateDiary.idx }">
			</c:when>
			<c:otherwise>
				<input type="submit" class="button" value="�ۼ��Ϸ�">
				<input type="hidden" id="question_idx" name="question_idx" value="${question_idx }">
				<input type="hidden" id="member_idx" name="member_idx" value="${member.idx }">
			</c:otherwise>
		</c:choose>	
			<input type="button" value="�������" onclick="location.href='${contextPath}/diary/diaryList.do'">
		</div>

			</center>
	</div>
</form>
</body>
</html>