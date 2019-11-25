import static com.jayway.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

import com.jayway.restassured.response.Response;

public class NewAssignment {


	
	@Test
	public void chechUserId()
	{
		
		Response response =given()

				//assignimg the values through parameters
				//.pathParam("name", "worldwide")
				.when()
				//Retrieving the input from api using get call
				.get("https://jsonplaceholder.typicode.com/posts")
				.then()

				//validating the response
				.statusCode(200)  
				.assertThat().contentType("application/json")
				.extract().response();
		
 
	//	response.prettyPrint();
		//System.out.println(userId);

		//parsing the response
		//Object jsonresponse = response.jsonPath().get("$");
		//Object jsonresponse = response.jsonPath();
		
		 //Object jsonresponse = response.jsonPath().get("$");
		
		//System.out.println(jsonresponse);
		
		List<HashMap<String,String>> jsonresponse=response.jsonPath().get("$");
		//
		//System.out.println(jsonresponse.get(0).get("title"));
		
		for(int i=0;i<jsonresponse.size();i++)
		{
			//Map.Entry<String, String>> Output=jsonresponse.get(i).entrySet();
			//System.out.println(jsonresponse.get(0).get("title"));
			String userId = String.valueOf(jsonresponse.get(i).get("userId"));
			//System.out.println(userId);
			if(userId.contentEquals("7"))
				System.out.println(jsonresponse.get(i).get("title"));
			
		/*	for (Map.Entry<String,String> entry : jsonresponse.get(i).entrySet())  
	            System.out.println("Key = " + entry.getKey() + 
	                             ", Value = " + entry.getValue());
			*/
		//	System.out.println("Key = " +  Output.getKey() + 
                   // ", Value = " + Output.getValue()); 
			
			
		}
		
		/*  for (Integer i : jsonresponse) 
	            System.out.print(i + " "); 
	*/
		/*
		for(int i=0;i<jsonresponse.size();i++)
		{
			if(jsonresponse.get(i).)
			{
				
				System.out.println(jsonresponse.get(i));
			}
				
		}
		
		
		/*String userIds = response.jsonPath().getString("userId");
		
		userIds.toCharArray();
		
		ArrayList<Character> userIdList=new ArrayList<Character>();
		
		for(Character S:userIds)
		{
			
		}
			
		
		
		//System.out.println(userIds);
		
			//System.out.println(jsonresponse);
			
		for(int i=0;i<jsonresponse.size();i++)
		{
		
			if(jsonresponse.))
			
		}
		*/
		
	}
	
	

}
