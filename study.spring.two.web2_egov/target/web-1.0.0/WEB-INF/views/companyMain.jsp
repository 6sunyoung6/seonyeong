<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<META HTTP-EQUIVE="CONTENT-TYPE" CONTENT="TEXT/HTML; CHARSET=UTF-8">
<link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script type="text/javascript" src="js/jquery.battatech.excelexport.js"></script>

</head>
<body topmargin="0" leftmargin="0">

<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td height="25"><img src="${pageContext.request.contextPath }/resources/image/icon.gif" width="9" height="9" align="absmiddle"> 
      <strong>사원조회</strong> <a href="login">로그인</a></td>
  </tr>
  <tr> 
    <td><table width="640" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td height="30" align="right">
          <form action="search2.do?pageNum=1" method="post" id="keywordForm">
          	<select name="searchOption" class="INPUT">
              <option value="all" <c:out value="${map.searchOption eq 'all'?'selected':'' }"/> >전체</option>
              <option value="companyName" <c:out value="${map.searchOption eq 'companyName'?'selected':'' }"/> >회사이름</option>
              <option value="companyNo" <c:out value="${map.searchOption eq 'companyNo'?'selected':'' }"/> >성별</option>
              <option value="daepyoName" <c:out value="${map.searchOption eq 'daepyoName'?'selected':'' }"/> >기술등급</option>
            </select>
            <input name="keyword" type="text" class="INPUT" value="${map.keyword }">
           
           <%-- <select name="searchOption2" class="INPUT">
              <option value="all2" <c:out value="${map.searchOption2 eq 'all2'?'selected':'' }"/> >전체</option>
              <option value="jumin1" <c:out value="${map.searchOption2 eq 'jumin1'?'selected':'' }"/> >주민앞번호</option>
              <option value="work_state" <c:out value="${map.searchOption2 eq 'work_state'?'selected':'' }"/> >상태</option>
              <option value="work_type" <c:out value="${map.searchOption2 eq 'work_type'?'selected':'' }"/> >근무</option>
            </select> 
            <input name="keyword2" type="text" class="INPUT" value="${map.keyword2 }"> --%>
            
            <button type="submit">검색</button>
            </form>
      </tr>
        <tr> 
          <td><table width="640" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td height="3" background="${pageContext.request.contextPath }/resources/image/bar_bg1.gif"></td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="26" align="right" bgcolor="F8F8F8" style="padding-right:10"><img src="${pageContext.request.contextPath }/resources/image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a onclick="deleteUpdate(1)" href="javascript:">삭제</a> <img src="${pageContext.request.contextPath }/resources/image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">인사기록카드</a> <img src="${pageContext.request.contextPath }/resources/image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">경력정보</a> <img src="${pageContext.request.contextPath }/resources/image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">근무정보</a> </td>
                  
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="1" align="right" bgcolor="B1B1B1"></td>
              </tr>
              <tr> 
                <td>
				<!-------------------------  리스트 ------------------------------>
				<form name="updateDelete" method="get">
				<table width="640" border="0" cellspacing="0" cellpadding="0">		
					<tr> 
                      <td width="35" height="20" align="center"></td>
                      <td width="85" align="center">회사고유번호</td>
                      <td width="153" align="center">회사명</td>
                      <td width="91" align="center">주소</td>
                      <td width="91" align="center">대표구분</td>
                      <td width="91" align="center">홈페이지주소</td>
                    </tr>
				<c:forEach var="tmp" items="${map.testList }">
                    <tr> 
                      <td width="35" height="20" align="center"><input type="checkbox" name="check_sub" value="${tmp.companyNo }"></td>
                      <td width="85" align="center">${tmp.companyNo }</td>
                      <td width="153" align="center">${tmp.companyName}</td>
                      <td width="91" align="center">${tmp.addr }</td>
                      <td width="91" align="center">${tmp.daepyeType }</td>
                      <td width="91" align="center">${tmp.homepage }</td>
                    </tr>
                    <tr> 
                      <td colspan="7" background="${pageContext.request.contextPath }/resources/image/line_bg.gif"></td>
                    </tr>
				</c:forEach>
                    <tr> 
						<td colspan="7" align="center">
							<nav aria-label="Page navigation" class="paging">
							<ul class="pagination">
								<c:choose>
									<c:when test="${startPageNum ne 1 }">
										<li>
											<a href="companyMain.do?pageNum=${startPageNum - 1 }&keyword=${map.keyword }" aria-label="Previous">
												<span aria-hidden="true">&laquo;</span>
											</a>
										</li>
									</c:when>
									<c:otherwise>
										<li class="disabled">
											<a href="javascript:;" aria-label="Previous">
												<span aria-hidden="true">&laquo;</span>
											</a>
										</li>
									</c:otherwise>
								</c:choose>
								<c:forEach var="i" begin="${startPageNum }" end="${endPageNum }">
									<li <c:if test="${i eq pageNum}">class="active"</c:if>><a href="companyMain.do?pageNum=${i }&keyword=${map.keyword }">${i }</a></li>
								</c:forEach>
								<c:choose>
									<c:when test="${endPageNum lt totalPageNum }">
										<li>
											<a href="companyMain.do?pageNum=${endPageNum + 1 }&keyword=${map.keyword }" aria-label="Previous">
												<span aria-hidden="true">&raquo;</span>
											</a>
										</li>
									</c:when>
									<c:otherwise>
										<li class="disabled">
											<a href="javascript:;" aria-label="Next">
												<span aria-hidden="true">&raquo;</span>
											</a>
										</li>
									</c:otherwise>
								</c:choose>
							</ul>
						</nav>
						</td>
                    </tr>
                  </table>
                  </form>
                  
 				<!-------------------------  리스트 ------------------------------>
				  </td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="1" align="right" bgcolor="B1B1B1"></td>
              </tr>
              <tr align="center" bgcolor="F8F8F8"> 
                <td height="26" align="right" bgcolor="F8F8F8" style="padding-right:10"><img src="${pageContext.request.contextPath }/resources/image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a onclick="deleteUpdate(2)" href="javascript:">수정</a> <img src="${pageContext.request.contextPath }/resources/image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">인사기록카드</a> <img src="${pageContext.request.contextPath }/resources/image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">경력정보</a> <img src="${pageContext.request.contextPath }/resources/image/all_icon.gif" width="11" height="11" align="absmiddle"> 
                  <a href="#">근무정보</a> </td>
              </tr>
              <tr>
            	<td width="49" align="right">
            	<!-- <input type="button" value="엑셀다운로드" onclick="goExcel()"/> -->
            		<button onclick="deleteUpdate(3)" id="deleteUpdate(3)" type="button">download</button>
            		<button onclick="upload()" type="button">업로드</button>
            		<%-- <button type="button">엑셀업로드</button>
            		<button type="button">엑셀다운로드</button>
            	</td>
            	<form name = "excelData">
            		<input type="text" name="table" value="${searchOption.table }">
            	</form> --%>
            </tr>
            </table></td>
        </tr>
        <tr> 
          <td height="3" background="${pageContext.request.contextPath }/resources/image/bar_bg1.gif"></td>
        </tr>
         
      </table></td>
  </tr>
