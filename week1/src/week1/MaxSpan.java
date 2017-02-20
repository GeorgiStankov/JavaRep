package week1;



public class MaxSpan {

	public static void main(String[] args) {
		int[] array={1,2,3,4,5,6,6,11,123,2};
		int size=array.length;
		int sum=0;
		for(int i=1;i<size-1;i++){
			sum+=array[i];	
			
		}
		System.out.println(sum);
		//System.out.println(sum-array[size-1]);
		
	}

}
