/* JSON 형식 변수 선언 */
let jsonarray;
let sumprice = 0;
let deliverypay = 0;
let totalpay = 0;
let point = 0;

/*테이블에 데이터 넣기 */
function tableview(){
	//alert(result); 
			//alert결과 -> [object Object],[object Object] 
			let tr = 
				'<tr>'+
	'				<th width="60%">상품명</th>'+
	'				<th width="20%">구매수량</th>'+
	'				<th width="20%">총가격</th>'+
	'			</tr>';
	
			sumprice = 0;
			deliverypay = 0;
			totalpay = 0;

	
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
		'							<button class="amount_btn" onclick="amountincre('+i+')">▲</button>'+
		'							<button class="amount_btn" onclick="amountdecre('+i+')">▼</button>'+
		'						</div>'+
		'					</div>'+
		'				</td>'+
		'				<td class="align-middle">'+
		'					<div class="row g-0">'+
		'						<div class="col-md-8 pricebox">'+jsonarray[i]['totalprice'].toLocaleString()+'원'+'</div>'+
		'						<div class="col-md-4 deletebox"><button onclick="cancel('+i+')">X</button></div>'+
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
				
				$("#sumprice").html(sumprice.toLocaleString())
				$("#deliverypay").html(deliverypay.toLocaleString())
				$("#totalpay").html(totalpay.toLocaleString())
				$("#point").html(point.toLocaleString())
				
				$("#carttable").html(tr);
}

function amountincre(i){
	//재고 수량 넘어가면 함수 종료
	
	$.ajax({
		url : "getamount",
		data : {'pno' :  jsonarray[i]['pno'] ,
				'color' : jsonarray[i]['scolor'] ,
				'size' : jsonarray[i]['ssize']},
		success : function(maxamount){
			if( jsonarray[i]['samount'] >= maxamount) {
				alert("재고 부족");
				return;
			}else {
				let price = parseInt( jsonarray[i]['totalprice']/jsonarray[i]['samount']);
				jsonarray[i]['samount'] ++;
				jsonarray[i]['totalprice'] = price * jsonarray[i]['samount'];
				updatecart();
				}
			}	
		
	});
}
function amountdecre(i){
	if(jsonarray[i]["samount"] == 1){
		alert('최소 수량 입니다');
		return;
	}else {
		let price = parseInt( jsonarray[i]['totalprice']/jsonarray[i]['samount']);
		jsonarray[i]['samount']--;
		jsonarray[i]['totalprice'] = price * jsonarray[i]['samount'];
		updatecart();
		}
}

$(function(){
	getcart();
})

function getcart(){
	$.ajax({
		url : 'getcart',
		success : function(json){
		jsonarray = json;
		tableview();
		}
	});
}

function updatecart(){
	$.ajax({
		url: "updatecart",
		data : {"json" : JSON.stringify(jsonarray)},
		success : function(json){
			getcart();
		}
	});
}
function deletecart(i){
	$.ajax({
		url: "deletecart",
		data : {'cartno' : jsonarray[i]["cartno"]},
		success : function(result){
			getcart();
		}
	});
}

/* ??????????????????????????????? */
function cancel(i){
	
	if(i == -1 ){//전체삭제
		if(confirm('전체 삭제하시겠습니까?')){
			//confirm("내용") : 확인/취소 버튼 알림창
				//확인 true / 취소 false
			for(let j = 0; j<jsonarray.length; j++) {
				deletecart(j);				
			}
		}
		return;
	}
	deletecart(i);
}