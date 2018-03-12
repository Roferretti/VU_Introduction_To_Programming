package Pizza;
import java.io.PrintStream;

public class Pizza {
	PrintStream out;
	Pizza() {
		out = new PrintStream(System.out);
	}
	
	int factorialFormula(int nFactorial, int kFactorial, int nMinusKFactorial){
		int result =0;
		result = ((nFactorial)/((kFactorial*nMinusKFactorial)));
		return result;
	}
	
	int factorial (int number){
		int result = 1;
		for(int i = 1; i <= number; i++){
			result = result * i;
		}
		return result;
	}
	
	int operation (int n, int k){
		int result;
		int nFactorial = 0; int kFactorial = 0; int nMinusKFactorial = 0; 
		
		nFactorial = factorial(n); //calls factorial individually & store
		kFactorial = factorial(k);
		nMinusKFactorial = factorial (n-k);
		
		result = factorialFormula(nFactorial, kFactorial, nMinusKFactorial); //calls the formula, sending the values of each factorial
		return result;
	}
	
	void start() {	
		int n = 10; int k = 3;   //mario
		int mario = operation(n, k);
		
		n = 9; k = 4;  //luigi
		int luigi = operation (n, k);
		
		out.printf("The number of combinations are:\nMario: %d\nLuigi: %d\n", mario, luigi);
		if (mario > luigi){
			out.printf("Mario is the winner!");
		}else{
			out.printf("Luigi is the winner!");
		}
	}
	
	public static void main(String[] args) {
		new Pizza().start();
	}
}
