import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Stack;

public class Problem9 {

	public static void main(String[] args) {

		ArrayDeque<Character> array = new ArrayDeque<Character>();
		Stack<Character> stack = new Stack<Character>();
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			if (x == 1) {
				String str = sc.nextLine();
				for (char c : str.toCharArray()) {
					array.add(c);					
				}
			}
			else if (x == 2) {
				short c = sc.nextShort();
				for (int s = 0; s < c; s++) {
					stack.push(array.pollLast());
					
				}
				System.out.println("OK");
			}
			else if(x==3){
				short c = sc.nextShort();
				System.out.println(stack.elementAt(c));				
			}
			else if(x==4){
				
			}
		}
		
	}

}
