package algorithm.sort;

import java.util.Random;

/**
 * 快速排序。不理解这个排序的实现。
 *
 * @author 江峰
 * @create 2020-04-15   15:21
 */
public class QuickSort {
    /**
     * 快速排序（左右指针法）
     *
     * @param arr  待排序数组
     * @param low  左边界
     * @param high 右边界
     */
    public static void sort2(int arr[], int low, int high) {
        if (arr == null || arr.length <= 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int left = low;
        int right = high;

        int key = arr[left];

        while (left < right) {
            while (left < right && arr[right] >= key) {
                right--;
            }
            while (left < right && arr[left] <= key) {
                left++;
            }
            if (left < right) {
                swap(arr, left, right);
            }
        }
        swap(arr, low, left);
        // System.out.println("Sorting: " + Arrays.toString(arr));
        sort2(arr, low, left - 1);
        sort2(arr, left + 1, high);
    }

    public static void swap(int arr[], int low, int high) {
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }

    public static void main(String[] args) {
        int count = 8000000;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = new Random().nextInt(10000000);
        }
        long start = System.currentTimeMillis();
        sort2(arr, 0, count - 1);
        // System.out.println(Arrays.toString(sort(arr)));
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + "毫秒");
    }
}
