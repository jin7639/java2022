/**
 * 
 */
 
//문서 열렸을 때 실행
$(document).ready(function(){
  $('#summernote').summernote({
    placeholder: '내용을 입력해주세요!',
    tabsize: 2,
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

function replywrite(bno){
	let rcontent = $("#rcontent").val();
	$.ajax({
		url : "replywrite",
		data : {"bno" : bno , "rcontent" : rcontent },
		success : function(result){
			if(result == 1){
				alert("댓글작성 완료");
				$("#rcontent").val("");	//댓글 작성input 공백으로 초기화
				$("#replytable").load(location.href+" #replytable");	//특정 태그 새로고침
			}else{
				alert("댓글작성 실패");
			}
		}
	})
}

function rereplyview(rno, bno){
	$("#"+rno).html(
		'<input type="text" id="rrcontent">'+
		'<button onclick="rereplywrite('+rno+','+bno+')">대댓글 등록</button>'
	);
}
function rereplywrite(rno, bno){
	let rrcontent = $("#rrcontent").val();
	$.ajax({
		url : "rereplywrite",
		data : { "rno" : rno , "bno" : bno , "rrcontent" : rrcontent},
		success : function(result){
			if(result == 1){
				alert("대댓글작성 완료");
				$("#rrcontent").val("");	//댓글 작성input 공백으로 초기화
				$("#replytable").load(location.href+" #replytable");	//특정 태그 새로고침
			}else{
				alert("대댓글작성 실패");
			}
		}
	})
}

