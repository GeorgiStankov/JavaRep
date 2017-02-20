import java.util.ArrayDeque;
import java.util.Scanner;

public class Problem7 {

	public static void main(String[] args) {

		ArrayDeque<Character> array = new ArrayDeque<Character>();
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		for (char c : str.toCharArray()) {
			array.add(c);
		}

		boolean s = false;

		for (int i = 0; i < array.size() / 2; i++) {

			if ((array.getFirst() == '{' && array.getLast() == '}')
					|| (array.getFirst() == '[' && array.getLast() == ']')
					|| (array.getFirst() == '(' && array.getLast() == ')')
					|| (array.getFirst() == '}' && array.getLast() == '{')
					|| (array.getFirst() == ']' && array.getLast() == '[')
					|| (array.getFirst() == ')' && array.getLast() == '(') || (array.pollFirst()==array.getFirst())) {
				s = true;
				array.removeFirst();
				array.removeLast();

				continue;
			} else {
				System.out.println("NO");
				s = false;
				break;

			}

		}
		if (s) {
			System.out.println("YES");
		}

		sc.close();
	}

}
