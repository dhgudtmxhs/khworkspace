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

public static final String serviceKey = "S2kBAKKCZziWzJ9rILXRaQIWpIxyF3H7oSVBZ%2BHYdNMu8E76DEYXUDfYUzAkZh2t7%2BXPw3J1cgAfYb4Cb8vlAw%3D%3D";
	
	@RequestMapping(value = "disaster", produces = "text/xml; charset=UTF-8")
	@ResponseBody
	public String disastser() throws IOException {
				
			String url = "http://apis.data.go.kr/1741000/TsunamiShelter3/getTsunamiShelter1List";
					
			url += "?serviceKey=" + serviceKey; 
			
			url += "&pageNo=1";
			
			url += "&numOfRows=2";
			
			url += "&returnType=xml";
				
				URL requestUrl = new URL(url);
				
				HttpURLConnection urlConnection = (HttpURLConnection)requestUrl.openConnection(); 
				
				urlConnection.setRequestMethod("GET");
				
				BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
				
				String text = "";
				String line = null;
				while( (line = br.readLine()) != null ) {
					text += line;
				}
				br.close();
				urlConnection.disconnect();
				
				return text;
			}
	
	
}