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
<style type="text/css">
	table{width: 300px; border:1px solid gray; margin: 300px auto;}
	th{width:100px;}
	input[name]{border-radius: 5px; width: 200px; height: 30px;}
	button{border-radius: 5px; width:100%;margin-top: 5px;height: 30px; background-color:#46CCFF}
</style>
</head>
<body>
<form action="login.member">
	<table >
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
				<button type="submit">로그인</button>
				<button type="button" onclick="registForm()">회원가입</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>