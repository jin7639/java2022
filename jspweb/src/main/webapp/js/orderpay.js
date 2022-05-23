
let jsonarray;
let totalpay = 0;

$(function(){
	getcart();
});
function getcart(){
	$.ajax({
		url : 'getcart',
		success : function(json){
		jsonarray = json;
		
		for(let i = 0; i <jsonarray.length; i++){
			totalpay += jsonarray[i]["totalprice"];
		}
		alert(totalpay);
		}
	});
}

/* 아임포트 API = 결제 API */
function payment(){
	var IMP = window.IMP; // 생략 가능
    IMP.init("imp55160233");
    IMP.request_pay({ // param
          pg: "html5_inicis", //pg사 -> 결제대행 회사
          pay_method: "card",	//결제방식
          merchant_uid: "ORD20180131-0000011", //주문번호 ->orderno
          name: "EZEN SHOP",	//결제창에 뜨는 홈페이지 이름
          amount: totalpay, //총 주문 금액
          buyer_email: "gildong@gmail.com", //주문하는 사람 이메일
          buyer_name: "홍길동", //주문하는 사람 이름
          buyer_tel: "010-4242-4242", //주문하는 사람 전화번호
          buyer_addr: "서울특별시 강남구 신사동", //주문하는 사람 주소
          buyer_postcode: "01181" //주문하는사람 우편번호
      }, function (rsp) { // callback -> 실행여부 판단
          if (rsp.success) {
              // 결제 성공 시 로직,
          } else {
              // 결제 실패 시 로직,
             saveorder();
          }
      });
}

function saveorder(){
	$.ajax({
		url : "saveorder",
		success : function(result){
			alert("DB처리 성공");
		}
	});
}