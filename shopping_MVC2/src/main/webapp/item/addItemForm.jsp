<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/regist.css"/>
<script type="text/javascript">
	function mainFileCheck(formEle){
		if(formEle.itemImgFile1.value==""){
			alert("메인 이미지는 필수입니다.");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
<div class="itemForm">
<%-- 	<input type="hidden" id="error" th:value="${errorMessage}"/> --%>
    <form class="form-group" action="addItem.item"  method="post" enctype="multipart/form-data" 
    onsubmit="return mainFileCheck(this)" >
		
        <p class="h2">
            상품 등록
        </p>
        <div>
            <select name="sell_status" required="required">
                <option value="SELL">판매중</option>
                <option value="SOLD_OUT">품절</option>
            </select>
        </div>
        <div>
            <div >
                <span>상품명</span>
            </div>
            <input type="text" name="item_name" placeholder="상품명을 입력해주세요" required="required">
        </div>
        <div>
            <div>
                <span>가격</span>
            </div>
            <input type="number" name="price" placeholder="상품의 가격을 입력해주세요" required="required">
        </div>
        <div class="input-group">
            <div>
                <span>재고</span>
            </div>                     
            <input type="number" name="stock_number" placeholder="상품의 재고를 입력해주세요" required="required">
        </div>
        <div>
            <div>
                <span>상품 상세 내용</span>
            </div>
            <textarea name="item_detail" rows="10" cols="60" required="required"></textarea>
        </div> 
        <div>
        	<%
        		for(int i=1;i<=5;i++){
        			%>
		            <div>
		                 <label>상품이미지 <%=i==1?i+" [메인이미지]":i%></label>
		              	 <input type="file" name="itemImgFile<%=i%>">
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