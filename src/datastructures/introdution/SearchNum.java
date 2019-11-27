package datastructures.introdution;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 设有一组N个数，要确定其中的第K个最大值。
 * @author 潇潇暮雨
 *
 */
//分析 ： 将这N个数存入到数组里面，在对这N个数进行降序排序，然后取出第K个最大值。
public class SearchNum {
	private static int N = 5;
	private static int K = 2;
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[N];
		for (int i = 0;i < N;i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(Arrays.toString(arr));
//		int[] arr = {1,5,6,2,7};
		/** 进行冒泡排序 */
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - i - 1; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j + 1] = temp;
				}
			}
			if ( K-1 == i) {
				System.out.println(arr[K - 1]);
				return;
			}
		}
		System.out.println(Arrays.toString(arr));
//		System.out.println(arr[N - K]);
	}
	
}
