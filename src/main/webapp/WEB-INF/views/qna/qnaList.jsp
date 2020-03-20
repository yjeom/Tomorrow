<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script type="text/javascript">
var contextPath= '<c:out value="${contextPath}"/>';
function paging(page) {
	location.href=contextPath+"/qna/qnaList.do?curPage="+page;
	}
function myPaging(page,idx) {
		location.href=contextPath+"/qna/myQnaList.do?idx="+idx+"&curPage="+page;
	}
function qna(){
		location.href=contextPath+"/qna/qnaForm.do";
}

</script>
<head>
	<meta charset="utf-8" />


<title>QnA 목록 : Tomorrow is...</title>
</head>
<body>
			<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/tomorrow/resources/images/icons/question.png" width="30px" /><br><br>
							<h3>QnA</h3>
							<p>문의사항은 언제든 환영합니다.<br>
							 </p>
						
					</p>
				</div>
			</div>
		</div>
		</section>
		<br>
		<a class="qnaList" href="${contextPath }/qna/myQnaList.do?idx=${member.idx}" style="text-decoration: none; color:gray; 
        margin-left: 1285px;">내 QnA만 보기</a>
        <br>
        <br>
		<table>
			<colgroup>
			<col width="10%" />
			<col width="70%" />
			<col width="10%" />
			<col width="10%" />
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
		<c:when test="${not empty qnaList}">
			<c:forEach var="qnaList" items="${qnaList}" varStatus="rNum">
				<tr>
					<td>${qnaList.rnum}</td>
					<td>
					<c:choose>
						<c:when test="${qnaList.secret_yn==1}">
							<img src="/tomorrow/resources/images/icons/lock.png" width="15px"/><span style=padding-left:10px></span>
							<a href="${contextPath}/qna/passwordForm.do?idx=${qnaList.idx}">${qnaList.title}</a>
						</c:when>
						<c:otherwise>
							<a href="${contextPath}/qna/getQna.do?idx=${qnaList.idx}">${qnaList.title}</a>
						</c:otherwise>
					</c:choose>
						<c:if test="${qnaList.reply_count>0 }">
						<span style=padding-left:5px></span>
						<img src="/tomorrow/resources/images/icons/comment.png" width="15px"/>
						<span style=padding-left:3px></span>${qnaList.reply_count}
						</c:if>
						
					</td>
					<td>${qnaList.regdate}</td>			
					<td>${qnaList.views}</td>
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
<c:choose>
	<c:when test="${isMy==true}">
	<div>
                    <c:if test="${paging.curPage > 1 }">
                        <a href="javascript:myPaging('${paging.curPage-1}','${member.idx}')">[이전]</a> 
                    </c:if>
                    <c:forEach var="pageNum" begin="${paging.startPage }" end="${paging.endPage}">
                        <c:choose>
                            <c:when test="${pageNum  eq  paging.curPage}">
                              <font color="blue"><Strong>${pageNum}</Strong></font> 
                            </c:when>
                            <c:otherwise>
                                <a href="javascript:myPaging('${pageNum}'),'${member.idx}'">${pageNum }</a> 
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    <c:if test="${paging.curPage != paging.totalPage && paging.totalPage> 0}">
                        <a href="javascript:myPaging('${paging.curPage+1}','${member.idx}')">[다음]</a> 
                    </c:if>
</div>	
	</c:when>
	<c:otherwise>
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
	</c:otherwise>
</c:choose>			

	<br>
			<input type="button" value="글 작성" onclick="location='javascript:qna()'">
			
		<br><br>
		

	</div>
</body>
</html>