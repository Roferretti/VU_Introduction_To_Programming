package BodyMassIndex;
import java.io.PrintStream;
import java.util.Scanner;

public class BodyMassIndex2 {
	PrintStream out;
	Scanner in;
	person Person1, Person2;
	
	BodyMassIndex2(){
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
		
	}

	person getPerson(){
		person Person = new person();
		
		
		out.println("Write name: ");
		Person.name = in.next();//nextLine
		
		out.println("Write last name: "); //delete this paragraph
		Person.lastname = in.next();
		
		out.println("Write sex: ");
		Person.sex = in.next();
		
		out.println("Write length: ");
		Person.length = in.nextDouble();
		
		out.println("Write weight: ");
		Person.weight = in.nextInt();
		
		Person.bMI = Person.BodyMassIndex(); //out.printf("%.2f\n", Person.bMI);
		
		return Person;
	}
	
	void printBMI(person person){
		if (person.sex.equals("m") || person.sex.equals("M")){
			out.printf("\nMr." + person.lastname +"'s BMI is: %.2f and is ", person.bMI);
			if (person.bMI >= 18.5 && person.bMI <=25){
				out.printf("healthy.\n");
			}else{
				out.printf("unhealthy.\n");
			}
		}else{
			out.printf("\nMrs." + person.lastname +"'s BMI is: %.2f and is ", person.bMI);
			if (person.bMI >= 18.5 && person.bMI <=25){
				out.printf("healthy\n");
			}else{
				out.printf("unhealthy\n");
			}
		}
		
	}
	
	public static void main(String[] args) {
		new BodyMassIndex2().start();
	}

	void start(){
		
		out.printf("Write the first person.\n");
		Person1 = getPerson();
		
		out.printf("Write the second person.\n");
		Person2 = getPerson();
	
		printBMI(Person1);
		printBMI(Person2);
		
	}
}
//out.printf("%.2f\n", Person1.BodyMassIndex());