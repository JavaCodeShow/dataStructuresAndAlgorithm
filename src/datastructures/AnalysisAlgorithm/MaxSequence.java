package datastructures.AnalysisAlgorithm;

/**
 * 求最大子序列问题
 * @author 潇潇暮雨
 *
 */
public class MaxSequence {
	public static void main(String[] args) {
		int[] arr = { 1, 5, 6, 7, -4, 6, -1,2,-3,100 };
		int sum = maxSubSum(arr);
		int sum1 = maxSubSum1(arr);
		int sum2 = maxSubSum2(arr);
		System.out.println(sum);
		System.out.println(sum1);
		System.out.println(sum2);
	}

	// 时间复杂度为o(N)
	public static int maxSubSum(int[] arr) {
		int thisSum = 0;
		int maxSum = 0;
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
	//时间复杂度为 : o(N^3)
	public static int maxSubSum1(int[] arr) {
		int maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				int thisSum = 0;
				for (int k = i; k <= j; k++) {
					thisSum += arr[k];
					if (thisSum > maxSum) {
						maxSum = thisSum;
					}
				}
			}
		}
		return maxSum;
	}
	
	//时间复杂度为 ： o(N^2) 
	public static int maxSubSum2(int[] arr) {
		int maxSum = 0;
		for (int i = 0; i < arr.length; i++) {
			int thisSum = 0;
			for (int j = i; j < arr.length; j++) {
				thisSum +=arr[j];
				if (thisSum > maxSum) {
					maxSum = thisSum;
				}
			}
		}
		return maxSum;
	}
}
