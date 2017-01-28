package week02;

public class IntVector {

	int size = 0;
	int capacity = 10;
	int arr[] = new int[capacity];

	IntVector() {

	}

	IntVector(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			this.add(arr[i]);
		}
	}

	IntVector(int data) {
		this.capacity = data;
		arr = new int[capacity];
	}

	public void add(int data) {
		if (size == capacity) {
			resize();

		}
		arr[size] = data;
		size++;
	}

	public void resize() {
		capacity *= 2;
		int[] temp = new int[capacity * 2];

		for (int i = 0; i < size; i++) {
			temp[i] = arr[i];

		}
		arr = temp;
	}

	public void set(int index, int data) {
		arr[index] = data;
	}

	public int get(int index) {
		return arr[index];
	}

	public String toString() {

		String result = "";
		for (int i = 0; i < arr.length; i++) {

			result += arr[i] + ", ";
		}

		return "[" + result + "]";
	}

	public int size() {

		return arr.length;
	}

}
