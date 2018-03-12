/*During a game of Othello the time a player spends thinking about his moves
is recorded. Write a program that takes the total time that two players have
thought, one human, one computer, in milliseconds as input. The program
determines which of the two players is human and prints the thinking time
of the human in the following format: hh:mm:ss. It may be assumed that a
computer does not require more than a thousand milliseconds to contemplate
its moves. e.g. black player thought: 234432, white: 46, time spent black thinking: 00:03:54 */
package Othello2;
import java.io.PrintStream;
import java.util.Scanner;

public class Othello2 {
	double whitePlayerNumber, blackPlayerNumber, humanPlayer;
	double hours, hoursFinal, hoursWithoutInteger, minutes, minutesWithoutInteger, minutesFinal, seconds, secondsFinal;
	PrintStream out;
	Scanner in;
	
	Othello2(){
		out = new PrintStream(System.out);
		in = new Scanner(System.in);
	}
	void start () {
		out.printf("Write number of miliseconds the black player thought: ");
		blackPlayerNumber = in.nextDouble();
		
		out.printf("Write numyber of miliseconds the white player thought: ");
		whitePlayerNumber = in.nextDouble();
	
		if (blackPlayerNumber > 1000){
			humanPlayer = blackPlayerNumber;
		}else {
			humanPlayer = whitePlayerNumber;
		}	
		
		hours = (humanPlayer / 3600000 ); //convert milliseconds to hours
		hoursFinal = (int) hours; //remove decimal part to get final result of hours
			
		hoursWithoutInteger = hours - (int)hours; //remove integer from hours (to translate remainder into minutes)
		minutes = (hoursWithoutInteger * 60); //translate remaining time into minutes
		minutesFinal = (int) minutes; // remove decimal part to get final result of minutes
			
		minutesWithoutInteger = minutes - (int)minutes; //remove integer from minutes (to translate remainder into seconds)
		seconds = (minutesWithoutInteger * 60);//translate remaining time into seconds
		secondsFinal = (int) seconds; //remove decimal part to get final result of seconds
		
			
		out.printf("The time the human player has spent thinking is: %02d:%02d:%02d", (int)hoursFinal, (int)minutesFinal, (int)secondsFinal); 
		}
	
	public static void main(String[] args) {
			new Othello2().start();
	}

}

