<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
var contextPath= '<c:out value="${contextPath}"/>';
function paging(page) {
	location.href=contextPath+"/diary/diaryList.do?curPage="+page;
	}
function question(){
	var isLogOn='<c:out value="${isLogOn}"/>';
	if(isLogOn){
		location.href=contextPath+"/diary/getQuestion.do";
	}
	else{
		alert("세션만료로 로그아웃되셨습니다. 다시 로그인후 이용해 주세요");
		location.href=contextPath+"/member/loginForm.do";
	}
}

</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<section id="banner">
				<div class="inner">
					<div class="flex">					
						<div>
							<img src="/images/icons/like.png" width="30px" /><br><br>
							<h3>To. 오 늘 의 나</h3>
								<p>오늘의 기록 속의 나는 어떤 모습인가요?<br>
							 </p>						
						</div>
					</div>					
				</div>
</section>
<br><br>
	<table>
			<colgroup>
			<col width="10%" />
			<col width="80%" />
			<col width="10%" />
		</colgroup>
		
		<thead>
			<tr>
				<th>No.</th>
				<th>Question</th>
				<th>Date</th>
			</tr>
		</thead>

			<tbody>
	<c:choose>
		<c:when test="${not empty diaryList}">
			<c:forEach var="diaryList" items="${diaryList}" varStatus="rNum">
				<tr>
					<td>${diaryList.rnum}</td>
					<td>
							<a href="${contextPath}/diary/getDiary.do?idx=${diaryList.idx}">
							${diaryList.question_idx }번째로 기록한 오늘의 나에게</a>
						
					</td>
					<td>${diaryList.regdate}</td>			
					</tr>		
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
			<td colspan="4" align="center">등록된 게시물이 없습니다 .</td>
			</tr>
		</c:otherwise>
		</c:choose>
			</tbody>
		</table>
			<center>
			
<div>
                    <c:if test="${paging.curPage > 1 }">
                        <a href="javascript:paging('${paging.curPage-1}')">[이전]</a> 
                    </c:if>
                    <c:forEach var="pageNum" begin="${paging.startPage }" end="${paging.endPage}">
                        <c:choose>
                            <c:when test="${pageNum  eq  paging.curPage}">
                              <font color="blue"><Strong>${pageNum}</Strong></font> 
                            </c:when>
                            <c:otherwise>
                                <a href="javascript:paging('${pageNum}')">${pageNum }</a> 
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${paging.curPage != paging.totalPage && paging.totalPage> 0}">
                        <a href="javascript:paging('${paging.curPage+1}')">[다음]</a> 
                    </c:if>
                </div>			

	<br>
			<input type="button" value="질문받기" onclick="location='javascript:question()'">
			
		<br><br>



</body>
</html>