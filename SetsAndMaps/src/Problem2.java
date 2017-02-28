import java.util.LinkedHashSet;
import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {

		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		LinkedHashSet<Integer> set2 = new LinkedHashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		String[] pair = sc.nextLine().split(" ");
		int n = Integer.parseInt(pair[0]);
		int m = Integer.parseInt(pair[1]);

		for (int i = 0; i < n; i++) {
			set.add(sc.nextInt());

		}
		for (int i = 0; i < m; i++) {
			set2.add(sc.nextInt());

		}
		for(int item:set){
			if(set2.contains(item)){
				System.out.println(item);
			}
		}

		sc.close();
	}

}
