package com.cshttprequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class PostHttpRequest {
	private static final String USER_AGENT = "Mozilla/5.0";
	private static final String POST_URL = "https://localhost:8080";
	private static final String POST_PARAMS = "userName=Pankaj";
	public static void main(String[] args) throws IOException {
		sendPOST();
		System.out.println("POST DONE");
	}
	private static void sendPOST() throws IOException {
		URL obj = new URL(POST_URL);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setRequestProperty("Content-Type", "application/json; utf-8");
		con.setRequestProperty("Accept", "application/json");
		// For POST only - START
		con.setDoOutput(true);
		//String jsonInputString = "{\"Name\":\"Abc\",\"Sub\":\"Xyz\"}";
		String jsonInputString="Muni Singh";
		System.out.println("34");
		//OutputStream os = con.getOutputStream();
		
		byte[] input=jsonInputString.getBytes("utf-8");
		//os.write(input, 0,input.length);
		//os.flush();
		//os.close();
		System.out.println("35");
		// For POST only - END
		int responseCode = con.getResponseCode();
		System.out.println("36");
		System.out.println("POST Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { //success
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			// print result
			System.out.println(response.toString());
		 }else {
	 		System.out.println("POST request not worked");
		 }
	 }
}

