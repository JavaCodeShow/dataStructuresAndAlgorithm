package algorithm.base;

/**
 * @author 潇潇暮雨
 * @create 2018-09-04   15:27
 * <p>
 * 典型的静态方法的实现
 */
public class StaticMethod {

    /**
     * 判断一个数是否是素数
     *
     * @param num
     * @return
     */
    public static boolean isPrime(int num) {
        if (num < 2)
            return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }


    /**
     * 二分查找的递归实现
     *
     * @param key
     * @param arr
     * @return
     */
    public static int binarySearch(int key, int[] arr) {
        return binarySearch(key, arr, 0, arr.length - 1);

    }

    private static int binarySearch(int key, int[] arr, int low, int high) {
        if (low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if (key < arr[mid])
            return binarySearch(key, arr, low, mid - 1);
        if (key > arr[mid])
            return binarySearch(key, arr, mid + 1, high);
        return mid;
    }

    public static void main(String[] args) {
        boolean b = isPrime(11);
        System.out.println("b = " + b);
        int[] arr = {1, 4, 5, 6, 2};
        int i = binarySearch(6, arr);
        System.out.println(i);
    }
}
