<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="/jspweb/css/productcart.css" rel="stylesheet">
</head>
<body>
	<%@include file = "../header.jsp" %>
	
	<div class="container">
		<div class="processbox">
			<span>01 옵션선택</span><span>></span>
			<span id="process_active">02 장바구니</span><span>></span>
			<span>03 주문결제</span><span>></span>
			<span>04 주문완료</span>
		</div>
		<table id="carttable" class="table my-5">
		</table>
		<div class="col-sm-2">
			<button class="form-control" onclick="cancel(-1)">전체 삭제</button>
		</div>
		<div class="paybox">
			<span>총 상품금액</span>
			<span id="sumprice">20,000원</span>
			<span>+</span>
			<span>배송비</span>
			<span id="deliverypay">3,000원</span>
			<span>=</span>
			<span>총 주문금액</span>
			<span id="totalpay">23,000원</span>
			<div class="pointbox">
				<span>주문시 적립예정 포인트</span>
				<span id="point">2,000</span>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-3 offset-3">
				<a href="/jspweb/main.jsp"><button class="form-control py-4" >계속 쇼핑하기</button></a>
			</div>
			<div class="col-sm-3">
				<a href="/jspweb/product/order.jsp">
					<button class="form-control py-4" style="background-color: darkblue; color: white;">구매하기</button>
				</a>
			</div>
		</div>
	</div>
	
	
	<%@include file = "../footer.jsp" %>
	<script src="/jspweb/js/productcart.js" type="text/javascript"></script>
</body>
</html>