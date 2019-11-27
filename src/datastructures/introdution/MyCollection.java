package datastructures.introdution;

/**
 * 设计一个泛型类，它存储Object对象的集合（在数组中），以及该集合的当前大小。
 * 提供public方法isEmpty,makeEmpty,insert,remove,isPresent(x).
 * 方法isPresent(x)当且仅当在集合中存在（由equals方法定义）等于x的一个Object是返回true;
 * @author 潇潇暮雨
 *
 */
public class MyCollection<T> {
	private static final int DEFAULT_CAPACITY = 10;
	/** 定义一个数组用来存储对象 */
	private Object table[] = null;
	/** 数组的大小 */
	private int size = 0;

	public MyCollection() {
		table = new Object[10];
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

	public boolean insert(T t) {
		if (size == DEFAULT_CAPACITY) {
			//进行扩容
		} else {
			table[size] = t;
			size++;
		}
		return true;
	}

	public T remove(T t) {
		T oldData = null;
		for (int i = 0; i < size; i++) {
			if (t.equals(table[i])) {
				oldData = (T) table[i];
				table[i] = table[i + 1];
				size--;
			}
		}
		return oldData;
	}

	public boolean isPresent(T x) {
		for (int i = 0; i < size; i++) {
			if (table[i].equals(x)) {
				table[i] = table[i+1];
			}
		}
		return true;
	}

	public static void main(String[] args) {
		MyCollection<Integer> mc = new MyCollection<>();
		System.out.println(mc.size);;
		mc.insert(1);
		mc.insert(6);
		mc.insert(9);
		Integer remove = mc.remove(6);
		System.out.println(remove);
		System.out.println(mc.size);
	}
}
