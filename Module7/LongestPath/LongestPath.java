package LongestPath;
import java.util.Scanner;
import ui.LabyrinthUserInterface;
import ui.UIAuxiliaryMethods;
import ui.UserInterfaceFactory;


public class LongestPath {
	Scanner in;
	LabyrinthUserInterface ui;
	
	CoordinateRow wallsCoordinateRow;
	CoordinateRow pathCoordinateRow;
	CoordinateRow longestPathToEnd;
	
	Coordinate startCoords;
	Coordinate endCoords;
	
	String startCoordinate = "";
	String endCoordinate = "";
	String wallCoordinates = "";
	
	public static final int WIDTH = 32;
	public static final int HEIGHT = 24;
	public static final int SPEED = 25;
	
	LongestPath(){
		in = UIAuxiliaryMethods.askUserForInput().getScanner();
		ui = UserInterfaceFactory.getLabyrinthUI(WIDTH, HEIGHT);
		UserInterfaceFactory.enableLowResolution(true);
		wallsCoordinateRow = new CoordinateRow();
		pathCoordinateRow = new CoordinateRow();
		longestPathToEnd = new CoordinateRow();
	}

	void readInput(){
		in.useDelimiter("=");
		
		startCoordinate = in.next();		
		startCoords=new Coordinate();
		Scanner startCoordsScanner = new Scanner(startCoordinate);
		startCoords.xCoord=startCoordsScanner.nextInt();
		startCoords.yCoord=startCoordsScanner.nextInt();
		pathCoordinateRow.addToRow(startCoords);
		
		endCoordinate = in.next();
		endCoords=new Coordinate();
		Scanner endCoordinatesScanner = new Scanner(endCoordinate);
		endCoords.xCoord=endCoordinatesScanner.nextInt();
		endCoords.yCoord=endCoordinatesScanner.nextInt();
		
		wallCoordinates = in.next();
		Scanner wallScanner=new Scanner(wallCoordinates);
		while (wallScanner.hasNext()){
			wallScanner.useDelimiter("\n");
			Scanner coordinateScanner = new Scanner (wallScanner.next());
			Coordinate wallCoordinate = new Coordinate();
			wallCoordinate.xCoord = coordinateScanner.nextInt();
			wallCoordinate.yCoord = coordinateScanner.nextInt();
			wallsCoordinateRow.addToRow(wallCoordinate);
		}
		printInitialConditions();
	}
	
	void printInitialConditions(){
		ui.encircle(endCoords.xCoord, endCoords.yCoord);
		ui.place(startCoords.xCoord, startCoords.yCoord, ui.PATH);
		
		for (int i=0; i<wallsCoordinateRow.numberOfElements;i++){
			ui.place(wallsCoordinateRow.coordinates[i].xCoord, wallsCoordinateRow.coordinates[i].yCoord, ui.WALL);
		}
		
		ui.showChanges();
		ui.wait(2500);
	}
	
	boolean checkForWall(int nextX, int nextY){
		boolean flag = false;
		for (int i = 0; i < wallsCoordinateRow.numberOfElements; i++){
			if (nextX == wallsCoordinateRow.coordinates[i].xCoord && nextY == wallsCoordinateRow.coordinates[i].yCoord){
				flag = true;
			}
		}
		return flag;
	}
	
	boolean checkForPath(int nextX, int nextY){
		boolean flag = false;
		for (int i=0; i < pathCoordinateRow.numberOfElements; i++){
			if (nextX == pathCoordinateRow.coordinates[i].xCoord && nextY == pathCoordinateRow.coordinates[i].yCoord){
				flag = true;
			}
		}
		return flag;
	}
	
	boolean checkEnd(int nextX, int nextY){
		boolean flag = false;
		if (nextX == endCoords.xCoord && nextY == endCoords.yCoord){
			flag = true;
			comparePath(nextX, nextY);
		}
		return flag;
	}
	
