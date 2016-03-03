package phone.properties;

import java.io.*;
import java.util.Properties;

public class PhoneDirectory {


	void addEntry(String name, String number) throws IOException {
		//print name and number

		Properties prop = new Properties();
		InputStream fileInput = null;
		fileInput = new FileInputStream("/Users/Alston/Documents/CODES/LargeScale/largeScale3/src/main/resources/phone.properties");// attaching to property file
		prop.load(fileInput);
	
	
		Writer fileWriter = new FileWriter((prop.getProperty("path")), true);  //new append to file
		fileWriter.write(name + " : " + number);
		fileWriter.write(System.lineSeparator());
		fileWriter.close();
		
		System.out.println("Just added: ");
		System.out.println("Name: " + name);
		System.out.println("Phone number: " + number);
		//pass
	}
	
	
	void deleteEntry(String name) throws IOException {
		
		
		Properties prop = new Properties();
		InputStream fileInput = null;
		fileInput = new FileInputStream("/Users/Alston/Documents/CODES/LargeScale/largeScale3/src/main/resources/phone.properties");// attaching to property file
		prop.load(fileInput);
		
		try {
	        // input the file content to the String "input"
			String newLine = System.getProperty("line.separator");
			BufferedReader file = new BufferedReader(new FileReader (prop.getProperty("path")));
	        String line;
	        String input = "";

	        while ((line = file.readLine()) != null) {
	        	
	        	if (line.toLowerCase().contains(name.toLowerCase())) {
	        		line = "";
	        	}
	        	
	        	input += line + newLine;
	        	System.out.println(input);
	        }
	        
    		System.out.println("That user was not found");
	        file.close();

	        // write the new String with the replaced line OVER the same file
	        FileOutputStream fileOut = new FileOutputStream("directory.txt");
	        fileOut.write(input.getBytes());
	        fileOut.close();

	    } catch (Exception e) {
	        System.out.println("Problem reading file.");
	    }
	}
	

}
	
	
	
