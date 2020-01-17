<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
var contextPath= '<c:out value="${contextPath}"/>';
function paging(page) {
		location.href=contextPath+"/admin/reportList.do?curPage="+page;
		}

	</script>
</head>
<body>
     <!-- Banner -->
   			<section id="banner">
				<div class="inner">
					<div class="flex">					
						<div>
							<img src="/images/icons/alarm_rhksflwk.png" width="30px" /><br>
							<h3>신 고 관 리</h3>
													
						</div>
					</div>					
				</div>
			</section>
         <br>
     <table>
		<colgroup>
			<col width="10%" />
			<col width="10%" />
			<col width="60%" />
			<col width="10%" />
			<col width="10%" />
		</colgroup>
			<thead>
				<tr>
				<th>No.</th>
				<th>신고한 회원</th>
				<th>글 제목</th>
				<th>신고 당한 회원</th>
				<th>신고 날짜</th>
			</tr>
			</thead>

			<tbody>

  <c:choose>
  	<c:when test="${empty reportList}">
		<tr>
			<td colspan="4" align="center">신고된 편지가 없습니다</td>
		</tr>
	</c:when>
	<c:when test="${not empty reportList}">
	<c:forEach  var="reportList" items="${reportList}" varStatus="rNum" >
		<tr>
			<td>${reportList.rnum}</td>
			<td>${reportList.reporter}</td>
			<td>
			  <c:if test="${reportList.views==0 }">
				<input type="image" src="/images/icons/newMessage.jpg"" width="10px" />
			  </c:if>
			<a href="${contextPath}/admin/getReport.do?idx=${reportList.idx}">${reportList.title }</a>
			</td>
			<td>${reportList.sender}</td>
			<td>${reportList.regdate}</td>
		</tr>
		</c:forEach>
	</c:when>
</c:choose>
			</tbody>
		</table>
		  <br><center>  
         
   <div>
                    <c:if test="${paging.curPage > 1 }">
                        <a href="javascript:paging('${paging.curPage-1}')">[이전]</a> 
                    </c:if>
                   <c:if test="${paging.totalCount>0 }">
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
                   </c:if>
                    <c:if test="${paging.curPage != paging.totalPage && paging.totalPage> 0}">
                        <a href="javascript:paging('${paging.curPage+1}')">[다음]</a> 
                    </c:if>
            </div>			

	<br>
	<br>
</body>
</html>