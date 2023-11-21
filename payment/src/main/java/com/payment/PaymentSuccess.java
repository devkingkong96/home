package com.payment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PaymentSuccess
 */
@WebServlet("/success.do")
public class PaymentSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/success.do");
		System.out.println("검증 성공");
		
//		String imp=request.getParameter("imp_uid");
//		String merchant_uid=request.getParameter("merchant_uid");
//		String name=request.getParameter("buyerName");
//		String total=request.getParameter("total");
//		String amount=request.getParameter("amount");
//		String paid_at=request.getParameter("paid_at");
//		System.out.println(imp);
//		System.out.println(merchant_uid);
//		System.out.println(name);
//		System.out.println(total);
//		System.out.println(amount);
//		System.out.println(paid_at);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
