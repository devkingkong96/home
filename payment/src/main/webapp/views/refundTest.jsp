<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
	<form action="<%=request.getContextPath()%>/refundcomplete.do" method="post">
    	<button onclick="cancelPay()">환불하기</button>
    </form>
<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>
<script>
  function cancelPay() {
    $.ajax({
      // 예: http://www.myservice.com/payments/cancel
       url : "{환불정보를 수신할 가맹점 서비스 URL}", 
       type : "POST",
       dataType : "json",
      "data": {
        "merchant_uid": "{1700547573685}", // 예: ORD20180131-0000011
        "cancel_request_amount": 23000, // 환불금액
        "reason": "테스트 결제 환불" // 환불사유
        // [가상계좌 환불시 필수입력] 환불 수령계좌 예금주
        // "refund_holder": "홍길동", 
        // [가상계좌 환불시 필수입력] 환불 수령계좌 은행코드(예: KG이니시스의 경우 신한은행은 88번)
        // "refund_bank": "88" 
        // [가상계좌 환불시 필수입력] 환불 수령계좌 번호
        // "refund_account": "56211105948400" 
      },
      success:function(res){
        document.getElementById('refund-form').submit();
      },
      error:function(err){
        console.log('결제실패이유 : '+err);
      }
    });
    alert("환불완료");
  }
</script>
</body>
</html>
