package dataStructures.introdution;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 编写一个程序，如果输入的是“abc"，那么输出的是"abc","acb","bac","bca","cab","cba"
 * @author 潇潇暮雨
 *
 */

public class Practice16 {
	private static Set<String> set = new HashSet();
	private static int count = 0;

	public static void premute(String str) {
		if (str == null || str.length() < 1) {
			throw new NullPointerException();
		}
		char[] arr = str.toCharArray();
		permute(arr, 0, arr.length);
	}

	//要求 ：使用递归
	private static void permute(char[] arr, int low, int high) {
		for (int i = 1; i < high; i++) {
			char temp = arr[low];
			arr[low] = arr[i];
			arr[i] = temp;
			StringBuffer append = new StringBuffer().append(arr);
			set.add(append.toString());
		}
		if (count == arr.length)
			return;
		count++;
		permute(arr, low, high);
	}

	public static void main(String[] args) {
		premute("abc");
		System.out.println(set);

	}

}
