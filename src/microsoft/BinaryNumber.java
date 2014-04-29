package microsoft;

/**
 * 输入两个数，相加求和，二进制输出
 * 
 * @author xiehai
 * @date 2014-2-18 下午01:41:55
 */
public class BinaryNumber {
	/** 字符串0 */
	private static final String ZERO = "0";
	/**
	 * 输入两个十进制的数,返回其和的二进制形式
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String add(int a, int b) {
		int sum = a + b;

		return binary(sum);
	}

	/**
	 * 返回输入数字的二进制形式
	 * 
	 * @param n
	 * @return
	 */
	public String binary(int n) {
		if (0 == n) {
			return ZERO;
		}
		int temp = n;
		StringBuilder sb = new StringBuilder();
		while (0 != temp) {
			int num = temp % 2;
			sb.append(num < 0 ? -num : num);
			temp >>>= 1;
		}

		return sb.reverse().toString();
	}

	/**
	 * 使用JDK的API
	 * 
	 * @param n
	 * @return
	 */
	public String binaryApi(int n) {
		return Integer.toBinaryString(n);
	}

	public static void main(String[] args) {
		BinaryNumber bn = new BinaryNumber();
		int num = 0;
		System.out.println(bn.binaryApi(num));
		System.out.println(bn.binary(num));
		System.out.println(bn.add(11, -5));
	}
}
