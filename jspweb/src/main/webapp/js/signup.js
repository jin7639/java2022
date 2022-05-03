/**
 * 
 */

//jqeury :js 프레임워크
	//$제이쿼리
//$ (function(){}) : 문서 실행시 무조건 실행되는 함수
	//js : .getElementById("mid")
	//jquery: $("#id명")
		//keyup() : 해당 id에 키보드 눌렸을 때
		
	//입력상자 유효성 확인 체크 배열	
	let pass = [false, false, false, false, false, false, false];
	//배열 = [ ]
	
$( function(){
	
	
	$("#mid").keyup(function(){
		
		//1.HTML 태그내 값 가져오기
		let mid = document.getElementById("mid").value;
		
		//2.HTML 태그내 데이터 넣기
		let idcheck = document.getElementById("idcheck");
		
		//정규표현식 : 특정한 규칙을 가지는 문자열의 집합 언어
		let idj = /^[a-zA-Z0-9]{5,15}$/; //영문 숫자 5~15글자
			//	 /^ : 정규표현식 시작
			//	 $/ : 정규표현식 끝
			//	[a-z] : 소문자 찾음
			//	[A-Z] : 대문자 찾음
			//	[0-9] : 숫자 찾음
			//	{ 최소길이, 최대길이 } : 문자 최소길이 ~ 최대길이 까지만 입력
				//정규표현식.test(변수) : 해당 변수가 정규표현식에 동일하면 true 
			if(idj.test(mid)){ //정규표현식과 다르면
					//아이디 중복체크
						//비동기식 통신 [목적 : 페이지 전환 없이 java(Controller)통신]
						// jquery에서 제공해주는 메소드
				$.ajax({
		            // 보내는 위치 [ 서블릿 경로 ]
		            url : "../idcheck" ,
		            // 보내는 데이터  { "변수명" : 값 }
		            data : { "mid" : mid  } ,
		            // 통신 성공 했을경우 (  result = 받은 값 변수 )
		            success : function( result ){
		               
	               if( result == 1 ){ // 만약에 받은 데이터가 1이면
	                  idcheck.innerHTML="사용중인 아이디 입니다.";
	                  pass[0] = false;
	               }else{ // 만약에 받은 데이터가 1이 아니면
	                  idcheck.innerHTML="사용가능한 아이디 입니다.";
	                  pass[0] = true;
	               }
	            }
	         });	//ajax end
		}else{
			idcheck.innerHTML="영문 , 숫자 포함 5~15길이로 입력해주세요.";
			pass[0] = false;
		}
	});
	//비밀번호 체크
	$("#mpassword").keyup(function(){
		// let mpassword = document.getElementById("mpassword").value; //js 식
		let mpassword = $("#mpassword").val(); //jquery 식
		let mpasswordcheck = $("#mpasswordcheck").val(); 
		
		let passwordj = /^[a-zA-Z0-9]{5,15}$/;
		
		if(passwordj.test(mpassword)){
			if( mpassword != mpasswordcheck ){
				// 비밀번호와 비밀번호 체크와 다르면
					//equals(X) // != (o)
				$("#passwordcheck").html("패스워드가 서로 다릅니다.");
				pass[1] = false;
			}else{
				$("#passwordcheck").html("사용가능한 비밀번호 입니다.");
				pass[1] = true; pass[2] = true;
			}
		}else{
			$("#passwordcheck").html("영문과 숫자로 5~15글자 입력해주세요.");
			pass[1] = false;
		}
	}); //비밀번호 유효 확인 end
	
	$("#mpasswordcheck").keyup(function(){
		// let mpassword = document.getElementById("mpassword").value; //js 식
		let mpassword = $("#mpassword").val(); //jquery 식
		let mpasswordcheck = $("#mpasswordcheck").val(); 
		
		if( mpassword != mpasswordcheck ){
				// 비밀번호와 비밀번호 체크와 다르면
					//equals(X) // != (o)
				$("#passwordcheck").html("패스워드가 서로 다릅니다.");
				pass[2] = false;
			}else{
				$("#passwordcheck").html("사용가능한 비밀번호 입니다.");
				pass[2] = true; pass[1] = true;
			}
		}); //비밀번호 일치 확인 end
		
	//이름체크
	$("#mname").keyup(function(){
		
		let mname = $("#mname").val(); //해당 id 데이터 가져오기
		let namej = /^[가-힣]{2,10}$/;	//한글만 2~10글자
		
		if(namej.test(mname)){
			$("#namecheck").html("사용가능한 이름입니다.");
			pass[3] = true;
		}else{
			$("#namecheck").html("한글 2~10글자로 입력해주세요");
			pass[3] = false;
		}
	}); //이름 체크 end
	
	//전화번호 체크	
	$("#mphone").keyup(function(){
		
		let mphone = $("#mphone").val(); //해당 id 데이터 가져오기
		let phonej = /^010([0-9]{4})([0-9]{4})$/;	//숫자만 가능 010-숫자4자리-숫자4자리
		
		if(phonej.test(mphone)){
			$("#phonecheck").html("사용가능한 번호입니다.");
			pass[4] = true;
		}else{
			$("#phonecheck").html("다시 확인해주세요");
			pass[4] = false;
		}
	});	//전화번호 체크 end
	
	//이메일 체크	
	$("#memail").keyup(function(){
		
		let memail = $("#memail").val(); //해당 id 데이터 가져오기
		let memailaddress = $("#memailaddress").val();
		
		if( memailaddress == "" ){ 
			$("#emailcheck").html("이메일을 적어주세요");  
			pass[5] = false;
		}else{
			let emailj = /^[a-zA-Z0-9]{3,20}$/;	
		
			if(emailj.test(memail)){
			
				//이메일 중복체크
						let email = memail+"@"+memailaddress;
						$.ajax({
								url : "../emailcheck",
								data : { "email" : email } , 
								success : function( result ){
									if( result == 1 ){
										$("#emailcheck").html("사용중인 이메일 입니다."); 
										pass[5] = false;
									}else{
										$("#emailcheck").html("사용가능한 이메일 입니다.2");
										 pass[5] = true;
									}
								}
							}); // ajax end 
					}else {
						$("#emailcheck").html("다시 확인해주세요");
					}
				}
	});	//이메일체크 end
	

	//이메일주소 목록상자 선택시
	$("#emailselect").change(function(){	//목록상자 내 값이 변경되었을때
		let emailselect = $("#emailselect").val();
		if(emailselect == ""){
			$("#memailaddress").val(" ");
			$("#memailaddress").attr("readonly" , false);
		}else {
			$("#memailaddress").val(emailselect);
			$("#memailaddress").attr("readonly" , true);
			$("#emailcheck").html("사용가능한 이메일 입니다.3");
			pass[5] = true;
		}
	});
	
		
	//주소체크
		$("#address4").keyup(function(){
			let address1 = $("#address1").val();
			let address2 = $("#address2").val();
			let address3 = $("#address3").val();
			let address4 = $("#address4").val();
			
			if(address1 == "" || address2 == "" || address3 == "" || address4 == ""){
				$("addresscheck").html("모든 주소를 입력해주세요");
				pass[6] = false;
			}else{
				$("addresscheck").html("사용가능한 주소입니다.");
				pass[6] = true;
				
			}
			
		});
		
		
		
});
 
	 //폼전송 메소드
	 function signup(){
		//pass 배열이 모두 true이면 폼 전송
		let check = true;
		for(let i = 0; i <pass.length; i++){
			if(pass[i] == false) check = false;
		}
		if(check){
			//js에서 폼 전송하는 방법
			document.getElementById("signupform").submit();
			
		}else {
			alert("필수입력 사항이 입력되지 않았습니다.");
		}
	}
			
	 
 
 
 //다음 api js - 주소
 function findaddress() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var roadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 참고 항목 변수

                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('address1').value = data.zonecode;
                document.getElementById("address2").value = roadAddr;
                document.getElementById("address3").value = data.jibunAddress;
                
                var guideTextBox = document.getElementById("guide");
                // 사용자가 '선택 안함'을 클릭한 경우, 예상 주소라는 표시를 해준다.
                if(data.autoRoadAddress) {
                    var expRoadAddr = data.autoRoadAddress + extraRoadAddr;
                    guideTextBox.innerHTML = '(예상 도로명 주소 : ' + expRoadAddr + ')';
                    guideTextBox.style.display = 'block';

                } else if(data.autoJibunAddress) {
                    var expJibunAddr = data.autoJibunAddress;
                    guideTextBox.innerHTML = '(예상 지번 주소 : ' + expJibunAddr + ')';
                    guideTextBox.style.display = 'block';
                } else {
                    guideTextBox.innerHTML = '';
                    guideTextBox.style.display = 'none';
                }
            }
        }).open();
        
}




