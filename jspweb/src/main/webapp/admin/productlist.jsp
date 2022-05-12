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
	<table class="table table-hover">
		<tr>
			<th>제품번호</th><th>대표이미지</th><th>제품명</th><th>가격</th><th>할인율</th><th>판매금액</th><th>제품상태</th>
			<th>카테고리</th><th>색상</th><th>사이즈</th><th>재고수량</th><th>수정일</th><th>비고</th>
		</tr>
		<%ArrayList<Product> productlist = ProductDao.getProductDao().getproductlist();
			for (Product product : productlist){%>
		
		<tr>
			<td><%=product.getPno()%></td>
			<td><%=product.getPimg()%></td>
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
			<td></td>
		</tr>
		<%} %>
	</table>
</body>
</html>