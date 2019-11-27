package datastructures.introdution;
//recurdive：递归
public class Recursion {
	public static int f(int x) {
		if(x == 0)
			return 0;
		else {
			return 2 * f(x - 1) + x * x;
		}
	}
	public static void main(String[] args) {
		int f = f(4);
		System.out.println(f);
	}
}
