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

function paging(page) {
		location.href="${contextPath}/adminHome.do?curPage="+page;
		}
function logout()
		{
			if(confirm("�α׾ƿ� �Ͻðڽ��ϱ�?")==true)
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
							<h3>�Ű�����</h3>
							
						</div>
						<div>
							<input type="image" src="/images/icons/question2.png" width="35px" onclick="location.href='${contextPath}/qna/qnaList.do'"/>
							<h3>QnA����</h3>
						</div>

						<div>
							<input type="image" src="/images/icons/microphone.png" width="35px"  onclick="location.href='${contextPath}/notice/noticeList.do'"/>
							<h3>��������</h3>
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
			<td colspan="5" align="center">��ϵ� ȸ���� �����ϴ� .</td>
		</tr>
	</c:when>
	<c:when test="${not empty memberList}">
	<c:forEach  var="memberList" items="${memberList}" varStatus="rNum" >
		<tr>
			<td>${memberList.rnum}</td>
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
                    <c:if test="${paging.curPage > 1 }">
                        <a href="javascript:paging('${paging.curPage-1}')">[����]</a> 
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
                        <a href="javascript:paging('${paging.curPage+1}')">[����]</a> 
                    </c:if>
                </div>		

	</body>
</html>