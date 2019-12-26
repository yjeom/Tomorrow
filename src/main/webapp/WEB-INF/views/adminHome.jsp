<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>

	</head>

		<!-- Banner -->
			<!-- Banner -->
			<section id="banner">
				<div class="inner">

					<div class="flex">

						<div>
							<h3>신고관리</h3>
							
						</div>
						<div>
							<input type="image" src="/images/icons/question2.png" width="35px" onclick="location.href='3.QnA.jsp'"/>
							<h3>QnA관리</h3>
						</div>

						<div>
							<input type="image" src="/images/icons/microphone.png" width="35px"  onclick="location.href='4.notice_list.jsp'"/>
							<h3>공지사항</h3>
						</div>
					</div>
						
							
</center>
			</section><br><br>
			
<table>
			<colgroup>
			<col width="20%" />
			<col width="20%" />
			<col width="20%" />
			<col width="20%" />
			<col width="20%" />
			</colgroup>
			<thead>
				<tr>
					<th>No.</th>
					<th>ID</th>
					<th>Password</th>
					<th>Email</th>
					<th>Report</th>
				</tr>
			</thead>

			<tbody>

  <c:choose>
  	<c:when test="${memberList==null}">
		<tr>
			<td colspan="4" align="center">등록된 회원이 없습니다 .</td>
		</tr>
	</c:when>
	<c:when test="${memberList !=null}">
	<c:forEach  var="memberList" items="${memberList}" varStatus="rNum" >
		<tr>
			<td>${rNum.count}</td>
			<td>${memberList.id }</td>
			<td>${memberList.pwd }</td>
			<td>${memberList.email }</td>
			<td>${memberList.report_count }</td>
		</tr>
		</c:forEach>
	</c:when>
</c:choose>
			</tbody>
		</table>
		
			<br><center>
			

	</body>
</html>