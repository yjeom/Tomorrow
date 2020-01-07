<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
<!--  
<c:if test="${isLogOn ==null}">
  <script type="text/javascript">
    alert("세션만료로 로그아웃되었습니다.");
    location.href = "${contextPath}/member/logout.do";
    </script>
 </c:if>
-->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8" />

<title>QnA : Tomorrow is...</title>
<script type="text/javascript">

function inputCheck() {
	if (document.reFrm.reply.value=="") {
		alert("내용을 입력해주세요.");
		document.reFrm.reply.value = "";
		document.reFrm.reply.focus();
		return false;
	}
	else {
		document.reFrm.action="${contextPath}/qna/insertReply.do";
		document.reFrm.submit();
	}
}
function delete_(){
	var ok=confirm("게시물을 삭제 하시겠습니까?");
	if (ok) {
		location.href= "${contextPath}/qna/deleteQna.do?idx=${qna.idx}";
	} 
}
function update_(){
	location.href="${contextPath}/qna/qnaForm.do?idx=${qna.idx}";
}
function ReplyDel(idx){

	document.delReFrm.ridx.value=idx;
	if (confirm("댓글을 삭제 하시겠습니까?")) {
		document.delReFrm.action = "${contextPath}/qna/deleteReply.do?idx="+idx;
		document.delReFrm.submit();
	} 
}
function updateRe_(idx){
	alert("댓글을 수정하시겠습니까?");
	document.updateReFrm.idx.value=idx;
	document.updateReFrm.action="${contextPath}/qna/updateReply.do?idx="+idx;
	document.updateReFrm.submit();
}
function list() {
	document.listFrm.action= "3.QnARead.jsp";
	document.listFrm.submit();
	}
	function paging(value) {
		
		location.href="${contextPath}/qna/getQna.do?idx=${qna.idx}&curPage="+value;
		}
	function block(value) {
		var pagePerBlock=${paging.blockSize} * (value-1) + 1;
		location.href="${contextPath}/qna/getQna.do?idx=${qna.idx}&curPage="+pagePerBlock;

		}

</script>

</head>
<body>

		
<!-- Banner -->
		<section id="banner">
		<div class="inner">
			<div class="flex">
				<div>
					<img src="/images/icons/question.png" width="30px" /><br><br>
							<h3>QnA 읽기</h3>
							<p>문의해주셔서 감사합니다.<br>
							 </p>
						
					</p>
				</div>
			</div>
		</div>
		</section>

	<div class="inner">
			<div class="field">
				<br><br><br>
				<table>
					<tr style=" border:0px;">
						<td col width="10%"><label for="name">작성자</label></td>
						<td col width="10%"><input type="text" size="350" value="${qna.writer}" readonly></td>
						<td col width="10%"><label for="name">문의 제목</label></td>
						<td col width="80%"><input type="text" size="350" value="${qna.title }" readonly></td>
					</tr>
				</table>
				<br><br>
					<label for="name">문의 내용</label>
					<textarea rows="15"  name="content" id="content" readonly>${qna.content}</textarea>
			<p>
			<p>
			</div>
			</div>
				<center>			
				<c:if test="${qna.writer_idx==member.idx }">
						<a href="javascript:update_()"><font color="grey" size="4pt">수정</a> </font>
						<a href="javascript:delete_()"><font color="red" size="4pt">삭제</a> </font>
				</c:if>
				</center>
<center><br>
			<hr style="border:solid 1px grey; width:97%;">
	
<form name="listFrm" method="post" >
<input type="hidden" name="reload" value="true">
<input  type="hidden" name="nowPage" value="1">
</form>
		
			<br>			

		<table>
			<colgroup>
				<col width="10%" />
				<col width="82%" />
				<col width="8%" />
			</colgroup>	
			<tbody>
	<c:choose>
		<c:when test="${not empty reList}">
			<c:forEach var="reList" items="${reList}" varStatus="rNum">
			<tr style="background-color:white; border:0px;">
				<c:choose>
					<c:when test="${reList.writer=='rhksflwk' }">
						<td align="right"><br>관리자</td>
					</c:when>
					<c:otherwise>
					<td align="right"><br>${reList.writer}</td>
					</c:otherwise>
				</c:choose>
				<td align="right"><textarea style="background-color:white; border:solid 2px #6cc091; color:black" rows="2" 
					name="content" id="content" readonly>${reList.content}</textarea></td>
				<td align="center">${reList.regdate }<br><br>
				<c:if test='${member.idx==reList.writer_idx}'>
					<a href="javascript:updateRe_('${reList.idx }')"><font color="grey" size="4pt">수정</a></font>
					<a href="javascript:ReplyDel('${reList.idx }')"><font color="red" size="4pt">삭제</a></font>
				</c:if>
				</td>
			</tr>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<tr>
				<td colspan="3" align="center">등록된 답변이 없습니다 .</td>
			</tr>
		</c:otherwise>
	</c:choose>

			</tbody>
		</table>	

		<center>
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
			


<form name="reFrm" action="${contextPath}/qna/insertReply.do" method="post" >
<center><br><br>
			<table>
			<colgroup>
				<col width="95%" />
				<col width="5%" />
			</colgroup>
			<tr style="background-color:white; border:0px;"><td align="left">
				<textarea style="background-color:white; color:black; border:solid 1px grey; width:100%;" rows="3" name="content" id="content"></textarea>
				</td><td align="left"><br><input type="submit" value="등록" onclick="inputCheck()"></td>
					
				</table><br>
					
			<input type="button" class="QnA" value="목록으로" onclick="location.href='${contextPath}/qna/qnaList.do'">
</center>
<input type="hidden" name="qna_idx" value="${qna.idx}">
<input type="hidden" name="writer_idx" value="${member.idx}">
</form>	
		
<form name="updateReFrm" method="get">
<input type="hidden" name="qna_idx" value="${qna.idx}">
<input type="hidden" name="curPage" value="${paging.curPage }">
</form>
<form name="delReFrm" method="get">
<input type="hidden" name="qna_idx" value="${qna.idx}">
<input type="hidden" name="curPage" value="${paging.curPage }">
</form>		

	<script type="text/javascript">
		window.history.forward();
		function noBack() {
			window.history.forward();

		}

         </script>	
</body>
</html>