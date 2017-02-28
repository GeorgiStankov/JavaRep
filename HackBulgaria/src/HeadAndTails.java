import java.util.Scanner;

public class HeadAndTails {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String[] input = scan.nextLine().replaceAll("\\s+", "").split(",");
		int temp = 0, c = 0;
		String winner="";
		for (int i = 0; i < input.length-1; i++) {
			if (input[i].equals(input[i+1])) {
				c++;
			} 
			else c=0;
			if(temp<=c){
				if(temp==c) winner="Draw!";
				else{
				temp=c;
				winner=input[i]+" wins!";
				}
				
			}
			
		}
		System.out.println(winner);
		
		
		scan.close();
	}

}
