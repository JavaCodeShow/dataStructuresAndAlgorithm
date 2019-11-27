package datastructures.introdution;

public class FindMaxDemo {
	public static void main(String[] args) {
		String [] arr = {"1","3","5","2"};
		Comparable max = findMax(arr);
		Integer i = 1;
		System.out.println(max);
		System.out.println(i.compareTo(2));
	}

	public static Comparable findMax(String[] arr) {
		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(arr[maxIndex]) > 0) {
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}
}
