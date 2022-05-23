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
			<span>02 장바구니</span><span>></span>
			<span id="process_active">03 주문결제</span><span>></span>
			<span>04 주문완료</span>
		</div>
		
		<div class="row">
			<div class="col-sm-8">
				<div> <!-- 제품목록 -->
					<table id="carttable" class="table my-5">
						
					</table>
				</div>
				
				<div><!-- 받는 사람 정보 -->
					<input type="checkbox" id="checkbox"> 회원정보와 동일
					<h5>받는 사람</h5>
					<form>
						이름 <input id="ordername"><br>
						연락처 <input id="orderphone"><br>
						주소 
						<div class="row mb-1">
						<div class="col-md-8">
							<input class=" form-control" type="text" id="address1" name="address1" placeholder="우편번호">
						</div>
						<div class="col-md-4">
							<input class=" form-control " type="button" onclick="findaddress()" value="우편번호 찾기">
						</div>
						</div>
						<input class=" form-control mb-1" type="text" id="address2" name="address2" placeholder="도로명주소" >
						<input class=" form-control mb-1" type="text" id="address3" name="address3" placeholder="지번주소" >
						<span id="guide" style="color:#999;display:none"></span>
						<input class=" form-control mb-3" type="text" id="address4" name="address4" placeholder="상세주소">
						배송 요청사항 <input id="orderrequest">
						
					</form>
				</div>
			</div>
			
			<div class="col-sm-4">
				<div class="paybox">
					<div><!-- 포인트 사용 -->
						*5000포인트 이상부터 사용가능합니다.<br>
						보유 포인트 : <span id="mpoint"></span><br>
						포인트 : <input id="pointinput"> <button onclick="pointbtn()">사용</button>
					</div>
					<div><!-- 결제 정보 -->
						총 상품금액 : <span id="sumprice">12,100 원</span><br>
						배송비 : <span id="deliverypay">12,100 원</span><br>
						포인트 사용 : <span id="pointbox">12,100 원</span><br>
						총 결제액 : <span  id="totalpay">21,100 원</span>
					</div>
					<div><!-- 결제 사용 -->
						<div>					<!-- 변수는 아임포트에서 정한 것 -->
							<span id="paymethod"></span>
							<button onclick="paymethod('samsung')">삼성페이</button>
							<button onclick="paymethod('card')">카드</button>
							<button onclick="paymethod('trans')">계좌이체</button>
							<button onclick="paymethod('vbank')">무통장</button>
							<button onclick="paymethod('phone')">핸드폰</button>
						</div>
					
						<div class="row">
							<div class="col-sm-6">
								<a href="/jspweb/main.jsp"><button class="form-control py-4" >계속 쇼핑하기</button></a>
							</div>
							<div class="col-sm-6">
								<button onclick="payment()" class="form-control py-4" style="background-color: darkblue; color: white;">결제하기</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			
		</div>

	</div>
	
	
	<%@include file = "../footer.jsp" %>
 	<!-- iamport.payment.js -->
 	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.2.0.js"></script>
	<script src="/jspweb/js/orderpay.js" type="text/javascript"></script>
</body>
</html>