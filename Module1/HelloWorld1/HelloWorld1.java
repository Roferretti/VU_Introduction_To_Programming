package HelloWorld1;

import java.io.PrintStream;

public class HelloWorld1 {
	//Name: Rodrigo Ferretti Morlet
	//Assignment: HelloWorld1
	//Date: 08/09/16
	
	PrintStream out;
	
	HelloWorld1() {
		out = new PrintStream(System.out);
	}
	
	void start () {
		out.printf("Hello World!! ");
		out.printf("written by: %s\n","Rodrigo Ferretti Morlet");
	}

	public static void main(String[] argv) {
		// TODO Auto-generated method stub
		new HelloWorld1().start();
	}
}
