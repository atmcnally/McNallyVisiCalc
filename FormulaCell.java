import java.util.Scanner;

public class FormulaCell extends Cell {
	
public static String formatEquation(String value) {
		
		char columnLetter;
		int columnNumber;
		int rowNumber;
		String caseChange;
		
		String partOne = "";
		String operator;
		String partTwo = "";
		
			value = value.substring(value.indexOf("(") + 2);
			value = value.substring(0, value.indexOf(")") - 1);
		
			Scanner valueReader = new Scanner(value);
			
			//get first part then continue if there's more with part one as the first part always
			String temp1 = valueReader.next();
			if (Character.isLetter(temp1.charAt(0))) {
				caseChange = temp1.toUpperCase();
				
				columnLetter = caseChange.charAt(0);
				rowNumber = Integer.parseInt(caseChange.substring(1)) - 1;
				
				//columnLetter to corresponding number
				columnNumber = Character.getNumericValue(columnLetter) - 10;
				
				//gets value of cell at location just parsed
				partOne = VisiCalc.gridSheet.spreadsheet[rowNumber][columnNumber].dispValue;
				
			} else if (Character.isDigit(temp1.charAt(0))) {
				partOne = temp1;
			}
			
			while (valueReader.hasNext()) {
				
				operator = valueReader.next();
				
				//check if this is a cell!!!
				String temp2 = valueReader.next();
				
				//yeah I know it's redundant but I would rather have this than a method with like a million parameters
				if (Character.isLetter(temp2.charAt(0))) {
					caseChange = temp2.toUpperCase();
					
					columnLetter = caseChange.charAt(0);
					rowNumber = Integer.parseInt(caseChange.substring(1)) - 1;
					
					//columnLetter to corresponding number
					columnNumber = Character.getNumericValue(columnLetter) - 10;
					
					//gets value of cell at location just parsed
					partTwo = VisiCalc.gridSheet.spreadsheet[rowNumber][columnNumber].dispValue;
					
				} else if (Character.isDigit(temp2.charAt(0))) {
					partTwo = temp2;
				}
				
				partOne = operations(partOne, operator, partTwo);
				
			}
			
			value = partOne;
		valueReader.close();	
		return value;
	}
	
	public static String operations(String partOne, String operator, String partTwo) {
		double output = 0;
		double partOneN = Double.parseDouble(partOne);
		double partTwoN = Double.parseDouble(partTwo);
		
		if (operator.equals("+")) {
			
			output = partOneN + partTwoN;
			
		} else if (operator.equals("-")) {
			
			output = partOneN - partTwoN;
			
		} else if (operator.equals("*")) {
			
			output = partOneN * partTwoN;
			
		} else if(operator.equals("/")) {
			
			output = partOneN / partTwoN;
		}
		
		String out = Double.toString(output);
		
		return out;
	}
	
}
