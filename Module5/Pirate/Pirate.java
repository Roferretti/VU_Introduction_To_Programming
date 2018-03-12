package Pirate;
import java.io.PrintStream;
import java.util.Scanner;
import ui.UIAuxiliaryMethods;

public class Pirate {
    Scanner in;
    PrintStream out;
    String[] rows = new String[5];
    CoordinateRow coordinateRowResult = new CoordinateRow();

    Pirate() {
        in = UIAuxiliaryMethods.askUserForInput().getScanner();
        out = new PrintStream(System.out);
    }

    void readRows() {
        in.useDelimiter("=");
        int i = 0;

        while (in.hasNext()) {
            rows[i] = in.next();
            //out.printf("\nThe #%d row is:\t%s\n", i, rows[i]);
            i++;
        }
    }

    void makeRowAndAdd() {
        CoordinateRow[] coordinateRows = new CoordinateRow[5]; //This section read all String of rows and assign to a CoordinateRow obj.

        CoordinateRow firstRow = new CoordinateRow();
        firstRow = assignRow(rows[0]);
        coordinateRows[0] = firstRow;

        CoordinateRow secondRow = new CoordinateRow();
        secondRow= assignRow(rows[1]);
        coordinateRows[1] = secondRow;

        CoordinateRow thirdRow = new CoordinateRow();
        thirdRow = assignRow(rows[2]);
        coordinateRows[2] = thirdRow;

        CoordinateRow fourthRow = new CoordinateRow();
        fourthRow = assignRow(rows[3]);
        coordinateRows[3] = fourthRow;

        CoordinateRow fifthRow = new CoordinateRow();
        fifthRow = assignRow(rows[4]);
        coordinateRows[4] = fifthRow;

        
        
        for (int i = 0; i < coordinateRows.length; i++) {  //This section adds the CoordinateRows (objects) to their correspondent part.
            if (i == 0) {
// 				add first row to to the array
                coordinateRowResult.addCordinateRowInBack(coordinateRows[i].coordinates);
                
            } else if (i % 2 == 0) {
// 				add 3rd and 5th to the row in the front
 				coordinateRowResult.addCordinateRowInFront(coordinateRows[i].coordinates);
 				
            } else {
//				add 2nd and 4th row to the back.
				coordinateRowResult.addCordinateRowInBack(coordinateRows[i].coordinates);
            }
        }
    }

    CoordinateRow assignRow(String row) {
        CoordinateRow currentRow = new CoordinateRow();

        Scanner rowScanner = new Scanner(row); 
        String coordSet = "";
        int cX, cY;

        while (rowScanner.hasNext()) {
            Coordinate currentCoordinateSet = new Coordinate();
            coordSet = rowScanner.next(); 

            Scanner coordScanner = new Scanner(coordSet);
            coordScanner.useDelimiter(",");
            cX = Integer.parseInt(coordScanner.next()); //out.printf("\nThe x coord is: %d\n", cX);
            cY = Integer.parseInt(coordScanner.next()); //out.printf("\nThe y coord is: %d\n", cY);

            currentCoordinateSet.x = cX; //store coordinate x into currentCoordinateSet object
            currentCoordinateSet.y = cY;  //store coordinate y into currentCoordinateSet object

            currentRow.addCoordinate(currentCoordinateSet);
        }
        return currentRow;
    }
    
    void print(){
    	for(int i = 0; i < coordinateRowResult.countElements; i++){
 			System.out.printf("%d,%d\n", coordinateRowResult.coordinates[i].x +1, coordinateRowResult.coordinates[i].y );
 		}
    }

    public static void main(String[] args) {
        new Pirate().start();
    }

    void start() {

        readRows();

        makeRowAndAdd();
        
        print();

    }
}
