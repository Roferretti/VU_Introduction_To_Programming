package LP;

import java.util.Scanner;
import ui.LabyrinthUserInterface;
import ui.UIAuxiliaryMethods;
import ui.UserInterfaceFactory;


public class LP {
	Scanner in;
	LabyrinthUserInterface ui;
	
	CoordinateRow walls;
	CoordinateRow path;
	CoordinateRow longestPath;
	
	Coordinate startC;
	Coordinate endC;
	
	String startCoordinate;
	String endCoordinate;
	String wallCoordinates;
	
	public static final int WIDTH = 32;
	public static final int HEIGHT = 24;
	public static final int SPEED = 2;
	
	LP(){
		in = UIAuxiliaryMethods.askUserForInput().getScanner();
		ui = UserInterfaceFactory.getLabyrinthUI(WIDTH, HEIGHT);
		UserInterfaceFactory.enableLowResolution(true);
		walls=new CoordinateRow();
		path=new CoordinateRow();
		longestPath=new CoordinateRow();
	}

	//read the text file
	//place the walls
	//start at start +encircle finish
	//check for walls etc
	
	void readTextFile(){
		in.useDelimiter("=");
		startCoordinate=in.next();
		endCoordinate=in.next();
		wallCoordinates=in.next();
		
		startC=new Coordinate();
		Scanner startScanner = new Scanner(startCoordinate);
		startC.x=startScanner.nextInt();
		startC.y=startScanner.nextInt();
		
		path.add(startC);
		startScanner.close();
		
		endC=new Coordinate();
		Scanner endScanner = new Scanner(endCoordinate);
		endC.x=endScanner.nextInt();
		endC.y=endScanner.nextInt();
		endScanner.close();
		
		processWalls();
	}
	
	void processWalls(){
		Scanner wallScanner=new Scanner(wallCoordinates);
		wallScanner.useDelimiter("\n");
		while (wallScanner.hasNext()){
			Scanner coordinateScanner=new Scanner (wallScanner.next());
			Coordinate wallCoordinate=new Coordinate();
			wallCoordinate.x=coordinateScanner.nextInt();
			wallCoordinate.y=coordinateScanner.nextInt();
			walls.add(wallCoordinate);
			
			coordinateScanner.close();
		}
		wallScanner.close();
		placeWalls();
	}
	
	void placeWalls(){
		for (int i=0; i<walls.count;i++){
			ui.place(walls.array[i].x, walls.array[i].y, ui.WALL);
		}
		ui.encircle(endC.x, endC.y);
		ui.place(startC.x, startC.y, ui.PATH);
		ui.showChanges();
		ui.wait(2000);
	}
	
	boolean checkForWall(int futurePathX, int futurePathY){
		boolean trueFalse=false;
		for (int i=0; i<walls.count; i++){
			if (futurePathX==walls.array[i].x && futurePathY==walls.array[i].y){
				trueFalse= true;
			}
		}
		return trueFalse;
	}
	
	boolean checkForPath(int futurePathX, int futurePathY){
		boolean trueFalse=false;
		for (int i=0; i<path.count; i++){
			if (futurePathX==path.array[i].x && futurePathY==path.array[i].y){
				trueFalse=true;
			}
		}
		return trueFalse;
	}
	
	boolean checkEnd(int futurePathX, int futurePathY){
		boolean trueFalse=false;
		if (futurePathX==endC.x && futurePathY==endC.y){
			trueFalse=true;
			comparePath(futurePathX, futurePathY);
		}
		return trueFalse;
	}
	
	void comparePath(int futurePathX, int futurePathY){
		if (path.count>longestPath.count){
			longestPath.count=0;
			for (int i=0; i<path.count;i++){
				longestPath.array[i]=path.array[i];
				longestPath.count+=1;
			}
			Coordinate lastCoordinate=new Coordinate();
			lastCoordinate.x=futurePathX;
			lastCoordinate.y=futurePathY;
			longestPath.add(lastCoordinate);
		}
		
	}
	
	
	boolean check(int futurePathX, int futurePathY){
		int trueFalse=0;
		if (checkForWall(futurePathX, futurePathY)){
			trueFalse+=1;
		}
		if (checkForPath(futurePathX, futurePathY)){
			trueFalse+=1;
		}
		if (checkEnd(futurePathX, futurePathY)){
			trueFalse+=1;
		}
		if (trueFalse>0){
			return true;
		}
		else {
			return false;
			}
	}
	
	void runMaze(){
		ui.wait(SPEED);
		if (check(path.array[path.count-1].x+1, path.array[path.count-1].y)==false){ //check east
			Coordinate newCoordinate=new Coordinate();
			newCoordinate.x=path.array[path.count-1].x+1;
			newCoordinate.y=path.array[path.count-1].y;
			path.add(newCoordinate);
			ui.place(newCoordinate.x, newCoordinate.y, ui.PATH);
			ui.showChanges();
			runMaze();
			ui.place(path.array[path.count-1].x, path.array[path.count-1].y, ui.EMPTY);
			path.delete(path.count-1);
			ui.showChanges();
		}
		
		if (check(path.array[path.count-1].x, path.array[path.count-1].y+1)==false){
			Coordinate newCoordinate=new Coordinate();
			newCoordinate.x=path.array[path.count-1].x;
			newCoordinate.y=path.array[path.count-1].y+1;
			path.add(newCoordinate);
			ui.place(newCoordinate.x, newCoordinate.y, ui.PATH);
			ui.showChanges();
			runMaze();
			ui.place(path.array[path.count-1].x, path.array[path.count-1].y, ui.EMPTY);
			path.delete(path.count-1);
			ui.showChanges();
		}
		
		if (check(path.array[path.count-1].x-1, path.array[path.count-1].y)==false){ //check east
			Coordinate newCoordinate=new Coordinate();
			newCoordinate.x=path.array[path.count-1].x-1;
			newCoordinate.y=path.array[path.count-1].y;
			path.add(newCoordinate);
			ui.place(newCoordinate.x, newCoordinate.y, ui.PATH);
			ui.showChanges();
			runMaze();
			ui.place(path.array[path.count-1].x, path.array[path.count-1].y, ui.EMPTY);
			path.delete(path.count-1);
			ui.showChanges();
		}
		
		if (check(path.array[path.count-1].x, path.array[path.count-1].y-1)==false){
			Coordinate newCoordinate=new Coordinate();
			newCoordinate.x=path.array[path.count-1].x;
			newCoordinate.y=path.array[path.count-1].y-1;
			path.add(newCoordinate);
			ui.place(newCoordinate.x, newCoordinate.y, ui.PATH);
			ui.showChanges();
			runMaze();
			ui.place(path.array[path.count-1].x, path.array[path.count-1].y, ui.EMPTY);
			path.delete(path.count-1);
			ui.showChanges();
		}
	}
	
	
	void start(){
		readTextFile();
		runMaze();
		ui.printf("Longest path is %d", longestPath.count);
		for (int i=0;i<longestPath.count; i++){
			ui.place(longestPath.array[i].x, longestPath.array[i].y, ui.PATH);
			ui.showChanges();
			ui.wait(50);
		}
		
	}
	
	public static void main(String[] args) {
		new LP().start();

	}

}
