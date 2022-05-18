<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="dto.Stock"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dao.ProductDao"%>
<%@page import="dto.Product"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container">
		<div id="mainslide" class="carousel slide" data-bs-ride="carousel" data-bs-interval="2000"><!-- 캐러셀 -->
		  <div class="carousel-indicators"><!-- 슬라이드 하단 위치 버튼 -->
		    <button type="button" data-bs-target="#mainslide" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
		    <button type="button" data-bs-target="#mainslide" data-bs-slide-to="1" aria-label="Slide 2"></button>
		    <button type="button" data-bs-target="#mainslide" data-bs-slide-to="2" aria-label="Slide 3"></button>
		  </div>
		  <div class="carousel-inner">
		    <div class="carousel-item active">
		      <img src="/jspweb/img/928756995498b9e14c675ffd4e6bd85a.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/jspweb/img/b1a53523ef9ebba55f602b99d0b50568.jpg" class="d-block w-100" alt="...">
		    </div>
		    <div class="carousel-item">
		      <img src="/jspweb/img/b5f42b0c012f4ae0ae4c36556e793f25.jpg" class="d-block w-100" alt="...">
		    </div>
		  </div>
		  <button class="carousel-control-prev" type="button" data-bs-target="#mainslide" data-bs-slide="prev">
		    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
		  </button>
		  <button class="carousel-control-next" type="button" data-bs-target="#mainslide" data-bs-slide="next">
		    <span class="carousel-control-next-icon" aria-hidden="true"></span>
		  </button>
		</div>
		<div class="row adbox"><!-- 광고 -->
			<div class="col-md-6">
				<img alt="" src="/jspweb/img/mainimg1.gif">
			</div>
			<div class="col-md-6">
				<img alt="" src="/jspweb/img/mainimg2.jpg">
			</div>
		</div>
		<div><!-- 베스트 -->
			<h6 class="main_title">BEST</h6>
			<div class="row">
				<div class="col-md-3 img_box">
					<img alt="" src="/jspweb/img/bestimg1.webp">
				</div>
				<div class="col-md-3 img_box">
					<img alt="" src="/jspweb/img/bestimg1.webp">
				</div>
				<div class="col-md-3 img_box">
					<img alt="" src="/jspweb/img/bestimg1.webp">
				</div>
				<div class="col-md-3 img_box">
					<img alt="" src="/jspweb/img/bestimg1.webp">
				</div>
			</div>
		</div>
		<div><!-- 신상품 -->
			<h6 class="main_title">NEW ARRIVAL</h6>
			<div class="row">
			<% 
				ArrayList<Product> list = ProductDao.getProductDao().getproductlist();
				for( Product product : list){
			%>
				<div class="col-md-4 img_box">
					<a href="product/productview.jsp?pno=<%=product.getPno() %>">
						<img alt="" src="/jspweb/admin/productimg/<%=product.getPimg()%>">
					</a>
					<div class="p_item">
						<div class="p_title"><%=product.getPname()%></div>
						<%
							//해당 제품 모든 재고 꺼내오기
							ArrayList<Stock> stocks = ProductDao.getProductDao().getStocklist(product.getPno());
							//해당 제품 사이즈 목록 만들기
							Set<String> sizelist = new TreeSet<>();
							for(Stock stock : stocks){
								sizelist.add(stock.getSsize());
							}
						%>
						<div class="p_size">
							<%for(String temp : sizelist){%>
								<%=temp + "" %>
							<%} %>
						</div>
						<div class="row">
						<%DecimalFormat df = new DecimalFormat("###,### 원"); %>
						<%if(product.getPdiscount() == 0){//할인이 없으면	%>
							<div class="p_price"><%=df.format(product.getPprice())%></div>
						<%}else{ //할인이 있으면%>
							<%//Float price = product.getPprice()*product.getPdiscount();
							double pprice = product.getPprice();
							double discount = product.getPdiscount() ;
							double price = pprice*(1-(discount/100)); 
							%>
								<div class="p_discount"><%=df.format(product.getPprice())%></div>
								<div class="p_price"><%=df.format(price)%></div>
						<%} %>
							<div class="p_review">리뷰 : 412</div>
						</div>
					</div>
				</div>
			<%} %>
			</div>
		</div>
		<div><!-- 실시간 구매후기 -->
		
		</div>
	</div>
	<%@include file="footer.jsp" %>

</body>
</html>