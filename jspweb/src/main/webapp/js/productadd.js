
function categorybtn(){
	//특정 태그의 HTML 넣기
	$("#categoryinput").html(
		'<div class=" col-md-10">'+
			'<input class="form-control" type="text" id="cname">'+
		'</div>'+
		'<div class=" col-md-2">'+
			'<button class="form-control" onclick="categoryadd()" type="button">등록</button>'+
		'</div>'
	)
}

$( function category(){ 
	getcategory();
});

/*카테고리 호출*/
function getcategory(){
	$.ajax({
		url : "getcategory",
		success : function(result){
			$("#categorybox").html(result);
		}
	});
};

function categoryadd(){
	let cname = $("#cname").val();
	$.ajax({
		url : "categoryadd",
		data : {"cname" : cname},
		success : function(result){
			if(result == 1){
				alert("카테고리 추가");
				$("#categoryinput").html("");
				getcategory();
			}else{
				alert("등록 오류");
			}
		}
	});
}

/* form 전송 */
function productadd(){
	var form = $("#addform")[0]; // 폼 태그 id 호출 [0] 인덱스 호출 
	var formData = new FormData( form ); // js 지원하는 FormData 클래스를 이용한 form태그 객체화
	// ajax 기본적으로 문자열 전송한다.  인코딩 URL 타입 : application/x-www-form-urlencoded
	$.ajax({
		url : "productadd",
		type : 'POST' , /* type : 1.GET(기본타입) 2.POST(첨부파일사용시,보안용 등)*/
		data : formData , 		/* form 객체를 전송 */
		contentType : false ,  /* 전송시 문자열 타입X *
		/* contentType 전송시 내용물 URL 타입 //  String방식 : https://finance.naver.com/item/main.naver?code=005930 */
		/* contentType : true : URL 인코딩 타입 문자열 O [ 기본타입 ]
		/* contentType : false : URL 인코딩 타입 문자열 X */ 
		processData : false ,  /* 전송시 문자열 전송X */
		/*  html 에서 enctype="multipart/form-data"  */
		/*  ajax 에서 contentType : false, processData : false */
		success : function(result){
			if(result){
				alert("등록 완료");				
				form.reset();
			}else{
				alert("등록 실패");				
			}
		}
	})
}

/* 첨부파일 변경되면 특정태그에 첨부파일 이미지 표시하기ㅣ */

$("#pimg").change(function(e){
	
	let reader = new FileReader();
	reader.readAsDataURL(e.target.files[0]);
	reader.onload = function(e){
		$("#preview").attr("src",e.target.result);
	}
});