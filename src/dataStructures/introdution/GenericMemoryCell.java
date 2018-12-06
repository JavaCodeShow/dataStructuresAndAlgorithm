package dataStructures.introdution;

public class GenericMemoryCell<T> {

	//定义一个变量用来存储数据
	private T storeValue;
	public void write(T obj) {	
		storeValue = obj;
	}
	public T read() {
		return storeValue;
	}

	public static void main(String[] args) {
		GenericMemoryCell<Integer> cell1 = new GenericMemoryCell<Integer>();
		cell1.write(6);
		Object cell = cell1.read();
//		GenericMemoryCell<String> cell2 = (GenericMemoryCell<String>) cell;
			((GenericMemoryCell<Integer>) cell).read();
	}

}
