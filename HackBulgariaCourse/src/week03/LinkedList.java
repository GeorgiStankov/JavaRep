package week03;


public class LinkedList<T> implements MyLinkedListInterface<T> {

	private class Node {
		T data;
		Node next;

		public Node(T data,Node next) {
			this.data = data;
			this.next = next;
		}
	}

	Node head;
	int count = 0;

	public LinkedList() {
		head = null;
	}

	@Override
	public void addFirst(T newElement) {
		head = new Node(newElement,head);
		count++;

	}

	@Override
	public void addLast(T newElement) {
		if (head == null) {
			addFirst(newElement);
		} else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new Node(newElement,null);
		}
		count++;

	}

	@Override
	public void add(T newElement, int index) {

		if (head != null) {

			Node temp = head;
			for (int i = 0; i < index; i++) {
				if (temp.next == null) {
					System.out.println("Error");
				}
				temp = temp.next;
			}
			temp = new Node(newElement,temp.next);
		}
		count++;

	}

	@Override
	public T getFirst() {

		return head.data;
	}

	@Override
	public T getLast() {
		Node temp = head;
		while (temp.next != null) {
			temp = temp.next;
		}

		return null;
	}

	@Override
	public T get(int index) {
		Node temp = null;
		if (head != null) {
			temp = head;

			for (int i = 0; i < index; i++) {
				temp = temp.next;
			}
			return null;
		}
		return null;

	}

	@Override
	public int getCounter() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public void remove(int index) {
		
		

	}

	


	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		Node temp = head;
		while (temp != null) {
			result.append(temp.data + " ");
			temp = temp.next;
		}
		return result.toString();
	}

}