// $ : jquery

let parentlist ;

$(function(){
	$.ajax({
		url : "/jspweb/product/getorder",
		success : function(jsonarray) {
			parentlist = jsonarray;  
			console.log(parentlist);
			view();
		}
	});
})
let viewcount = 2; // 화면에 보여지는 주문 수
//스크롤 사용 이벤트
$(window).scroll(function(){
	//스크롤이 바닥에 닿았을때 계산
		/*
			$(window).scroll : 브라우저 스크롤
			$(window).scollTop() : 스크롤막대의 상단 위치
			$(document).height() : 문서 높이
			$(window).height() : 현재 보고 있는 화면의 높이
		*/
		//스크롤 되어 내려온 위치와 브라우저에 표시된 높이를 더한 값이 페이지 전체 높이 값과 같거나 크면, --> 맨아래

		//현재 스크롤의 상단 위치 == 현재 보고 있는 문서 내 높이 - 현재 보고 있는 화면 높이
	if($(window).scrollTop() + 50 >= $(document).height() - $(window).height()){
		//alert( $(window).scrollTop() + " : 스크롤막대의 상단 위치" );//414
		//alert( $(document).height() +": 문서내 높이" );//1356
		//alert( $(window).height() + ": 현재 보고 있는 화면의 높이" );//942
		//alert( $(window).scrollTop() + " : 스크롤막대의 상단 위치" );//414
		viewcount++; // 스크롤이 바닥에 닿을 때마다 하나씩 증가 -> 주문 하나 씩 더 출력
		view(); // 새로고침
	}
});

function view(){
	//let html; --> 초기값 안 넣으면 "undefined"가 들어감
	let html ="";
	for(let i = 0; i <parentlist.length; i++){
		if(i == viewcount){break;}
		
		html +=  '<div class="orderinfo"> <!-- 주문번호 -->'+
'					<span>주문 번호</span>'+
'					<span>'+parentlist[i][0]["orderno"]+'</span>'+
'					<span>주문 날짜</span>'+
'					<span>'+parentlist[i][0]["orderdate"]+'</span>'+
'					<a href="#"><span>주문상세보기</span></a>'+
'				</div>';
					for(let j = 0; j < parentlist[i].length; j++){
						let childlist = parentlist[i];
						console.log( childlist );
						html +=
								'<div class="row">'+
'									<div class="col-sm-1">'+
'										<img width="100%" alt="" src="../admin/productimg/'+childlist[j]["pimg"]+'">'+
'									</div>'+
'									<div class="col-sm-8">'+
'										<div class="row">'+
'											<div class="pname">'+childlist[j]["pname"]+'</div>'+
'											<div class="poption">'+childlist[j]["scolor"]+' / '+childlist[j]["ssize"]+' / '+childlist[j]["samount"]+'</div>'+
'										</div>'+
'										<div class="orderbtnbox">'+
'											<button>배송조회</button>'+
'											<button>교환/반품/취소</button>'+
'											<button>리뷰 작성</button>'+
'										</div>'+
'									</div>'+
'									<div class="col-sm-3">'+
'										<span>상품준비중</span>'+
'									</div>'+
'								</div>';
					}
	}
	$("#orderbox").html(html);
}