package week1;

public class HackNumber {

	public static void main(String[] args) {
		System.out.println(isHack(20));
		System.out.println(nextHack(20));
		
	}
		
		public static boolean isHack(int number) {
	        int palindrome =number; // copied number into variable
	        int reverse = 0;
	        String i=Integer.toBinaryString(number);
			char o='1';
			int occ=0;
				

	        while (palindrome != 0) {
	            int remainder = palindrome % 10;
	            reverse = reverse * 10 + remainder;
	            palindrome = palindrome / 10;
	        }

	        for(int s=0;s<i.length();s++){	
				
				
				if(i.charAt(s)==o)
					occ++;			
				}
	        if (number == reverse && occ!=0 ) {  	
	        	
	            return true;
	        }
	        return false;
	    }
		
		public static int nextHack(int number){
			
			do{
				
			if(isHack(number)){
				number++;			
			//System.out.println(number);				
				break;
			}
			else number++;
		}while(isHack(number)!=false);
			
			return number;
			
	}

	
}


