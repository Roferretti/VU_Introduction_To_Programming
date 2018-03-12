package BodyMassIndex;

public class person {
	String name, lastname, sex;
	int weight;
	double length, bMI;
	
	person(){
		String name, lastname = ""; 
		String sex = ""; 
		double length = 0.;
		int weight = 0;
		double bMI = 0.;
	}
	
	double BodyMassIndex(){
		return (weight/(length*length));
	}
}
