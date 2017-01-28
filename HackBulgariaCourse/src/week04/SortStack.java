package week04;

import java.util.Stack;

public class SortStack {

	static Stack<Integer> input = new Stack<Integer>();
	static Stack<Integer> sorted = new Stack<Integer>();

	public static void main(String[] args) {
		adding(5);
		adding(4);
		adding(6);
		adding(11);
		adding(10);
		adding(7);
		adding(3);
		adding(2);
		show();

	}

	public static void adding(int element) {
		input.add(element);
	}
	public static void remove(){
		input.pop();
	}
	public static void show(){
		sort();
		
		for(Integer item:sorted){
			System.out.println(item);
		}
		
	}
	public static boolean isEmp(){
		return input.isEmpty();
	}
	public static void sort(){
		int size=input.size();
		
		for (int i = 0; i < size; i++) {
			int min=Integer.MAX_VALUE;
			for(Integer item :input){
				if(item<min){
					min=item;
				}
			}
			sorted.push(min);
			input.remove(Integer.valueOf(min));
			
		}
		
	}
}
