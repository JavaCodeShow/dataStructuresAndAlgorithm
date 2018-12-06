package algorithm.sort;

import java.util.Arrays;

/**
 * @author 潇潇暮雨
 * @create 2018-09-07   15:18
 * <p>
 * 插入排序
 */
public class InsertSort {

    public void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                swap(arr, j, j - 1);
            }
        }
    }

    private void swap(int[] arr, int i, int i1) {
        int temp = arr[i];
        arr[i] = arr[i1];
        arr[i1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 3, 2, 5, 6, 8, 7};
        InsertSort sort = new InsertSort();
        sort.insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
