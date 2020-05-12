package AppClient.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.HttpClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class AppHttpClient {

	private static HttpClient httpClient;
	private static HttpPost postRequest;
	private static HttpResponse response;

	private String urlSignIn = "http://localhost:8080/auth/signin";

	public HttpClient getServer() {
		try {
			if (httpClient == null) {

				return httpClient = HttpClientBuilder.create().build();
			} else {
				return httpClient;
			}
		} catch (Exception e) {
			System.out.println(e.toString());

			return null;
		}

	}

	public HttpPost sendHttpPost(Object obj) {
		try {
			StringEntity input = new StringEntity(obj.toString());
			input.setContentType("application/json");
			postRequest = new HttpPost(this.urlSignIn);
			postRequest.setEntity(input);
			return postRequest;
		} catch (Exception e) {
			System.out.println(e.toString());

			return null;

		}
	}

	public int postJson(Object obj) {

		try {
			response = this.getServer().execute(this.sendHttpPost(obj));
			
			System.out.println(response.getStatusLine().getStatusCode());
			
			BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent())));

			String output;
			while ((output = br.readLine()) != null) 
			{
				System.out.println(output);
			
			}
			
			return response.getStatusLine().getStatusCode();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return (Integer) null;

	}

}
