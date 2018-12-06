package algorithm.base;

import java.util.Arrays;

/**
 * 对数组进行操作
 * @author 潇潇暮雨
 * @create 2018-09-04   10:08
 */
public class OperationArray {

    /**
     * 查找数组中的最大元素
     * @param arr
     * @return
     */
    public int findMaxNum(int[] arr) {
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[max]){
                max = i;
            }
        }
        return  arr[max];
    }

    /**
     * 计算数组元素的平均值
     * @param arr
     * @return
     */
    public double findAverage(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
        }
        System.out.println(sum);
        double average = sum / (arr.length * 1.0);
        return average;
    }

    /**
     * 复制数组
     * 注意 : 复制数组时需要新建一个数组，然后将原数组的元素一次复制到新的数组中去，
     * 而不是将新数组的地址指向原数组的地址
     * @param arr
     * @return
     */
    public int[] copyArray(int[] arr){
        int[] oldTable = arr;
        int[] newTable = new int[oldTable.length];
        for (int i = 0; i < oldTable.length; i++) {
            newTable[i] = oldTable[i];
        }
        return newTable;
    }

    /**
     * 颠倒数组元素的循序
     * @param arr
     * @return
     */
    public int[]  reverseArray(int[] arr){
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 4, 6, 3, 9};
        System.out.println(Arrays.toString(arr));
        OperationArray hello = new OperationArray();
        int maxNum = hello.findMaxNum(arr);
        System.out.println("maxNum = " + maxNum);
        System.out.println("----------------------------------------------------");
        double average = hello.findAverage(arr);
        System.out.println("average = " + average);
        System.out.println("----------------------------------------------------");
        int[] array = hello.copyArray(arr);
        System.out.println(Arrays.toString(array));
        System.out.println("----------------------------------------------------");
        int[] reverseArray = hello.reverseArray(arr);
        System.out.println(Arrays.toString(reverseArray));

    }
}