</table>

<script type="text/javascript">

function upload(){
	alert("업로드를 하시겠습니까?");
	return false;
}

function deleteUpdate(index){
	if($("input[name=check_sub]").is(":checked")==0){
		alert("삭제 혹은 수정을 하시려면 1개 이상 선택하세요!");
		}
		else{
			if(index==1){
				if(confirm("삭제하시겠습니까?")){
					document.updateDelete.action = "delete.do";
				}else{
					return false;
				}
			}
			if(index==2){
				if(confirm("수정하시겠습니까?")){
					document.updateDelete.action = "updateform.do";
				}else{
					return false;
				}
			}
			
			if(index==3){
				if(confirm("다운로드하시겠습니까?")){
					document.updateDelete.action = "excel.do";
				}else {
					return false;
				}
			}
			
			if(index==4){
				if(confirm("업로드하시겠습니까?")) {
					document.updateDelete.action = "#";
				} else {
					return false;
				}
			}
		
		}
		document.updateDelete.submit();
	}
		
function send()
  {
   var result="";
  
   for (i=0; i<document.deleteUpdate.check_sub.length; i++ )
   {
    //체크된 값을 result변수에 누적(문자열)
    if (document.deleteUpdate.check_sub[i].checked==true)
     {
      result +=document.deleteUpdate.check_sub[i].value+"\n";
     }
   }
   //선택된 것 이 없으면 
   if (result=="")
   {
   alert("아무것도 선택하지 않으셨습니다");
   }
   //하나라도 선택이 됐으면 
   else 
   {
   alert(result);
   }
  }
	
</script>
</body>
</html>

