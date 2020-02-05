package com.cshttprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class ClientHttpRequest1 {
  public static void main(String args[]) throws IOException, JSONException {
	try {
    URL url = new URL("https://api.github.com/users/google");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    StringBuffer response=new StringBuffer();
    while ((inputLine = in.readLine()) != null) {
      response.append(inputLine);
    }
    System.out.println(response.toString());
    in.close();
    JSONObject myresponse=new JSONObject(response.toString());
    // for the endpoint https://api.github.com/users/google
    System.out.println(myresponse.getString("name"));
    System.out.println(myresponse.getInt("id"));
    System.out.println(myresponse.getString("node_id"));
    System.out.println(myresponse.getString("avatar_url"));
    
    // for the endpoint http://httpbin.org/ip
    //System.out.println("origin : "+myresponse.getString("origin"));
    
	}
	catch(Exception e) {
		System.out.println("Ex. "+e);
	}
  }
}