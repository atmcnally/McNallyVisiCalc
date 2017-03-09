
public class Cell {
	String value;
	
	public String toString() {
		
		return value;
		
	}
	
	//turn into array of cell objects
	//string field
	//print grid method should get all cells and print that field
	
	public Cell() {
		
	value = "          ";
		
	}
	
	//import input
	public void parse(String input) {
		
		if(input.contains("=")) {
			String inCell = input.substring(0, input.indexOf("="));
			String contents = input.substring(input.indexOf("="));
		} else if (input.length() < 4) {
			
			
			
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