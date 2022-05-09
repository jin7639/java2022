/**
 * 
 */
 
//문서 열렸을 때 실행
$(document).ready(function(){
  $('#summernote').summernote({
    placeholder: '내용을 입력해주세요!',
    tabsize: 1,
    minheight: 200,
    maxheight : null,
    lang : 'ko-KR' 
  });
});
function filedelete(bno){
	
	$.ajax({
		url : "filedelete" ,
		data : { "bno" : bno },
		success : function( result ){
			if(result == "1"){
				alert("첨부파일삭제완료");
				location.reload();
			}else {
				alert("첨부파일삭제오류");
			}
		}
	});
}