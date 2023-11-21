package com.payment;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentConfirm
 */
@WebServlet("/payments/complete.do")
public class PaymentConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentConfirm() {
        super();
        // TODO Auto-generated constructor stub
    }
    
//    public void PaymentConfirm() {
//        this.api = new IamportClient("3452420157053319","DXI0XVlgpUwS8B3Hj9cFxozTrGn6CXmfU4fS0B8pvFhDglkzvxe3VNXnukt7hPmcUC4UddkJSCn9XIJt");
//    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("결제만 완료");
		
		String imp=request.getParameter("imp_uid");
		String merchant_uid=request.getParameter("merchant_uid");
		
//		try {
//            IamportResponse<Payment> paymentResponse = api.paymentByImpUid(imp);
//            // TODO: response를 클라이언트에게 반환하는 로직 구현
//        } catch (IamportResponseException e) {
//            // TODO: 예외 처리 로직 구현
//        }
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
