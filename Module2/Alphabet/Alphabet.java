package Alphabet;
import java.io.PrintStream;

public class Alphabet {
	PrintStream out;
	
	Alphabet(){
		out = new PrintStream(System.out);
	}
	
	void start(){
		for (int alphabetChar=65; alphabetChar<=90; alphabetChar++){
			out.print((char)alphabetChar);
		}
	}
	
	public static void main(String[] args) {
		new Alphabet().start();
	}
}
