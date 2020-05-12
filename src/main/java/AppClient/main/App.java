package AppClient.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import AppClient.service.AppHttpClient;
import view.Login;


public class App {



	public static void main(String[] args) {
		
		//AppHttpClient appConnect = new AppHttpClient();
		
		//Scanner scanner = new Scanner(System.in);
		
		new Login().main(args);
		
		//ObjectMapper map = new ObjectMapper();
		
		
		// String jsonUsername = "{ \"username\" : \"marcos\"}";
		// String jsonPassword = "{ \"password\" : \"marcos\"}";
		
		//Map<String, Object> params = new HashMap<String, Object>();
		
		
		try
		{
		   // System.out.print("Please your username: ");
		    //String username = scanner.nextLine();
		   // System.out.print("Please your password: ");
		    //String password = scanner.nextLine();
		    
		   // params.put("username", username);
		   // params.put("password", password);
		    
		    //User user = new ObjectMapper().readValue(json, User.class);
		    
		    //String parse = new ObjectMapper().writeValueAsString(params);

			//appConnect.postJson(parse);
		}
		catch(Exception e)
		{
			
		}

	}
}
