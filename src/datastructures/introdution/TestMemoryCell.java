package datastructures.introdution;

public class TestMemoryCell {
	public static void main(String[] args) {
		MemoryCell m = new MemoryCell();
		m.write(37);
		 Integer read = (Integer) m.read();
		System.out.println(read == 37);
	}
	
	public static<Integer> boolean contains(Integer[] arr,Integer i) {
		for(Integer a : arr) {
			if(i.equals(a)) {
				return true;
			}
		}
		return false;
	}
}
