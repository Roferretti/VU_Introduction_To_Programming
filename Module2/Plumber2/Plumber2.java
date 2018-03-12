package Plumber2; /* After careful assessment of the new program it turns out that the employees of
‘The Maverick Monkey’ are as bad at rounding numbers as they are at making
calculations. Therefore the boss decides to alter the program in such a way that
the program only needs the number of hours an employee has actually worked.
The program will determine the number of billable hours based on this input.
Make a copy of the previous assignment and edit the code to implement this
new feature. The number of billable hours is the number of hours worked
rounded to an integer.
Example A plumber earning e31.50 an hour, working for 4.5 hours should
get the following output.    
hourly wages= 31.50, hours worked=4.5  total=173.50 */

import java.io.PrintStream;
import java.util.Scanner;

public class Plumber2 {
	double hoursWorked, total, hourlyWages;
	static final int CALL_OUT_COST = 16;
	PrintStream out;
	Scanner in;
	
	Plumber2(){
		out = new PrintStream(System.out);
		in = new Scanner (System.in);
	}
	void start (){
		out.printf("Calculation of total cost of repair: \n");
		
		out.printf("Write number of hourly wages: ");
		hourlyWages = in.nextDouble();
		
		out.printf("Write the number of the hours you have worked: ");
		hoursWorked = in.nextDouble(); 
		hoursWorked = (int)(hoursWorked + 0.5); //round hoursWorked
		
		total= hourlyWages * hoursWorked + CALL_OUT_COST;
		out.printf("Total of repair is: %.2f", total);
	}
	
	public static void main(String[] args) {
		new Plumber2().start();
	}
}
