import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int x = sc.nextInt();

		for (int i = 0; i < n; i++) {
			queue.add(sc.nextInt());
		}
		for (int i = 0; i < s; i++) {
			queue.poll();
		}
		if(queue.isEmpty()){
			System.out.println("0");
		}
		else if (queue.contains(x)) {
			System.out.println("true");
		} else {
			int smallest = 1000000;
			for (int item : queue) {
				if (item < smallest) {
					smallest = item;
				}
			}
			System.out.println(smallest);

		}
		sc.close();
	}

}
