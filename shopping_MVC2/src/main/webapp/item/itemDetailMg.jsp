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
	ItemDto dto=(ItemDto)request.getAttribute("dto");
%>
<body>
<div class="itemForm">
<%-- 	<input type="hidden" id="error" th:value="${errorMessage}"/> --%>
    <form class="form-group" action="addItem.item"  method="post" enctype="multipart/form-data" >
		
        <p class="h2">
            상품 등록
        </p>
        <div>
            <select name="sell_status" required="required">
                <option value="SELL" <%=dto.getItem_sell_status().equals("SELL")?"selected":"" %>>판매중</option>
                <option value="SOLD_OUT" <%=dto.getItem_sell_status().equals("SOLD_OUT")?"selected":"" %>>품절</option>
            </select>
        </div>
        <div>
            <div >
                <span>상품명</span>
            </div>
            <input type="text" name="item_name" value="<%=dto.getItem_name()%>" required="required">
        </div>
        <div>
            <div>
                <span>가격</span>
            </div>
            <input type="number" name="price" value="<%=dto.getPrice()%>" required="required">
        </div>
        <div class="input-group">
            <div>
                <span>재고</span>
            </div>                     
            <input type="number" name="stock_number" value="<%=dto.getStock_number()%>" required="required">
        </div>
        <div>
            <div>
                <span>상품 상세 내용</span>
            </div>
            <textarea name="item_detail" rows="10" cols="60" required="required"><%=dto.getItem_detail()%></textarea>
        </div> 
        <div>
        	<%
        		for(int i=0;i<5;i++){
        			%>
		            <div>
		                <label>상품이미지 <%=i%></label>	         
	              		<img src="<%="upload/"+dto.getItemImgDto().getImg_url()%>"/>
	              		<input type="hidden" name="item_img_id" value="<%=dto.getItemImgDto().getItem_img_id()%>"/>
	              		<input type="file" name="itemImgFile<%=i%>" >
		            </div>	
        			<%
        		}
        	%>
        </div>
		<div>
	        <button type="submit">저장</button>
		</div>

	    </form>
	</div>
</body>
</html>