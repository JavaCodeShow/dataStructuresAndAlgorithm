package algorithm.sort;


import java.util.Arrays;
import java.util.Random;

/**
 * 归并排序
 * 采用递归法： ①. 将序列每相邻两个数字进行归并操作，形成 floor(n/2)个序列，排序后每个序列包含两个元素；
 * <p>
 * ②. 将上述序列再次归并，形成 floor(n/4)个序列，每个序列包含四个元素；
 * <p>
 * ③. 重复步骤②，直到所有元素排序完毕
 *
 * @author 江峰
 * @create 2020-04-15   16:00
 */
public class MergeSort {

    public static int[] sort(int[] a) {
        if (a.length <= 1) {
            return a;
        }
        int num = a.length >> 1;
        int[] left = Arrays.copyOfRange(a, 0, num);
        int[] right = Arrays.copyOfRange(a, num, a.length);
        return mergeTwoArray(sort(left), sort(right));
    }

    public static int[] mergeTwoArray(int[] a, int[] b) {
        int i = 0, j = 0, k = 0;

        // 申请额外空间保存归并之后数据
        int[] result = new int[a.length + b.length];

        //选取两个序列中的较小值放入新数组
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        //序列a中多余的元素移入新数组
        while (i < a.length) {
            result[k++] = a[i++];
        }

        //序列b中多余的元素移入新数组
        while (j < b.length) {
            result[k++] = b[j++];
        }
        return result;
    }


    public static void main(String[] args) {
        int count = 10;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = new Random().nextInt(100);
        }
        long start = System.currentTimeMillis();
        sort(arr);
        // System.out.println(Arrays.toString(sort(arr)));
        long end = System.currentTimeMillis();
        System.out.println("耗时： " + (end - start) + "毫秒");
    }
}
