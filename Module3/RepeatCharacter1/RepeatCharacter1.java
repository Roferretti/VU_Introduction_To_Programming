package RepeatCharacter1;
import java.io.PrintStream;
import java.util.Scanner;

public class RepeatCharacter1 {
	PrintStream out;
	Scanner in;
	
	RepeatCharacter1() {
		out = new PrintStream(System.out);
	}
	
	void printExclamationMarks(int number) {
		int i = 0;
		while (i != number){
			out.printf("! ");
			i++;
		}
	}
	
	void start() {
		in = new Scanner(System.in);
		out.printf("Write a number: ");
		int number = in.nextInt();
		
		printExclamationMarks(number);
	}
	public static void main(String[] args) {
		new RepeatCharacter1().start();
	}

}
