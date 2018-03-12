package Administration;
import ui.UIAuxiliaryMethods;
import java.util.Scanner;

public class Administration {
	Scanner in;
	
	Administration(){
		in = UIAuxiliaryMethods.askUserForInput().getScanner();
	}
	
	void readFirstLine(String line){
		String name = "";
		Scanner lineScanner= new Scanner(line);
		lineScanner.useDelimiter("_"); 
		name = lineScanner.next(); 
		String gradesString = "";
		
		while (lineScanner.hasNext()) {  
			gradesString = lineScanner.next();
		}

		System.out.printf("%s has an average of: ", name);
		parseAndCalculateAverage(gradesString);
	}
	
	void parseAndCalculateAverage(String gradesString){
		double numberOfGrades = 0.0, sum = 0.0, average = 0;
		
		Scanner gradesScanner=new Scanner(gradesString);	
		while (gradesScanner.hasNext()) {
			String gradeString2 = gradesScanner.next();
			int number = Integer.parseInt(gradeString2);
			sum += number;
			numberOfGrades++;
		}
		
		average = sum/numberOfGrades;
		average = Math.round(average * 2) / 2.0;
		int averageInt = (int) average;
		
		if (average >= 5.5 && average < 6.0) {
			System.out.println("6-");
		} else{
			if (average % averageInt == 0){ 
				System.out.println(averageInt); //case of integer
			} else{
				System.out.println(average); //case of double  
			}
		}
		
	}
	
	String readSimilarity(String line){
		Scanner lineScanner = new Scanner(line);
		lineScanner.useDelimiter(";");
		
		String firstPart = "";
		firstPart = lineScanner.next();
		return firstPart;
	}
	
	void similarityToSymbols(String firstPart){
		String similarityString = "", similarityString2 = "";
		int result = 0;
		
		Scanner similarityScanner = new Scanner(firstPart);
		similarityScanner.useDelimiter("=");
		
		while (similarityScanner.hasNext()){
			similarityString = similarityScanner.next();
			result = Integer.parseInt(similarityString);
			if (result == 0){
				similarityString2 = similarityString2.concat("_");
			}else if (result <= 19){
				similarityString2 = similarityString2.concat("-");
			}else if (result >= 20){
				similarityString2 = similarityString2.concat("^");
			}
		}
		similarityScanner.close();
		System.out.printf("\t%s\n", similarityString2);
	}
	
	void readSecondPartOfLine2(String line){
		String secondPart = "";
		
		Scanner nameScanner = new Scanner(line);
		nameScanner.useDelimiter(",");
		
		while (nameScanner.hasNext()){
			secondPart = nameScanner.next();
			System.out.printf("\t%s\n", secondPart);
		}
	}
	
	void start(){
		int evenOrOdd = 0;
		double average = 0;
		
		String firstPart = "", secondPart="", similarityString;
		
		while (in.hasNextLine()){
			String line = in.nextLine();
			
			if (evenOrOdd % 2 == 0){
				readFirstLine(line);
				
			}else if (evenOrOdd % 2 == 1){			
				Scanner secondLineScanner=new Scanner (line);
				secondLineScanner.useDelimiter(";");
				
				firstPart = readSimilarity (secondLineScanner.next());
				similarityToSymbols(firstPart); 
				
				if(secondLineScanner.hasNext()) {
					readSecondPartOfLine2(secondLineScanner.next());
				}else{
					System.out.println("\tNo matches found");}
				}
			evenOrOdd++;
			}
		
	}
	
	public static void main(String[] args) {
		new Administration().start();
	}
}