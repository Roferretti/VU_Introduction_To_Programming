package Collatz;
import java.io.PrintStream;
import java.util.Scanner;

public class Collatz {
	int number, evenOrOdd;
	PrintStream out;
	Scanner in;
	
	Collatz(){
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}
	void start(){
		
		out.printf("Write your number: ");
		number = in.nextInt();
		
		while (number > 1){
			out.printf("%d, ",number);
			evenOrOdd = number % 2; 
			
			if (evenOrOdd == 0){
				number = number/2;
			}else{
				number = 3 * number + 1;
			}
		}	
		out.print(1);	
	}
	public static void main(String[] args) {
		new Collatz().start();
	}

}
