package dataStructures.introdution;

public class MemoryCell {
	//定义一个变量用来存储数据
	private Object storeValue;
	public void write(Object obj) {	
		storeValue = obj;
	}
	public Object read() {
		return storeValue;
	}
}
