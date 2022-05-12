
function categorybtn(){
	//특정 태그의 HTML 넣기
	$("#categoryinput").html(
		'<input type="text" id="cname">'+
		'<button onclick="categoryadd()" type="button">등록</button>'
	)
}

function categoryadd(){
	let cname = $("#cname").val();
	$.ajax({
		url : "categoryadd",
		data : {"cname" : cname},
		success : function(result){
			if(result == 1){
				$("#categoryinput").html("");
				
			}else{
				alert("등록 오류");
			}
		}
	});
}

/*카테고리 호출*/
$(function getcategory(){
	$.ajax({
		url : "getcategory",
		success : function(result){
			$("#categorybox").html(result);
		}
	});
});



