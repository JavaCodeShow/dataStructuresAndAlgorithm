package algorithm.sort;

import java.util.Arrays;

/**
 * @author 潇潇暮雨
 * @create 2018-12-27   20:58
 */
public class BubbleSort {
    /**
     * 冒泡排序
     *
     * @param arr
     * @return
     */
    public static int[] bubble_sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int temp = 0;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 5};
        System.out.println(Arrays.toString(bubble_sort(arr)));
    }
}
