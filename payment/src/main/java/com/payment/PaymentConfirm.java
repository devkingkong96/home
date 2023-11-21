package com.payment;

import java.io.IOException;
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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String imp=request.getParameter("imp_uid");
		String merchant_uid=request.getParameter("merchant_uid");
		String name=request.getParameter("buyerName");
		String total=request.getParameter("total");
		String amount=request.getParameter("amount");
<<<<<<< HEAD
		String memo=request.getParameter("memo");
=======
		String paid_at=request.getParameter("paid_at");
>>>>>>> branch 'ksj' of https://github.com/devkingkong96/home.git
		System.out.println(imp);
		System.out.println(merchant_uid);
		System.out.println(name);
		System.out.println(total);
		System.out.println(amount);
		System.out.println(paid_at);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
