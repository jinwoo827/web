<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
	function getXMLHttpRequest() {
	if (window.ActiveXObject) {
		try {
			return new ActiveXObject("Msxml2.XMLHTTP");
		} catch(e) {
			try {
				return new ActiveXObject("Microsoft.XMLHTTP");
			} catch(e1) { return null; }
		}
	} else if (window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else {
		return null;
	}
}
var httpRequest = null;

	function sendRequest(url, params, callback, method) {
	httpRequest = getXMLHttpRequest();
	var httpMethod = method ? method : 'GET';
	if (httpMethod != 'GET' && httpMethod != 'POST') {
		httpMethod = 'GET';
	}
	var httpParams = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if (httpMethod == 'GET' && httpParams != null) {
		httpUrl = httpUrl + "?" + httpParams;
	}
	httpRequest.open(httpMethod, httpUrl, true);
	httpRequest.setRequestHeader(
		'Content-Type', 'application/x-www-form-urlencoded');
	httpRequest.onreadystatechange = callback;
	httpRequest.send(httpMethod == 'POST' ? httpParams : null);
}

	function check(){
		sendRequest("<%=request.getContextPath()%>/check.do?id=" + f.id.value,null, check_res, "GET");
	}
	function check_res() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var check_div = document.getElementById("check_div");
				check_div.innerHTML = httpRequest.responseText;
			}
		}
	}
</script>
</head>
<body>
<h3>ȸ������</h3>
	<form action="<%=request.getContextPath()%>/insert.do" method="post"
		name="f">
		<table border="1" cellspacing="0">
			<tr>
				<td>���̵�</td>
				<td><input type="text" name="id"><br> <input
					type="button" value="�ߺ�üũ" onclick="check()">
					<div id="check_div"></div></td>
			</tr>
			<tr>
				<th>��й�ȣ</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			<tr>
				<th>�̸�</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>�����λ�</th>
				<td><input type="text" name="msg"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="reset" value="�ٽ��Է�"> <input
					type="submit" value="����"></td>
			</tr>
		</table>
		<!-- <input type="hidden" name="type" value="insert"> -->
	</form>

</body>
</html>