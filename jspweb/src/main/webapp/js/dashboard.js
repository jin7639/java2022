/**
 * 
 */
 
function pagechange(page){
	$("#mainbox").load(page+".jsp");
		//$ 제이쿼리 문법
		//특정 태그 호출 : $("태그id명")
		//태그.load(페이지 경로)
}
/*사이드바 위치 변경을 이용한 사이드바 열기/닫기*/
$(function(){
	let side = $("#sidebar"); /*태그 반복 사용을 위해 변수에 담기 */
	//find() 해당 태그내 특정 태그 찾기
	side.find('span').on('click',function(){
		side.toggleClass('open'); //해당 태그의 클래스가 open이면
			//toggleclass : 해당 태그에 클래스 넣기 [open 클래스 넣기]
		if(side.hasClass('open')){
			side.stop(true).animate({left:"0px"}, 300);
				//side 태그에 애니메이션 효과 : 해당 태그의 위치를 왼쪽 0px로 이동
		}else{
			side.stop(true).animate({left:"-200px"}, 300);
				//side 태그에 애니메이션 효과 : 해당 태그의 위치를 왼쪽 -200px로 이동
		}
	});
});