package week1;

public class NumberOfOccurances {

	public static void main(String[] args) {
		String str="dadadaaadadaddadadada";
		
		System.out.println(numberOfOcc("da",str));

	}
	public static int numberOfOcc(String needle,String a){
		int occur=0;
		String word=needle;
		int size=a.length()-1;
		for(int i=0;i<size;i++){
		  if((a.substring(i,i+2)).equals(word))
		 occur++;
		 
		}
		return occur;
	}

}
