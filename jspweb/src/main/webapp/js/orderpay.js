
let jsonarray;
let sumprice = 0;
let deliverypay = 0;
let totalpay = 0;
let point = 0;
let member;
let mpoint = 0; 

let pay_method;

$(function(){
	getcart();

	$.ajax({
		url : "../member/getmember",
		success : function(json){
			member = json
		}
	});
	/*받는사람 정보가 기존 회원정보와 동일 버튼을 눌렀을때 */
	//문서내에서 대기상태 이벤트
	$("#checkbox").change(function(){
		//체크박스가 변경 되었을 때 이벤트
		if($("#checkbox").is(":checked")){
			//체크되어있으면
			$("#ordername").val(member['mname']);
			$("#orderphone").val(member['mphone']);
			$("#address1").val(member['maddress'].split('_')[0]);
			$("#address2").val(member['maddress'].split('_')[1]);
			$("#address3").val(member['maddress'].split('_')[2]);
			$("#address4").val(member['maddress'].split('_')[3]);
		}else{
			$("#ordername").val("");
			$("#orderphone").val("");
			$("#address1").val("");
			$("#address2").val("");
			$("#address3").val("");
			$("#address4").val("");
		}
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
				
				totalpay = sumprice + deliverypay - mpoint;
				point = sumprice * 0.01;
				
				$("#carttable").html(tr);
				$("#mpoint").html(member['mpoint']);
				$("#pointbox").html(mpoint);
				$("#totalpay").html(totalpay);
}
		


function saveorder(){
	$.ajax({
		url : "saveorder",
		success : function(result){
			alert("성공");
		}
	});
}

function pointbtn(){
	mpoint = $("#pointinput").val();
	if( mpoint == 0 ) {
		mpoint = 0;
	}else if(mpoint <5000 ){
		alert("최소 5000포인트부터 사용가능합니다.");
		mpoint = 0;
		$("#pointinput").val(0);
		return;
	}else if(mpoint > member['mpoint']){
		alert('포인트가 부족합니다. ');
		mpoint = 0;
		$("#pointinput").val(0);
		return;
	}
	cartview();
}

function paymethod(method){
	$("#paymethod").html(method);
	pay_method = method;
}

/* 아임포트 API = 결제 API */
function payment(){
	
	if(pay_method == null){ //결제 수단을 선택하지 않았으면
		alert("결제수단을 선택해주세요");
		return;
	}
	
	var IMP = window.IMP; // 생략 가능
    IMP.init("imp55160233");
    IMP.request_pay({ // param
          pg: "html5_inicis", //pg사 -> 결제대행 회사
          pay_method: pay_method,	//결제방식
          merchant_uid: "ORD20180131-0000011", //주문번호 ->orderno
          name: "EZEN SHOP",	//결제창에 뜨는 홈페이지 이름
          amount: totalpay, //총 주문 금액
          buyer_email: member['mid'], //주문하는 사람 이메일
          buyer_name: member['mname'], //주문하는 사람 이름
          buyer_tel: member['mphone'], //주문하는 사람 전화번호
          buyer_addr: member['maddress'], //주문하는 사람 주소
          buyer_postcode: member['maddress'].split('_')[0] //주문하는사람 우편번호
      }, function (rsp) { // callback -> 실행여부 판단
          if (rsp.success) {
              // 결제 성공 시 로직
          } else {
              // 결제 실패 시 로직
             saveorder();
          }
      });
}