package week1;

public class StringIsPalidrom {

	public static void main(String[] args) {
		String a="gosho";
		
		System.out.println(isPalindrome(a));
		
		

	}
	public static boolean isPalindrome(String str){
		boolean s=false;
		int size=str.length();
		for(int i=0;i<size/2;i++){
			if(str.charAt(i)!=str.charAt(size-1-i)){
				s=false;
			}
				
			else {
				s=true;
			}
		}
		return s;

}

}