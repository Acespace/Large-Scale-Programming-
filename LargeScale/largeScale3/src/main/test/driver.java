package main.test;

import java.io.IOException;

import main.java.PhoneDirectory;

public class driver{


public static void main(String[] args) throws IOException {

//new name and number

	String num= "";
	PhoneDirectory newDirectory = new PhoneDirectory();

   // newDirectory.addEntry("Smith", "2025575988");
  //  newDirectory.addEntry("Code", "8888888");
  //  newDirectory.deleteEntry("Smith");
   

    //newDirectory.changeEntry("Code", "1234567889");
    
	num = newDirectory.getNumber("Code");
	
	System.out.print(num);

}

}

 