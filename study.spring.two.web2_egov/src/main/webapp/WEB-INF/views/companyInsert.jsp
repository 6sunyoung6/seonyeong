<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	// html 연결
	/* $(document).ready(function(){
		$("#ok").click(function(){
			var params = $("#list").val();
			$.ajax({
				url: 'companyList.html',
				async: true,
				dataType:"html",
				type: 'get',
				contentType: 'application/json; charset=utf-8',
				
				success: function(params){
					console.log("성공");
					alert('성공');
					location.href="companyList.html";
				},
				error: function(){
					alret('실패');
				}
			});
		});
	});  */

	
	
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
<style type="text/css">
</style>
</head>
<body topmargin="0" leftmargin="0">

<form  action="insertCompany.do" method="post" enctype="multipart/form-data">
<table width="640" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td width="640">&nbsp;</td>
  </tr>
  
  <tr> 
    <td height="25"><img src="${pageContext.request.contextPath }/resources/image/icon.gif" width="9" height="9" align="absmiddle"> 
      <strong>회사 기본 정보 등록</strong></td>
        
  
        
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
                              	<input type="hidden" value="companyNo">
                                <input type="text" name="companyName"  >
                              </td>
                            </tr>
                            <tr>
                              <td height="26" align="right"><strong>주소 :&nbsp;</strong></td>
                              <td height="26"><input type="text" name="addr" ></td>
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
                            	<input type="radio" name="daepyoType" id="listButton" value="각자대표" onclick="div_OnOff(this.value,'con');">각자대표</br>
                            	<div style="display:none" id="con">
                            	</div> 
								<div id="listDiv"></div>
								 <input type="radio" id="test11" name="daepyoType" value="대표" checked="checked" onclick="div_OnOff(this.value,'con');">대표:&nbsp;
                              	<input type="text" name="daepyo" id="data1" readonly>&nbsp;
	                              	<button type="button">
	                              		<a href=javascript:openNewWindow("aaa.do") target="_blank">검색</a>
	                              	</button>
                              	</td>
                              
								</div>
                            	
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>홈페이지주소 :&nbsp;</strong></td>
                            <td width="392"><input name="homepage" type="text" size="20"> 
                            </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>기타 :&nbsp;</strong></td>
                            <td width="392"><input name="etc" type="text" size="20"> 
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
              <td width="49"><button type="submit" id="ok">확인</button></td>
              <td width="51"><button type="button" onClick="history.back()" >취소</button></td>
            </tr>
           
          </table>            </td>
        </tr>
        <tr> 	
          <td height="7" align="right">&nbsp;</td>
        </tr>
        
        <tr>
        
      </table></td>
  </tr>
</table>
</form>
<script type="text/javascript">

$("#listButton").click(function(){
	alert("성공");
	  $.ajax({
	          type: 'post'
	        , url: 'ccc.do'
	        , dataType : 'html'
	        , success: function(data) {
	        	$("#listDiv").html(data);
	          }
	  });	
})	

	$("#test11").click(function(){
		$(".test1").val("");
	});
</script>
</body>
</html>

