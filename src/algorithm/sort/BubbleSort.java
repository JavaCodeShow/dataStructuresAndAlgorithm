package algorithm.sort;

import java.util.Arrays;

/**
 * 冒泡排序算法的算法过程如下：
 * ①. 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * ②. 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * ③. 针对所有的元素重复以上的步骤，除了最后一个。
 * ④. 持续每次对越来越少的元素重复上面的步骤①~③，直到没有任何一对数字需要比较。
 *
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
    public static int[] bubbleSort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            int tmp = 0;
            // 加入这个标志位进行判断的原因是如果没有一个数据发生过交换，
            // 说明当前数组里面的数据已经是有序的了。那么就没有必要进行交换了。
            boolean flag = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
            if (!flag) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 6, 5, -1};

        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
}
