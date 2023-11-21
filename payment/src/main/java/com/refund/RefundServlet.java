package com.refund;

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

}
