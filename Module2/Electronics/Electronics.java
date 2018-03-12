/* The electrics company ‘The Battered Battery’ is nearly bankrupt. To avoid total
disaster, the marketing branch has come up with a special sale to attract more
customers. Whenever a customer buys three products, he or she receives a 15%
reduction on the most expensive product. Write a program that takes the prices
of three products as input and prints the discount and final price as output.
Example Determine the reduction and final price if the three products cost
e200, e50 and e25 respectively. 1st: 200, 2nd: 50, 3rd:25, discount:30, total: 245.00*/
package Electronics;
import java.io.PrintStream;
import java.util.Scanner;

public class Electronics {
	PrintStream out;
	Scanner in;
	double firstArticle, secondArticle, thirdArticle, discount, highestNumber; 
	
	Electronics(){
		out = new PrintStream(System.out);
	}
	void start () {
		in = new Scanner(System.in);
		
		out.printf("Enter the number of the first article: ");
		firstArticle= in.nextDouble();
		
		out.printf("Enter the number of the second article: ");
		secondArticle = in.nextDouble();
		
		out.printf("Enter the number of the third article: ");
		thirdArticle = in.nextDouble();
		
		if (firstArticle >= secondArticle){
			if (firstArticle >= thirdArticle){
				highestNumber = firstArticle;
			}else{
				highestNumber = thirdArticle;
			}
		}else{
			if (secondArticle >= thirdArticle){
				highestNumber = secondArticle;
			}else {
				highestNumber = thirdArticle;
			}
		}

		out.printf("Discount: %.2f\n", discount = highestNumber * .15);
		out.printf("Total amount to pay is: %.2f", firstArticle + secondArticle + thirdArticle - discount);
	}
	
	public static void main(String[] args) {
		new Electronics().start();
	}
}