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
		location.href="${contextPath}/notice/noticeList.do?curPage="+page;
		}

	</script>
</head>
<body>
     <!-- Banner -->
         <section id="banner">
            <div class="inner">
               <div class="flex">               
                  <div>
                     <img src="/images/icons/microphone.png" width="30px" /><br><br>
                     <h3>�� �� �� ��</h3>
                        <p>�����ڰ� �����ϴ� ����Դϴ�.<br>
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
			<td colspan="4" align="center">��ϵ� ���������� �����ϴ� .</td>
		</tr>
	</c:when>
	<c:when test="${not empty noticeList}">
	<c:forEach  var="noticeList" items="${noticeList}" varStatus="rNum" >
		<tr>
			<td>${noticeList.rnum}</td>
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

   <br>
   		  <c:if test="${not empty member and member.id eq 'rhksflwk'}">
		  		<input type ="button" class="button" value="�ۼ��ϱ�" onclick="location='${contextPath}/notice/noticeForm.do'">
		  </c:if>
	<br>
	<br>
</body>
</html>