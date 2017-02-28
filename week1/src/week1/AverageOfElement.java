package week1;

import java.util.Scanner;

public class AverageOfElement {

	public static void main(String[] args) {
		
		int[] array = new int[5];
		int size;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter 5 numbers");
		for(int i=0;i<array.length;i++){
			array[i]=input.nextInt();
		}
		size=array.length;
		System.out.println(size);
		System.out.println(average(array));

	}
	public static int average(int[] array){
		int a=0;
		for(int i=0;i<array.length;i++){
			a=a+array[i];
			
		}
		System.out.println(a);
		//a=(array[0]+array.length)/2;
		return a/array.length;
	}
	

}
