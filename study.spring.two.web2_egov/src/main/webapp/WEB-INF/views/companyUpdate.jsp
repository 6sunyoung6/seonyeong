<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.min.js"></script>

<script type="text/javascript">

function openNewWindow(window) {
	open (window,"NewWindow","left=0, top=0, toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, width=200, height=200");
}

function setChildValue(data1){
	// window.open("open할 window", "자식창 이름", "팝업창 옵션");
	document.getElementById("data1").value = data1;
}



/* 각자 대표 클릭시 아래 인풋박스 보이게 */
function div_OnOff(v,id){
	 // 라디오 버튼 value 값 조건 비교
	 if(v == "각자대표"){
	  document.getElementById(id).style.display = ""; // 보여줌
	 }else{
	  document.getElementById(id).style.display = "none"; // 숨김
	 }
	}
</script>

</head>
<body topmargin="0" leftmargin="0">
<form  action="companyUpdate1.do?pageNum=1" method="post" enctype="multipart/form-data">
<table width="640" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td width="640">&nbsp;</td>
  </tr>
  <tr> 
    <td height="25"><img src="${pageContext.request.contextPath }/resources/image/icon.gif" width="9" height="9" align="absmiddle"> 
      <strong>회사 기본 정보 수정</strong></td>
  </tr>
  <tr> 
    <td><table width="640" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td height="15" align="left"><table width="640" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td><table width="640" border="0" cellspacing="1" cellpadding="0">
                    <tr> 
                      <td height="2" background="${pageContext.request.contextPath }/resources/image/bar_bg1.gif"></td>
                    </tr>
                    <tr align="center" bgcolor="F8F8F8"> 
                      <td height="26" align="center" bgcolor="#E4EBF1" style="padding-right:10"><table width="600" border="0" cellspacing="0" cellpadding="0">
                          <tr> 
                            <td align="center"><strong></strong></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr align="center" bgcolor="F8F8F8"> 
                      <td height="3" align="right" background="${pageContext.request.contextPath }/resources/image/bar_bg1.gif"></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td height="6" align="center" valign="top">&nbsp;</td>
        </tr>
        <tr>
          <td height="7" align="center" valign="top"><table width="600" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td bgcolor="#CCCCCC"><table width="600" border="0" cellspacing="1" cellpadding="0">
                    <tr> 
                      <td height="135" align="center" bgcolor="#E4EBF1"><table width="600" border="0" cellpadding="0" cellspacing="0">
                        <tr>
                          <td width="144" height="119" align="center"><table width="100" border="0" cellspacing="0" cellpadding="0">
                            <tr>
                              
                            </tr>
                          </table></td>
                          <td width="456"><table width="423" border="0" cellspacing="2" cellpadding="0">
                            <tr>
                              <td height="2" colspan="2"></td>
                              </tr>
                            <tr>
                              <td width="107" height="26" align="right"><strong>회사명:</strong>&nbsp;</td>
                              <td width="310" height="26">
                              <input type="hidden" name = "companyNo" value="${dto.companyNo }">
                                <input type="text" name="companyName"  value="${dto.companyName }">
                              </td>
                            </tr>
                            <tr>
                              <td height="26" align="right"><strong>주소 :&nbsp;</strong></td>
                              <td height="26"><input type="text" name="addr" value="${dto.addr }"></td>
                            </tr>
                            
                          </table></td>
                        </tr>
                      </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td height="7" align="center" valign="top">&nbsp;</td>
        </tr>
        <tr> 
          <td height="13" align="center"><table width="600" border="0" cellspacing="0" cellpadding="0">
              <tr> 
                <td bgcolor="#CCCCCC"><table width="600" border="0" cellspacing="1" cellpadding="0">
                    
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                            <td width="102" align="right"><strong>대표구분 :&nbsp;</strong></td>
                            <td width="391">
                            	<input id="test10" type="radio" name="daepyoType" value="각자대표"  onclick="div_OnOff(this.value,'con');" <c:if test="${dto.daepyoType eq '각자대표' }">checked="checked"</c:if>>각자대표</br>
                            	
                            	<div style="display:block" id="con">
	                            	<input class="test1" type="text" name="daepyosName" value="${dto.daepyosName }">각자 대표 이름</br>
	                            	<input class="test2" type="text" name="daepyosAddress" value="${dto.daepyosAddress }">각자 대표 주소</br>
	                            	<input class="test3" type="text" name="jumin1" value="${dto.jumin1 }">주민번호</br>
                            	</div>
                            	
                              	<input type="radio" id="test11" name="daepyoType" value="대표" <c:if test="${dto.daepyoType eq '대표' }">checked="checked"</c:if>>대표
                              	<input type="text" name="daepyo" value="${dto.daepyo }" id="data1" readonly>&nbsp;
	                              	<button type="button">
	                              		<a href=javascript:openNewWindow("aaa.do") target="_blank">검색</a>
	                              	</button>
	                              	</td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>홈페이지주소 :&nbsp;</strong></td>
                            <td width="392"><input name="homepage" type="text" size="20" value="${dto.homepage }"> 
                            </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>기타 :&nbsp;</strong></td>
                            <td width="392"><input name="etc" type="text" size="20" value="${dto.etc }"> 
                            </td>
                          </tr>
                        </table></td>
                    </tr>
                  </table></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td height="3" align="center">&nbsp;</td>
        </tr>
        <tr>
          <td height="3" align="center"><table width="107" border="0" cellpadding="1" cellspacing="1">
            <tr>
              <td width="49"><button type="submit">확인</button></td>
              <td width="51"><button type="button" onClick="history.back()" >취소</button></td>
            </tr>
           
          </table>            </td>
        </tr>
        <tr> 	
          <td height="7" align="right">&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>
</form>
<script>
	$("#test11").click(function(){
		$(".test1").val("");
		$(".test2").val("");
		$(".test3").val("");
	});
</script>
</body>
</html>

