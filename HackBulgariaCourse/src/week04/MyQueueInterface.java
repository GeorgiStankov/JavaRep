package week04;

/*
 * Queue Interface
 * 
 * Author Georgi
 * 
 */

public interface MyQueueInterface<T extends Comparable<T>> {

	/*
	 * ADds an element to the end of the queue
	 * 
	 */
	public void enqueue(T element);

	/*
	 * Removes and returns first element
	 */
	public T dequeue();

	/*
	 * return the element on top of the stack;
	 */
	public T peek();

	public int getSize();

}
