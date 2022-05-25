<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<link href="/jspweb/css/myshopping.css" rel="stylesheet">
</head>
<body>
	<%@include file="../header.jsp" %>
	
	<div class="container">
		<div class="row">
			<div class="col-md-3">
				<%@include file="info_sidebar.jsp" %>
			</div>
			<div class="col-md-9">
				<h3 class="text-center">주문현황</h3>
				<div id="orderbox">
				</div>
			</div>
		</div>
	</div>
	
	<!-- Modal -->
	<div class="modal fade" id="cancelModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">주문 취소</h5>
	        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
	      </div>
	      <div class="modal-body">
	        <h5>주문 취소 요청 사유</h5>
	        <textarea id="cancelconfirm" class="form-control"></textarea>
	      </div>
	      <div class="modal-footer">
	        <button id="madalclose" type="button" class="btn btn-secondary" data-bs-dismiss="modal">돌아가기</button>
	        <button type="button" onclick="cancel()" class="btn btn-primary">주문취소</button>
	      </div>
	    </div>
	  </div>
	</div>
	<script type="text/javascript" src="/jspweb/js/myshopping.js"></script>
	<%@include file="../footer.jsp" %>
</body>
</html>