package Events;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
import ui.Event;
import java.util.Scanner;

public class Events {
	SnakeUserInterface ui;
	public static final int WIDTH = 40, LENGTH = 30, FPS=40;
	int xCoord=0, yCoord=0;
	
	Events(){
		ui = UserInterfaceFactory.getSnakeUI(WIDTH, LENGTH);
		ui.enableEventProcessing(true);
        ui.setFramesPerSecond(FPS);
        
        UserInterfaceFactory.enableLowResolution(true);
	}
	
	void processEvent(Event event){
		if (event.name.equals("click")){
			processClick(event.data);
			
		} else if (event.data.equals("␣")){
			ui.clear();
			ui.showChanges();
		}else{
			
		}
	}
	
	void processClick(String data){
		String coordinates = "";
		coordinates = data;
		
		Scanner coordScanner = new Scanner(coordinates);
		xCoord = coordScanner.nextInt();
		yCoord = coordScanner.nextInt();
		
		ui.place(xCoord, yCoord, ui.WALL);
		System.out.println(data);
		ui.showChanges();
	}

	void start(){
		while (true){
			Event event = ui.getEvent();
			processEvent(event);
		}
	}

	public static void main(String[] args) {
		new Events().start();
	}

}
