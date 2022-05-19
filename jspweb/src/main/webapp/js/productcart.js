$(function(){
	$.ajax({
		url : 'getcart',
		success : function(result){
			//alert(result); 
			//alert결과 -> [object Object],[object Object] 
			let tr = 
					'<tr>'+
						'<th>이미지</th>'+
						'<th>상품명</th>'+
						'<th>구매수량</th>'+
						'<th>총가격</th>'+
						'<th> </th>'+
					'</tr>'
			for(let i = 0; i<result.length; i++){ //지금 result 는 배열인건가?? jsonArray는 배열의 일종인건가??
				//alert(result[i]); 
				// -> [object Object]
				//alert(Object.keys(result[i])); //key 가 뭐지?? -> dao 랑 연결되어 있음 //Object. -> Object는 interface라는데??
				// -> pno,scolor,totalprice,cartno,samount,ssize
				//alert(result[i]['ssize']); //dao랑 같은 이름 써야하는 거 같음
				// -> 100
				// -> 95
				tr += 
					'<tr>'+
						'<td width="10%"><img width="100%" alt="" src="../admin/productimg/'+result[i]['pimg']+'"></td>'+
						'<td>'+result[i]['pname']+'<br>'+result[i]['scolor']+'/'+result[i]['ssize']+'</td>'+
						'<td>'+result[i]['samount']+'</td>'+
						'<td>'+result[i]['totalprice']+'</td>'+
						'<td><button>X</button></td>'+
					
					'</tr>'
				$("#carttable").html(tr);
			}
		}
	});
});
