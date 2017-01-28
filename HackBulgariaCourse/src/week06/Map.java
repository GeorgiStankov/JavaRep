package week06;

public class Map<K, V> implements MyMapImpl<K, V> {

	BucketInterface<K, V>[] buckets;
	private double loadFactor;
	private int size;

	public Map() {
		size = 8;
		loadFactor = 10;
		buckets = new LinkedBucket[size];
	}

	@Override
	public void put(K key, V value) {
		if (key == null) {
			return;
		}

		int hashValue = calculateBucketIndex(key);
		buckets[hashValue].add(key, value);

	}

	private int calculateBucketIndex(K key) {
		int hashValue = key.hashCode() % size;
		return hashValue;
	}

	@Override
	public V get(K key) {
		int hashValue = calculateBucketIndex(key);
		if (buckets[hashValue] == null) {
			return null;
		} else {

			return buckets[hashValue].get(key);
		}
	}

	static int indexFor(int h, int length) {
		return h & (length - 1);
	}

	@Override
	public void remove(K key) {
		int hashValue = calculateBucketIndex(key);
		buckets[hashValue].remove(key);

	}

	@Override
	public boolean containsKey(K key) {

		return (get(key) != null);
	}

	public int getSize() {
		return size;
	}
	/*
	 * 1 create newList new LinkedBucket[2*size] 2 oldList=this.list; 3 *
	 * list=newList; 4 for each element in oldList -> call put();
	 * 
	 * 
	 */

}
