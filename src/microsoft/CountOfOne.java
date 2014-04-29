package microsoft;

/**
 * 输入一个整数，求该整数的二进制表达中有多少个1。<BR>
 * 例如输入10，由于其二进制表示为1010，有两个1，因此输出2。
 * 
 * @company 微软
 * @author xiehai
 * @date 2014-2-27 下午03:52:38
 */
public class CountOfOne {
	/**
	 * 用位运算获得结果
	 * 
	 * @param num
	 * @return
	 */
	public int getCountOfOne(int num) {
		int count = 0;
		while (num != 0) {
			count += num & 1;// 最低位与1进行与运算,如果最低位是1,则1的个数增加,否则结果为0
			num >>= 1;// 每计算一次,向右移一位
		}

		return count;
	}

	/**
	 * 用除法获得结果
	 * 
	 * @param num
	 * @return
	 */
	public int getCountOfOneDivide(int num) {
		int count = 0;
		while (num != 0) {
			count += num % 2;
			num /= 2;
		}

		return count;
	}

	public static void main(String[] args) {
		CountOfOne coo = new CountOfOne();
		int num = 100;
		System.out.println(coo.getCountOfOne(num));// 包含1的个数
		System.out.println(coo.getCountOfOneDivide(num));
		System.out.println(Integer.toBinaryString(num));// 输入数字的二进制形式
	}
}
