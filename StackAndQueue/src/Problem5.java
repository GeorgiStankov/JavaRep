import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {

		ArrayDeque<Long> array = new ArrayDeque<Long>();
		Scanner sc = new Scanner(System.in);
		Long n = sc.nextLong();
		array.addFirst(n);

		for (int i = 0; i < 50; i++) {

			Long curr = array.removeFirst();
			System.out.printf("%d ",curr);
			
			long s1=curr+1;
			long s2=2*curr+1;
			long s3=curr+2;
			
			array.addLast(s1);
			array.addLast(s2);
			array.addLast(s3);

		}
		sc.close();
	}
	

}
