import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class VisiCalc {
	public static String optionResult = "";
	
    //what is safe to make static??
		
	public static void main(String[] args) throws FileNotFoundException {
		Grid gridSheet = new Grid();
		File temporary = new File("temp.txt");
		Scanner console = new Scanner(System.in);
		PrintStream saver = new PrintStream(temporary);
		
		gridSheet.fillGrid();
		//sets .value of spreadsheet at E3 to 5
		gridSheet.spreadsheet[2][4].value = "5"; 
		
        
        String input = "";
        //creates scanner for input after first input received
    	Scanner inputScanner = new Scanner(input);
	    
    	
	    //while loop for input
        while (!(input.equals("quit"))) {
        	//takes a line of input
        	input = console.nextLine();
        
        	processCommand(input, console, gridSheet, temporary);
		
        	
        	//save input to temp file
        	saver.println(input);
        	
        	//start each input on a new line
        	System.out.println();
        
        }
	}
        
	//input goes to cell and then to grid??
	
		//only has console to handle closing it for quit
        public static void processCommand(String input, Scanner console, Grid gridSheet, File temporary) throws FileNotFoundException {
        	
        	input = input.toLowerCase();
        	String fileName;
        	String firstFour;
        	
        	if (input.length() > 4) {
        		
        		//excludes space since substring is not inclusive
        		firstFour = input.substring(0, 4);
        		fileName = input.substring(5);
        		
        		if (input.equalsIgnoreCase("print")) {
             	   
           			gridSheet.printGrid();
           		
           	   } else if (firstFour.equalsIgnoreCase("load")) {
        			
        			processFile(fileName, console, gridSheet, temporary);
              	   
                } else if (firstFour.equalsIgnoreCase("save")) {
                	
                	File saveFile = new File(fileName);
                	
                	//if(fileName)
                	//transfer from temp file to file of specified name
                	temporary.renameTo(saveFile);
                }
        	} else if (input.equalsIgnoreCase("help")) {
               //help menu contents
               System.out.println("please write the help menu i am so lost");
               
           } else if (input.equalsIgnoreCase("quit")){
                 //quit option
                
                   System.out.println("Thanks for using VisiCalc!");
                   console.close();
                   
                   //need to get rid of last else or otherwise figure out how to get aroudn closed sanner- do while scanner is open?
           } else {
        	   System.out.println(input);
           }
       }

	public static void processFile(String fileName, Scanner console, Grid gridSheet, File temporary) throws FileNotFoundException {
		
		File loadFile = new File(fileName);
		
		//file name is 5 to end, so includes the .txt
		//assuming same directory
		Scanner fileScan = new Scanner(loadFile);
		
		String input = "";
		
		while (fileScan.hasNextLine() && !input.equals("quit")) {
			input = fileScan.nextLine();
			processCommand(input, fileScan, gridSheet, temporary);
			
		}
		
	}
}
