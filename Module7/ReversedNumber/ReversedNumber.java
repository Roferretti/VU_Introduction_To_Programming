package ReversedNumber;
import java.util.Scanner;

public class ReversedNumber {
	Scanner in;
	String newString;
	
	ReversedNumber(){
		in = new Scanner(System.in);
	}

//	int countNumbers(int number){
//		if(number<10){
//			return 1;
//		}
//		
//		return 1+ countNumbers(number/10);
//		
//	}

	public static void reverseDigits(int number) {
	    if (number < 10) {
	        System.out.print(number);
	        return;
	    }
	    else {
	        System.out.print(number % 10); //12345 % 10 = 5
	        reverseDigits(number/10);
	    }
	}
	void start(){
		System.out.printf("Write a number to print it backwards:\n");
		
		int number = in.nextInt();
		//System.out.println(number);
		
//		int numberOfNumbers = countNumbers(number); //to count how many numbers
//		System.out.println(numberOfNumbers);
		
		reverseDigits(number);
	}
	
	public static void main(String[] args) {
		new ReversedNumber().start();

	}

}

//String line= in.nextLine();
//Scanner lineScanner = new Scanner(line);