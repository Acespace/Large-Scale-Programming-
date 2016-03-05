package main.java;

import java.io.*;
import java.util.Properties;

//variable
public class PhoneDirectory {
	
	





InputStream varible() throws FileNotFoundException{
		
		InputStream fileInput = null;
		fileInput = new FileInputStream("/Users/Alston/Documents/CODES/Large-Scale-Programming-/LargeScale/largeScale3/src/main/resources/phone.properties");// attaching to property file
		
		return fileInput;
	
	}
	


	public void addEntry(String name, String number) throws IOException {
		//print name and number
		
		
		Properties prop = new Properties();
		prop.load(varible());
	
	
		Writer fileWriter = new FileWriter((prop.getProperty("path")), true);  
		fileWriter.write(name + " : " + number);
		fileWriter.write(System.lineSeparator());
		fileWriter.close();
		
		System.out.println("Just added: ");
		System.out.println("Name: " + name);
		System.out.println("Phone number: " + number);
		//pass
	}
	
	
	public void deleteEntry(String name) throws IOException {
		
		
		Properties prop = new Properties(); //creating new variable
		prop.load(varible());
		String line = null;
		     
		try {
	        //making path to main
			BufferedReader file = new BufferedReader(new FileReader (prop.getProperty("path")));
			
			//creating new file
			File temp = new File("/Users/Alston/Documents/CODES/Large-Scale-Programming-/LargeScale/largeScale3/src/main/resources/temp.txt");//creating new temporary file
		    BufferedWriter writer = new BufferedWriter(new FileWriter(temp));// making the file writable
		        
		  
	     
	    
	        while ((line = file.readLine()) != null) {
	        	
	        	if (!line.toLowerCase().contains(name.toLowerCase())) { //searching file for entries that do not contain name to delete
	        		writer.write(line); //writing to temporary file
	        
	        }
	        
        	file.close();//closing addressbook file
 	        writer.close();//closing temporary file 
 	        writer = new BufferedWriter(new FileWriter(prop.getProperty("path"))); //opening writing file
 	        
 	        writer.write(line); // overwriting the file

			System.out.println("Deleted: ");
			System.out.println("Name: " + name);

	        }
		}

	     catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}
	
	
	public String getNumber(String name) throws IOException {
		Properties prop = new Properties(); //creating new variable
		prop.load(varible());
			
		try {
	        // input the file content to the String "input"
	        BufferedReader file = new BufferedReader(new FileReader((prop.getProperty("path"))));
	        String line;

	        while ((line = file.readLine()) != null) {
	        	
	        	if (line.toLowerCase().contains(name.toLowerCase())) {
	        		String[] splitString = line.split(" ");
	        		        		
	        		
	    	        file.close();
	        		return splitString[2];
	        	}
	        }
	       

			file.close();
			
	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
		
		return "That user was not found";
	}	

	
	
	
	public void changeEntry(String name, String number) throws IOException{

		
		deleteEntry(name);
		addEntry(name, number);
		
	}
	

}
	
	

