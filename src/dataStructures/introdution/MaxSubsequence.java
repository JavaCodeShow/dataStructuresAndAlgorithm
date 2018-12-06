package dataStructures.introdution;

/**
 * 求最大子序列
 * @author 潇潇暮雨
 *
 */
public class MaxSubsequence {
	public static void main(String[] args) {
		int[] arr = { 1, 2, -3,4};
		int maxSum = findMaxSubNum2(arr);
		System.out.println(maxSum);
		System.out.println("");
	}

	//	时间复杂度为O(N^2)  时间复杂度考虑的是最坏情况下
	public static int findMaxSubNum1(int[] arr) {
		int maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			int testSum = 0;
			for (int j = i; j < arr.length; j++) {
				testSum += arr[j];
				if (testSum > maxSum) {
					maxSum = testSum;
				}
			}
		}
		return maxSum;
	}
	// 时间复杂度为O(N),也是求最大子序列和的最好算法。
	public static int findMaxSubNum2(int[] arr) {
		int maxSum = 0, thisSum = 0;
		//对数组进行遍历,并求出数组的和thisSum，赋值给maxSum,如果thisSum < 0;便将thisSum置为0，继续遍历。
		for (int i = 0; i < arr.length; i++) {
			thisSum += arr[i];
			if (thisSum > maxSum) {
				maxSum = thisSum;
			}
			if (thisSum < 0) {
				thisSum = 0;
			}
		}
		return maxSum;
	}
}
