<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
      
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>

<form action="<%=request.getContextPath()%>/login.do" method="post">

<table border="1" cellspacing="0">
	<tr>
		<td>���̵�</td><td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>��й�ȣ</td><td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="reset" value="�ٽ��Է�">
		<input type="submit" value="����">
		<a href="<%=request.getContextPath() %>/form.do">ȸ������</a></td>
	</tr>	
</table>
</form>
<a href="<%=request.getContextPath() %>/list.do">�Խù�����</a>


</body>
</html>