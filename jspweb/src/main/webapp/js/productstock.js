/**
 * 
 */
 
 /* 특정 select 에 DB데이터 넣기 */
 $(function getcategory(){
	
	$.ajax({
		url : "getcategory",
		data: {'type' : "option"},
		success : function(result){
			$("#categorybox").html (result);
		}
	});
	
});
 /* 카테고리 select 값이 변경 될 때마다 product 목록 변경 */
 $("#categorybox").change(function(){
	let cno = $("#categorybox").val();
	
	$.ajax({
		url : "getproduct",
		data : {"type" : "option" , "cno" : cno},
		success : function(result){
			if( result == ""){
				alert("해당 카테고리의 제품이 없습니다.");
				$("#productbox").html(" ");
				$("#stockaddform").css('display', 'none');
			}else{ 
				$("#productbox").html( result );
				$("#stockaddform").css('display', 'block');
			}
		}
	})
});


/*재고추가*/
function stockadd(){
	
	let pno = $("#productbox").val();
	let scolor = $("#scolor").val();
	let ssize = $("#ssize").val();
	let samount = $("#samount").val();
	
	$.ajax({
		url : "stockadd",
		data : {"pno" : pno, "scolor": scolor, "ssize" : ssize, "samount" : samount},
		success : function(result){
			if(result == 1){
				alert("재고 등록 성공");
				$("#mainbox").load('productstock.jsp');
			}else{
				alert("재고 등록 실패");
			}
		}
	});
	
}

/* select 에서 제품명을 선택(변경)할 때마다*/
$("#productbox").change(function(){
	getstock();
})

function getstock(){
	let pno = $("#productbox").val();
	$.ajax({
		url : 'getstock',
		data : {"pno":pno},
		success : function(result){
			$("#stocklistbox").html(result);
		}
	})
}

/*제품별 사이즈 가져오기 */
$(function getstock(){
	let pno = $("#th1").html();
	//제품번호 가져오기
	$.ajax({
 		url : "getstock" , 
 		data : { "field" : 'ssize' , 'pno' : pno },
 		success : function(result){
			alert(result);
			$("#sizebox1").html(result);
		}		
	});
});


