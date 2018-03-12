package Snake;
import ui.SnakeUserInterface;
import ui.UserInterfaceFactory;
import ui.UIAuxiliaryMethods;
import ui.Event;
import java.io.PrintStream;

public class Snake {
	PrintStream out;
	SnakeUserInterface ui;
	
	int actualSize;
	String direction = "";
	SnakeObject[] snake = new SnakeObject [768];
	Fruit fruit;

	public static final double FPS = 20.0;
	public static final int WIDTH = 32;
	public static final int LENGTH = 24;
	
	Snake() {
		ui = UserInterfaceFactory.getSnakeUI(WIDTH, LENGTH);
		out = new PrintStream(System.out);
		ui.setFramesPerSecond(FPS);
	}	
	
	void setInitialValues(){
		snake[0].xCoord=1;
		actualSize = 2;
		direction = "right";
	}
	
	void changeDirection(Event event){
		
		if (direction == "right" && (event.data.equals("L") && event.name.equals("arrow"))){
			return; //if there is a left event and going right do nothing
		}else if(direction == "left" && (event.data.equals("R") && event.name.equals("arrow"))){
			return; // if there is a right event and going left do nothing
		}else if(direction == "down" && (event.data.equals("U") && event.name.equals("arrow"))){
			return; // if there is a up event and going down do nothing
		}else if(direction == "up" && (event.data.equals("D") && event.name.equals("arrow"))){
			return; // if there is a down event and going up do nothing
		}
		
		if (event.data.equals("L") && event.name.equals("arrow")) {
			direction="left";
		} else if (event.data.equals("R") && event.name.equals("arrow")) {
			direction="right";
		} else if (event.data.equals("D") && event.name.equals("arrow")) {
			direction="down";
		} else if (event.data.equals("U") && event.name.equals("arrow")) {
			direction="up";
		}
		
	}
	
	void placeHead(String direction){
		ui.place(snake[0].xCoord, snake[0].yCoord, ui.SNAKE); //place head
		ui.place(snake[0].lastX, snake[0].lastY, ui.EMPTY); //empty last head
		
		snake[0].lastX = snake[0].xCoord; //assign current value to last
		snake[0].lastY = snake[0].yCoord; //assign current value to last
		
		if(direction=="right"){
			snake[0].xCoord++;
		}else if (direction == "left"){
			snake[0].xCoord--;
		}else if (direction == "down"){
			snake[0].yCoord++;
		}else if (direction == "up"){
			snake[0].yCoord--;
		}
		
	}

	void placeBody(){
		if (actualSize == 2 ){
			ui.place(snake[0].xCoord, snake[0].yCoord, ui.SNAKE);
		}else{
			int i;
			
			for(i=0; i<actualSize; i++){  
				snake[i+1].lastX = snake[i+1].xCoord;
				snake[i+1].lastY = snake[i+1].yCoord;

				
				snake[i+1].xCoord = snake[i].lastX;
				snake[i+1].yCoord = snake[i].lastY;
				
				ui.place(snake[i+1].xCoord, snake[i+1].yCoord, ui.SNAKE);
				ui.place(snake[i+1].lastX, snake[i+1].lastY, ui.EMPTY);
			}
			checkIfDead();
		}
	}
	
	void moveRight(String direction){
		
		checkIfNextPossible(direction);
		
		placeHead(direction);
		
		placeBody();
	}
	
	void moveLeft(String direction){
		checkIfNextPossible(direction);
		
		placeHead(direction);
		
		placeBody();
	}
	
	void moveDown(String direction){
		checkIfNextPossible(direction);
		
		placeHead(direction);
		
		placeBody();	
	}
	
	void moveUp(String direction){
		
		checkIfNextPossible(direction);
		
		placeHead(direction);
		
		placeBody();

	}
	
	void checkIfNextPossible(String direction){
		if (direction == "right"){
			if(snake[0].xCoord == 31){
				snake[0].xCoord = 0;
				ui.place(31, snake[0].lastY, ui.EMPTY);   //ui.place(31,0, ui.EMPTY);
				ui.showChanges();	
			}
		}else if(direction == "left"){
				if(snake[0].xCoord == 0){
					snake[0].xCoord = 31;
					ui.place(0, snake[0].lastY, ui.EMPTY);
					ui.showChanges();	
				}
		}else if(direction == "down"){
			if(snake[0].yCoord == 23){
				snake[0].yCoord = 0;
				ui.place(snake[0].lastX, 23, ui.EMPTY);
				ui.showChanges();	
			}
		}else if(direction == "up"){
			if(snake[0].yCoord == 0){
				snake[0].yCoord = 23;
				ui.place(snake[0].lastX, 0, ui.EMPTY);
				ui.showChanges();	
			}
		}
	}
	
	void Fruit(){
		if(fruit.status == false){
			printFruit();
		}
			
		if ((snake[0].xCoord == fruit.xCoord) && (snake[0].yCoord == fruit.yCoord)){
			actualSize++;
			fruit.status = false;
		}
	}
	
	void printFruit(){
		fruit.xCoord = UIAuxiliaryMethods.getRandom(0,31);
		fruit.yCoord = UIAuxiliaryMethods.getRandom(0,23);
		ui.place(fruit.xCoord, fruit.yCoord, ui.FOOD);
		fruit.status = true;
	}
	
	void checkIfDead(){
		for (int i=1; i<actualSize; i++){
			if ((snake[0].xCoord == snake[i].xCoord) && (snake[0].yCoord == snake[i].yCoord)){
				ui.printf("GAME OVER!");
				while (true) {
					ui.clear();
					ui.showChanges();
				}
			}
		}
	}
	
	void start(){
		int j=0;
		for (j=0; j<768; j++){ 
			snake[j] = new SnakeObject();
		}
		fruit = new Fruit();
		
		setInitialValues();
		
		while (true){
			
			Fruit();
			if(fruit.status == false){
				Fruit();
			}
			
			Event event = ui.getEvent();

			changeDirection(event);
			
			if(event.data.equals("refresh")){
				if (direction=="right"){
					moveRight(direction);
					ui.showChanges();
				} else if (direction == "left"){
					moveLeft(direction);
					ui.showChanges();
				} else if (direction == "down"){
					moveDown(direction);
					ui.showChanges();
				} else if (direction == "up"){
					moveUp(direction);
					ui.showChanges();
				}else{
					return;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new Snake().start();
	}
}

