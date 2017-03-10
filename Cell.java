
public class Cell {
	public String value;
	
	public String toString() {
		
		return value;
		
	}
	
	//turn into array of cell objects
	//string field
	//print grid method should get all cells and print that field
	
	public Cell() {
	
		//sets default value
		value = "          ";
		
	}
	
	//import input
	//is this ok to be static??
	public static void parse(String input, Grid gridSheet) {
		
		//these are declared for all, but are used differently in each input type
		//so parse differently to get these values but code for storing is the same
		
		char columnLetter;
		int columnNumber;
		int rowNumber;
		
		if(input.contains("=")) {
			String inCell = input.substring(0, input.indexOf("="));
			String contents = input.substring(input.indexOf("="));
			
		} else if (input.length() < 4 && input.length() >= 2) {
			//what this part needs to do is print out the input from the specified cell
			//assumes wither two or three chars are entered
			
			String caseChange = input.substring(0, 1).toUpperCase();
			
			columnLetter = caseChange.charAt(0);
			rowNumber = Integer.parseInt(input.substring(1));
			
			//columnLetter to corresponding number
			columnNumber = Character.getNumericValue(columnLetter) - 65;
			
			if (rowNumber >= 0 && rowNumber <= 10 && columnNumber >= 0 && columnNumber <= 7) {
				
				gridSheet.spreadsheet[rowNumber - 1][columnNumber - 1].value = input;
				
			}
			
			//implement error checking here later
			//else {
				
				//error
			//}
			
			System.out.print(columnLetter + "" + rowNumber);
			
			//store input as field of cell object, value that prints is different
		}
	//if cell contents too long, substring for printing to less than 10 characters
	}
	
}

//row then column

//spreadsheet[0][j] = 1 row
//spreadsheet[1][j] = 2 row
//spreadsheet[2][j] = 3 row
//spreadsheet[3][j] = 4 row
//spreadsheet[4][j] = 5 row
//spreadsheet[5][j] = 6 row
//spreadsheet[6][j] = 7 row
//spreadsheet[7][j] = 8 row
//spreadsheet[8][j] = 9 row
//spreadsheet[9][j] = 10 row

//spreadsheet[i][0] = A column
//spreadsheet[i][1] = B column
//spreadsheet[i][2] = C column
//spreadsheet[i][3] = D column
//spreadsheet[i][4] = E column
//spreadsheet[i][5] = F column
//spreadsheet[i][6] = G column