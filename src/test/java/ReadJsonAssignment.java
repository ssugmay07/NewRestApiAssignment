import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;


public class ReadJsonAssignment {
	
	@Test
	public void Findvalues()
	{
	
	String fileName="C:\\Users\\ssuga\\eclipse-workspace\\RestAssuredApi\\src\\test\\java\\file.json";
	
	//JSON parser object to parse the json file contents
	 JSONParser jsonParser = new JSONParser();
    
    try {
    	
    	FileReader reader =new FileReader(fileName);
    	
    	Object obj=jsonParser.parse(reader);
    	
    	//Converting the object into JSon object
    	
    	JSONObject jsonobj=(JSONObject)obj;
    	
    	//1)Find value of username:
    	
    	String username=(String)jsonobj.get("username");
    	
    	System.out.println("The value of username is : "+username);
    	
    	//2)Find values of all sessionId:
    	
    	JSONArray sessionId=(JSONArray)jsonobj.get("sessionid");
    	 	
    	Iterator i=sessionId.iterator();
    	
    	System.out.println("The value of all SessionIDs are : ");
    	
    	
    	while(i.hasNext())
    	{
    		Long sessionIds=(Long) i.next();
    		
    		System.out.println(sessionIds);
    		
    		
    	}
    	
    	
    	//3) Find last value of sessionId:
    	
    	Long lastSessionId =(Long)sessionId.get(sessionId.size()-1);
    	
    	System.out.println("The value of Last session Id is  :"+lastSessionId);
    	
    	
    	//4)Find all marks of second student:
    	
    	
    	JSONArray studentArray=(JSONArray)jsonobj.get("students");
    	
    	//System.out.println(studentArray);
    	
    	int counter=0;
    	
    	List<String>studentContacts=new ArrayList<String>();
    	
    	Iterator j=studentArray.iterator();
    	    	
    	while(j.hasNext())
    	{
    		
    		JSONObject studentObj=(JSONObject)j.next();
    		
    		JSONArray adress=(JSONArray) studentObj.get("adresss");
    		
    		JSONArray contactArray=(JSONArray)studentObj.get("contact"); 
    		
    		Iterator allcontacts = contactArray.iterator();
            while (allcontacts.hasNext()) {
                String  studentContact = (String) allcontacts.next();
                System.out.println("The contacts of all students are :"+studentContact);
            }
    		
    		
    		
    		Iterator k=adress.iterator();
    		if(counter==0)
    		{
    		while(k.hasNext())
    		{
    			
    	       HashMap<String,String>adressValues=(HashMap<String, String>) k.next();
    		
    			String statevalue=(String)adressValues.get("state");
    			
    			System.out.println("The second state value of first student is :"+statevalue);
    			
    			System.out.println("The Adresses of first student are :"+adressValues);
				}
    			
    			
    		}
    		
    		if(counter==1)
    		{
    			JSONArray marksofsecondStudent=(JSONArray) studentObj.get("marks");
    			
    			System.out.println("The marks of second student are  "+marksofsecondStudent);
    			
    			
    			Iterator contactArrayValue=contactArray.iterator();
    			
    			while(contactArrayValue.hasNext())
    			{
    				
    				String contactvalue=(String) contactArrayValue.next();
    				
    				System.out.println("The 2nd contact value is :"+contactvalue);
    				
    			}
    			
    			
    			while(k.hasNext())
        		{
        			
        	       HashMap<String,String>adressValues=(HashMap<String, String>) k.next();
        		
        			String cityValue=(String)adressValues.get("city");
        			
        			System.out.println("The cities of second student are :"+cityValue);
    				}
    		}
    		
    		counter++;
    		
    	}
    	
    	
    }
	
	catch(Exception e)
    {
		e.printStackTrace();
    }
	
	
	
	}
}
