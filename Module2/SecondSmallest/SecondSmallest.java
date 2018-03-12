package SecondSmallest;
import java.io.PrintStream;
import java.util.Scanner;

public class SecondSmallest {
	int smallest = 0, secondSmallest = 0, i = 0;
	PrintStream out;
	Scanner in;
	
	SecondSmallest(){
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}
	
	void start(){
		out.printf("Write at least 3 integers: ");

		
		while (in.hasNext()){
			int number = in.nextInt();
			
			if (i == 0){
				smallest = number;
			} else if (number < smallest){
				secondSmallest = smallest;
				smallest = number;
			} else if (number < secondSmallest){
				secondSmallest = number;
			}
			i = i+1;
		}
		out.printf("The second smallest number is %d", secondSmallest);
	}

	public static void main(String[] args) {
		new SecondSmallest().start();
	}

}
