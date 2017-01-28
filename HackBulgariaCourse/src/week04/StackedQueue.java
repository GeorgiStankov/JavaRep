package week04;

import java.util.Stack;

public class StackedQueue {
	static Stack<Integer> input = new Stack<Integer>();
	static Stack<Integer> output = new Stack<Integer>();

	public static void main(String[] args) {

		adding(5);
		adding(4);
		adding(3);
		System.out.println(printing());
		System.out.println(printing());
		System.out.println(printing());

	}

	public static void adding(int element) {
		input.add(element);
	}

	public static int printing() {

		while (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}

		return output.pop();
	}

}
