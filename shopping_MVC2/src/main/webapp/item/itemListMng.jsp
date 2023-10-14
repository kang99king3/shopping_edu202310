<%@page import="java.util.List"%>
<%@page import="com.edu.shop.dtos.ItemDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/regist.css"/>
</head>
<%
	List<ItemDto> list=(List<ItemDto>)request.getAttribute("list");
%>
<body>
<div class="itemForm">
 <table border="1" class="table" style="width:800px;">
            <thead>
            <tr>
                <td>상품아이디</td>
                <td>상품명</td>
                <td>상태</td>
                <td>등록일</td>
            </tr>
            </thead>
            <tbody>
            <%
            	for(ItemDto dto:list){
            		%>
		            <tr >
		                <td><%=dto.getItem_id()%></td>
		                <td>
		                    <a href="itemDetialMng.item?item_id=<%=dto.getItem_id()%>"><%=dto.getItem_name()%></a>
		                </td>
						<td><%=dto.getItem_sell_status().equals("Y")?"판매중":"품절"%></td>
						<td><%=dto.getReg_date()%></td>
		            </tr>            		
            		<%
            	}
            %>
            </tbody>
        </table>
</div>
</body>
</html>