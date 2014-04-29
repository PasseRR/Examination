package microsoft;

/**
 * 编程实现两个正整数的除法，当然不能用除法操作符。
 * 
 * @company 微软
 * @author xiehai
 * @date 2014-2-13 下午01:52:55
 */
public class Divide {
	/**
	 * 正整数除法
	 * 
	 * @param a
	 *            被除数
	 * @param b
	 *            除数
	 * @return
	 */
	public int divide(final int a, final int b) {
		int x = a;
		int y = b;
		int result = 0;
		boolean flgA = false;
		boolean flgB = false;// 是否为负数
		if (x < 0) {
			flgA = true;
			x = -x;
		}
		if (y < 0) {
			flgB = true;
			y = -y;
		}
		if (x < y) {
			return result;
		}
		while (x >= y) {
			x -= y;
			result += 1;
		}

		return (flgA && flgB) ? result : -result;
	}

	public static void main(String[] args) {
		Divide divide = new Divide();
		int a = 31;
		int b = -3;
		System.out.println(divide.divide(a, b));
	}
}
