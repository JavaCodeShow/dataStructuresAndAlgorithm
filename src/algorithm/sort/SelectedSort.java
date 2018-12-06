package algorithm.sort;

import java.util.Arrays;

/**
 * @author 潇潇暮雨
 * @create 2018-09-05   20:18
 */
public class SelectedSort {

    /**
     * 选择排序具体实现
     * @param arr
     */
    public void selectedSort(int[] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 找出第n小的一个数
            int min = i;
            for (int j = i + 1; j < n ; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            // 将这个数与第n个数置换
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
    }

    public static void main(String[] args) {
        int [] arr = {2,3,4,1,6,3};
        new SelectedSort().selectedSort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
