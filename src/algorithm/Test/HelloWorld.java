package algorithm.Test;


import java.util.Arrays;

/**
 * @author 潇潇暮雨
 * @create 2018-09-04   15:25
 * <p>
 * <p>
 * 6. 合并排序数组 II
 * 合并两个排序的整数数组A和B变成一个新的数组。
 * <p>
 * 样例
 * 给出A=[1,2,3,4]，B=[2,4,5,6]，返回 [1,2,2,3,4,4,5,6]
 * <p>
 * 挑战
 * 你能否优化你的算法，如果其中一个数组很大而另一个数组很小？
 */

public class HelloWorld {

    /**
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        int[] arr = new int[A.length + B.length];
        for (int i = 0; i < A.length; i++) {
            arr[i] = A[i];
        }
        int k = 0;
        for (int i = A.length - 1; i < arr.length-1; i++) {
            for (int j = i; j > 0; j--) {
                if (B[k] < arr[j]) {
                    arr[j + 1] = arr[j];
                    arr[j] = B[k];
                }
                if (B[k] >= arr[i]){
                    arr[i+1] = B[k];
                    break;
                }
            }
            k++;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] A={1,2,3,4};
        int[] B={ 4,5,9,7/*,6,2,11,56,44,11*/};
        HelloWorld hello = new HelloWorld();
        int[] ints = hello.mergeSortedArray(A, B);
        System.out.println(Arrays.toString(ints));

    }

}
