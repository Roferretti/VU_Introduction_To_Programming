package RepeatCharacter2;
import java.io.PrintStream;
import java.util.Scanner;

public class RepeatCharacter2 {
	PrintStream out;
	Scanner in;
	boolean flag = false;
	
	RepeatCharacter2() {
		out = new PrintStream(System.out);
	}
	
	void printExclamationMarksOrComas(int number, boolean flag) {
		int i=0;
		if (flag == false){
			while (i != number){
				out.printf("! ");
				i++;
			}
		}else{
			i=0;
			while (i != number){
				out.printf(", ");
				i++;
			}
		}
	}
	
	void start() {
		in = new Scanner(System.in);
		out.printf("Write a number: ");
		int number = in.nextInt();
		printExclamationMarksOrComas(number, flag);
		flag = true; //if flag is true, then next time printing will be comas.
		
		
		out.printf("\nWrite a number: ");
		number = in.nextInt();
		printExclamationMarksOrComas(number, flag);
	}
	public static void main(String[] args) {
		new RepeatCharacter2().start();
	}

}