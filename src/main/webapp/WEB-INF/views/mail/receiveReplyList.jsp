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
		location.href="${contextPath}/mail/receiveReplyList.do?curPage="+page;
		}
function receiveWorry(){
	var isLogOn ='<c:out value="${isLogOn}"/>';
	if(isLogOn){
		location.href="${contextPath}/mail/receiveWorryList.do";
	}
	else{
	alert("로그인후 이용할 수 있습니다.");
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
							<img src="/images/icons/contact.png" width="30px" /><br><br>
							<h3>받 은 답 장 함</h3>
							<p>누군가의 위로가 당신에게 도착했습니다.<br>
							 </p>							
						</div>
					</div>					
				</div>
			</section>
         <br>
     <table>
			<colgroup>
			<col width="20%" />
			<col width="60%" />
			<col width="20%" />
			</colgroup>
			<thead>
				<tr>
					<th>No.</th>
					<th>TITLE</th>
					<th>DATE</th>
				</tr>
			</thead>

			<tbody>

  <c:choose>
  	<c:when test="${empty receiveReplyList}">
		<tr>
			<td colspan="3" align="center">받은 답장 편지가 없습니다.</td>
		</tr>
	</c:when>
	<c:when test="${not empty receiveReplyList}">
	<c:forEach  var="receiveReplyList" items="${receiveReplyList}" varStatus="rNum" >
		<tr>
			<td>${receiveReplyList.rnum}</td>
			<td><a href="${contextPath}/mail/getReceiveReply.do?idx=${receiveReplyList.idx}">${receiveReplyList.title }</a></td>
			<td>${receiveReplyList.regdate}</td>
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
   		  		<input type="button" class="button" value="받은 고민함" onclick="location='javascript:receiveWorry()'">
	<br>
	<br>
</body>
</html>