package NucearPowerPlant;
import java.io.PrintStream;

public class NuclearPowerPlant {
	PrintStream out;
	
	NuclearPowerPlant() {
		out = new PrintStream(System.out);
	}
	
	void printMessage() {
		out.printf("NUCLEAR CORE UNSTABLE!!!\nQuarantine is in effect.\nSurrounding hamlets will be evacuated.\nAnti-radiationsuits and iodine pills are mandatory.\n\n");
	}
	
	void start() {
		for (int i=0; i!=3; i++){
			printMessage();
		}
	}
	
	public static void main(String[] args) {
		new NuclearPowerPlant().start();
	}
}
