
function pnomove(pno) {
	$("#modalinput").val(pno);
}

function activechange(active){
	let pno = $("#modalinput").val();
	$.ajax({
		url : "activechange",
		data : {"active" : active , "pno" : pno},
		success : function(result){
			if(result == 1){
				$("#madalclosebtn").click();
				$("#mainbox").load('productlist.jsp');
			}else{
				alert("변경 실패");
			}
		}
	})
}

function getamount(pno){
	let scolor = $("#colorbox"+pno).val();
	let ssize = $("#sizebox"+pno).val();
	
	$.ajax({
		url : 'getstock',
		data : {'field': 'amount', "pno" : pno, "scolor" : scolor, "ssize": ssize},
		success : function(result){
			if(result == ""){
				$("#amountbox"+pno).html("재고없음");
				$("#datebox"+pno).html( "" );
			}else{
				$("#amountbox"+pno).html(result.split(',')[0]+"개");
				$("#datebox"+pno).html(result.split(',')[1]);
			}
		}
	})
}


function getstock(pno){
	$.ajax({
		url : 'getstock',
		data : { "pno" : pno },
		success : function(result){
			$("#stocklistbox").html(result);
		}
	})
}

function showupdate(sno){
	$("#updatebox").css("display","block");
	$("#sno").val(sno);
}
function stockupdate(){
	let sno = $("#sno").val();
	let samount = $("#samount").val();
	
	$.ajax({
		url : 'stockupdate',
		data : {'sno' : sno , 'samount' : samount},
		success : function(result){
			$("#madalclosebtn2").click();
			$("#mainbox").load('productlist.jsp');
		}
	})	
}
