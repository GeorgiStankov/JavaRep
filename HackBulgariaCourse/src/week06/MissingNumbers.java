package week06;

import java.util.Scanner;

public class MissingNumbers {

	public static void main(String[] args) {
        int size=10001;
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int A[] = new int[size];
		for (int i = 0; i < n; i++) {			
		   int num=sc.nextInt();
		   A[num]+=1;
		}
		
		int m = sc.nextInt();
		
		for (int i = 0; i < m; i++) {
			int num=sc.nextInt();
			A[num] -=1 ;
			
		}
		for (int i = 0; i < size; i++) {
			if(A[i]<0){
				System.out.print(i+" ");
			}
		}
		
		sc.close();
		
	}
	

}
