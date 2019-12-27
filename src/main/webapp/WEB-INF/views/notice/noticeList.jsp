<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
     <!-- Banner -->
         <section id="banner">
            <div class="inner">
               <div class="flex">               
                  <div>
                     <img src="/images/icons/microphone.png" width="30px" /><br><br>
                     <h3>공 지 사 항</h3>
                        <p>관리자가 소통하는 방법입니다.<br>
                      </p>                  
                  </div>
               </div>               
            </div>
         </section>
         <br>
     <table>
			<colgroup>
			<col width="20%" />
			<col width="40%" />
			<col width="20%" />
			<col width="20%" />
			</colgroup>
			<thead>
				<tr>
					<th>No.</th>
					<th>TITLE</th>
					<th>DATE</th>
					<th>VIEWS</th>
				</tr>
			</thead>

			<tbody>

  <c:choose>
  	<c:when test="${empty noticeList}">
		<tr>
			<td colspan="4" align="center">등록된 공지사항이 없습니다 .</td>
		</tr>
	</c:when>
	<c:when test="${not empty noticeList}">
	<c:forEach  var="noticeList" items="${noticeList}" varStatus="rNum" >
		<tr>
			<td>${rNum.count}</td>
			<td><a href="${contextPath}/notice/getNotice.do?idx=${noticeList.idx}">${noticeList.title }</a></td>
			<td>${noticeList.regdate}</td>
			<td>${noticeList.views}</td>
		</tr>
		</c:forEach>
	</c:when>
</c:choose>
			</tbody>
		</table>
		  <br><center>  
		  
		  <c:if test="${not empty member and member.id eq 'rhksflwk'}">
		  		<input type ="button" class="button" value="작성하기" onclick="location='${contextPath}/notice/noticeForm.do'">
		  </c:if>
         
      
</body>
</html>