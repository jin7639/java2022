<%@page import="dao.MemberDao"%>
<%@page import="java.util.TreeSet"%>
<%@page import="java.util.Set"%>
<%@page import="dto.Stock"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.DecimalFormat"%>
<%@page import="dto.Product"%>
<%@page import="dao.ProductDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<!--사용자정의 css 호출-->
	<link rel="stylesheet" href="/jspweb/css/productview.css">
</head>
<body>
	<%@include file = "../header.jsp" %>
	
	<%
	////////////////////////////////////// java ///////////////////////////////////////////
		int pno =  Integer.parseInt( request.getParameter("pno") ); // 제품번호 요청
		Product p = ProductDao.getProductDao().getproduct(pno); // 제품 호출
		ArrayList<Stock> stocks =  ProductDao.getProductDao().getStocklist(pno); // 해당 제품의 재고
		
		Set<String> sizelist  = new TreeSet<>(); // 사이즈목록 선언   = 중복제거(set컬렉션) 
		for( Stock s : stocks ){ sizelist.add(s.getSsize() ); } // 사이즈 목록 만들기 
		
		Set<String> colorlist  = new TreeSet<>(); // 칼라목록 선언   = 중복제거(set컬렉션) 
		for( Stock s : stocks ){ colorlist.add(s.getScolor() ); } // 칼라 목록 만들기 
		
		DecimalFormat df = new DecimalFormat("###,###원"); // 천단위 구분 쉼표
		//Float price = product.getPprice()*product.getPdiscount();
		int pprice = p.getPprice();
		int discount = (int) Math.round(p.getPdiscount());
		int price = pprice*(1-(discount/100)); 
		int point = (int) Math.round(price*0.01);
		
	///////////////////////////////////////////////////////////////////////////////////////		
	%>
	<div class="container viewbox">
		<div class="row">
		 <!-------------------  이미지 ------------------------- -->
			<div class="col-md-6">
				<img alt="" src="../admin/productimg/<%=p.getPimg()%>">
			</div>
		<!-------------------- 상품의 정보----------------------------- -->
			<div class="col-md-6">  
				<div class="infobox">
					<h5 id="pname" class="view_title"><%=p.getPname()%></h5>
					<div class="price_box">
						<% if( p.getPdiscount() == 0 ){ %> <!-- 할인이 없을때 -->
							<span class="price"><%=df.format(p.getPprice())%></span>
						<%	}else{ %> <!-- 할인이 있을때  -->
						
							<span class="price_rat"><%=(int)discount +"%" %></span>
							<span class="price_dis"><%=df.format(p.getPprice()) %></span>
							<span class="price"><%= df.format(price) %></span>
						<%	} %>
					</div>
					<div class="size_box">
						<span> 
							<% for( String t : sizelist ){  %> <!-- 사이즈 목록 출력 -->
								<%=t +"   "%>
							<% } %>
						 </span>
					</div>
					<!-- 제품번호  -->
					<input type="hidden" value="<%=pno%>" id="pno">
					<input type="hidden" value="<%=price%>" id="pprice">
					
					<table class="table info_t my-5">
						<tr> <td width="20%"> DELVERY </td> <td> 2,500원 (70,000원 이상 구매시 무료 )</td> </tr>
						<tr> <td> SAVE </td> <td> <%=df.format( point )%>(1%)</td> </tr>
						<tr>
							<td> COLOR </td>
							<td>  <select id="color_select" class="form-select info_t">
										<option value="">-[필수]옵션 선택-</option>
									<% for( String c  : colorlist ){ %>
										<option value=<%=c %> ><%=c %></option>
									<%} %>
									</select> </td>
						</tr>
						<tr>
							<td> SIZE </td> 
							<td>  <select id="size_select" class="form-select info-t">
										<option value="">-[필수]옵션 선택-</option>
									</select> </td>
						</tr>
					</table>
					<table id="select_table" class="table my-5">
					</table>
					
					<div class="row my-5">
						<div class="col-md-6"> 총 상품금액  </div>
						<div class="col-md-6 total_price" id="total_price"></div>
					</div>
					
					<% String mid = (String)session.getAttribute("login");
					int mno =  MemberDao.getMemberDao().getmno(mid);%>
					<div id="btnbox" class="btnbox">
						<button id="btn1">바로 구매하기</button>
						<button id="btn2" onclick="savecart('<%=mno%>')">장바구니 담기</button>
					<% if( mid !=null && ProductDao.getProductDao().getplike(pno, mno )){%>
							<button id="plike" onclick="saveplike('<%=mid%>')">관심상품 ♥</button>
						<%}else{%>
							<button id="plike" onclick="saveplike('<%=mid%>')">관심상품 ♡</button>
						<%} %>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="/jspweb/js/productview.js" type="text/javascript"></script>
	<%@include file = "../footer.jsp" %>

</body>
</html>