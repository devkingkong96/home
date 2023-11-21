package com.refund;

<<<<<<< HEAD
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class RefundServlet
 */
@WebServlet("/refund.do")
public class RefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	     String paymentId = request.getParameter("paymentId");

	     String paymentId="imp53448234";
	        // 액세스 토큰을 통해 아임포트 API를 호출하여 환불 로직 수행
	        String accessToken = "a0fa7c9fd2b61407f9531bf47c776f3a2bca00b2";
	        boolean refundSuccess = performRefund(paymentId, accessToken);

	        if (refundSuccess) {
	            response.setStatus(HttpServletResponse.SC_OK);
	        } else {
	            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
	        }
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


private boolean performRefund(String paymentId, String accessToken) {
    try {
        URL url = new URL("https://api.iamport.kr/payments/cancel");
        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Authorization", accessToken);
        conn.setDoOutput(true);

        // 환불 요청에 필요한 데이터
        JsonObject json = new JsonObject();
        json.addProperty("imp_uid", paymentId);

        // 요청 데이터를 전송
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
        bw.write(json.toString());
        bw.flush();
        bw.close();

        // 응답 확인
        int responseCode = conn.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            // 환불 성공
            return true;
        } else {
            // 환불 실패
            return false;
        }
    } catch (IOException e) {
        e.printStackTrace();
        return false;
    }
}
=======
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class RefundServlet
 */
@WebServlet("/refund.do")
public class RefundServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RefundServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	URL url = new URL("https://api.iamport.kr/payments/cancel");
	        HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
	 
	        // 요청 방식을 POST로 설정
	        conn.setRequestMethod("POST");
	 
	        // 요청의 Content-Type, Accept, Authorization 헤더 설정
	        conn.setRequestProperty("Content-type", "application/json");
	        conn.setRequestProperty("Accept", "application/json");
	        conn.setRequestProperty("Authorization", "242dd4a8a0a79656c4b7e4da80d4c5bb0dd16ccf");
	 
	        // 해당 연결을 출력 스트림(요청)으로 사용
	        conn.setDoOutput(true);
	 
	        // JSON 객체에 해당 API가 필요로하는 데이터 추가.
	        JsonObject json = new JsonObject();
	        json.addProperty("merchant_uid", "1700562269320");
	        json.addProperty("reason", "너무 늦어요");
	 
	        // 출력 스트림으로 해당 conn에 요청
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
	        bw.write(json.toString());
	        bw.flush();
	        bw.close();
	 
	        // 입력 스트림으로 conn 요청에 대한 응답 반환
	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        br.close();
	        conn.disconnect();
	 
	        System.out.println("[결제 취소 완료] 주문 번호 : "+"1700562269320");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

>>>>>>> branch 'ksj' of https://github.com/devkingkong96/home.git
}
