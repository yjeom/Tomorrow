<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8" />


<title>QnA 목록 : Tomorrow is...</title>
</head>
<body>
			<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/images/icons/question.png" width="30px" /><br><br>
							<h3>QnA</h3>
							<p>문의사항은 언제든 환영합니다.<br>
							 </p>
						
					</p>
				</div>
			</div>
		</div>
		</section>
<br>
		<table>
			<colgroup>
			<col width="10%" />
			<col width="80%" />
			<col width="7%" />
			<col width="3%" />
			</colgroup>
			<thead>
				<tr>
					<th>No.</th>
					<th>Title</th>
					<th>Date</th>
					<th>Views</th>
				</tr>
			</thead>

			<tbody>
	<c:choose>
		<c:when test="${qnaList !=null}">
			<c:forEach var="qnaList" items="${qnaList}" varStatus="rNum">
				<tr>
					<td>${rNum.count}</td>
					<c:choose>
						<c:when test="${qnaList.level >1 }">
							<c:forEach begin="1" end="${qnsList.level}" step="1">
								<span style=padding-left:20px></span>
							</c:forEach>
							<span style="font-size:12px;">[답변]</span>
							<c:if test="${qnaList.secret_yn=1}">
								<img src="/images/icons/lock.png" width="15px"/><span style=padding-left:20px></span>
							</c:if>
							<a href="javascript:read('${qnaList.idx}')">${qnaList.title}</a>
						</c:when>
						<c:otherwise>
							<c:if test="${qnaList.secret_yn=1}">
									<img src="/images/icons/lock.png" width="15px"/><span style=padding-left:20px></span>
							</c:if>
							<a href="javascript:read('${qnaList.idx}')">${qnaList.title}</a>
						</c:otherwise>
					</c:choose>	
					<td>${qnaList.regdate}</td>			
					<td>${qnaList.views}</td>			
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
			<td colspan="4" align="center">등록된 게시물이 없습니다 .</td>
			</tr>
		</c:otherwise>
			</tbody>
		</table>
	</c:choose>
			<center>
			

		
		<br><br>
		

	</div>
</body>
</html>