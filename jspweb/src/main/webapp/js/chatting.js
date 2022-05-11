/**
 * 
 */
 function cwrite(){
	let cname = $("#cname").val();
	let ccontent = $("#ccontent").val();
	$.ajax({
		url : "cwrite",
		data : { "cname" : cname , "ccontent" : ccontent },
		success : function(result){
			if(result == 1){
				//alert(result);
				$("#cname").val("");
				$("#ccontent").val("");
				//$("#chattingtable").load(location.href+" #chattingtable");
			}else{
				alert("채팅실패");
			}
		}
	})
}


