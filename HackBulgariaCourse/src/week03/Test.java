package week03;

public class Test {

	public static void main(String[] args) {
		MyLinkedList list=new MyLinkedList();
	//	MyLinkedList list1=new MyLinkedList();
		


		list.addFirst(5);
		list.addLast(3);
		list.addLast(2);
		list.addLast(2);
		list.addLast(3);
		list.addLast(5);
	
		
	
		//list.remove(1);
		System.out.println(list);
		System.out.println(list.get(2));
	//   list.partition(5);
	  //  System.out.println(list);
	    System.out.println(list.isPalidrom());

	}

}
