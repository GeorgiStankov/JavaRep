package week1;

public class OddnumberArray {

	public static void main(String[] args) {
		int[] array={1,2,2,1,3,4,3,4,4,6,5,6,5};
		int c=8^20;
		System.out.println(c);

		getOddOccurrence(array);
	}
	public static int getOddOccurrence(int[] array){
		int s=0;
		
		for (int i=0; i < array.length; i++) {
	        s = s^array[i];
		}
		System.out.println(s);
		return s;
	}

}
