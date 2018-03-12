package Pirate;

public class CoordinateRow {
   Coordinate [] coordinates;
	int counter, countElements;

	CoordinateRow(){
		coordinates = new Coordinate[1000];
		counter = 0;
		countElements = 0;
	}
	
	void addCoordinate(Coordinate coordinate){
		coordinates[counter] = coordinate;
		counter++;
	}
	
	void addCordinateRowInFront(Coordinate[] coordinates){
		int countNewElements = 0;
		Coordinate[] newCoordinates = new Coordinate[15];
		
		for(int i = 0; i < coordinates.length; i++){  //put every coordset in a newCoordinate[15] object
			if(coordinates[i] != null){  
				newCoordinates[countNewElements] = coordinates[i];
				++countNewElements;
			}
		}

		for(int i = 0; i < countElements; i++){
				newCoordinates[countNewElements + i] = this.coordinates[i];
		}
		
		this.countElements = this.countElements + countNewElements;
		this.coordinates = newCoordinates;
	}
	
	public void addCordinateRowInBack(Coordinate[] coordinates){
		for(int i = 0; i < coordinates.length; i++){
			if(coordinates[i] != null){  
				this.coordinates[countElements] = coordinates[i];
				countElements++;
			}
		}
	}
}
