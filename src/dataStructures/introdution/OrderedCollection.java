package dataStructures.introdution;
/**
 * 设计一个泛型类OrderedCollection，它存储Compareble对象的集合（在数组中），以及该集合的当前大小。
 * 提供public方法isEmpty,makeEmpty,insert,remove,findMin和fingMax.
 * findMin 和 findMax必须返回该集合中最小的和最大的Comparable对象的引用。
 * 如果集合为空，返回为null
 * @author 潇潇暮雨
 *
 */
public class OrderedCollection {
	private static final int DEFAULT_CAPACITY = 10;

	/** 定义一个数组用来存储对象 */
	private Comparable table[] = null;
	/** 数组的大小 */
	private int size = 0;

	public OrderedCollection() {
		table = new Comparable[10];
	}

	public boolean isEmpty() {
		if (size == 0) {
			return true;
		}
		return false;
	}

	public void makeEmpty() {
		table = null;
		size = 0;
	}

	public boolean insert(Comparable t) {
		if (size == DEFAULT_CAPACITY) {
			//进行扩容
		} else {
			table[size] = t;
			size++;
		}
		return true;
	}

	public Comparable remove(Comparable t) {
		Comparable oldData = null;
		for (int i = 0; i < size; i++) {
			if (t.equals(table[i])) {
				oldData = (Comparable) table[i];
				table[i] = table[i + 1];
				size--;
			}
		}
		return oldData;
	}
	
	public Comparable findMin() {
		if (table == null) {
			return null;
		}
		int minIndex = 0;
		for (int i = 1; i < size; i++) {
			if (table[i].compareTo(table[minIndex]) < 0) {
				minIndex = i;
			}
		}
		return table[minIndex];
	}
	
	public Comparable findMax() {
		if (table == null) {
			return null;
		}
		int maxIndex = 0;
		for (int i = 1; i < size; i++) {
			if (table[i].compareTo(table[maxIndex]) > 0) {
				maxIndex = i;
			}
		}
		return table[maxIndex];
	}
	
	public static void main(String[] args) {
		OrderedCollection oc = new OrderedCollection();
		oc.insert(6);
		oc.insert(7);
		oc.insert(1);
		oc.insert(5);
		oc.insert(3);
		System.out.println("最大值 = " + oc.findMax());
		System.out.println("最小值 = " + oc.findMin());
	}
}
