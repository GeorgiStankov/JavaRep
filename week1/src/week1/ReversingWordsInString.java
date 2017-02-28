package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversingWordsInString {

	/*public static void main(String[] args) {
	String abc="Gosho utre ima PIK";
	System.out.println(reverseString(abc));

	}
	public static String reverseString(String ab){
		StringBuilder revStr = new StringBuilder("");
	    int end = ab.length(); // substring takes the end index -1
	    int counter = ab.length()-1;
	    for (int i = ab.length()-1; i >= 0; i--) {     
	        if (ab.charAt(i) == ' ' || i == 0) {
	            if (i != 0) {
	                revStr.append(ab.substring(i+1, end));
	                revStr.append(" ");
	            }
	            else {
	                revStr.append(ab.substring(i,end));
	            }
	            end = counter;
	        }
	        counter--;
	    }
	    System.out.println(revStr);
	    return revStr.toString();
	}*/
	public static void main(String[] args) {
        String input="";
        System.out.println("Enter the input string");
        try
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            input = br.readLine();
            char[] try1= input.toCharArray();
            for (int i=try1.length-1;i>=0;i--)
            System.out.print(try1[i]);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
	}
}


