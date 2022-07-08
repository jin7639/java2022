
alert("update");
function updatecheck(){
	if(document.update.custname.value == ""){
		alert("회원성명을 입력해주세요");
		document.update.custname.focus();
		return false;
	}
	if(document.update.phone.value == ""){
		alert("전화번호를 입력해주세요");
		document.update.phone.focus();
		return false;
	}
	if(document.update.address.value == ""){
		alert("회원주소를 입력해주세요");
		document.update.address.focus();
		return false;
	}
	if(document.update.grade.value == ""){
		alert("회원등급을 입력해주세요");
		document.update.grade.focus();
		return false;
	}
	if(document.update.city.value == ""){
		alert("도시코드를 입력해주세요");
		document.update.city.focus();
		return false;
	}
	document.update.submit();
}