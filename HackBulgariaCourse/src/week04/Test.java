package week04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
	MyBST<Integer> tree=new MyBST<Integer>();
	List<Integer> list=new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14));
	
	tree.build(list);
	tree.print();

	}
}
