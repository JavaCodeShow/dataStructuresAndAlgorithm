package algorithm.search;

/**
 * 二分查找
 *
 * @author 江峰
 * @create 2020-04-15   17:04
 */
public class BinarySearch {
    /**
     * 迭代实现
     *
     * @param arr
     * @param k
     * @return
     */
    public int binarySearch1(int[] arr, int k) {
        int heigth = arr.length;
        int low = 0;
        while (low < heigth) {
            int mid = (low + heigth) / 2;
            if (arr[mid] < k) {
                low = mid + 1;
            } else if (arr[mid] > k) {
                heigth = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int i = new BinarySearch().binarySearch1(arr, 4);
        System.out.println("i = " + i);
    }
}
