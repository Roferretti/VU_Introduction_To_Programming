package HelloWorld2;

import java.io.PrintStream;
import java.util.Scanner;

public class HelloWorld2 {
	//Name: Rodrigo Ferretti Morlet
	//Assignment: HelloWorld1
	//Date: 08/09/16
	
	PrintStream out;

	HelloWorld2() {
		out = new PrintStream(System.out);
	}
	
	void start () {
		Scanner in = new Scanner(System.in);
		
		out.printf("Enter your name: ");
		String name = in.nextLine();
		
		out.printf("Hello World!! ");
		out.printf("written by: %s\n","Rodrigo Ferretti Morlet");
		
		out.printf("Written name was:" );
		out.printf(name); //or could also 
	}

	public static void main(String[] argv) {
		// TODO Auto-generated method stub
		new HelloWorld2().start();
	}
}
