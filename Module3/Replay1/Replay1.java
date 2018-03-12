package Replay1;
import java.util.Scanner;
import ui.UserInterfaceFactory;
import ui.OthelloReplayUserInterface;
import ui.UIAuxiliaryMethods;

public class Replay1 {
	Scanner in;
	OthelloReplayUserInterface ui;

	Replay1() {
		ui = UserInterfaceFactory.getOthelloReplayUI();
		in = UIAuxiliaryMethods.askUserForInput().getScanner();
		UserInterfaceFactory.enableLowResolution(true);
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

	void start() {
		String color = "";
		String moveOrPass = "";
		String coordinateA = "";
		int coordinateB = 0;
		int wait = 0;
		int coordinateAInInt = 0;

		ui.place(3, 3, ui.WHITE);
		ui.place(4, 4, ui.WHITE);
		ui.place(3, 4, ui.BLACK);
		ui.place(4, 3, ui.BLACK);
		ui.showChanges();
		ui.wait(1000);

		while (in.hasNextLine()) {
			color = in.next();
			wait = in.nextInt();
			moveOrPass = in.next();
			if (moveOrPass.equals("move")) {
				ui.wait(wait);
				coordinateA = in.next();
				coordinateAInInt = changeA(coordinateA);
				coordinateB = (in.nextInt() - 1);

				//System.out.println(color + ", " + coordinateAInInt + ", " + coordinateB);
				if (color.equals("black")) {
					placeMove(ui.BLACK, wait, coordinateAInInt, coordinateB, moveOrPass);
				} else {
					placeMove(ui.WHITE, wait, coordinateAInInt, coordinateB, moveOrPass);
				}
			}

		}
	}

	public static void main(String[] args) {
		new Replay1().start();
	}
}