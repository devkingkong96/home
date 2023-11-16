<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%
	//주문자명,이메일,전화번호,주소,총가격 받아오기
   String name = (String)request.getAttribute("name");
   String email = (String)request.getAttribute("email");
   String phone = (String)request.getAttribute("phone");
   String address = (String)request.getAttribute("address");
   int totalPrice = (int)request.getAttribute("totalPrice"); 
%> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="https://code.jquery.com/jquery-1.12.4.min.js" ></script>
	<script src="https://cdn.iamport.kr/v1/iamport.js"></script>
	<script src="https://cdn.portone.io/v2/browser-sdk.js"></script>
	<script src="/main.js"></script>
</head>
<body>
	<!-- <button onclick="buy1()" >주문하기</button> -->
		<input type="radio" name="payment" class="mr-2" value="kcp"> 카드 결제
		<input type="radio" name="payment" class="mr-2" value="cacao"> 카카오페이 결제
		<button onclick="paymentOrder_btn()">결제하기</button>
    <script>
       <%-- function buy1(){
    	var IMP = window.IMP;
    	IMP.init("imp53448234"); // 'iamport' 대신 부여받은 "가맹점 식별코드" 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kakaopay',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '고구마',
            amount : '300',
            buyer_email : 'email@email',
            buyer_name : '구매자이름',
            buyer_tel : '010-5335',
            buyer_addr : '서울 금천구',
            buyer_postcode : '123-456',
        }, function(rsp) {
            if (rsp.success) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "<%=request.getContextPath()%>/payments/complete.do", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid,         //결제 고유번호
                        merchant_uid : rsp.merchant_uid //주문번호
                        /* buyerName : rsp.buyer_name //주문자 이름 */
                        /* amount : rsp.paid_amount //총가격 */
                        //필요한 데이터가 있으면 추가
                    }
                })
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/fail.do";
                alert(msg);
            }
        });
    }
     function buy(){
    	var IMP = window.IMP;
    	IMP.init("imp53448234"); // 'iamport' 대신 부여받은 "가맹점 식별코드" 사용
        var msg;
        
        IMP.request_pay({
            pg : 'kcp.{AO09C}',
            pay_method : 'card',
            merchant_uid : 'merchant_' + new Date().getTime(),
            name : '고구마',
            amount : '300',
            buyer_email : 'email@email',
            buyer_name : '구매자이름',
            buyer_tel : '010-5335',
            buyer_addr : '서울 금천구',
            buyer_postcode : '123-456',
        }, function(rsp) {
            if (rsp.success) {
                //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
                jQuery.ajax({
                    url: "<%=request.getContextPath()%>/payments/complete.do", //cross-domain error가 발생하지 않도록 주의해주세요
                    type: 'POST',
                    dataType: 'json',
                    data: {
                        imp_uid : rsp.imp_uid,         //결제 고유번호
                        merchant_uid : rsp.merchant_uid //주문번호
                        /* amount : rsp.paid_amount //총가격 */
                        //필요한 데이터가 있으면 추가
                    }
                })
            } else {
                msg = '결제에 실패하였습니다.';
                msg += '에러내용 : ' + rsp.error_msg;
                //실패시 이동할 페이지
                location.href="<%=request.getContextPath()%>/fail.do";
                alert(msg);
            }
        });
    }  --%>
    
    function paymentOrder_btn(){
		var kcp=document.querySelector('input[name="payment"][value="kcp"]');
		var cacao=document.querySelector('input[name="payment"][value="cacao"]');
		
		if(kcp.checked){
			kcp_payment();
		}else if(cacao.checked){
			cacao_payment();
		}else{
			alert('결제수단을 선택하세요.');
		}
	}
	
<!-- 카드 결제 함수 -->


/* 카카오결제 */
function cacao_payment(){
	var IMP = window.IMP;
	IMP.init("imp53448234"); // 'iamport' 대신 부여받은 "가맹점 식별코드" 사용
    var msg;
    
    IMP.request_pay({
        pg : 'kakaopay',
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : '고구마',
        amount : '300',
        buyer_email : 'email@email',
        buyer_name : '구매자이름',
        buyer_tel : '010-5335',
        buyer_addr : '서울 금천구',
        buyer_postcode : '123-456',
    }, function(rsp) {
        if (rsp.success) {
            //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
            jQuery.ajax({
                url: "<%=request.getContextPath()%>/payments/complete.do", //cross-domain error가 발생하지 않도록 주의해주세요
                type: 'POST',
                dataType: 'json',
                data: {
                    imp_uid : rsp.imp_uid,         //결제 고유번호
                    merchant_uid : rsp.merchant_uid, //주문번호
                    total : rsp.paid_amount, //결제된 금액
                    buyerName : rsp.buyer_name, //주문자 이름
                    amount : rsp.paid_amount, //총가격
                    //필요한 데이터가 있으면 추가
                }
            })
        } else {
            msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            //실패시 이동할 페이지
            location.href="<%=request.getContextPath()%>/fail.do";
            alert(msg);
        }
    });
}
/* kcp결제 */
function kcp_payment(){
	var IMP = window.IMP;
	IMP.init("imp53448234"); // 'iamport' 대신 부여받은 "가맹점 식별코드" 사용
    var msg;
    
    IMP.request_pay({
        pg : 'kcp.{AO09C}',
        pay_method : 'card',
        merchant_uid : 'merchant_' + new Date().getTime(),
        name : '고구마',
        amount : '300',
        buyer_email : 'email@email',
        buyer_name : '구매자이름',
        buyer_tel : '010-5335',
        buyer_addr : '서울 금천구',
        buyer_postcode : '123-456',
    }, function(rsp) {
        if (rsp.success) {
            //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
            jQuery.ajax({
                url: "<%=request.getContextPath()%>/payments/complete.do", //cross-domain error가 발생하지 않도록 주의해주세요
                type: 'POST',
                dataType: 'json',
                data: {
                    imp_uid : rsp.imp_uid,         //결제 고유번호
                    merchant_uid : rsp.merchant_uid //주문번호
                    /* amount : rsp.paid_amount //총가격 */
                    //필요한 데이터가 있으면 추가
                }
            })
        } else {
            msg = '결제에 실패하였습니다.';
            msg += '에러내용 : ' + rsp.error_msg;
            //실패시 이동할 페이지
            location.href="<%=request.getContextPath()%>/fail.do";
            alert(msg);
        }
    });
}
    
    
    </script>
 
</body>
</html>
