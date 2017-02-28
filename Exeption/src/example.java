import java.util.Scanner;
import java.lang.ArithmeticException;

public class example {

	public static void main(String[] args) {
		try{
			Scanner scan=new Scanner(System.in);
			System.out.println("enter first number");
			int a= scan.nextInt();
			Scanner scan2=new Scanner(System.in);		
			System.out.println("enter second number");
			int b= scan.nextInt();
		umnojenie(a,b);
		}
		catch(ArithmeticException e){
			e.printStackTrace();	
		

	}
		finally{
			System.out.println("the code is correct");
		}
			
	}
	
	public static void umnojenie(int a,int b){
		
		int c=(a/b);
		System.out.println(c);
		
	}

}
