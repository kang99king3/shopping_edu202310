<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function registForm(){
		location.href="registForm.member";
	}
</script>
</head>
<body>
<form action="login.member">
	<table border="1">
		<tr>
			<th>아이디</th>
			<td><input type="email" name="email" /></td>
		</tr>
		<tr>
			<th>패스워드</th>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" value="로그인" />
				<input type="button" value="회원가입" onclick="registForm()" />
			</td>
		</tr>
	</table>
</form>
</body>
</html>