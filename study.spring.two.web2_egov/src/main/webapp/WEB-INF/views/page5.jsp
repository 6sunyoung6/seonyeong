<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script type="text/javascript">
function execDaumPostcode(postcode_id, addr1_id, addr2_id) {
    new daum.Postcode({
        oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 각 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullAddr = ''; // 최종 주소 변수
            var extraAddr = ''; // 조합형 주소 변수

            // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
            if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                fullAddr = data.roadAddress;

            } else { // 사용자가 지번 주소를 선택했을 경우(J)
                fullAddr = data.jibunAddress;
            }

            // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
            if(data.userSelectedType === 'R'){
                //법정동명이 있을 경우 추가한다.
                if(data.bname !== ''){
                    extraAddr += data.bname;
                }
                // 건물명이 있을 경우 추가한다.
                if(data.buildingName !== ''){
                    extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('postcode_id').value = data.zonecode; //5자리 새우편번호 사용
            document.getElementById('addr1_id').value = fullAddr;

            // 커서를 상세주소 필드로 이동한다.
            document.getElementById('addr2_id').focus();
        }
    }).open();
}
</script>
</head>
<body topmargin="0" leftmargin="0">
<form action="update.do?pageNum=1" method="post" enctype="multipart/form-data">
<table width="640" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td width="640">&nbsp;</td>
  </tr>
  <tr> 
    <td height="25"><img src="${pageContext.request.contextPath }/resources/image/icon.gif" width="9" height="9" align="absmiddle"> 
      <strong>사원 기본 정보 수정</strong></td>
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
                            <td align="center"><strong>교육정보 | 자격증. 보유기술정보 | 프로젝트 
                              정보 |경력정보 | 근무정보</strong></td>
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
                              <td height="112" bgcolor="#CCCCCC"><table width="100" border="0" cellspacing="1" cellpadding="0">
                                  <tr>
                                   <td height="110" bgcolor="#FFFFFF"><img src="${pageContext.request.contextPath }/upload/${dto.img}" width="110"  height="112" alt="" /></td>
                                     <%-- <td height="110" bgcolor="#FFFFFF"><img src="D://egov-workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp3/wtpwebapps/study.spring.two.web/WEB-INF/upload/${dto.img}" width="110"  height="112" alt="" /></td>  --%>
                                  </tr>
                              </table></td>
                            </tr>
                          </table></td>
                          <td width="456"><table width="423" border="0" cellspacing="2" cellpadding="0">
                            <tr>
                              <td height="2" colspan="2"></td>
                              </tr>
                            <tr>
                              <td width="107" height="26" align="right"><strong>한글이름 :</strong>&nbsp;</td>
                              <td width="310" height="26">
                              	<input type="hidden" name="no" value="${dto.no }" />
                                <input type="text" name="kor_name"  value="${dto.kor_name }">
                              </td>
                            </tr>
                            <tr>
                              <td height="26" align="right"><strong>영문이름 :&nbsp;</strong></td>
                              <td height="26"><input type="text" name="eng_name" value="${dto.eng_name }" ></td>
                            </tr>
                            <tr>
                              <td height="26" align="right"><strong>한문이름 :&nbsp;</strong></td>
                              <td height="26"><input type="text" name="han_name" value="${dto.han_name }" ></td>
                            </tr>
                            <tr>
                              <td height="26" align="right"><strong>주민등록번호 :</strong>&nbsp;</td>
                              <td height="26"><input name="jumin1" type="text" size="15" value="${dto.jumin1 }">
      						-
        					<input name="jumin2" type="text" size="15" value="${dto.jumin2 }"></td>
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
                      <td bgcolor="#E4EBF1"><table width="526" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="102" align="right"><strong>사진파일명 :&nbsp;</strong></td>
                            <td width="268"><input name="file" type="file" size="40" value=""></td>
                            <td width="146"><font color="#FF0000">
                            	
                            </td>
                            
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="102" align="right"><strong>생년월일 :&nbsp;</strong></td>
                            <td width="391"><input name="b_year" type="text" size="10" value="${dto.b_year }">
                              년 
                              <input name="b_month" type="text" size="7" value="${dto.b_month }">
                              월 
                              <input name="b_day" type="text" size="7" value="${dto.b_day }">
                              일 ( 
                              <input type="radio" name="calender" value="1" <c:if test="${dto.calender eq 1 }">checked="checked"</c:if>>
                              양력 
                              
                              <input type="radio" name="calender" value="2" <c:if test="${dto.calender eq 2 }">checked="checked"</c:if>>
                              음력 )</td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="102" align="right"><strong>성별 :&nbsp; </strong></td>
                            <td width="391"> <input type="radio" name="gender" value="1" <c:if test="${dto.gender eq 1 }">checked="checked"</c:if>>
                              남자 
                              <input type="radio" name="gender" value="2" <c:if test="${dto.gender eq 2 }">checked="checked"</c:if>>
                              여자</td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="102" align="right"><strong>결혼유무 :&nbsp;</strong></td>
                            <td width="391"> <input type="radio" name="marry" value="1" <c:if test="${dto.marry eq 1 }">checked="checked"</c:if>>
                              기혼 
                              <input type="radio" name="marry" value="2" <c:if test="${dto.marry eq 2 }">checked="checked"</c:if>>
                              미혼</td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>년차 :&nbsp;</strong></td>
                            <td width="392"><input name="work_date" type="text" size="10" value="${dto.work_date }"> 
                            </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>급여 지급유형 :&nbsp;</strong></td>
                            <td width="392"> <select name="sal_type">
                                <option value="1" <c:if test="${dto.sal_type eq 1 }">selected</c:if>>월급</option>
                                <option value="2" <c:if test="${dto.sal_type eq 2 }">selected</c:if>>주급</option>
                              </select> </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>근무 :&nbsp;</strong></td>
                            <td width="392"> <select name="work_type">
                                <option value="1" <c:if test="${dto.work_type eq 1 }">selected</c:if>>SI</option>
                                <option value="2" <c:if test="${dto.work_type eq 2 }">selected</c:if>>SM</option>
                              </select> </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>상태 :&nbsp;</strong></td>
                            <td width="392"> <select name="work_state">
                                <option value="1" <c:if test="${dto.work_state eq 1 }">selected</c:if>>정규직</option>
                                <option value="2" <c:if test="${dto.work_state eq 2 }">selected</c:if>>계약직</option>
                              </select> </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                    <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr>
                          	<td width="101" align="right">
                          		<input type="text" name="postcode" id="postcode_id" value="${dto.postcode }">
                          		<!-- 클릭시, JavaScript 함수 호출: openDaumPostcode() -->
                          		<input type="button" value="우편번호 찾기" onclick='execDaumPostcode("postcode", "addr1", "addr2")'>
                          	</td>
                          </tr>
                          
                          <tr> 
                            <td width="101" align="right"><strong>주소 :&nbsp;</strong></td>
                            <td width="392">
                            	<input id="addr1_id" name="addr1" type="text" size="10" value="${dto.addr1 }"> 
                            	<input id="addr2_id" name="addr2" type="text" size="40"value="${dto.addr2 }"> 
                            </td>
                          </tr>
                        </table></td>
                      <%-- <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>주소 :&nbsp;</strong></td>
                            <td width="392"><input name="addr1" type="text" size="10" value="${dto.addr1 }"> 
                              <input name="addr2" type="text" size="40" value="${dto.addr2 }"> 
                            </td> --%>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>연락처 :&nbsp;</strong></td>
                            <td width="392"><input name="tel1" type="text" size="10" value="${dto.tel1 }">
                              - 
                              <input name="tel2" type="text" size="10"  value="${dto.tel2 }">
                              - 
                              <input name="tel3" type="text" size="10" value="${dto.tel3 }"></td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>이메일 :&nbsp;</strong></td>
                            <td width="392"><input name="email" type="text" size="20" value=${dto.email }> 
                            </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>기술등급 :&nbsp;</strong></td>
                            <td width="392"><input name="tech" type="text" size="20" value="${dto.tech }"> 
                            </td>
                          </tr>
                        </table></td>
                    </tr>
                    <tr> 
                      <td bgcolor="#E4EBF1"><table width="500" border="0" cellspacing="1" cellpadding="1">
                          <tr> 
                            <td width="101" align="right"><strong>주량 :&nbsp;</strong></td>
                            <td width="392"><input name="drink" type="text" size="20" value="${dto.drink }"> 
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
              <td width="51"><button type="button" onClick="history.back()">취소</button></td>
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
</body>
</html>

