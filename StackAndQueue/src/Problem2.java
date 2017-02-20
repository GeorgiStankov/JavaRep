import java.util.Scanner;
import java.util.Stack;

public class Problem2 {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int s = sc.nextInt();
		int x = sc.nextInt();

		for (int i = 0; i < n; i++) {
			stack.push(sc.nextInt());
		}
		for (int i = 0; i < s; i++) {
			stack.pop();
		}
		if (stack.isEmpty()) {
			System.out.println("0");
		} else if (stack.contains(x)) {
			System.out.println("true");
		} else {
			int smallest = 1000000;
			for (int item : stack) {
				if (item < smallest) {
					smallest = item;
				}
			}
			System.out.println(smallest);
		}
		sc.close();
	}

}
