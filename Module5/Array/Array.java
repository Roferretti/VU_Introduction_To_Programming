package Array;
import java.io.PrintStream;
import java.util.Scanner;

public class Array {
	PrintStream out;
	Scanner in;
	int [] number;
	
	Array(){
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
	}
	
	void createArray(){ //works also with Scanner in 
		int i;
		for (i=0; i<20; i++){
			number [i] = in.nextInt();
			//out.printf("\tnumber is: %d\n", number[i]);
		}
	}
	
	void printArrayBackwards(){
		int i=0;
		for (i = 19; i >= 0; i--){
			if (i == 0){
				out.printf("%d", number[i]);
			}else{
				out.printf("%d, ", number[i]);
			}
		}
	}
		
	void start(){
		
		out.printf("Hello World!\nNow please type 20 numbers: \n");
		number = new int [20];
		createArray();//can send "in" and works
		printArrayBackwards();
	}
	
	public static void main(String[] args) {
		new Array().start();
	}

}
