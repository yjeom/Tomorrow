<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

function paging(page) {
		location.href="${contextPath}/mail/sendWorryList.do?curPage="+page;
		}
function sendWorry(){
	var isLogOn ='<c:out value="${isLogOn}"/>';
	if(isLogOn){
		location.href="${contextPath}/mail/sendWorryForm.do";
	}
	else{
	alert("�α����� �ۼ��� �� �ֽ��ϴ�.");
	location.href="${contextPath}/member/loginForm.do";
	}
}
function sendReply(){
	var isLogOn ='<c:out value="${isLogOn}"/>';
	if(isLogOn){
		location.href="${contextPath}/mail/sendReplyList.do";
	}
	else{
	alert("�α����� �̿��� �� �ֽ��ϴ�.");
	location.href="${contextPath}/member/loginForm.do";
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
							<img src="/images/icons/paper-plane.png" width="35px" /><br><br>
							<h3>�� �� �� �� ��</h3>
								<p>������ ������� �� �����?<br>
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
  	<c:when test="${empty sendWorryList}">
		<tr>
			<td colspan="3" align="center">���� ���� ������ �����ϴ�.</td>
		</tr>
	</c:when>
	<c:when test="${not empty sendWorryList}">
	<c:forEach  var="sendWorryList" items="${sendWorryList}" varStatus="rNum" >
		<tr>
			<td>${sendWorryList.rnum}</td>
			<td><a href="${contextPath}/mail/getSendWorry.do?idx=${sendWorryList.idx}">${sendWorryList.title }</a></td>
			<td>${sendWorryList.regdate}</td>
			<td>${sendWorryList.views}</td>
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
                        <a href="javascript:paging('${paging.curPage+1}')">[����]</a> 
                    </c:if>
            </div>			

   <br>
   		  		<input type="button" class="button" value="���� ����" onclick="location='javascript:sendWorry()'">
   		  		<input type="button" class="button" value="���� ������" onclick="location='javascript:sendReply()'">
	<br>
	<br>
</body>
</html>