import java.util.Scanner;

public class FormulaCell extends Cell {

	public static String formatFormula(String value) {
		
		char columnLetter;
		int columnNumber;
		int rowNumber;
		String caseChange;
		
		String partOne;
		String operator;
		String partTwo;
		
		
			value = value.substring(value.indexOf("(") + 1);
			value = value.substring(0, value.indexOf(")"));
		
			Scanner valueReader = new Scanner(value);
			while (valueReader.hasNext()) {
				
				if (Character.isLetter(valueReader.next().charAt(0))) {
					
					caseChange = valueReader.next().substring(0, 1).toUpperCase();
					
					columnLetter = caseChange.charAt(0);
					rowNumber = Integer.parseInt(caseChange.substring(1)) - 1;
					
					//columnLetter to corresponding number
					columnNumber = Character.getNumericValue(columnLetter) - 10;
					
					//gets value of cell at location just parsed
					partOne = VisiCalc.gridSheet.spreadsheet[rowNumber][columnNumber].value;
					
				} else if (Character.isDigit(valueReader.next().charAt(0))) {
					

				}
				
				operator = valueReader.next();
				
				//check if this is a cell!!!
				partTwo = valueReader.next();
				
				partOne = operations(partOne, operator, partTwo);
			}
			
		return value;
	}
	
	public static String operations(String partOne, String operator, String partTwo) {
		
		if (operator.equals("+")) {
			
			
			
		} else if (operator.equals("-")) {
			
			
			
		} else if (operator.equals("*")) {
			
			
			
		} else if(operator.equals("/")) {
			
			
		}
		
		return "";
	}
	
}
