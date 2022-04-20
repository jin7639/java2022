<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		#notice {
			margin: 0 auto;
			text-align: center;
		}
		h3 {
			margin-bottom: 20px;
		}
		#search {
			margin-bottom: 20px;
		}
		table {
			margin: 0 auto;
			border-collapse: collapse;
			width: 1100px;
			border-top: 2px solid #eeeeee;
			border-bottom: 2px solid #eeeeee;
		}
		tr {
			height: 50px;
			border-bottom: 1px solid #eeeeee;
		}
		
		#search_txt {
			width: 500px;
			height: 30px;
			text-align: left;
		}
		#search_btn {
			width: 80px;
			height: 35px;
			background-color: #555555;
			color: white;
		}
		.title {
			text-align: left;
			padding-left: 50px;
		}
	</style>
</head>
<body>
	<!-- 헤더 -->
	<%@include file="header.jsp" %>
	<!-- 헤더 이미지 -->
	<%@include file="mainimg.jsp" %>
	<!-- 본문 -->
	<div id="notice">
		<h3>공지사항</h3>
			<div id="search">
				<input id="search_txt" type="text" placeholder="검색어를 입력해주세요.">
				<input id="search_btn"type="button" value="검색">
			</div>
			<div>
				<table>
					<tr id="table_header">
						<th class="table_header">번호</th>
						<th class="table_header">제목</th>
						<th class="table_header">등록일</th>
					</tr>
					<tr>
						<td>3</td>
						<td class="title">[공지사항] 개인정보 처리방침 변경안내</td>
						<td>2017.07.13</td>
					</tr>
					<tr>
						<td>2</td>
						<td class="title">공지사항 안내입니다. 이용해주셔서 감사합니다.</td>
						<td>2017.06.15</td>
					</tr>
					<tr>
						<td>1</td>
						<td class="title">공지사항 안내입니다. 이용해주셔서 감사합니다.</td>
						<td>2017.06.15</td>
					</tr>
				</table>
			</div>
		</div>
	<!-- 푸터 -->
	<%@include file="footer.jsp" %>
	
</body>
</html>