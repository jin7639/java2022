$("#incontent").focus();	//입력창에 포커스

//js 웹 소켓 변수
let websocket = null;


start();

/* 엔터 눌렀을 때*/
function enterkey(mid){
	if(window.event.keyCode == 13){
		if(mid == 'null'){
			alert("로그인 후 채팅입력이 가능합니다.");
			return;
		}else{
			send(mid);
		}
	}
}
/* 전송버튼 눌렀을 때*/
function sendbtn(mid){
	if(mid == 'null'){
		alert("로그인 후 채팅입력이 가능합니다.");
		return;
	}else{
		send(mid);
	}
}
/*채팅 소켓 실행 */
function start(){
	let mid = $("#mid").val();
	//192.168.17.33
	//js 에서 사용되는 웹소켓 클래스("ws://ip번호:포트번호/프로젝트이름/서버소켓이름")
	websocket = new WebSocket("ws://localhost:8081/jspweb/chatting/"+mid);
	websocket.onopen = function(e){onOpen(e);}
	websocket.onmessage = function(e){onmessage(e);}
	websocket.onclose = function(e){onclose(e)}
	websocket.onerror = function(e){onerror(e)}
}
function onerror(e){
	alert("서버소켓 오류" + e);
}
function onOpen(e){
	alert("서버소켓으로 들어왔습니다.");
	console.log(e);
	
}
function onclose(e){
	alert("채팅방을 나갑니다." + e);
}
function onmessage(e){
	
	let msg = JSON.parse(e.data);
	
	if(msg["type"] != "1"){
		let html = "";
		for(let i = 0; i <msg.length; i ++){
			html +=  
				'<div class="row p-2"><!-- 접속자 정보 표시 구역 -->'+
				'	<div class="col-sm-4"><!-- 프로필 이미지 표시 구역 -->'+
				'		<img class="img rounded-circle" alt="" src="/jspweb/board/upload/profile (1).jpg">'+
				'	</div>'+
				'	<div class="col-sm-8"><!-- 접속자 이름 -->'+
				'		<div class="membe_name">'+msg[i]["mid"]+'</div>'+
				'		<div class="btnbox">'+
				'			<span>쪽지</span>'+
				'			<span>친추</span>'+
				'		</div>'+
				'	</div>'+
				'</div>';
			
		}
		$("#enterlist").html( html );
	
			
	}else {
		let from = msg["from"];
		let content = msg["content"];
		let img = msg["img"];
		let date = msg["date"];
		let html = $("#contentbox").html();
		if(from == $("#mid").val()){
			html +=  '<div class="secontent"><!-- 보낼때 -->'+
					'	<span class="date">'+date+'</span>'+
					'	<span class="content">'+content+'</span>'+
					'</div>';
		}else{
			html +=
				'<div class="row g-0">'+
				'	<div class="col-sm-1">'+
				'		<img class="img rounded-circle" alt="" src="/jspweb/board/upload/profile (2).jpg">'+
				'	</div>'+
				'	<div class="col-sm-9">'+
				'		<div class="recontent"><!-- 받을때 -->'+
				'			<div class="member_name">'+from+'</div>'+
				'			<span class="content">'+content+'</span>'+
				'			<span class="date">'+date+'</span>'+
				'		</div>'+
				'	</div>'+
				'</div>';
		}
		$("#contentbox").html( html );
		$("#contentbox").scrollTop($("#contentbox")[0].scrollHeight);
	}	
}

function send(mid){
	let content = $("#incontent").val();
	
	//json 형식으로 통신
	let msg ={ //json 객체화
		type : "1",
		from : mid,
		content : content,
		img : "profile (2).jpg",
		date : new Date().toLocaleTimeString()
	} 
	
	//json 통신할 때 json 모양 문자열 변환
		// json - > 문자열 : JSON.stringify
		// 문자열 - > json : JSON.parse()
	websocket.send(JSON.stringify(msg));
	$("#incontent").val("");	//전송후 초기화
	$("#incontent").focus();	//입력창에 포커스
}