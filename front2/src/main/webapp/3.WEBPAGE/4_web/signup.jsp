<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- ����ڰ� ������ css ���� -->
	<link href="css/main.css" rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp" %>
	<br><br><br><br><br><br><br><br>
	<div class="container">
		<h3 class="text-center">ȸ������</h3>
		<div class="row">
			<div class="col-md-6 px-3">
				<hr>
				<p>ȸ������ �� �������� ���� �̿��� ���� �Ʒ� ����� �о� ���ð�, ���� ���θ� �������ּ���</p>
				<p>�ʼ� ����� ���� �ϼž� ȸ�������� �����մϴ�.</p>
				<hr>
				<h2>ȸ������ �������<span style="color: red">*</span></h2>
				<textarea class="form-control" rows="5" readonly style="background-color: white; resize: none; ">
				��1�� ��Ģ
		��1�� (����)
		�� ����� �߻���ο���ġ��(���� "ȸ��"�� �մϴ�)�� ��ϴ� ������Ʈ(���� ������Ʈ���� �մϴ�) �� ����� ���ø����̼�(���� �����ø����̼ǡ��̶� �ϸ�, ����Ʈ�� ���ø����̼��� ��Ī�Ͽ� ������Ʈ ��̶� �մϴ�)�� ���� ���񽺸� �����Կ� �־� ȸ��� �̿����� �̿����� �� ���� ����, ��Ÿ �ʿ��� ������ ������ �������� �մϴ�.
		
		��2�� (����� ����)
		�� ������� ����ϴ� ����� ���Ǵ� �Ʒ��� �����ϴ�.
		
		�� ������Ʈ���� ���� ȸ�簡 ���񽺸� �̿��ڿ��� �����ϱ� ���Ͽ� ����, ��ϴ� ����Ʈ�� ���մϴ�. ���� ȸ�簡 ��ϴ� ����Ʈ�� ���� �ּҴ� �Ʒ��� �����ϴ�.
		- www.saramin.co.kr
		- m.saramin.co.kr
		�� "���ø����̼�"�̶� ���� ȸ��� �迭�簡 �̿��ڿ��� ���񽺸� �����ϱ� ���Ͽ�IOS, �ȵ���̵� �� �ü���� ������� ����Ʈ�� �Ǵ� ��Ÿ �޴�� �ܸ��⿡�� �̿��� �� �ֵ��� ����, ��ϴ� ���α׷��� ���մϴ�. ���� ȸ�簡 ��ϴ� ���ø����̼��� �̸��� �Ʒ��� �����ϴ�.
		- �����, ���̿��׶���, �������� ��
		�� "����"�� ���� ä������, �̷¼� �� ������� ���� ��Ÿ�� ���񽺸� ���Ͽ� ���� ä����忡�� �����ڿ� ����� ������ ���� �÷��� �����Դϴ�. ��ü�����δ� ȸ�簡 ��� �Ǵ� �����ڰ� ����, ������ ������ �������� ����ϴ� ���� �ڷḦ DBȭ�Ͽ� ������ ������ �°� �з� ����, �����Ͽ� ������ �����ϴ� ���� �� ��Ÿ ���� �� ������ ��Ȱ�� �̷�������� �ϱ� ���Ͽ� ����Ʈ ��� �����ϴ� ��� ���񽺸� ���մϴ�. ȸ�簡 �����ϴ� ���񽺴� ������ ���� ���� �Ǵ� ����� �����˴ϴ�. ������ �ڼ��� ������ ��8������ ���ϴ� �ٿ� �����ϴ�.
		�� "�̿���"�� ���� ����Ʈ � �����Ͽ� �� ����� ���� ȸ�簡 �����ϴ� ���񽺸� �̿��ϴ� ȸ��(���ȸ�� �� ����ȸ���� ����) �� ��ȸ���� ���մϴ�.
		�� "����ȸ��"�̶� ���� �� ���񽺸� �̿��ϱ� ���Ͽ� �� ����� �����ϰ� ȸ��� ���� �̿����� ü���Ͽ� ����ȸ��ID�� �ο����� �̿��ڸ� ���մϴ�.
		�� ����ȸ�����̶� ���� ȸ��� ���� �̿����� ü������ ���� ä ����Ʈ ���� ���Ͽ� ȸ�簡 �����ϴ� ���񽺸� �̿��ϴ� �̿��ڸ� ���մϴ�.
		�� "���� �̿���"�̶� ���� ȸ�簡 ����ȸ���� ���� �����ϴ� ���񽺸� ��������� �̿��ϱ� ���Ͽ� ȸ��� �̿��� ���̿� ü��Ǵ� ����� ���մϴ�.
		�� "�̿���ID" �Ǵ� "����ȸ��ID"�� ���� ����ȸ���� �ĺ� �� ���� �̿��� ���Ͽ� ����ȸ���� �����ϰų� ȸ�簡 �ο��ϴ� ���ڿ� ������ ������ ���մϴ�.
		�� "��й�ȣ"�� ���� ȸ���� ���񽺸� �̿��Ϸ��� ����� ����ȸ��ID�� �ο� ���� �ڿ� ���������� Ȯ���ϰ� ����ȸ���� ������ ��ȣ�ϱ� ���Ͽ� ����ȸ���� �����ϰų� ȸ�簡 �ο��ϴ� ���ڿ� ������ ������ ���մϴ�.
		�� ���������̶� ���� ����ȸ���� ��������, �̷¼� ���� ���, ������ �� �ֵ��� ȸ�簡 ����ȸ������ �����ϴ� ������ ���մϴ�.
				</textarea>
				<br>
				<input type="checkbox"> ȸ������ ��� ���� �մϴ�.
				<hr>
				<h2>��������ó����ħ<span style="color: red">*</span></h2>
				<textarea class="form-control" rows="5" readonly style="background-color: white; resize: none; ">
				��������ó����ħ(Ver 5.31)
		�ֽ�ȸ�� ����ο���ġ��(���� ��ȸ�硱)�� ������������ȣ����, ��������Ÿ� �̿����� �� ������ȣ � ���� ������(���� ��������Ÿ�����) �� ���� ���ɻ��� �������� ��ȣ������ �ؼ��ϸ�, ����������ȣ���� �ǰ��� ��������ó����ħ�� ���Ͽ� �̿��� ���� ��ȣ�� �ּ��� ���ϰ� �ֽ��ϴ�. �� ��������ó����ħ�� ȸ�簡 �����ϴ� ����� ����(������ ���� ����)�� ����Ǹ� ������ ���� ������ �����ϰ� �ֽ��ϴ�.
		
		1. �������� ���� �� �̿� ��Ȳ
		��. ȸ��� ���� ������ ���� �ּ����� ���� ������ �̿����� ���� �Ͽ� ���������� �����ϸ�, ������ ��� ���������� ������ ���� ���� �������� ���˴ϴ�. ����, �����ϴ� ����(ä�� �������� ��) Ư���� ���ٷα��ع����� ���� ��15�� �̸��� ��� ȸ�������� ������� �ʽ��ϴ�. ȸ�翡�� �����ϴ� ���� ������ ���� ������ ���� ���������� ����, �̿�, ���� �� �ı��ϰ� �ֽ��ϴ�.
		
		���ϲ����� ȸ�簡 ���� ���� �����ϴ� ���������� ���� �������� �ʰų� ���������� �������� �������ν� �ź��� �� �ֽ��ϴ�. �ٸ�, �̶� ȸ������ �����Ǵ� ���񽺰� ���ѵ� �� �ֽ��ϴ�.
		
				</textarea>
				<br>
				<input type="checkbox"> ��������ó����ħ ���� �մϴ�.
			</div>
			<div class="col-md-6 text-center flex-column" >
				<form action="">
					<input class="form-control my-3" type="text" placeholder="���̵� �Է��ϼ���." >
					<input class="form-control mb-3" type="password" placeholder="��й�ȣ�� �Է��ϼ���." >
					<input class="form-control mb-3" type="password" placeholder="�ѹ��� ��й�ȣ�� �Է��ϼ���." >
					<input class="form-control mb-3" type="text" placeholder="�̸��� �Է��ϼ���." >
					<input name="sex" class="mb-3" type="radio">����
					<input name="sex" class="mb-3" type="radio">����
					<input class="form-control mb-3" type="text" placeholder="����ó�� �Է��ϼ���." >
					<input class="form-control mb-3" type="text" placeholder="�̸��ϸ� �Է��ϼ���." >
					<input class="form-control mb-3" type="text" placeholder="���̸� �Է��ϼ���." >
					<div class="row">
						<div class="col-md-4"><h4>�ּ�<span style="color: red">*</span></h4></div>
						<div class="col-md-4">
							<input class=" form-control mb-3" type="text" placeholder="�����ȣ">
						</div>
						<div class="col-md-4 ">
							<button class="form-control mb-3">�����ȣ ã��</button>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4 offset-4 mb-3">
							<input class="form-control" type="text" placeholder="���θ��ּ�">
						</div>
						<div class="col-md-4 mb-3">
							<input class="form-control" type="text" placeholder="�����ּ�">
						</div>
					</div>
					<div class="row">
						<div class="col-md-8 offset-4 mb-3">
							<input class="form-control" type="text" placeholder="���ּ�">
						</div>
					</div>
				<button type="submit" class="form-control mb-3">ȸ������</button>
				</form>
			</div>
		</div>
	</div>
	<%@include file="footer.jsp" %>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>