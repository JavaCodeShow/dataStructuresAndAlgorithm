package dataStructures.ListAndStackAndQueue;

import java.util.Iterator;

/**
 * 自己实现一个简易版的ArrayList
 * @author 潇潇暮雨
 *
 */
public class MyArrayList<AnyType> implements Iterable<AnyType> {
	/** ArrayList的默认初始大小为10 */
	private static final int DEFAULT_CAPACITY = 10;
	/** 数组里面实际元素的个数 */
	private int theSize;
	private AnyType[] theItems;

	public int size() {
		return theSize;
	}

	public MyArrayList() {
		doClear();
	}

	//将数组大小改为10，元素为null; size改为0；
	public void clear() {
		doClear();

	}

	private void doClear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public AnyType set(int idx, AnyType x) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();

		}
		AnyType old = theItems[idx];
		theItems[idx] = x;
		return old;
	}

	public AnyType get(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[idx];
	}

	/** 进行扩容  */
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize)
			return;
		AnyType[] oldItems = theItems;
		theItems = (AnyType[]) new Object[newCapacity];
		for (int i = 0; i < size(); i++) {
			theItems[i] = oldItems[i];
		}
	}

	public AnyType remove(int idx) {
		if (idx < 0 || idx >= size()) {
			throw new ArrayIndexOutOfBoundsException();

		}
		AnyType oldItem = theItems[idx];
		for (int i = idx; i < size(); i++) {
			if (i == size() - 1) {
				theItems[i] = null;
				// trimToSize();
			} else {
				theItems[i] = theItems[i + 1];
			}
		}
		theSize--;
		return oldItem;
	}

	public void add(AnyType x) {
		//		if (size() == theItems.length) {
		//			ensureCapacity(2 * size()+1);
		//		}
		//		theItems[size()] = x;
		//		theSize++;
		add(size(), x);
	}

	public void add(int idx, AnyType x) {
		if (size() == theItems.length) {
			ensureCapacity(2 * size() + 1);
		}
		for (int i = size(); i > idx; i--) {
			theItems[i] = theItems[i - 1];
		}
		theItems[idx] = x;
		theSize++;

	}

	//迭代器
	@Override
	public Iterator<AnyType> iterator() {
		//返回的是一个迭代器，所以我们要自己写一个迭代器。
		return new MyIterator<AnyType>();
	}

	private class MyIterator<AnyType> implements Iterator<AnyType> {
		//光标的位置
		private int current = 0;

		@Override
		public boolean hasNext() {
			if (current < size())
				return true;
			return false;
		}

		@Override
		public AnyType next() {
			return (AnyType) theItems[current++];
		}

		public void remove() {
			MyArrayList.this.remove(--current);
		}

	}

	public static void main(String[] args) {
		MyArrayList<Integer> list = new <Integer>MyArrayList();
		System.out.println("开始");
		for (int i = 0; i < 11320; i++) {
			list.add(i);
		}
		System.out.println("结束");
		Iterator<Integer> it = list.iterator();
		list.printList(it);
	}

	public void printList(Iterator it) {
		while (!it.hasNext()) {
			return;
		}
		System.out.println(it.next());
		printList(it);

	}

}
