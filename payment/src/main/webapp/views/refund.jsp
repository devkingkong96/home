<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/getToken.do" method="post">
		<button id="">��ū�� �ޱ�</button>
	</form>
	<form action="<%=request.getContextPath()%>/refund.do" method="post">
		<button id="check2">ȯ���ϱ�</button>
	</form>
	<script>
	$("#check2").click(function(e){
		$.ajax({
				url: "/samsam/coupon_cancel.do",
				type:"post",
				//datatype:"json",
				contentType : 'application/x-www-form-urlencoded; charset = utf-8',
				data : {
					"biz_email" : '' // �ֹ���ȣ
					"cancle_request_amount" : 2000, //ȯ�ұݾ�
					"reason": "�׽�Ʈ ���� ȯ��", //ȯ�һ���
					//"refund_holder": "ȫ�浿", //[������� ȯ�ҽ� �ʼ��Է�] ȯ�� ������� ������
					//"refund_bank":"88", //[������� ȯ�ҽ� �ʼ��Է�] ȯ�� ������� �����ڵ�(ex Kg�̴Ͻý��� ��� �������� 88)
					//"refund_account": "56211105948400" // [������� ȯ�ҽ� �ʼ��Է�] ȯ�� ������� ��ȣ
				}
			}).done(function(result){ //ȯ�� ����
				 pay -= 5;
				 $('#pay_coupon').html(pay);	
				console.log("ȯ�� ���� : "+ result);
			}).fail(function(error){
				console.log("ȯ�� ���� : "+ error);
			});//ajax
	}); //check2 Ŭ��
}); //doc.ready
	</script>
</body>
</html>