<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>결제</h2>
	<form action="<%=request.getContextPath()%>/buy.do" method="post">

			
		이름: <input type="text" name="name">
		이메일: <input type="text" name="email">
		폰넘버:<input type="text" name="phone">
		주소: <input type="text" name="address">
		총가격: <input type="text" name="totalPrice">
		<!-- <input type="submit" value="결제하기"> -->
		<button onclick="requestPay()">결제하기</button>
		<input type="reset"  value="취소하기">
	</form>
</body>
</html>
