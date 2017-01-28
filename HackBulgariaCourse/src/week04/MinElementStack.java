package week04;

import java.util.Stack;

public class MinElementStack {
	static Stack<Integer> input = new Stack<Integer>();
	static Stack<Integer> min = new Stack<Integer>();

	static int minVal = Integer.MAX_VALUE;

	public static void main(String[] args) {
        adding(10);
		adding(5);
		adding(6);
		adding(7);
		adding(8);

		//System.out.println(print());
		System.out.println(min());
		System.out.println(min());
		System.out.println(min());
		System.out.println(min());
		System.out.println(min());

	}

	public static void adding(int element) {
		input.add(element);
		if(element<minVal){
			minVal=element;
			min.push(element);
		}
		else{ min.push(min.peek());
		}

	}

	public static int print() {
		if (input.peek() == minVal) {
			min.pop();
		}
		return input.pop();
	}

	public static int min() {
		return min.pop();
	}

}
