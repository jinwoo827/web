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
		<td>아이디</td><td><input type="text" name="id"></td>
	</tr>
	<tr>
		<td>비밀번호</td><td><input type="password" name="pwd"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="reset" value="다시입력">
		<input type="submit" value="전송">
		<a href="<%=request.getContextPath() %>/form.do">회원가입</a></td>
	</tr>	
</table>
</form>
<a href="<%=request.getContextPath() %>/list.do">게시물보기</a>


</body>
</html>