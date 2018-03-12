package Animation;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
import ui.Event;
import java.util.Scanner;
import java.io.PrintStream;

public class Animation {
	
	PrintStream out;
	Scanner in;
	SnakeUserInterface ui;
	boolean flag = false;
	
	Animation() {
		ui = UserInterfaceFactory.getSnakeUI(10, 10);
		in = new Scanner(System.in);
		out = new PrintStream(System.out);
	}

	int processAnimation(Event event, int fps, int xCoordinate, int yCoordinate, int previousXCoord, int previousYCoord){
		if (event.data.equals("L") && event.name.equals("arrow")) {
			fps -= 1;
		} else if (event.data.equals("R") && event.name.equals("arrow")) {
			fps += 1;
		}
		
		if ((event.data.equals("j")||event.data.equals("J")) && event.name.equals("letter")){
			flag = !flag;
		}
		
		if (flag == false){
			ui.place(xCoordinate, yCoordinate, ui.WALL);
			ui.place(previousXCoord, previousYCoord, ui.EMPTY);
			ui.showChanges();
		}else{
			ui.place(xCoordinate, yCoordinate, ui.SNAKE);
			ui.place(previousXCoord, previousYCoord, ui.EMPTY);
			ui.showChanges();
		}
		
		return fps;
	}
	
	void start() {
		int xCoord = 0; int yCoord = 0;
		int previousXCoord = 0; int previousYCoord = 0;
		int fps = 30;
		
		while (true) {
			ui.setFramesPerSecond(fps);
			Event event = ui.getEvent();
			fps = processAnimation(event, fps, xCoord, yCoord, previousXCoord, previousYCoord); 
			previousXCoord = xCoord;
			previousYCoord = yCoord;
			
			xCoord++; //to print the next wall after entering the while again
			
			if (xCoord == 10) {
				xCoord = 0;
				yCoord += 1;
			}
			
			if (yCoord == 10) {
				yCoord = 0;
			}	
			out.println(fps);	
		}
	}

	public static void main(String[] args) {
		new Animation().start();
	}
}