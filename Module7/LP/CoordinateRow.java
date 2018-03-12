package LP;



public class CoordinateRow {

	Coordinate[] array;
	int count;
	
	CoordinateRow(){
		array = new Coordinate[32*24];
		count=0;
	}
	
	void add(Coordinate c){
		array[count]=c;
		count++;
	}
	
	void delete(int index){
		array[index]=null;
		count--;
	}
	
	
	
}
