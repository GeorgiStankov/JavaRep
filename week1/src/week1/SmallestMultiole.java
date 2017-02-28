package week1;



public class SmallestMultiole {

	public static void main(String[] args) {
		
		int upperBound[] = { 1,-8,2,5,-3,0,6,1,9};
		
		
		getSmallestMultiple(upperBound);
		
	}
	
	public static long getSmallestMultiple(int[] upperBound){
		
		int upperBound1[]=new int[10];
		
		int min = Integer.MAX_VALUE;
		boolean max_val_present = false; 
		for(int i=1;i<upperBound.length;i++){
    			if(upperBound[i]>0){
    				int c=0;
    				upperBound1[c]=upperBound[i];
    			}
    			
		}
				
			System.out.println(upperBound1);
				
			for(int s=1;s<upperBound.length;s++){
				
				
				if(min > upperBound[s] && upperBound[s] > 0)
			         min=upperBound[s];
			      
					max_val_present=true;
		}
			
			System.out.println("////"+min);
			
		
		return min;
	}

}
