package dataStructures.introdution;

/**
 * 编写一种递归方法，它返回数N的二进制中表示1的个数。
 * @author 潇潇暮雨
 *
 */
public class Practice15 {
	public static void main(String[] args) {
		int N = 15;
		int count = getNumOfOne(N);
		System.out.println("二进制为 ： " + Integer.toBinaryString(N));
		System.out.println(count);
	}

	public static int getNumOfOne(int N) {
		String str = Integer.toBinaryString(N);
		int count = 0;
		int length = str.length();
		for (int i = 0; i < length; i++) {
			if ('1' == str.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
