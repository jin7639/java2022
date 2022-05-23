
let jsonarray;
let sumprice = 0;
let deliverypay = 0;
let totalpay = 0;
let point = 0;

$(function(){
	getcart();
	
	/*받는사람 정보가 기존 회원정보와 동일 버튼을 눌렀을때 */
	//문서내에서 대기상태 이벤트
	$("#checkbox").change(function(){
		//체크박스가 변경 되었을 때 이벤트
		$.ajax({
			url : "../member/getmember",
			success : function(result){
				if($("#checkbox").is(":checked")){
					//체크되어있으면
					$("#ordername").val(result['mname']);
					$("#orderphone").val(result['mphone']);
					$("#address1").val(result['maddress'].split('_')[0]);
					$("#address2").val(result['maddress'].split('_')[1]);
					$("#address3").val(result['maddress'].split('_')[2]);
					$("#address4").val(result['maddress'].split('_')[3]);
				}else{
					$("#ordername").val("");
					$("#orderphone").val("");
					$("#address1").val("");
					$("#address2").val("");
					$("#address3").val("");
					$("#address4").val("");
				}
			}
		})
		
	});
});

function getcart(){
	$.ajax({
		url : 'getcart',
		success : function(json){
			jsonarray = json;
			cartview();
		}
	});
}

/* js 내 존재하는 json 객체를 table에 데이터 출력 */
function cartview(){
	
			sumprice = 0;;
			deliverypay = 0;
			totalpay = 0;

			let tr = 
				'<tr>'+
	'				<th width="60%">상품명</th>'+
	'				<th width="20%">구매수량</th>'+
	'				<th width="20%">총가격</th>'+
	'			</tr>';

	
			for(let i = 0; i<jsonarray.length; i++){ 
				
				sumprice += jsonarray[i]["totalprice"];
				
				tr += 
					'<tr>'+
		'				<td class="align-middle">'+
		'					<div class="row">'+
		'						<div class="col-sm-2">'+
		'							<img width="70%" alt="" src="../admin/productimg/'+jsonarray[i]['pimg']+'">'+
		'						</div>'+
		'						<div class="col-sm-10">'+
		'							<div class="pnamebox">'+jsonarray[i]['pname']+'</div>'+
		'							<div class="poptionbox">'+jsonarray[i]['scolor']+'/'+jsonarray[i]['ssize']+'</div>'+
		'						</div>'+
		'					</div>'+
		'				</td>'+
		'				<td class="align-middle"><!-- 수량 -->'+
		'					<div class="row g-0">'+
		'						<div class="col-sm-5 offset-3">'+
		'							<input readonly="readonly" value="'+jsonarray[i]['samount']+'" type="text" class="form-control" style="background-color: white">'+
		'						</div>'+
		'						<div class="col-sm-2">'+
		'						</div>'+
		'					</div>'+
		'				</td>'+
		'				<td class="align-middle">'+
		'					<div class="row g-0">'+
		'						<div class="col-md-8 pricebox">'+jsonarray[i]['totalprice'].toLocaleString()+'원'+'</div>'+
		'					</div>'+
		'				</td>'+
		'			</tr>';
				
				}
				
				//총 가격이 7만원 이상이면 배송비 무료
				if(sumprice >= 70000){
					deliverypay = 0;
				}else{
					deliverypay = 2500;
				}
				
				//장바구니에 상품이 없으면
				if(jsonarray.length == 0){
					tr +=
						 '<td colspan="3" style="text-align: center">'+
							'상품이 없습니다.'+
						'</td>';
					deliverypay = 0;
				}
				
				totalpay = sumprice + deliverypay;
				
				point = sumprice * 0.01;
				
				$("#carttable").html(tr);
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