	void comparePath(int nextX, int nextY){
		if (pathCoordinateRow.numberOfElements > longestPathToEnd.numberOfElements){
			longestPathToEnd.numberOfElements = 0;
			for (int i = 0; i < pathCoordinateRow.numberOfElements; i++){
				longestPathToEnd.coordinates[i] = pathCoordinateRow.coordinates[i];
				longestPathToEnd.numberOfElements++;
			}
			Coordinate lastCoordinate = new Coordinate();
			lastCoordinate.xCoord = nextX;
			lastCoordinate.yCoord = nextY;
			longestPathToEnd.addToRow(lastCoordinate);
			
			ui.printf("So far the longest path has a length of: %d\n", longestPathToEnd.numberOfElements);
		}
		
	}
	
	boolean check(int nextX, int nextY){
		int flag = 0;

		if (checkForWall(nextX, nextY)){
			flag++;
		}
		if (checkForPath(nextX, nextY)){
			flag++;
		}
		if (checkEnd(nextX, nextY)){
			flag++;
		}
		if (flag > 0){
			return true;
		}else{
			return false;
		}
	}
	
	void goRight (Coordinate newCoordinate){
		if (check(pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].xCoord+1, pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].yCoord) == false){ //check east
			newCoordinate.xCoord = pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].xCoord+1;
			newCoordinate.yCoord = pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].yCoord;
			pathCoordinateRow.addToRow(newCoordinate);
			
			ui.place(newCoordinate.xCoord, newCoordinate.yCoord, ui.PATH);
			ui.showChanges();
			
			runMaze();	
			unmarkPath();
		}
	}
	
	void goDown(Coordinate newCoordinate){
		if (check(pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].xCoord, pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].yCoord+1) == false){
			newCoordinate.xCoord = pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].xCoord;
			newCoordinate.yCoord = pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].yCoord+1;
			pathCoordinateRow.addToRow(newCoordinate);
			
			ui.place(newCoordinate.xCoord, newCoordinate.yCoord, ui.PATH);
			ui.showChanges();
			
			runMaze();
			unmarkPath();
		}
	}
	
	void goLeft(Coordinate newCoordinate){
		if (check(pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].xCoord-1, pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].yCoord) == false){
			newCoordinate.xCoord = pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].xCoord-1;
			newCoordinate.yCoord = pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].yCoord;
			pathCoordinateRow.addToRow(newCoordinate);
			
			ui.place(newCoordinate.xCoord, newCoordinate.yCoord, ui.PATH);
			ui.showChanges();
			
			runMaze();
			unmarkPath();
		}
	}
	
	void goUp(Coordinate newCoordinate){
		if (check(pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].xCoord, pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].yCoord-1) == false){
			newCoordinate.xCoord = pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].xCoord;
			newCoordinate.yCoord = pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].yCoord-1;
			pathCoordinateRow.addToRow(newCoordinate);
			
			ui.place(newCoordinate.xCoord, newCoordinate.yCoord, ui.PATH);
			ui.showChanges();
			
			runMaze();
			unmarkPath();
		}
	}
	
	void unmarkPath(){
		ui.place(pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].xCoord, pathCoordinateRow.coordinates[pathCoordinateRow.numberOfElements-1].yCoord, ui.EMPTY);
		pathCoordinateRow.remove(pathCoordinateRow.numberOfElements-1);
	}
	
	void runMaze() { //recursive method
		Coordinate newCoordinate=new Coordinate();
		ui.wait(SPEED);
		
		goRight(newCoordinate);
		
		goDown(newCoordinate);
		
		goLeft(newCoordinate);
		
		goUp(newCoordinate);
		
	}
	
	void printLongestPath(){
		ui.printf("Longest path is the following one with a length of : %d", longestPathToEnd.numberOfElements);
		for (int i = 0; i < longestPathToEnd.numberOfElements; i++){
			ui.place(longestPathToEnd.coordinates[i].xCoord, longestPathToEnd.coordinates[i].yCoord, ui.PATH);
			ui.showChanges();
			ui.wait(70);
		}
	}
	
	void start(){
		readInput();
		
		runMaze();
		
		printLongestPath();
	}
	
	public static void main(String[] args) {
		new LongestPath().start();
	}
}
