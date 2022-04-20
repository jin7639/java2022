<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<style type="text/css">
		h3 {
			text-align: center;
		}
		li {
			list-style-type: none;
		}
		#join {
			width: 600px;
			margin: 0 auto;
			border-top: solid 2px #eeeeee;
			border-bottom: solid 2px #eeeeee;
			padding: 30px;
		}
		#button {
			margin-top: 20px;
			margin-left: 60%;
		}
		.cols {
			padding: 3px;
		}
		.cols li{
			display: inline-block;
		}
		.col1 {
			width: 150px
		}
		.col2 input {
			width: 200px;
			height: 20px;
		}
		.hello {
			vertical-align:top;
		}
		.button {
			padding: 10px;
		}
	
	</style>

</head>
<body>
	<!-- ��� -->
	<%@include file="header.jsp" %>
	<!-- ��� �̹��� -->
	<%@include file="mainimg.jsp" %>
	<!-- ���� -->
	<h3>ȸ�� ���� ��</h3>
	<form>
		<ul id="join"> <!-- ��ü -->
			<li>	<!-- �� tr-->	
				<ul class="cols">
					<li class="col1">���̵�</li> <!-- column/td 1 -->
					<li class="col2"><input type="text"></li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1">��й�ȣ</li>
					<li class="col2"><input type="password"></li>
				</ul>
			
			</li>
			<li>
				<ul class="cols">
					<li class="col1">��й�ȣ Ȯ��</li>
					<li class="col2"><input type="password"></li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1">�̸�</li>
					<li class="col2"><input type="text"></li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1">�̸���</li>
					<li><input type="text">@
						<select>
							<option> ���� �Է� </option>
							<option> naver.com </option>
							<option> gmail.com </option>
						</select>
					</li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1">�̸��� ����</li>
					<li >
					<input type="radio" name="email" checked="checked">����
					<input type="radio" name="email">�����
					</li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1">���� ���</li>
					<li >
						<input type="checkbox" name="access1">ģ����õ
						<input type="checkbox" name="access2">���ͳ� �˻�
						<input type="checkbox" name="access3">��Ÿ
					</li>
				</ul>
			</li>
			<li>
				<ul class="cols">
					<li class="col1 hello">�λ縻</li>
					<li><textarea rows="6" cols="40"></textarea>
					</li>
				</ul>
			</li>
		</ul>
	</form>
	<div id="button">
		<input class="button" type="button" value="�����ϱ�">
		<input class="button" type="button" value="����ϱ�">
	</div>
	<!-- Ǫ�� -->
	<%@include file="footer.jsp" %>
</body>
</html>