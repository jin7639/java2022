/*

	js문법 [ 사용목적 : 유효성검사, 비동기통신(화면전환 없는 통신)]
		1. 주석 : java 동일
		2. 변수선언
			1. var : 변수명 중복 O, 메모리 초기화 O -> 
			2. const : 변수명 중복 X, 메모리 초기화 X ->java final(고정값)
			3. let : 변수명 중복 X, 메모리 초기화 O
		3. 내장객체/메소드
			1. alert("알림내용") 	: 알림창
			2. document.		: 문서 객체 [현 html 객체화]
				1. .write("html작성") : html 쓰기
				2. .getElementById() : 해당 태그 가져오기
					.innerHTML : 해당 태그에 html 넣기		: 해당 태그에 html 넣기
					.textContent = ""해당 태그에 넣을 데이터" 	: 해당 태그에 html 넣기
					.style.css.속성명 = 속성값				: 해당 태그에 css 속성 적용
					.value								: 해당 태그에 value 값 가져오기 [value 속성이 있는 태그만 가능]
			3. console.log() 	: 브라우저(F12)내 console창에 출력 [테스트 목적]
		4. 반복문 / 제어문
			1. for(초기값 ; 조건식; 증감식) {		}
			2. if(논리식){	}
		5.함수 선언
			function 함수명() {실행문;} 		인수 없을 때
			function 함수명(인수, 인수) {실행문;}	인수 있을 때


 */
var 메시지1 = "자바 var변수";
//alert(메시지1);
var 메시지1 = "자바 var중복변수";
//alert(메시지1);
//변수 var : 중복 가능, 메모리 초기화 가능

const 메시지4 = "const 변수";
//alert(메시지4);
//변수 const : 고정값. 중복 불가능.
//메시지4 = "const변수 값 변경";
//alert(메시지4);

let 메시지5 = "js let변수";
//alert(메시지5);
//let 메시지5 = "let 중복변수"
메시지5 = "let 중복변수 값변경"
//alert(메시지5);


let tag1 = document.getElementById("spantag1");
tag1.innerHTML = "js에서 작성된 문자";

let 가격 = 500; 	//변수 선언
let 개수 = 10;	//변수 선언
let 총가격 = 가격 * 개수 ;	//변수 연산
let tag2 = document.getElementById("spantag2");
tag2.innerHTML = 총가격;

	//function 함수명(인수) {}
		//js : function 함수명(인수) {실행문}
		//java : void 함수명(인수) {실행문}
function 함수1() { //html 태그내 이벤트 태그에서 함수 호출해야 실행 가능
 let color = [ 'red', 'black', 'white'];
	//배열선언
		//let 배열명 = [ 1, 2,3 ];
	//배열 호출
		//배열명 [인덱스 번호];
	let tag3 = document.getElementById("spantag3");
	tag3.textContent = color[0];
	tag3.style.color = color[0];
	
	//배경색 변경
	document.body.style.backgroundColor = "grey";
}

function 함수2() {
	
	//while
	let i = 1;	//변수선언
	while(i <= 10){	//반복문 - 10회 반복
		let tag4 = document.getElementById("orderlist1");
		tag4.innerHTML += "<li>반복횟수 : "+i+"</li>";
		// +=(대입연산자)
		i++;
	}

	//for
	let j = 0;
	let 제품배열 = ["갤럭시","아이폰","엘지폰"];
	for(j; j <제품배열.length; j++){
		let tag5 = document.getElementById("orderlist2");
		tag5.innerHTML+= "<li>제품명 : "+j+"</li>";
	}
	
}

function 함수3(){
	
	let 제품명 = document.getElementById("input1").value;
	document.getElementById("orderlist3").innerHTML += "<li>"+제품명+"</li>";
}

function 함수4() {
	document.getElementById("orderlist3").innerHTML = "";
}

function 함수5(이름, 성별) {
	document.write("입력하신 이름 : "+이름+"<br>");
	document.write("입력하신 성별 : "+성별);
}

