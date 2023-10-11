<%@page import="com.edu.shop.dtos.ItemDto"%>
<%@page import="java.util.List"%>
<%@page import="com.edu.shop.dtos.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>    
<%response.setContentType("text/html; charset=utf-8"); %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<% 
	MemberDto ldto=(MemberDto)session.getAttribute("ldto"); 
	
	List<ItemDto> list=(List<ItemDto>)request.getAttribute("list");
%>
<body>
<h1>Shopping Mall</h1>
<div id="header">
	<nav>
		<ul class="navbar-nav mr-auto  mt-2 mt-lg-0">
		<%
			if(ldto==null||ldto.getEmail()==null){ 
				%>
				 <li class="nav-item" ><a class="nav-link" href="loginForm.member">로그인</a></li>
				 <%
			}else {
				if(ldto.getRole().equals("ADMIN")){
				%>
			        <li class="nav-item" ><a class="nav-link" href="addItemForm.item">상품등록</a></li> 
				    <li class="nav-item" ><a class="nav-link" href="admin/items">상품 관리</a></li>				
				<%
				}else if(ldto.getRole().equals("USER")){
					%>
				    <li class="nav-item" ><a class="nav-link" href="cart">장바구니</a></li>
				    <li class="nav-item" ><a class="nav-link" href="orders">구매이력</a></li>					
					<%
				}
				%>
				    <li class="nav-item" ><a class="nav-link" href="logout.member">로그아웃</a></li>				
				<%
			}
		%>
      </ul>
	</nav>
</div>
<%
	if(ldto!=null){
		%>
		<span><%=ldto.getEmail()%> | <%=ldto.getRole() %></span>
		<%
	}
%>
<div class="itemList">
	<%
		if(list==null||list.size()==0){
			out.print("<div class='items'><span>등록된 상품이 없습니다.</span></div>");
		}else{
			%>
			<div class="items" style="width:1350px;">
				<%
					for(ItemDto dto:list){
						%>
						<div class="item" style="display: inline-block;width: 250px;margin:5px;">
							<a href="detail.item?item_id=<%=dto.getItem_id()%>">
								<img width="250px" height="300px" src="https://atimg.sonyunara.com/files/attrangs/goods/155321/1695399861_0.gif" alt="<%=dto.getItem_name()%>"/>
							</a>
							<div><%=dto.getPrice()%></div>
							<div><%=dto.getItem_name()%></div>
						</div>						
						<%
					}
				%>
			</div>
			<%
		}
	%>
</div>
</body>
</html>