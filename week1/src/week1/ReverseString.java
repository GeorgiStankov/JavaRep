package week1;

public class ReverseString {

	public static void main(String[] args) {
		String abc="Gosho";
		System.out.println(reverse(abc));
		
	}
	public static String reverse(String source) {
	    int i, len = source.length();
	    StringBuilder dest = new StringBuilder(len);

	    for (i = (len - 1); i >= 0; i--){
	        dest.append(source.charAt(i));
	    }

	    return dest.toString();
	}

}
