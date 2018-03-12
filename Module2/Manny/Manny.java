package Manny;
import java.io.PrintStream;
import java.util.Scanner;

public class Manny {
	double donation;
	PrintStream out;
	Scanner in;
	
	Manny(){
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}
	
	void start(){
		do{
			out.printf("Enter the amount you want to donate to charity: ");
			donation = in.nextDouble();
		} while (donation < 50.00);
		out.printf("Thank you for your donation of: %.2f euro.", donation);
	}
	public static void main(String[] args) {
		new Manny().start();
	}

}
