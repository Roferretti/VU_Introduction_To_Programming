package LongestPath;

public class CoordinateRow {

	Coordinate[] coordinates;
	int numberOfElements;
	
	CoordinateRow(){
		coordinates = new Coordinate[768];
		numberOfElements = 0;
	}
	
	void addToRow(Coordinate c){
		coordinates[numberOfElements] = c;
		numberOfElements++;
	}
	
	void remove(int i){
		coordinates[i] = null;
		numberOfElements--;
	}
	
}
