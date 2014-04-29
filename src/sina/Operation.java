package sina;

/**
 * 在只使用++操作符的情况下,实现加、减、乘、除功能。<br>
 * 假设操作数全为整数。
 * 
 * @company 新浪
 * @author xiehai
 * @date 2014-2-7 下午05:07:56
 */
public class Operation {
	/**
	 * 只使用++实现加法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int add(int a, int b) {
		int sum = a;
		for (int i = 0; i < b; ++i) {
			sum++;
		}
		return sum;
	}

	/**
	 * 只使用++实现减法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int substract(int a, int b) {
		int c = 0;
		boolean flg = true;// true返回结果为正,false返回结果为负
		if (a < b) {// 如果被减数大于减数,交换两个的值,并将返回结果置为负数
			flg = false;
			a ^= b;
			b ^= a;
			a ^= b;
		}
		while (a != b) {
			c++;
			b++;
		}
		if (flg) {
			return c;
		} else {
			return -c;
		}
	}

	/**
	 * 只使用++实现减法(a-b = -b+a)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int minus(int a, int b) {
		return add(-b, a);
	}

	/**
	 * 只使用++实现乘法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int multipy(int a, int b) {
		int sum = 0;
		for (int i = 0; i < b; ++i) {
			sum = add(sum, a);
		}
		return sum;
	}

	/**
	 * 只使用++实现除法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int divide(int a, int b) {
		int sum = 0;
		for (int i = 0;; ++i) {
			sum = multipy(i, b);
			if (sum == a) {
				return i;
			} else if (sum > a) {
				return i - 1;
			}
		}
	}

	public static void main(String[] args) {
		int a = 3;
		int b = 12;
		Operation operation = new Operation();
		int result;
		System.out.println(-b);
		result = operation.add(a, b);
		System.out.println(result);
		result = operation.minus(a, b);
		System.out.println(result);
		result = operation.substract(a, b);
		System.out.println(result);
		result = operation.multipy(a, b);
		System.out.println(result);
		result = operation.divide(a, b);
		System.out.println(result);
	}
}
