package dataStructures.introdution;
/**
 * 传入一个整数n,一次打印一个数。将n每个位数上的数字依次打印出来。
 * @author 潇潇暮雨
 *
 */
public class PrintOneNum {
	public static void printOut(int n) {
		System.out.println(n%10);
		if (n < 10) {
			return ;
		}
		printOut(n / 10);
	}
	public static void main(String[] args) {
		printOut(100);
	}
}
