package week1;

import java.util.Scanner;

public class RaisingAnInteger {

	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Enter an integer");
		int a=input.nextInt();
		System.out.println("Enter degree");
		int b=input.nextInt();
		pow(a,b);

	}
	public static long pow(int a, int b){
		long s=0;
		if(a>0 && b>0){
			s=(long) Math.pow(a, b);
			
		}
		if(a<0){
			return 0;
		}
		if(b==-1){
			return 1;
		}
		System.out.println(s);
		return s;
	}

}
