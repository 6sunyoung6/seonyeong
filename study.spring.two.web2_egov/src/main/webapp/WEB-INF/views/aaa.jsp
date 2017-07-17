<%@page import="org.springframework.web.servlet.ModelAndView"%>
<%@page import="study.spring.two.service.AaaService"%>
<%@page import="study.spring.two.dto.AaaDto"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!doctype html>
<html>
<head>
	<meta charset="utf-8" />
	<title>aaa 1인대표</title>
	<link href="${pageContext.request.contextPath }/resources/css/style.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath }/resources/css/bootstrap.css" rel="stylesheet" type="text/css">
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.1.1.min.js"></script>
<script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>

</head>
<body>
	<form method="post" id="frm" name="frm">
		<div class="container">
			<h3>1인대표</h3>
		</div>
		<table>
			<tr>
				<td>
					<select name="list" id="list" style="width: 70px; height: 30px; padding-left: 5px; margin-left: 20px;">
					
						<option value="" selected>대표</option>
						
						<c:forEach var="list" items="${list}" varStatus="i" >
							<option value="${list.data1 }">${list.data1 }</option>
							<a href="javascript:sendChildValue('${list.data1},')">${list.data1}</a>
						</c:forEach>
					</select>
				</td>
				<td>
					<!-- <input type="button" onClick="test1()"  value="확인">
					<input type="button" onClick="sendChildValue()"  value="확인2"> -->
					<input id="confirm_id" type="button" value="확인">
				<!-- 	<input type="button" onclick="test4()" value="종료4"> -->
				</td>
			</tr>
		</table>
	</form>
</body>
<script type="text/javascript">
	function test1()
	{
		document.frm.action="confirm.do";
		document.frm.submit();
		window.close();
	}
	
	
	function sendChildValue(data1)
	{
		document.frm.action="confirm.do";
		document.frm.submit();
		opener.setChildValue(data1);
	}
	
	
	$(function(){
		
		  $('#confirm_id').click(function(){
			  var selected = $("#list").val();
		     $('#data1',opener.document).val(selected); 
		    self.close();

		  });
		 });
	
	/* function test4(data1){
		opener.document.insertCompany.daepyo.value = data1;
		window.close();
	} */
	
	
	
	
	/* function sendChildValue(data1)
	{
		
		opener.setChildValue(data1);
		window.close();
	} */
	/* function test2()
	{
		window.opener.companyInsert.daepyo.data1 = data1;
		
		팝업창에서 부모창으로 값 넘기기
		1-1. 일반적인 방법
		window.opener.document.getElementById("parentId").value = "부모창으로 전달할 값";
		 
		1-2. 일반적인 방법
		window.opener.폼네임.parentInputName.value = value;
		 
		2. jQuery를 이용한 방법
		$("#parentEleId", parent.opener.document).val(부모창으로 전달할 값);
		$("#parentEleId", parent.opener.document).text(부모창으로 전달할 값);
		 
		3. find를 이용한 방법
		$(opener.document).find("#parentId").val(부모창으로 전달할 값);
	}*/
</script>
</html>
<!-- 
	부모창으로 값 넘어가는거 구현해야 함
 -->