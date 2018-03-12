package Plumber1; /*The employees at plumbery ‘The Maverick Monkey’ are notorious bad mathmaticians.31
Therefore the boss has decided to use a computer program to calculate
the costs of a repair. The costs of a repair can be obtained with the following
calculation: the hourly wages multiplied by the number of billable hours plus
the call-out cost. The number of billable hours is always rounded. Plumbing
laws fix the call-out cost at e16,00.
Write a program that calculates the costs of a repair. Take the hourly wages
and number of billable hours as input for this program.

Example A plumber earning e31,50 an hour working for 5 hours should get
the following output:  31.50     5    173.50 */
import java.util.Scanner;
import java.io.PrintStream;

public class Plumber1 {
	double hourlyWages, billableHours, total;
	static final int CALL_OUT_COST = 16;
	PrintStream out;
	Scanner in;
	
	Plumber1() {
		out = new PrintStream(System.out);
		in = new Scanner (System.in);
	}
	
	void start (){
		out.printf("Calculation of total cost of repair: \n");
		
		out.printf("Write number of hourly wages: ");
		hourlyWages = in.nextDouble();
		
		out.printf("Write the number of billage hours: ");
		billableHours = in.nextDouble(); 
		
		total= hourlyWages * billableHours + CALL_OUT_COST;
		out.printf("Total of repair is: %.2f", total);
	}
	
	public static void main(String[] args) {
		new Plumber1().start();
	}
}
