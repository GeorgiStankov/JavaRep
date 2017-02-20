package week1;

import java.util.Scanner;

public class DoubleFactorial {

	
	public static void main(String[] args) {
		
		
		Scanner input=new Scanner(System.in);
		System.out.println("Enter a numbers");
			int s=input.nextInt();
			factorial(s);

	}
	public static int factorial(int s){
		
		int p=1,k=1;
		for(int i =1;i<=s;i++){
			
			
		 p=p*i;		 	 
		}
		System.out.println(p);
		for(int i =1;i<=p;i++){
			
			k=k*i;
			
		}
		System.out.println(k);
		return s;
	}

}
