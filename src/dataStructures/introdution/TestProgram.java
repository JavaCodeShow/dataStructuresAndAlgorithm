package dataStructures.introdution;

import java.util.Comparator;

public class TestProgram {
	//求数组中的最大值,传入一个数组，一个Comparator接口。
	public static <anyType> anyType findMax(anyType[] arr, Comparator<? super anyType> cmp) {
		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (cmp.compare(arr[i], arr[maxIndex]) > 0) {
				maxIndex = i;
			}
		}
		return arr[maxIndex];
	}
	
	public static void main(String[] args) {
		String[] arr = { "a", "g", "l" };
		String maxStr = findMax(arr, new CaseInsensitiveCompare());
		System.out.println(maxStr);
	}
}

class CaseInsensitiveCompare implements Comparator<String> {

	public int compare(String o1, String o2) {
		// TODO Auto-generated method stub
		return o1.compareToIgnoreCase(o2);
	}
}