<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/regist.css"/>
<script type="text/javascript">
	function isPassword(form){
	//		alert(form.password.value);
		if(form.password.value!=form.password2.value){
			alert("비밀번호를 확인하세요");
			form.password.value="";//비밀번호 입력값 초기화
			form.password2.value="";//비밀번호 입력값 초기화
			form.password.focus();//바로 입력할 수 있게 커서 넣어주기
			return false;//유효하지 않은 값이 존재하면 submit 이벤트를 취소시켜야 한다!!
		}
	}
</script>
</head>
<body>
<form class="form-group" action="regist.member" method="post"
      onsubmit="return isPassword(this)">
	<h1>회원가입</h1>
	<span>${param.msg}</span>
	<input required="required" type="email" name="email" 
		id="inputPassword3" placeholder="email">
	<input required="required" type="text" name="name"  id="inputPassword3" placeholder="이름">
	<input required="required" type="password" name="password" 
		id="inputPassword3" placeholder="Password">
	<input required="required" type="password" name="password2" 
		id="inputPassword3" placeholder="Password 확인">
	<input required="required" type="text" name="address" 
		id="inputPassword3" placeholder="주소">
	<input required="required" type="text" name="phone" 
		id="inputPassword3" placeholder="전화번호">	
	<button type="submit" >가입 완료</button>
	<button type="button"  
		onclick="location.href='main.item'">메인</button>
</form>
</body>
</html>