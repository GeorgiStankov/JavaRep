package week03;

public class MyLinkedList {

	private static int counter;
	private Node head;

	
	public MyLinkedList() {

	}

	public void addFirst(Object data) {

		head = new Node(data, head);

		incrementCounter();
	}

	
	public void addLast(Object data) {

		if (head == null) {
			head = new Node(data);
		}

		Node temp = new Node(data);
		Node current = head;

		if (current != null) {

			while (current.getNext() != null) {
				current = current.getNext();
			}

			current.setNext(temp);
		}

		incrementCounter();
	}

	
	public void add(Object data, int index) {
		Node temp = new Node(data);
		Node current = head;

		if (current != null) {
			for (int i = 0; i < index && current.getNext() != null; i++) {
				current = current.getNext();
			}
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		incrementCounter();
	}

	public Object get(int index)

	{

		if (index < 0)
			return null;
		Node current = null;
		if (head != null) {
			current = head;
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null)
					return null;

				current = current.getNext();
			}
			return current.getData();
		}
		return current;

	}

	public Object getFirst() {
		return head.data;
	}

	public Object getLast() {
		int count = getCounter() - 1;
		return get(count);
	}

	
	public boolean remove(int index) {
		if (index < 1 || index > size())
			return false;

		Node current = head;
		if (head != null) {
			for (int i = 0; i < index; i++) {
				if (current.getNext() == null)
					return false;

				current = current.getNext();
			}
			current.setNext(current.getNext().getNext());

			decrementCounter();
			return true;

		}
		return false;
	}

	public int size() {
		return getCounter();
	}

	private static int getCounter() {
		return counter;
	}

	private static void incrementCounter() {
		counter++;
	}

	private void decrementCounter() {
		counter--;
	}

	public void deleteMid(Node nod) {
		Node current = nod;
		Node temp = nod.getNext();
		current.setData(temp);
		current.setNext(temp.getNext());
	}

	public void appendList(MyLinkedList list) {
		Node current = head;
		Node temp = list.head;
		if (current != null && temp != null) {

			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(temp);
		}

	}


	public Node nthToLast(Node head, int n) {
		if (head == null || n < 1) {
			return null;
		}

		Node p1 = head;
		Node p2 = head;

		for (int j = 0; j < n - 1; ++j) { 
			if (p2 == null) {
				return null; 
			}
			p2 = p2.next;
		}

		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}

		return p1;
	}

	public Node partition(int x) {
		if (head == null)
			return head;
		Node prev = null;
		Node current = head;
		while (current != null) {
			if (Integer.valueOf(String.valueOf(current.data)) > x || current == head) {
				prev = current;
				current = current.next;
			} else {
				Node next = current.next;
				current.next = head;
				if (prev != null) {
					prev.next = next;
				}
				head = current;
				current = next;
			}
		}
		return head;
	}

	public boolean isPalidrom() {
		if (head == null)
			return true;

		Node p = head;
		Node prev = new Node(head.data);

		while (p.next != null) {
			Node temp = new Node(p.next.data);
			temp.next = prev;
			prev = temp;
			p = p.next;
		}

		Node p1 = head;
		Node p2 = prev;

		while (p1 != null) {
			if (p1.data != p2.data)
				return false;

			p1 = p1.next;
			p2 = p2.next;
		}

		return true;

	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		Node temp = head;
		result.append("[ ");
		while (temp != null) {
			result.append(temp.getData() + " ");
			temp = temp.next;
		}
		result.append("]");
		return result.toString();
	}

	private class Node {

		Node next;
		Object data;

		public Node(Object dataValue) {
			next = null;
			data = dataValue;
		}

		public Node(Object dataValue, Node nextValue) {
			this.data = dataValue;
			this.next = nextValue;

		}

	
		public Object getData() {
			return data;
		}

	
		public void setData(Object dataValue) {
			data = dataValue;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node nextValue) {
			next = nextValue;
		}

	}

}
