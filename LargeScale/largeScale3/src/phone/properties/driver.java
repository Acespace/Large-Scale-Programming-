package phone.properties;

import java.io.IOException;

public class driver{


public static void main(String[] args) throws IOException {

//new name and number

	PhoneDirectory newDirectory = new PhoneDirectory();

   // newDirectory.addEntry("Alston", "2025575988");
	newDirectory.deleteEntry("Alston");


}

}