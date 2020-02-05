package com.cshttprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

public class ClientHttpRequest2 {
  public static void main(String args[]) throws IOException, JSONException {
	try {
    URL url = new URL("https://httpbin.org/post");
    
    Map<String,Object> params=new LinkedHashMap<String, Object>();
    params.put("name", "Muni");
    params.put("email", "singhshikharmuni@gmail.com");
    params.put("phno", "9554321383");
    params.put("message", "Post Request");
    
    StringBuilder postData=new StringBuilder();
    
    for(Map.Entry<String,Object> param:params.entrySet()) {
    	if(postData.length()!=0)
    		postData.append('&');
    	postData.append(URLEncoder.encode(param.getKey(),"UTF-8"));
    	postData.append('=');
    	postData.append(URLEncoder.encode(String.valueOf(param.getValue()),"UTF-8"));
    }
    
    byte [] postDataBytes=postData.toString().getBytes("UTF-8");
    
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("POST");
    con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
    con.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
    con.setDoOutput(true);
    
    con.getOutputStream().write(postDataBytes);
    
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
    String inputLine;
    StringBuffer response=new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    System.out.println(response.toString());
    in.close();
    JSONObject myresponse=new JSONObject(response.toString());
    System.out.println("origin : "+myresponse.getString("origin"));
    System.out.println("data : "+myresponse.getString("data"));
    //System.out.println("json : "+myresponse.getInt("json"));
    System.out.println("url : "+myresponse.getString("url"));
    System.out.println("----------form--------------------------------------------------");
    JSONObject myresponse1=new JSONObject(myresponse.getJSONObject("form").toString());
    System.out.println("name : "+myresponse1.getString("name"));
    System.out.println("email : "+myresponse1.getString("email"));
    System.out.println("phno : "+myresponse1.getString("phno"));
    System.out.println("message : "+myresponse1.getString("message"));
    System.out.println("----------headers-----------------------------------------------");
    JSONObject myresponse2=new JSONObject(myresponse.getJSONObject("headers").toString());
    System.out.println("Accept : "+myresponse2.getString("Accept"));
    System.out.println("Content-Length : "+myresponse2.getString("Content-Length"));
    System.out.println("Content-Type : "+myresponse2.getString("Content-Type"));
    System.out.println("Host : "+myresponse2.getString("Host"));
    System.out.println("User-Agent : "+myresponse2.getString("User-Agent"));
    System.out.println("X-Amzn-Trace-Id : "+myresponse2.getString("X-Amzn-Trace-Id"));
	}
	catch(Exception e) {
		System.out.println("Ex. "+e);
	}
  }
}
  