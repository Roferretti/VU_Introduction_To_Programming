package BodyMassIndex;
import java.io.PrintStream;
import java.util.Scanner;
import ui.UIAuxiliaryMethods;

public class BodyMassIndex {
	PrintStream out;
	Scanner in;
	person [] persons;
	
	BodyMassIndex(){
		out = new PrintStream(System.out);
		in = UIAuxiliaryMethods.askUserForInput().getScanner();
	}

	person getPerson(String line){
		Scanner lineScanner = new Scanner (line);
		person Person = new person();
		
		Person.name = lineScanner.next();
		Person.lastname = lineScanner.next();
		Person.sex = lineScanner.next();
		Person.length = lineScanner.nextDouble();
		Person.weight = lineScanner.nextInt();

		Person.bMI = Person.BodyMassIndex(); 
		return Person;
	}
	
	void printBMI(person person){
		if (person.sex.equals("m") || person.sex.equals("M")){
			out.printf("\nMr." + person.lastname +"'s BMI is %.1f and is ", person.bMI);
			if (person.bMI >= 18.5 && person.bMI <=25){
				out.printf("healthy.\n");
			}else{
				out.printf("unhealthy.\n");
			}
		}else{
			out.printf("\nMrs." + person.lastname +"'s BMI is %.1f and is ", person.bMI);
			if (person.bMI >= 18.5 && person.bMI <=25){
				out.printf("healthy.\n");
			}else{
				out.printf("unhealthy.\n");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new BodyMassIndex().start();
	}

	void start(){
		
		persons = new person [2];
		
		int i=0;
		while (in.hasNextLine()){
			String line = in.nextLine();
			persons[i] = getPerson(line);
			i++;
		}
		printBMI(persons[0]);
		printBMI(persons[1]);
		
	}
}
