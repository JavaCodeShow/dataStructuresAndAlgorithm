package dataStructures.ListAndStackAndQueue;

public class BinaryHeap<AnyType extends Comparable<? super AnyType>> {
	private static final int DEFAULT_CAPACITY = 10;
	/**	Number of element in heap */
	private int currentSize;
	/**	The heap array */
	private AnyType [] array;
	public BinaryHeap() {
		/* 省略 */
	}

	public BinaryHeap(int capacity) {
		/* 省略 */
	}

	public BinaryHeap(AnyType[] items) {
		/* 省略 */
	}

	public void insert(AnyType x) {

	}

	/**
	 * 查找最小值
	 * @return
	 */
	public AnyType findMin() {
		return null;

	}

	/**
	 * 删除最小值
	 * @return
	 */
	public AnyType deleteMin() {
		return null;

	}

	public boolean isEmpty() {
		return false;

	}

	public void makeEmpty() {

	}
	
	/**
	 * percolate : 渗透
	 * @param hole
	 */
	private void percolateDown(int hole) {
		
	}
	
	private void buildHeap() {
		
	}
	/**
	 * enlarge : 扩大
	 * @param newSize
	 */
	private void enlargeArray(int newSize) {
		
	}
}
