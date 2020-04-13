package datastructures.array;

/**
 * 稀疏数组
 * 稀疏数组就是数组中，大部分的元素值都未被使用（或都为0），在数组中仅有少部分的空间使用。因此造成内存空间的浪费，
 * 为了解决这问题，并且不影响数组中原 有的元素值，我们采用了一种压缩的方式来表示稀疏数组的内容。
 *
 * @author 江峰
 * @create 2020-04-13   16:08
 */
public class SparseArray {
    private static final int row = 7;
    private static final int col = 7;

    public static void main(String[] args) {
        // 创建一个原始的二维数组
        int arr[][] = new int[row][col];
        arr[1][1] = 3;
        arr[3][0] = 1;
        arr[3][1] = 4;
        arr[4][2] = 7;
        arr[5][5] = 5;
        System.out.println("输入原始二维数组-----------------");
        prt(arr);
        System.out.println("-------------------------------");
        System.out.println("row.length = " + arr.length);
        System.out.println("col.length = " + arr[0].length);

        // 将原始的二维数组转换为稀疏数组
        // 数组中非0的数字个数。
        int count = 0;
        for (int[] ints : arr) {
            for (int i : ints) {
                if (i != 0) {
                    count++;
                }
            }
        }
        int[][] sparseArr = new int[count + 1][3];
        sparseArr[0][0] = 9;
        sparseArr[0][1] = 7;
        sparseArr[0][2] = count;
        count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = arr[i][j];
                }
            }
        }
        System.out.println("原始二维数组转换为稀疏数组-----------------");
        prt(sparseArr);
        System.out.println("-------------------------------");

        // 将稀疏数组转换为原始对的二维数组
        int[][] arr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            for (int j = 0; j < sparseArr[i].length; j++) {
                arr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
            }
        }

        System.out.println("稀疏数组转换为原始二维数组-----------------");
        prt(arr2);
        System.out.println("-------------------------------");

    }

    /**
     * 打印二维数组
     *
     * @param arr
     */
    public static void prt(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%d\t\t", arr[i][j]);
            }
            System.out.println("\n");
        }
    }
}
