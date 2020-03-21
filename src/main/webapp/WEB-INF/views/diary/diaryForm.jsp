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
		alert("답변을 입력해주세요.");
			document.regFrm.answer.focus();
			return false;
		}
	if(document.regFrm.bad.value=="")
	{
	alert("오늘 중 가장 안 좋았던 일을 입력해주세요.");
		document.regFrm.bad.focus();
		return false;
	}

	if(document.regFrm.good.value=="")
	{
	alert("오늘 중 가장 좋았던 일을 입력해주세요.");
		document.regFrm.good.focus();
		return false;
	}
	if(document.regFrm.decide.value=="")
	{
	alert("내일의 다짐을 입력해주세요.");
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
		 		<h3>From. 지난 날의 나</h3>
				<p>지난 날들 속  나는 어떤 모습인가요?<br></p>
		 	</c:when>
		 	<c:otherwise>
		 		<h3>To. 오늘의 나</h3>
				<p>오늘 하루는 당신에게 어떤 하루였나요?<br></p>	
		 	</c:otherwise>
		</c:choose>
			
			</div>
		</div>
	</div>
	</section>

			<br>
			
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
				<label for="question" style=text-align:left>Q. 오 늘 의 나</label>
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
					<label for="answer" style=text-align:left>A. 오 늘 의 나</label>
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
					<c:when test="${not empty readDiary }">${readDiary.regdate} 의 기록</c:when>
					<c:when test="${not empty updateDiary}">${updateDiary.regdate } 의 기록</c:when>
					<c:otherwise>${today_year }년 ${today_month }월 ${today_day }일의 기록</c:otherwise>
				</c:choose>	
				
				</font></center>
			
				
			
					
				<label for="bad" style=text-align:left>오늘 중 가장 안 좋았던 일은?</label>
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
			
				<label for="good" style=text-align:left>오늘 중 가장 좋았던 일은?</label>
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
		
				<label for="decide" style=text-align:left>내일의 다짐은?</label>
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
				<input type="button" value="수정하기" onclick="location.href='${contextPath}/diary/updateForm.do?idx=${readDiary.idx }'">
			</c:when>
			<c:when test="${not empty updateDiary}">
				<input type="submit" class="button" value="수정">
				<input type="hidden" id="question_idx" name="question_idx" value="${updateDiary.question_idx }">
				<input type="hidden" id="member_idx" name="member_idx" value="${member.idx }">
				<input type="hidden" id="idx" name="idx" value="${updateDiary.idx }">
			</c:when>
			<c:otherwise>
				<input type="submit" class="button" value="작성완료">
				<input type="hidden" id="question_idx" name="question_idx" value="${question_idx }">
				<input type="hidden" id="member_idx" name="member_idx" value="${member.idx }">
			</c:otherwise>
		</c:choose>	
			<input type="button" value="목록으로" onclick="location.href='${contextPath}/diary/diaryList.do'">
		</div>

			</center>
	</div>
</form>
</body>
</html>