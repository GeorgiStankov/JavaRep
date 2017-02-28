import java.util.Scanner;
import java.util.Stack;

public class Problem3 {

	public static void main(String[] args) {

		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> maxStack=new Stack<Integer>();
		int max =Integer.MIN_VALUE;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		

		for (int i = 0; i < n; i++) {
			byte x = sc.nextByte();
			if (x == 1) {
				int c = sc.nextInt();
				stack.push(c);
				if(max<=c){
					max=c;
					maxStack.push(max);
				}
				
			} else if (x == 2) {
				int poppedItem=	stack.pop();
				if(poppedItem==max){
					maxStack.pop();
					if(maxStack.size()>0){
						max=maxStack.peek();
					}
					else{
						max=Integer.MIN_VALUE;
					}
					
				}
				
			} else if (x == 3) {
				
				
				System.out.println(max);
			}

		}

		// for (int i = 0; i < n; i++) {
		// byte x = sc.nextByte();
		// switch (x) {
		// case 1:
		// int c = sc.nextInt();
		// stack.push(c);
		// break;
		// case 2:
		// stack.pop();
		// break;
		// case 3:{
		// int biggest = -100000;
		// for (int item : stack) {
		// if (item > biggest) {
		// biggest = item;
		// }
		// }
		// System.out.println(biggest);
		// break;
		// }
		//
		// default : break;
		// }
		//
		//
		// }
		sc.close();
	}
}
