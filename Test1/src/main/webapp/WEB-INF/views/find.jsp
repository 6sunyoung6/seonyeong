<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	//window로드 됐을때, id가 btnFindUid / btnFindPW 인 것을 클릭하면 해당 함수 실행
	$(window).load(function() {
		$("#btnFindUid").click(btnFindUid);
		$("#btnFindPW").click(btnFindPW);
	});

	// btnFindUid를 클릭했을 때 실행되는 함수내용.
	function btnFindUid(event) {

		// id가 Email인 객체를 Email이라는 변수에 저장.
		var c_num = $("#c_num");

		// 변수 Email의 value가 공백("")이면 alert창(경고창) 띄우고 return false를 함.
		if (c_num.val() == "") {
			alert("카드 번호를 입력하세요");
			return;
		}

		var c_pwd = $("#c_pwd");
		if (name.val() == "") {
			alert("비밀번호를 입력하세요");
			return;
		}

		var c_pwd = $("#c_cvc");
		if (c_cvc.val() == "") {
			alert("cvc를 입력하세요");
			return;
		}
		// 해당 값들을 findIDResult.htm의 주소로 변수 Email과 name의 값들을 controller에 전달, 
		// 전달한 후 받은 익명의 function으로 controller로 부터 받은 결과값(result변수 값)을 alert창을 통해 출력.
		$.post("findIDResult.htm", {
			Email : Email.val(),
			name : name.val()
		}, function(data) {
			alert(eval(data).result);
		});
	}

	// 비밀번호 찾기
	function btnFindPW(event) {
		var id = $("#id");
		if (id.val() == "") {
			alert("아이디를 입력하세요");
			return;
		}

		var c_num = $("#c_num");
		if (c_num.val() == "") {
			alert("카드번호를 입력하세요");
			return;
		}

		var c_pwd = $("#c_pwd");
		if (c_pwd.val() == "") {
			alert("카드 비밀번호를 선택하세요");
			return;
		}

	}

	$.post("findPWResult.htm", {
		id : id.val(),
		name : name.val(),
		PwQ : PwQ.val(),
		PwA : PwA.val()
	}, function(data) {
		alert(eval(data).result);
	});}
 
</script>
</head>
<body>
	<table width="100%" border="0" cellspacing="0" cellpadding="0">
		<tr>
			<td bgcolor="#999999" style="padding: 5px 10px;" class="white12bold">카드</td>
		</tr>
	</table>
	<table width="450" border="0" cellspacing="0" cellpadding="0"
		class="grey12">
		<tr>
			<td style="padding: 20px 0 0 0">
				<table width="420" border="0" align="center" cellpadding="0"
					cellspacing="0">
					<tr>
						<td
							style="padding: 15px; border-top: 2px #cccccc solid; border-right: 2px #cccccc solid; border-bottom: 2px #cccccc solid; border-left: 2px #cccccc solid;">
							<form name="id_f" id="id_f" method="post" action="id_find_ok.php">
								<table width="380" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="stitle">아이디 찾기</td>
									</tr>
								</table>
								<table width="380" border="0" cellspacing="1" class="regtable">
									<tr>
										<td width="100" height="25" bgcolor="#f4f4f4">카드번호</td>
										<td width="130"><input type="text" name="c_num"
											id="c_num" tabindex="1" /></td>
									</tr>
									<tr>
										<td height="25" bgcolor="#f4f4f4">카드비밀번호</td>
										<td><input type="text" name="c_pwd" id="c_pwd"
											tabindex="2" /></td>
										<td rowspan="2" align="center"><div class="bts">
												<a href="javascript:id_search();" tabindex="4"><span
													style="width: 80px">아이디 찾기</span></a>
											</div></td>
									</tr>
									<tr>
										<td height="25" bgcolor="#f4f4f4">cvc</td>
										<td><input type="text" name="c_cvc" id="c_cvc"
											tabindex="2" /></td>
									</tr>
								</table>
							</form>



							<form name="pw_f" id="pw_f" method="post" action="pw_find_ok.php">
								<table width="380" border="0" cellspacing="0" cellpadding="0">
									<tr>
										<td class="stitle">비밀번호 찾기</td>
									</tr>
								</table>
								<table width="380" border="0" cellspacing="1" class="regtable">
									<tr>
										<td width="100" height="25" bgcolor="#f4f4f4">ID</td>
										<td width="130"><input type="text" name="mem_id"
											id="mem_id" tabindex="5" /></td>
										<td rowspan="2" align="center"><div class="bts">
												<a href="javascript:pw_search();" tabindex="8"><span
													style="width: 80px">비밀번호 찾기</span></a>
											</div></td>
									</tr>
									<tr>
										<td height="25" bgcolor="#f4f4f4">e-Mail</td>
										<td><input type="text" name="mem_email" id="mem_email"
											tabindex="6" /></td>
									</tr>
								</table>
							</form>



						</td>
					</tr>
				</table>
				<table border="0" align="right" cellpadding="0" cellspacing="0">
					<tr>
						<td height="40" style="padding: 0 13px 0 0">
							<div class="bts">
								<a href="javascript:self.close();"><span style="width: 50px">닫기</span></a>
							</div>
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>