<%@page import="com.edu.shop.dtos.ItemImgDto"%>
<%@page import="com.edu.shop.dtos.ItemDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<style type="text/css">
	.itemForm img {
		width: 150px;
		height: 150px;
	}
	/*label을 버튼으로 표현*/
	.itemForm label[for] {
		background-color: orange;
		border: 1px solid gray;
		border-radius: 2px;
	}
	
	.itemForm label[for]:hover {
		background-color: #FFB914;
	}
	
	.itemForm input[type=file] {
		display: none;
	}
</style>
<script type="text/javascript">
	$(function(){
		$(".itemForm input[type=file]").change(function(){
			$(this).prev().text($(this).val());
		});
	})
</script>
</head>
<%
	ItemDto dto=(ItemDto)request.getAttribute("dto");
%>
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
        		int size=dto.getItemImgDtoList().size();
        		for(int i=0;i<size;i++){
        			ItemImgDto mDto=dto.getItemImgDtoList().get(i);
        			%>
		            <div>
		                 <label ><%=mDto.getOri_img_name()%> <%=i%></label><br/>
		                 <img src="upload/<%=mDto.getImg_name()%>"/>
		                 <label for="<%=i%>">파일선택</label>
		                 <span class="upload_filename"></span>
		                 <input id="<%=i%>" type="file" name="itemImgFile<%=i%>">		              			
		              	 <input type="hidden" name="item_img_id" value="<%=mDto.getItem_img_id()%>"	/>
		            </div>	
        			<%
        		}
        		for(int i=size;i<5;i++){
        			%>
		            <div>
		                 <label>상품 이미지 <%=i%></label>
		                 <label for="<%=i%>">파일선택</label>
		                 <span class="upload_filename"></span>
		                 <input id="<%=i%>" type="file" name="itemImgFile<%=i%>">		              			
		              	 <input type="hidden" name="item_img_id"/>
		            </div>	
        			<%
        		}
        	%>
        </div>
		<div>
	        <button type="submit">수정</button>
		</div>

	    </form>
	</div>
</body>
</html>