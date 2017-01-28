package week03;

public interface MyLinkedListInterface <T>{

	public void addFirst(T newElement);
	public void addLast(T newElement);
	public void add(T newElement,int index);
	public T getFirst();
	public T getLast();
	public T get(int index);
	public int getCounter();
	public void remove(int index);
	
	
	
}
