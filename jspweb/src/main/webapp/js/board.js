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
