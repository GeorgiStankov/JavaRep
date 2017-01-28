package week04;

public class ClassEx {

	

	public static void main(String[] args) {
	    int[] arr = {1,5,8,10,0,5};
//		for (int i = 0; i < arr.length; i++) {
//			arr[i] = i;
//		}
      System.out.println(sum(arr,4));
	}

	public static int sum(int[] arr,int index) {
		int sum = 1;
		for (int i = 0; i < arr.length; i++) {
			if (i == index) {
           continue;
			} else {
				sum *= arr[i];
			}

		}
		return sum;
	}

}
