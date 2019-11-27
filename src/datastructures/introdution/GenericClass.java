package datastructures.introdution;

class Shape {

}

class Square extends Shape {
	private int i;

	public Square(Integer i) {
		this.i = i;
	}

	public String toString() {
		return new String("" + i + "");
	}

}

class Rectangle extends Shape {
	private int i;

	public Rectangle(Integer i) {
		this.i = i;
	}
}

public class GenericClass {
	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 5, 6, 3 };
		System.out.println(contains(arr, 3));
	}

	public static <AnyType> boolean contains(AnyType[] arr, AnyType a) {
		for (AnyType s : arr) {
			if (s.equals(a))
				return true;
		}
		return false;
	}

	public static <AnyType extends Comparable<AnyType>> AnyType findMax(AnyType[] arr, AnyType a) {
		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].compareTo(arr[maxIndex]) > 0) {
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}

}
