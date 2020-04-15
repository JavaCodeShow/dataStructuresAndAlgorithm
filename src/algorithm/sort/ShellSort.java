package algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * 希尔排序
 * 将待排序数组按照步长gap进行分组，然后将每组的元素利用直接插入排序的方法进行排序；每次再将gap折半减小，循环上述操作；当gap=1时，利用直接插入，完成排序。
 * 可以看到步长的选择是希尔排序的重要部分。只要最终步长为1任何步长序列都可以工作。一般来说最简单的步长取值是初次取数组长度的一半为增量，之后每次再减半，直到增量为1。更好的步长序列取值可以参考维基百科。
 * <p>
 * 作者：foofoo
 * 链接：https://juejin.im/post/5b95da8a5188255c775d8124
 * 来源：掘金
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 *
 * @author 江峰
 * @create 2020-04-15   13:18
 */
public class ShellSort {
    public void shellSort(int[] arr) {
        // System.out.println("arr = " + Arrays.toString(arr));
        int gap = arr.length >> 1;
        // int count = 0;
        while ((gap /= 2) != 0) {
            for (int i = 0; i < arr.length - gap; i++) {
                for (int j = i + gap, tmp = 0; j >= gap && arr[j - gap] > arr[j]; j -= gap) {
                    tmp = arr[j - gap];
                    arr[j - gap] = arr[j];
                    arr[j] = tmp;
                }
            }
            // System.out.println("第" + ++count + "次交换后的结果");
            // System.out.println("gap = " + gap);
            // System.out.println(Arrays.toString(arr));
        }
    }

    public static void main(String[] args) {
        int count = 30;
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            arr[i] = new Random().nextInt(30);
        }
        // int[] arr = {1, 3, 5, 3, 2, 5, 6, 8, 7};
        new ShellSort().shellSort(arr);
        System.out.println("希尔排序完成");
        System.out.println(Arrays.toString(arr));
    }
}
