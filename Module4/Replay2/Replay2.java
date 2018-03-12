package Replay2;
import java.util.Scanner;
import ui.UserInterfaceFactory;
import ui.OthelloReplayUserInterface;
import ui.UIAuxiliaryMethods;

public class Replay2 {
	Scanner in;
	OthelloReplayUserInterface ui;

	Replay2() {
		UserInterfaceFactory.enableLowResolution(true);
		ui = UserInterfaceFactory.getOthelloReplayUI();
		in = UIAuxiliaryMethods.askUserForInput().getScanner();
	}
	
	int changeA(String coordinateA) {
		int result = 0;
		switch (coordinateA) {
		case "a":
			result = 0;
			break;
		case "b":
			result = 1;
			break;
		case "c":
			result = 2;
			break;
		case "d":
			result = 3;
			break;
		case "e":
			result = 4;
			break;
		case "f":
			result = 5;
			break;
		case "g":
			result = 6;
			break;
		case "h":
			result = 7;
			break;
		}
		return result;
	}

	void placeMove(int color, int wait, int coordinateA, int coordinateB, String move) {
			ui.place(coordinateA, coordinateB, color);
			ui.showChanges();
	}

	void startSettings(){
		ui.place(3, 3, ui.WHITE);
		ui.place(4, 4, ui.WHITE);
		ui.place(3, 4, ui.BLACK);
		ui.place(4, 3, ui.BLACK);
		ui.showChanges();
		ui.wait(1000);
	}
	
	void start() {	
		String color = "";
		String moveOrPass = "";
		String coordinateA = "";
		int coordinateB = 0;
		int wait = 0;
		int coordinateAInInt = 0;

		startSettings();
		
		while (in.hasNextLine()) {
			String line = in.nextLine();
			Scanner lineScanner = new Scanner (line);
			
			color = lineScanner.next();
			wait = lineScanner.nextInt();
			moveOrPass = lineScanner.next();
			
			if (moveOrPass.equals("move")) {
				ui.wait(wait);
				int conquered = -1;
				while (lineScanner.hasNext()){
					conquered++;
					coordinateA = lineScanner.next();
					coordinateAInInt = changeA(coordinateA);
					coordinateB = (lineScanner.nextInt() - 1);
					
					//System.out.println(color + ", " + coordinateAInInt + ", " + coordinateB);
					
					if (color.equals("black")) {
						placeMove(ui.BLACK, wait, coordinateAInInt, coordinateB, moveOrPass);
						if (conquered > 0){
							ui.printf("black conquered: %d pieces\n" , conquered);
						}
					} else {
						placeMove(ui.WHITE, wait, coordinateAInInt, coordinateB, moveOrPass);
						if (conquered > 0){
							ui.printf("white conquered: %d pieces\n" , conquered);
						}
					}
				}	
			
			}
			if (moveOrPass.equals("pass") && color.equals("black")){
				ui.printf("black: passed\n");
			}else if (moveOrPass.equals("pass") && color.equals("white")){
				ui.printf("white: passed\n");
			}
			lineScanner.close();
		}
	}

	public static void main(String[] args) {
		new Replay2().start();
	}
}