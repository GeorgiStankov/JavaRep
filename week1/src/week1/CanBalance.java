package week1;

import java.util.Arrays;

public class CanBalance {

	public static void main(String[] args) {
        int[] test = { 1,1,1,2,1};
        System.out.println("\nFinal result is "+canBalance(test)+Arrays.toString(test));
        for(int i=0;i<test.length;i++){
        	//System.out.println(test[i]);
        }
        
    }

    public static boolean canBalance(int[] nums) {
    	int total=0;
        for(int number : nums){
        	total +=number;
        }
        if(total%2!=0)
        	return false;
        
        else {
        	total/=2;
        }
        return isTotal(nums,nums.length,total);
    }
public static boolean isTotal(int[] nums,int n,int total){
	System.out.println("total"+total);
	if(total==0){
		return true;
	}
	if(total%2!=0 && n==0){
		return false;
	}
	if (nums[n - 1] > total)
        return isTotal(nums, n - 1, total);
	

    //check if total can be obtained excluding the last element or including the last element 
    return isTotal(nums, n - 1, total - nums[n - 1]) || isTotal(nums, n - 1, total); 

	

}
}
