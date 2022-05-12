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
				//$("#cname").val("");
				//$("#ccontent").val("");
				//$("#chattingtable").load(location.href+" #chattingtable");
				$("#contents").load(location.href + " #contents");
			}else{
				alert("채팅실패");
			}
		}
	})
}

$(function(){
	timer = setInterval(function(){
		$.ajax({
			url : "chattingroad",
			cashe : false,
			success : function(result){
				var co = result.split("_");
				var contents = "";
				
				for( var i = 0 ; i<co.length-1 ; i++ ){
					contents +=
						'<div class="box" >'+
							'<div class = "nicname" style="color : #999999; font-size: 12px;">'+
								co[i].split(",")[0]+
							'</div>'+
							'<span class="content">'+
								co[i].split(",")[1]+
							'</span>'+
						'</div><br>'
				}
				$("#contents").html(contents);
				$("#contetns").scrollTop($('#contents')[0].scrollHeight);
			}
		})
	}, 1000);
});
	





