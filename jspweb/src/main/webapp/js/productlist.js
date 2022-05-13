/**
 * 
 */
 
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