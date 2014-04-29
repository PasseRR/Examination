package tencent;

/**
 * 比较两个数a、b的大小，不能使用大于、小于、if语句
 * 
 * @company 腾讯
 * @author xiehai
 * @date 2014-2-13 下午01:36:55
 */
public class CompareNumber {
	/** int最小数字的16进制 */
	private final int MIN = 0X80000000;// Integer.MIN_VALUE
	/**
	 * 比较两个数,不能分辨出相等
	 * 
	 * @param a
	 * @param b
	 * @return a >= b返回true,否则返回false
	 */
	public boolean compare(int a, int b) {
		return ((a - b) & MIN) == 0 ? true : false;
	}

	public static void main(String[] args) {
		int a = 2;
		int b = 2;
		CompareNumber cn = new CompareNumber();
		System.out.println(cn.compare(a, b));
	}
}
