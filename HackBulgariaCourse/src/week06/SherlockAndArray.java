package week06;

import java.util.Scanner;

public class SherlockAndArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int[] nums;
		int n=sc.nextInt();
		for (int i = 0; i < n; i++) {
			int m=sc.nextInt();
			nums=new int[m];
			for(int s=0;s<m;s++){				
			 nums[s]=sc.nextInt();				
			}
			if(check(nums)){
				System.out.println("yes");
			}
			else{
				System.out.println("No");
			}
			
		}
		sc.close();
	}
	
	public static boolean check(int[] nums){
		boolean isEqual=false;
		for (int i = 0; i < nums.length; i++) {
			int sumLeft=0;
			int sumRight=0;
			for(int c=i;c>=0;c--){
				sumLeft+=nums[c];
			}
			for(int c=i;c<nums.length;c++){
				sumRight+=nums[c];
			}
			if(sumLeft==sumRight){
				isEqual=true;
			}
			
		}
		return isEqual;
	}

}
