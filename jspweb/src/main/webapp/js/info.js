/**
 * 
 */
 
 
 function passwordcheck (mid) {
	//제이쿼리식
	let mpassword = $("#mpassword").val();
	//자바스크립트식
	//document.getElementById("mpassword").value;
	
	//비동기 통신 = 제이쿼리에서 제공해주는 통신[js(view)--->java(controller)] 메소드
	//$.ajax({속성명 = 속성값, 속성명2 = 속성값2})
	$.ajax({
		url : "../passwordcheck" ,//어디로
		data : {"mid" : mid, "mpassword" : mpassword},//보낼 데이터
		type : "POST",
		success : function( result ){
			if(result == 1){
				$("#checkmsg").html("정말 탈퇴하시겠습니까?");
				$("#mpassword").css("display", "none");	//제이쿼리 css 적용 [.css("속성명","속성값")]
				$("#btnmpassword").css("display", "none");	//제이쿼리 css 적용 [.css("속성명","속성값")]
				$("#btndelete").css("display", "block");	
			}else {
				$("#checkmsg").html("비밀번호가 일치하지 않습니다.");
				$("#mpassword").val("");
				
			}
		}
		
	});
	
}



function mdelete(mid) {
	$.ajax({
		url : "../delete",
		data : {"mid" : mid},
		success : function(result){
			if(result == 1) {
				alert("회원탈퇴 완료")
				location.href="/jspweb/logout"; //서블릿
			}else{
				location.href="/jspweb/error.jsp"; //서블릿
				
			}
		}
	});
	
}