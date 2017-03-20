import java.util.Scanner;

public class FormulaCell extends Cell {
	
	public static String formatFormula(String value) {
		
		char columnLetter;
		int columnNumber;
		int rowNumber;
		String caseChange;
		
		String partOne = "";
		String operator;
		String partTwo;
		
			value = value.substring(value.indexOf("(") + 2);
			value = value.substring(0, value.indexOf(")") - 1);
		
			Scanner valueReader = new Scanner(value);
			while (valueReader.hasNext()) {
				String temp1 = valueReader.next();
				if (Character.isLetter(temp1.charAt(0))) {
					caseChange = temp1.substring(0).toUpperCase();
					
					columnLetter = caseChange.charAt(0);
					rowNumber = Integer.parseInt(caseChange.substring(1)) - 1;
					
					//columnLetter to corresponding number
					columnNumber = Character.getNumericValue(columnLetter) - 10;
					
					//gets value of cell at location just parsed
					partOne = VisiCalc.gridSheet.spreadsheet[rowNumber][columnNumber].value;
					
				} else if (Character.isDigit(valueReader.next().charAt(0))) {
					partOne = valueReader.next();
				}
				
				operator = valueReader.next();
				
				//check if this is a cell!!!
				partTwo = valueReader.next();
				
				//yeah I know it's redundant but I would rather have this than a method with like a million parameters
				if (Character.isLetter(partTwo.charAt(0))) {
					caseChange = partTwo.substring(0, 1).toUpperCase();
					
					columnLetter = caseChange.charAt(0);
					rowNumber = Integer.parseInt(caseChange.substring(1)) - 1;
					
					//columnLetter to corresponding number
					columnNumber = Character.getNumericValue(columnLetter) - 10;
					
					//gets value of cell at location just parsed
					partTwo = VisiCalc.gridSheet.spreadsheet[rowNumber][columnNumber].value;
					
				} else if (Character.isDigit(temp1.charAt(0))) {
					partTwo = valueReader.next();
				}
				
				partOne = operations(partOne, operator, partTwo);
				
			}
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
