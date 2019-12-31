<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
<c:if test='${not empty msg }'>
<script>
window.onload=function()
{
  result();
}
function result(){
	alert("${msg}");
}
</script>
</c:if>
<script type="text/javascript">

function pageing(page) {
		location.href="${contextPath}/adminHome.do?curPage="+page;
		}
function block(value) {
		var pagePerBlock=${paging.blockSize} * (value-1) + 1;
		location.href="${contextPath}/adminHome.do?nowPage="+pagePerBlock;

		}
function logout()
		{
			if(confirm("로그아웃 하시겠습니까?")==true)
		{

			location.href="${contextPath}/member/logout.do";
		}
			else
		{
			return;
		}
		}


	</script>
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
  	<c:when test="${empty memberList}">
		<tr>
			<td colspan="5" align="center">등록된 회원이 없습니다 .</td>
		</tr>
	</c:when>
	<c:when test="${not empty memberList}">
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
		       <div>
                    <c:if test="${pagig.curBlock > 1 }">
                        <a href="javascript:block('${curBlock-1}')">[이전]</a> 
                    </c:if>
               
                    <c:forEach var="pageNum" begin="${paging.startPage }" end="${paging.endPage}">
                        <c:choose>
                            <c:when test="${pageNum  eq  paging.curPage}">
                              <font color="blue"><Strong>${pageNum}</Strong></font> 
                            </c:when>
                            <c:otherwise>
                                <a href="javascript:pageing('${pageNum}')">${pageNum }</a> 
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${paging.curPage ne paging.totalPage && paging.totalPage> 0}">
                        <a href="javascript:block('${curBlock+ 1}')">[다음]</a> 
                    </c:if>
                </div>	

	</body>
</html>