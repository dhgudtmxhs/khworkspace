package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class OpenAPIController {

	public static final String SERVICEKEY = "S2kBAKKCZziWzJ9rILXRaQIWpIxyF3H7oSVBZ%2BHYdNMu8E76DEYXUDfYUzAkZh2t7%2BXPw3J1cgAfYb4Cb8vlAw%3D%3D";
												
	// json 형식으로 대기오염 OpenAPI 활용하기
	@ResponseBody
	//@RequestMapping(value = "air", produces = "application/json; charset=UTF-8")
	public String airMethod(@RequestParam String location) throws IOException {
		
		// System.out.println(location);
		
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

		url += "?serviceKey=" + SERVICEKEY; // 서비스키 추가
		
		url += "&sidoName=" + URLEncoder.encode(location, "UTF-8"); // 지역명 추가(한글이 들어가면 인코딩처리 해야한다.)
											 // 서울, 대전, 부산
		url += "&returnType=json"; // or = xml // 리턴타입
		
		url += "&numOfRows=15";
		
		// 1. 작성된 url 정보를 넣어 URL 객체 생성
		URL requestUrl = new URL(url);
		
		// 2. 생성된 URL 객체로 URLConnection 생성
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection(); // 다운캐스팅
		
		// 3. 요청 시 필요한 Header 설정
		urlConn.setRequestMethod("GET");
		
		// 4. 해당 OpenAPI 서버로 요청 후 입력스트림을 통해서 응답데이터 읽어오기
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String responseText = "";
		String line;
		while( (line = br.readLine()) != null ) {// 한줄씩 읽어서 담는데 null이 아닐때 까지
			responseText += line;

		}
	
		// 5. 다 사용한 스트림 반납 및 연결 해제
		br.close();
		urlConn.disconnect();
	
		return responseText;
	
	}
	
	
	// xml 형식으로 대기오염 OpenAPI 활용하기
	@RequestMapping(value = "air" , produces = "text/xml; charset=UTF-8")
	@ResponseBody
	public String airPollution(@RequestParam String location) throws IOException {
	// Spring Framework에서 @RequestParam 어노테이션을 사용하면 클라이언트가 전송한 데이터의 key에 해당하는 값을 메서드 파라미터로 바인딩할 수 있습니다.	
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";

		url += "?serviceKey=" + SERVICEKEY; 
		
		url += "&sidoName=" + URLEncoder.encode(location, "UTF-8"); 
											
		url += "&returnType=xml"; 
		
		url += "&numOfRows=15";
		
		URL requestUrl = new URL(url); // url 객체 생성
		
		HttpURLConnection urlConn = (HttpURLConnection)requestUrl.openConnection(); // 생성된 URL객체로 urlconnection 생성
		
		urlConn.setRequestMethod("GET"); // 요청시 필요한 header 설정
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream())); // 입력스트림으로 응답데이터 얻어오기

		String respText = "";
		String line;
		
		while( (line = br.readLine()) != null ) { 
				respText += line;
		}
		
		// 스트림 반납, 연결해제
		br.close();
		urlConn.disconnect();
		
		return respText;
	}
	
	// xml형식으로 지진해일 대피소 OpenAPI 활용하기
	@RequestMapping(value = "disaster", produces = "text/xml; charset = UTF-8")
	@ResponseBody
	public String shelterList() throws IOException {
		
		String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";
		
		url += "?serviceKey=" + SERVICEKEY;
		
		url += "&pageNo=1";
		
		url += "&numOfRows=15";
		
		url += "&returnType=xml";
		
		URL requestUrl = new URL(url);
		
		HttpURLConnection urlConn = (HttpURLConnection) requestUrl.openConnection();
		
		urlConn.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String respText = "";
		String line;
		
		while( (line = br.readLine()) != null) {
				respText += line;
		}
	
		br.close();
		urlConn.disconnect();
		
		return respText;
	}
	
	
	
}