package com.kh.opendata;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AirPollutionJavaApp {

	public static final String serviceKey = "S2kBAKKCZziWzJ9rILXRaQIWpIxyF3H7oSVBZ%2BHYdNMu8E76DEYXUDfYUzAkZh2t7%2BXPw3J1cgAfYb4Cb8vlAw%3D%3D";
			
	public static void main(String[] args)throws IOException {
		
	String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
			
	url += "?serviceKey=" + serviceKey; 
	
	url += "&sidoName=" + URLEncoder.encode("¼­¿ï", "UTF-8"); 
	
	url += "&returnType=json";
		
		URL requestUrl = new URL(url);
		
		HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection(); 
		
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		
		String line = null;
		while( (line = br.readLine()) != null ) {
			System.out.println(line);
		}
		br.close();
		urlConnection.disconnect();
	}
}