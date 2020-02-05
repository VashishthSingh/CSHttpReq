package com.cshttprequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

public class ClientHttpRequest {
  public static void main(String args[]) throws IOException, JSONException {
    URL url = new URL("https://api.github.com/users/google");
    HttpURLConnection con = (HttpURLConnection) url.openConnection();
    con.setRequestMethod("GET");
    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
    String inputLine;
    while ((inputLine = in.readLine()) != null) {
    	System.out.println(inputLine);
    }
    in.close();
  }
}