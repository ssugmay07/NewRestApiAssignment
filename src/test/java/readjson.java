import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParser;


public class readjson {
	
	public static void main(String[] args)
	{

	
/*	ClassLoader classLoader=new readjson().getClass().getClassLoader();
	String FileName="C:\\Users\\ssuga\\eclipse-workspace\\RestAssuredApi\\src\\test\\java\\file.json";
	File file=new File(classLoader.getResource(FileName).getFile());
	*/
		String fileName="C:\\Users\\ssuga\\eclipse-workspace\\RestAssuredApi\\src\\test\\java\\file.json";
		
		//JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
         

	try {
        FileReader reader = new FileReader(fileName);
        
        //using the parser object to read the contents of json file.
      //After parsing,it returns an object and storing it in object
		
        Object obj=jsonParser.parse(reader);
		
		//converting object into a json object.
		
        JSONObject jsonobj=(JSONObject)obj;
        
        //converting object into jsonarray
		
       
		
        //Extracting the username(string value ) from json object
        
		String userName= (String)jsonobj.get("username");
		
		System.out.println("The username is : "+userName);
		
		JSONArray student=(JSONArray) jsonobj.get("students");
		
		System.out.println("The student details are : "+student);
		
		
		 //converting object into jsonarray
		
/*JSONArray sessionId=(JSONArray) jsonobj.get("sessionid");
		System.out.println("The session ids are :"+sessionId);
		
		System.out.println("The size of session id is :"+sessionId.size());
		
		
		Long LastSessionId=(Long) sessionId.get(3);
		
		System.out.println("The Last session id is :"+LastSessionId);
		
		 JSONObject student1=(JSONObject)student.get(0);
		
		 JSONObject student2=(JSONObject)student.get(1);
		 

		
		//System.out.println(student2);
		 
		 JSONArray marks2=(JSONArray)student2.get("marks");
		
		 System.out.println("The marks of the secind student are :" +marks2);
		 
		 JSONArray Address1=(JSONArray)student1.get("adresss");
		 
		 System.out.println("The address details of the first student are :"+Address1);
		 
		 JSONObject Address12=(JSONObject)Address1.get(1);
		 
		System.out.println( Address12);
		
		String state2=(String)Address12.get("state");
		
		System.out.println("The second state value of first student is : "+state2);
		
		JSONArray contact22=(JSONArray)student2.get("contact");
		
		String contactof2ndstudent=(String)contact22.get(1);
		
		System.out.println("The second contact value of second student is :"+contactof2ndstudent);
		
		JSONArray Adress22=(JSONArray)student2.get("adresss");
		
		System.out.println("The address details of the second student are : "+Adress22);
		
		String city=(String)student2.get("city");
		
		System.out.println(((Map) Adress22).containsKey(city));
//	*/	
		int counter=0;
		Iterator i = student.iterator();
		List<String>studentContacts=new ArrayList<String>();
        while (i.hasNext()) {
           JSONObject studentObject = (JSONObject) i.next();
           
           
           JSONArray contactOfStudent=(JSONArray)studentObject.get("contact");
           
           Iterator j = contactOfStudent.iterator();
           while (j.hasNext()) {
               String  studentContact = (String) j.next();
               System.out.println(studentContact);
           }
           if(counter==1)
           {
        	   JSONArray Adressof2ndstudent=(JSONArray) studentObject.get("adresss");
        	   
        	   Iterator k=Adressof2ndstudent.iterator();
        	   while(k.hasNext())
        	   {
        		   
        		 
        		  HashMap<String,String>adressValueMAp= (HashMap<String, String>) k.next();
        		  String cityofsecondStudent=adressValueMAp.get("city");
        		  System.out.println("The cities of secondStudent are : " +cityofsecondStudent);
        		   
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
