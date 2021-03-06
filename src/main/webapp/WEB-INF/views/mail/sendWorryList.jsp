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
var contextPath= '<c:out value="${contextPath}"/>';
function paging(page) {
		location.href=contextPath+"/mail/sendWorryList.do?curPage="+page;
		}
function sendWorry(){
	var isLogOn ='<c:out value="${isLogOn}"/>';
	if(isLogOn){
		location.href=contextPath+"/mail/sendWorryForm.do";
	}
	else{
	alert("로그인후 작성할 수 있습니다.");
	location.href=contextPath+"/member/loginForm.do";
	}
}
function sendReply(){
	var isLogOn ='<c:out value="${isLogOn}"/>';
	if(isLogOn){
		location.href=contextPath+"/mail/sendReplyList.do";
	}
	else{
	alert("로그인후 이용할 수 있습니다.");
	location.href=contextPath+"/member/loginForm.do";
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
							<h3>보 낸 고 민 함</h3>
								<p>고민을 비워내니 좀 어떤가요?<br>
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
			<td colspan="3" align="center">보낸 고민 편지가 없습니다.</td>
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
   		  		<input type="button" class="button" value="고민 비우기" onclick="location='javascript:sendWorry()'">
   		  		<input type="button" class="button" value="보낸 답장함" onclick="location='javascript:sendReply()'">
	<br>
	<br>
</body>
</html>