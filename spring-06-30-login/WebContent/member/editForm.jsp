<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>�� ���� ����</h3>
<form action="<%=request.getContextPath()%>/edit.do" method="post">
	<table border="1" cellspacing="0">
		<tr>
			<td>���̵�</td><td><input type="text" name="id" readonly value="${m.id }"></td>
		</tr>
		<tr>
			<td>��й�ȣ</td><td><input type="text" name="pwd" value="${m.pwd }"></td>
		</tr>
		<tr>
			<td>�̸�</td><td><input type="text" name="name" value="${m.name }" readonly></td>
		</tr>
		<tr>
			<td>�����λ�</td><td><input type="text" name="msg" value="${m.msg }"></td>
		</tr>
		<tr>
			<td colspan="2" ><input type="submit" value="����"></td>
		</tr>
	</table>
</form>
</body>
</html>