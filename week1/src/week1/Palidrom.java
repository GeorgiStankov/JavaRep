package week1;

public class Palidrom {

	public static void main(String[] args) {
		int c=5000;
		for(int i=0;i<c;--c){
			
			if(isPalindrome(c)){
				break;
			}
		}
    
	}
	public static boolean isPalindrome(int number) {
        int palindrome = number; // copied number into variable
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        
        if (number== reverse) {
        	System.out.println(number);
            return true;
        }
        return false;
    }

}




