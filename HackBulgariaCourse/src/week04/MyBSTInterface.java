package week04;

public interface MyBSTInterface<T extends Comparable<T>> {

	
	public void insert(T element);
	public void remove(T element);
	public boolean find(T element);
}
