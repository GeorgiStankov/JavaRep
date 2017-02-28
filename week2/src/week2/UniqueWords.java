package week2;

import java.util.Arrays;
import java.util.Vector;

public class UniqueWords {

	public static void main(String[] args) {
	
		String[] arr={"apple", "banana", "apple", "pie"};

		System.out.println(uniqueWordsCount(arr));
	}

	public static int uniqueWordsCount(String[] a){
		Vector<String> words=new Vector<String>();
		
		for(int i=0;i<a.length;i++){
			
			if(!(words.contains(a[i]))) words.add(a[i]);
			
		}
		return words.size();
	}
}
