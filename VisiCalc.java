import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class VisiCalc {
	public static String optionResult = "";
		
	public static void main(String[] args) throws FileNotFoundException {
		
		Grid gridSheet = new Grid();
		gridSheet.fillGrid();
		gridSheet.spreadsheet[2][4].value = "5"; 
		
		Scanner console = new Scanner(System.in);
        PrintStream saver = new PrintStream(new File("temp.txt"));
        
        String input = "";
        //creates scanner for input after first input received
    	Scanner inputScanner = new Scanner(input);
	    
	    //while loop for input
        while (!(input.equals("quit"))) {
        	//takes a line of input
        	input = console.nextLine();
        
        	processCommand(input, console);
        	
		
        	if(input.equals("print")) {
        		gridSheet.printGrid();
        	}
        	
        	//save input to temp file
        	saver.println(input);
        	
        	//start each input on a new line
        	System.out.println();
        
        }
	}
        
	//input goes to cell and then to grid??
	
        public void processCommand(String input, Scanner console) {
        	
        	input = input.toLowerCase();
        	String fileName;
        	String firstFour;
        	
        	if (input.length() >= 4) {
        		
        		//excludes space
        		firstFour = input.substring(0, 4);
        		fileName = input.substring(5);
        		
        		if (firstFour.equalsIgnoreCase("load")) {
              	   
        			Scanner fileScan = new Scanner(fileName);
        			processFile(fileScan);
              	   
                } else if (firstFour.equalsIgnoreCase("save")) {
                	
                	File f = new File(fileName);
                	
                	//if(fileName)
                	//transfer from temp file to file of specified name
                }
        	} 
        	
        	
            if (input.equalsIgnoreCase("help")) {
               //help menu contents
               System.out.println("please write the help menu i am so lost");
               
           } else if (input.equalsIgnoreCase("quit")){
                 //quit option
                
                   System.out.println("Thanks for using VisiCalc!");
                   console.close();

           } else {
        	   System.out.println(input);
           }
       }

	public void processFile(Scanner fileScan) {
		
		while (fileScan.hasNextLine()) {
			
  	    input = fileScan.nextLine();
  	    
		}
		
	}
}
