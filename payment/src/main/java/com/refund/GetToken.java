package com.refund;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class refundTest
 */
@WebServlet("/refundtest.do")
public class GetToken extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetToken() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		 String apiKey = request.getParameter("");
//	     String secretKey = request.getParameter("");

	     // API 키와 시크릿 키를 사용하여 액세스 토큰을 요청하는 메소드 호출
	     String accessToken = getToken("1351426225816408","cfHurcVtJYllMUeKbWmEhhvu9CQmFEAutcrNomOiB0xv3OFhJnONYdPPjHSmLKiorN4fDHTIAyEuNReb");

	     response.setContentType("text/plain");
	     response.getWriter().write("Access Token: " + accessToken);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
public String getToken(String apiKey,String secretKey) throws IOException{
	URL url = new URL("https://api.iamport.kr/users/getToken");
    HttpsURLConnection conn=(HttpsURLConnection)url.openConnection();

    // 요청 방식을 POST로 설정
    conn.setRequestMethod("POST");

    // 요청의 Content-Type과 Accept 헤더 설정
    conn.setRequestProperty("Content-Type", "application/json");
    conn.setRequestProperty("Accept", "application/json");

    // 해당 연결을 출력 스트림(요청)으로 사용
    conn.setDoOutput(true);

    // JSON 객체에 해당 API가 필요로하는 데이터 추가.
    JsonObject json = new JsonObject();
    json.addProperty("imp_key", apiKey);
    json.addProperty("imp_secret", secretKey);

    // 출력 스트림으로 해당 conn에 요청
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream()));
    bw.write(json.toString()); // json 객체를 문자열 형태로 HTTP 요청 본문에 추가
    bw.flush(); // BufferedWriter 비우기
    bw.close(); // BufferedWriter 종료

    // 입력 스트림으로 conn 요청에 대한 응답 반환
    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
    Gson gson = new Gson(); // 응답 데이터를 자바 객체로 변환
    String response = gson.fromJson(br.readLine(), Map.class).get("response").toString();
    String accessToken = gson.fromJson(response, Map.class).get("access_token").toString();
    br.close(); // BufferedReader 종료

    conn.disconnect(); // 연결 종료

    System.out.println("Iamport 엑세스 토큰 발급 성공 : "+ accessToken);
    return accessToken;
	}
}
