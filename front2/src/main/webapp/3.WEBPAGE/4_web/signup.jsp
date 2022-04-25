<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- 사용자가 정의한 css 포함 -->
	<link href="css/main.css" rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp" %>
	<br><br><br><br><br><br><br><br>
	<div class="container">
		<h3 class="text-center">회원가입</h3>
		<div class="row">
			<div class="col-md-6 px-3">
				<hr>
				<p>회원가입 및 정상적인 서비스 이용을 위해 아래 약관을 읽어 보시고, 동의 여부를 결정해주세요</p>
				<p>필수 약관을 동의 하셔야 회원가입이 가능합니다.</p>
				<hr>
				<h2>회원가입 약관동의<span style="color: red">*</span></h2>
				<textarea class="form-control" rows="5" readonly style="background-color: white; resize: none; ">
				제1장 총칙
		제1조 (목적)
		본 약관은 ㈜사람인에이치알(이하 "회사"라 합니다)이 운영하는 웹사이트(이하 “사이트”라 합니다) 및 모바일 애플리케이션(이하 “애플리케이션”이라 하며, 사이트와 애플리케이션을 총칭하여 “사이트 등”이라 합니다)을 통해 서비스를 제공함에 있어 회사와 이용자의 이용조건 및 제반 절차, 기타 필요한 사항의 규정을 목적으로 합니다.
		
		제2조 (용어의 정의)
		본 약관에서 사용하는 용어의 정의는 아래와 같습니다.
		
		① “사이트”라 함은 회사가 서비스를 이용자에게 제공하기 위하여 제작, 운영하는 사이트를 말합니다. 현재 회사가 운영하는 사이트의 접속 주소는 아래와 같습니다.
		- www.saramin.co.kr
		- m.saramin.co.kr
		② "애플리케이션"이라 함은 회사와 계열사가 이용자에게 서비스를 제공하기 위하여IOS, 안드로이드 등 운영체제와 관계없이 스마트폰 또는 기타 휴대용 단말기에서 이용할 수 있도록 제작, 운영하는 프로그램을 말합니다. 현재 회사가 운영하는 애플리케이션의 이름은 아래와 같습니다.
		- 사람인, 아이엠그라운드, 연봉계산기 등
		③ "서비스"라 함은 채용정보, 이력서 및 기업정보 제공 기타의 서비스를 통하여 구직 채용시장에서 구직자와 기업의 연결을 돕는 플랫폼 서비스입니다. 구체적으로는 회사가 기업 또는 구직자가 구인, 구직과 교육을 목적으로 등록하는 각종 자료를 DB화하여 각각의 목적에 맞게 분류 가공, 집계하여 정보를 제공하는 서비스 및 기타 구인 및 구직이 원활히 이루어지도록 하기 위하여 사이트 등에서 제공하는 모든 서비스를 말합니다. 회사가 제공하는 서비스는 유형에 따라 무료 또는 유료로 제공됩니다. 서비스의 자세한 내용은 제8조에서 정하는 바에 따릅니다.
		④ "이용자"라 함은 사이트 등에 접속하여 본 약관에 따라 회사가 제공하는 서비스를 이용하는 회원(기업회원 및 개인회원을 포함) 및 비회원을 말합니다.
		⑤ "개인회원"이라 함은 본 서비스를 이용하기 위하여 본 약관에 동의하고 회사와 서비스 이용계약을 체결하여 개인회원ID를 부여받은 이용자를 말합니다.
		⑥ “비회원”이라 함은 회사와 서비스 이용계약을 체결하지 않은 채 사이트 등을 통하여 회사가 제공하는 서비스를 이용하는 이용자를 말합니다.
		⑦ "서비스 이용계약"이라 함은 회사가 개인회원을 위해 제공하는 서비스를 계속적으로 이용하기 위하여 회사와 이용자 사이에 체결되는 계약을 말합니다.
		⑧ "이용자ID" 또는 "개인회원ID"라 함은 개인회원의 식별 및 서비스 이용을 위하여 개인회원이 선정하거나 회사가 부여하는 문자와 숫자의 조합을 말합니다.
		⑨ "비밀번호"라 함은 회사의 서비스를 이용하려는 사람이 개인회원ID를 부여 받은 자와 동일인임을 확인하고 개인회원의 권익을 보호하기 위하여 개인회원이 선정하거나 회사가 부여하는 문자와 숫자의 조합을 말합니다.
		⑩ “계정”이라 함은 개인회원의 개인정보, 이력서 등을 등록, 관리할 수 있도록 회사가 개인회원에게 제공하는 공간을 말합니다.
				</textarea>
				<br>
				<input type="checkbox"> 회원가입 약관 동의 합니다.
				<hr>
				<h2>개인정보처리방침<span style="color: red">*</span></h2>
				<textarea class="form-control" rows="5" readonly style="background-color: white; resize: none; ">
				개인정보처리방침(Ver 5.31)
		주식회사 사람인에이치알(이하 “회사”)는 「개인정보보호법」, 「정보통신망 이용촉진 및 정보보호 등에 관한 법률」(이하 “정보통신망법”) 등 관련 법령상의 개인정보 보호규정을 준수하며, 개인정보보호법에 의거한 개인정보처리방침을 정하여 이용자 권익 보호에 최선을 다하고 있습니다. 본 개인정보처리방침은 회사가 제공하는 사람인 서비스(오투잡 서비스 별도)에 적용되며 다음과 같은 내용을 포함하고 있습니다.
		
		1. 개인정보 수집 및 이용 현황
		가. 회사는 서비스 제공을 위한 최소한의 범위 내에서 이용자의 동의 하에 개인정보를 수집하며, 수집한 모든 개인정보는 고지한 목적 범위 내에서만 사용됩니다. 또한, 제공하는 서비스(채용 정보제공 등) 특성상 「근로기준법」에 따라 만15세 미만인 경우 회원가입을 허용하지 않습니다. 회사에서 제공하는 서비스 유형에 따라 다음과 같이 개인정보를 수집, 이용, 보유 및 파기하고 있습니다.
		
		귀하께서는 회사가 위와 같이 수집하는 개인정보에 대해 동의하지 않거나 개인정보를 기재하지 않음으로써 거부할 수 있습니다. 다만, 이때 회원에게 제공되는 서비스가 제한될 수 있습니다.
		
				</textarea>
				<br>
				<input type="checkbox"> 개인정보처리방침 동의 합니다.
			</div>
			<div class="col-md-6 text-center flex-column" >
				<form action="">
					<input class="form-control my-3" type="text" placeholder="아이디를 입력하세요." >
					<input class="form-control mb-3" type="password" placeholder="비밀번호를 입력하세요." >
					<input class="form-control mb-3" type="password" placeholder="한번더 비밀번호를 입력하세요." >
					<input class="form-control mb-3" type="text" placeholder="이름을 입력하세요." >
					<input name="sex" class="mb-3" type="radio">남자
					<input name="sex" class="mb-3" type="radio">여자
					<input class="form-control mb-3" type="text" placeholder="연락처를 입력하세요." >
					<input class="form-control mb-3" type="text" placeholder="이메일를 입력하세요." >
					<input class="form-control mb-3" type="text" placeholder="나이를 입력하세요." >
					<div class="row">
						<div class="col-md-4"><h4>주소<span style="color: red">*</span></h4></div>
						<div class="col-md-4">
							<input class=" form-control mb-3" type="text" placeholder="우편번호">
						</div>
						<div class="col-md-4 ">
							<button class="form-control mb-3">우편번호 찾기</button>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 offset-4 mb-3">
							<input class="form-control" type="text" placeholder="도로명주소">
						</div>
						<div class="col-md-4 mb-3">
							<input class="form-control" type="text" placeholder="지번주소">
						</div>
					</div>
					<div class="row">
						<div class="col-md-8 offset-4 mb-3">
							<input class="form-control" type="text" placeholder="상세주소">
						</div>
					</div>
				<button type="submit" class="form-control mb-3">회원가입</button>
				</form>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>