package Numbers;

public class Numbers {
	boolean flag = false;

	void print(int number){
		
		if (number == 1){
			flag = true;
			System.out.print(1 + " ");
		}else if (number == 11){
			return;
		}
		
		
		System.out.print(number + " ");

		
		if(flag == false){
			print(number-1);
		}else{
			print(number+1);
		}
	}
	
	void start() {
		int number = 10;
		print(number);
	}

	public static void main(String[] args) {
		new Numbers().start();

	}

}
