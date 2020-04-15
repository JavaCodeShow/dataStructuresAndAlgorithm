package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序
 * ①. 从第一个元素开始，该元素可以认为已经被排序
 * ②. 取出下一个元素，在已经排序的元素序列中从后向前扫描
 * ③. 如果该元素（已排序）大于新元素，将该元素移到下一位置
 * ④. 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置
 * ⑤. 将新元素插入到该位置后
 * ⑥. 重复步骤②~⑤
 *
 * @author 潇潇暮雨
 * @create 2018-09-07   15:18
 * <p>
 * 插入排序
 */
public class InsertSort {

    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
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
        new InsertSort().insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
