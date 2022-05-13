<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>제품목록 페이지</h3>
	<table class="table table-hover" id="producttable">
		<tr>
			<th width="5%">제품번호</th><th width="5%">대표이미지</th><th width="5%">제품명</th>
			<th width="5%">가격</th><th width="5%">할인율</th><th width="5%">판매금액</th>
			<th width="5%">제품상태</th><th width="5%">카테고리</th><th width="5%">색상</th>
			<th width="5%">사이즈</th><th width="5%">재고수량</th><th width="5%">수정일</th><th width="5%">비고</th>
		</tr>
		<%ArrayList<Product> productlist = ProductDao.getProductDao().getproductlist();
			for (Product product : productlist){%>
		<tr>
			<td><%=product.getPno()%></td>
			<td><img width="100%" src="/jspweb/admin/productimg/<%=product.getPimg()%>"></td>
			<td><%=product.getPname()%></td>
			<td><%=product.getPprice()%></td>
			<td><%=product.getPdiscount()%></td>
			<%//int saleprice = product.getPprice()*(1-((int)product.getPdiscount()/100)); 
				double pprice = product.getPprice();
				double discount = product.getPdiscount() ;
				double saleprice = pprice*(1-(discount/100)); %>
			<td><%=saleprice%></td>
			<td><%=product.getPactive()%></td>
			<td><%=product.getCno()%></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td>
				<button>제품 삭제</button>
				<button>제품 수정</button>
				<button onclick="pnomove(<%=product.getPno()%>)" data-bs-toggle="modal" data-bs-target="#activemodal">상태 변경</button>
				<button>재고 변경</button>
			</td>
		</tr>
		<%} %>
	</table>
	
	<button data-bs-toggle="modal" data-bs-target="#activemodal">모달</button>
	
	<!-- 상태 변경 모달 구역 -->
	<div class="modal" tabindex="-1" id="activemodal">
	  <div class="modal-dialog">
	    <div class="modal-content">
	    
	      <div class="modal-header">
	        <h5 class="modal-title">제품 상태 변경</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      
	      <div class="modal-body">
	        <p>변경할 상태를 선택해주세요.</p>
	        <input type="hidden" id="modalinput">
	      </div>

      <div class="modal-footer">
        <button type="button" class="btn btn-primary" onclick="activechange(0)">준비</button>
        <button type="button" class="btn btn-primary" onclick="activechange(1)">판매</button>
        <button type="button" class="btn btn-primary" onclick="activechange(2)">품절</button>
        <button type="button" class="btn btn-primary" onclick="activechange(3)">중단</button>
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal" id="madalclosebtn">취소</button>
      </div>
    </div>
  </div>
</div>
<script src="/jspweb/js/productlist.js" type="text/javascript"></script>
</body>
</html>