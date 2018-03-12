package Othello1;
import java.io.PrintStream;
import java.util.Scanner;

public class Othello1 {
	PrintStream out;
	Scanner in;
	
	Othello1(){
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}
	void start () {
		double blackPieces, whitePieces;
		
		out.printf("Enter the number of white pieces on the board: ");
		whitePieces = in.nextInt();
		
		out.printf("Enter the number of black pieces on the board: ");
		blackPieces = in.nextInt();
		
		out.printf("The percentage of black pieces on the board is: %.2f\n", ((blackPieces*100)/64));
		out.printf("The percentage of black pieces of all the pieces on the board is: %.2f\n", (blackPieces*100/(whitePieces+blackPieces)));
	} 
	
	
	public static void main(String[] args) {
			new Othello1().start();
	}

}
