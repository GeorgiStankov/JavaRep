package week04;

/*
 *Stack Interface
 *
 *author Georgi
 *
 */
public interface MyStackInterface<T extends Comparable<T>> {

	/*
	 * Removes the element on top of the stack
	 */
	public T pop();
	/*
	 * Adds an element on top of the stack
	 */

	public void push(T element);
	

	public T peek();

	public int size();

}
