package dataStructures.introdution;

public class WrapperDemo {
	public static void main(String[] args) {
//		MemoryCell m = new MemoryCell();
//		m.write(new Integer(37));
//		Integer read = (Integer) m.read();
//		int intValue = read.intValue();
//		System.out.println(intValue);
//		System.out.println(null == " ");
		MemoryCell m = new MemoryCell();
		m.write(new Integer(37));
		Integer wrapperVal = (Integer)m.read();
		int i = wrapperVal.intValue();
		System.out.println(i);
	}
}
