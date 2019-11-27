package datastructures.introdution;

/**
 * 二分查找
 * @author 潇潇暮雨
 *
 */
public class BinarySearchDemo {
	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 8 };
		int myNum = binarySearch(arr, 9);
		System.out.println(myNum);
	}

	//二分查找，返回的是要查找的数字的下标。如果没找到，返回-1；
	public static int binarySearch(int[] arr, int num) {
		int low = 0, high = arr.length - 1;
		while (low <= high) {
			int mid = (low + high) / 2;
			if (arr[mid] > num) {
				high = mid - 1;
			} else if (arr[mid] < num) {
				low = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
