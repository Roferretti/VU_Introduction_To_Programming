package VAT; 
import java.util.Scanner;
import java.io.PrintStream;

public class VAT {
	static final double VAT_VALUE = 1.21; // 21% VAT
	double valueWithVat;
	PrintStream out;
	Scanner in;
	
	VAT() {
		in = new Scanner (System.in);
		out = new PrintStream(System.out);
	}
	
	void start () {
		out.printf("Please write the amount of your article (with VAT): ");
		valueWithVat = in.nextDouble();
		
		out.printf("The price of your article without VAT is: %.2f\n", (valueWithVat/VAT_VALUE));
	}

	public static void main(String[] args) {
		new VAT().start();
	}

}

/* 
package VAT; 
import java.util.Scanner;
import java.io.PrintStream;

public class VAT {
	static final double VAT_VALUE = 1.21; // 21% VAT
	double valueWithVat;
	PrintStream out;
	Scanner in;
	
	VAT() {
		in = new Scanner (System.in);
		out = new PrintStream(System.out);
	}
	
	void start () {
		out.printf("Please write the amount of your article (with VAT): ");
		valueWithVat = in.nextDouble();
		
		out.printf("The price of your article without %.2f%%VAT is: %.2f\n", (100*(VAT_VALUE-1)), (valueWithVat/VAT_VALUE));
	}

	public static void main(String[] args) {
		new VAT().start();
	}

}

 */
