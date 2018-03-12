package Pyramid;
import java.io.PrintStream;

public class Pyramid {
	PrintStream out;
	
	Pyramid(){
		out = new PrintStream(System.out);
	}
	void printSpaces(int currentRow){
		for (int spaces = 0; spaces < 40 - currentRow; spaces++){
			out.printf(" ");
		}
	}
	void printLetters(int nextLevel, char c) {
		for (int letter = 0; letter <= nextLevel; letter++){
			out.printf("%c", c);
		}
	}
	void start(){
		int currentRow;
		int nextLevel = 0;
		char character = 'a';

		for (currentRow = 0; currentRow < 15; currentRow++){
			printSpaces(currentRow);
			printLetters(nextLevel, character);
			nextLevel += 2;
			character += 1;
			out.printf("\n");
		}
		
	}
	public static void main(String[] args) {
		new Pyramid().start();
	}

}
