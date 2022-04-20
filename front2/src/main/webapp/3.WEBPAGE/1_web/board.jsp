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
	<!-- ��� -->
	<%@include file="header.jsp" %>
	<!-- ��� �̹��� -->
	<%@include file="mainimg.jsp" %>
	<!-- ���� -->
	<div id="notice">
		<h3>��������</h3>
			<div id="search">
				<input id="search_txt" type="text" placeholder="�˻�� �Է����ּ���.">
				<input id="search_btn"type="button" value="�˻�">
			</div>
			<div>
				<table>
					<tr id="table_header">
						<th class="table_header">��ȣ</th>
						<th class="table_header">����</th>
						<th class="table_header">�����</th>
					</tr>
					<tr>
						<td>3</td>
						<td class="title">[��������] �������� ó����ħ ����ȳ�</td>
						<td>2017.07.13</td>
					</tr>
					<tr>
						<td>2</td>
						<td class="title">�������� �ȳ��Դϴ�. �̿����ּż� �����մϴ�.</td>
						<td>2017.06.15</td>
					</tr>
					<tr>
						<td>1</td>
						<td class="title">�������� �ȳ��Դϴ�. �̿����ּż� �����մϴ�.</td>
						<td>2017.06.15</td>
					</tr>
				</table>
			</div>
		</div>
	<!-- Ǫ�� -->
	<%@include file="footer.jsp" %>
	
</body>
</html>