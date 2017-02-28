package week2;

import java.util.Scanner;

public class IncreasinAndDecreasingSequences {

	public static void main(String[] args) {
		System.out.print("Enter size of array");
		Scanner sscan=new Scanner(System.in);
		int n=sscan.nextInt();
		int[] sequence=new int[n];
		for(int i=0;i<sequence.length;i++){
			Scanner scan=new Scanner(System.in);
			sequence[i]=scan.nextInt();
		}
			System.out.println(isIncreasing(sequence));
		
	}
	

public static boolean isDecreasing(int[] sequence) {

	for (int i = 1; i < sequence.length; i++) {
		if (sequence[i] > sequence[i - 1])
			return false;
	}

	return true;
}

public static boolean isIncreasing(int[] sequence) {

	for (int i = 1; i < sequence.length; i++) {
		if (sequence[i] < sequence[i - 1])
			return false;
	}

	return true;
}



}
