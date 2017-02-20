import java.util.Scanner;
import java.util.Stack;

public class Problem1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Stack<Integer> nums = new Stack<Integer>();
		sc = new Scanner(sc.nextLine());

		while (sc.hasNext()) {
			nums.push(sc.nextInt());
		}
		System.out.println(nums);
		int size = nums.size();
		for (int i = 0; i < size; i++) {
			System.out.print(nums.pop() + " ");
		}

		sc.close();
		

	}

}
