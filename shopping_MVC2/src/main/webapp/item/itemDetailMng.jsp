<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="itemForm">
<%-- 	<input type="hidden" id="error" th:value="${errorMessage}"/> --%>
    <form class="form-group" action="addItem.item"  method="post" enctype="multipart/form-data" >
		
        <p class="h2">
            ${dto.item_name}
        </p>
        <div>
            <select name="sell_status" required="required">
                <option value="SELL" ${dto.item_sell_status eq "SELL" ? "selected":""} >판매중</option>
                <option value="SOLD_OUT" ${dto.item_sell_status eq "SOLD_OUT" ? "selected":""}>품절</option>
            </select>
        </div>
        <div>
            <div >
                <span>상품명</span>
            </div>
            <input type="text" name="item_name" value="${dto.item_name}" required="required">
        </div>
        <div>
            <div>
                <span>가격</span>
            </div>
            <input type="number" name="price" value="${dto.price}" required="required">
        </div>
        <div class="input-group">
            <div>
                <span>재고</span>
            </div>                     
            <input type="number" name="stock_number" value="${dto.stock_number}" required="required">
        </div>
        <div>
            <div>
                <span>상품 상세 내용</span>
            </div>
            <textarea name="item_detail" rows="10" cols="60" required="required">${dto.item_detail}</textarea>
        </div> 
        <div>
        	<%
        		for(int i=0;i<5;i++){
        			%>
		            <div>
		                 <label>상품이미지 <%=i%></label>
		                 <%
		              		if(i==0){
		              		%>
		              		<input type="file" name="itemImgFile<%=i%>" required="required">
		              		<%
		              		}else{
		              		%>
		                    <input type="file" name="itemImgFile<%=i%>">		              			
		              		<%
		              		}
		                 %>
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