package week04;

import java.util.Stack;

public class SetOfStacks {

	static Stack<Stack<Integer>> set = new Stack<Stack<Integer>>();
	static Stack<Integer> singleStack=new Stack<>();
	static Stack<Integer> popStack=new Stack<>();

	public static void main(String[] args) {

		add(5);
		add(6);
		add(7);
		add(8);
		add(9);
		add(10);
		add(11);
	   System.out.println(show());
	   System.out.println(show());
	  System.out.println(show());
	   System.out.println(show());
	   System.out.println(show());
	   System.out.println(show());
	   System.out.println(show());
	   
	}

	public static void add(int element) {
		if (singleStack.size() > 4 || singleStack.size()==0) {			
			singleStack = new Stack<Integer>();
			set.push(singleStack);
		}		
		
		(set.peek()).push(Integer.valueOf(element));
		
	}
	public static int show(){
	      if(popStack.size()==0){
	    	  popStack=set.pop();
	      }
		
		return popStack.pop();
	}

}
