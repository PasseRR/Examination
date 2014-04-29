package microsoft;

import java.math.BigInteger;

/**
 * 大数的加减乘除<BR>
 * 只考虑整数的情况,未考虑异常情况
 * 
 * @company 微软
 * @author xiehai
 * @date 2014-2-21 下午04:55:52
 */
public class BigNumber {
	/**
	 * 大数加法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String add(String a, String b) {
		if (a.length() < b.length()) {// 保证a是长度较长的那个数字
			String temp = a;
			a = b;
			b = temp;
		}
		StringBuilder result = new StringBuilder();
		int lenA = a.length();
		int lenB = b.length();
		int upper = 0;// 进位
		int i = lenA - 1;
		int j = lenB - 1;
		while (i >= 0 && j >= 0) {// 从低位到高位依次相加
			int numA = a.charAt(i) - 48;
			int numB = b.charAt(j) - 48;
			int sum = numA + numB + upper;
			if (sum / 10 > 0) {
				upper = sum / 10;
			} else {
				upper = 0;
			}
			result.append(sum % 10);
			i--;
			j--;
		}
		for (i = lenA - lenB - 1; i >= 0; --i) {// 计算长度较长的数字余下的
			int numA = a.charAt(i) - 48;
			int sum = numA + upper;
			if (sum / 10 > 0) {
				upper = sum / 10;
			} else {
				upper = 0;
			}
			result.append(sum % 10);
		}
		return result.reverse().toString();
	}

	/**
	 * 大数减法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String substract(String a, String b) {
		boolean isNegative = false;// 结果是否为负
		if (a.length() != b.length()) {
			if (a.length() < b.length()) {
				isNegative = true;
			}
		} else {
			if (a.compareTo(b) < 0) {
				isNegative = true;
			}
		}
		if (isNegative) {// 如果被减数大于减数,交换两个数的位置
			String temp = a;
			a = b;
			b = temp;
		}
		int lenA = a.length();
		int lenB = b.length();
		int upper = 0;// 借位
		int i = lenA - 1;
		int j = lenB - 1;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 && j >= 0) {// 从低位到高位依次相减
			int numA = a.charAt(i) - 48;
			int numB = b.charAt(j) - 48;
			int result = numA - numB - upper;
			if (result < 0) {
				upper = 1;
				result += 10;
			} else {
				upper = 0;
			}
			sb.append(result);
			i--;
			j--;
		}
		for (i = lenA - lenB - 1; i >= 0; --i) {// 计算长度较长的数字余下的
			int numA = a.charAt(i) - 48;
			int result = numA - upper;
			if (result < 0) {
				result += 10;
				upper = 1;
			} else {
				upper = 0;
			}
			sb.append(result);
		}
		for (i = sb.length() - 1; i > 0; --i) {
			if (sb.charAt(i) == '0') {
				continue;
			} else {
				break;
			}
		}
		sb = new StringBuilder(sb.substring(0, i + 1));
		if (isNegative) {
			sb.append("-");
		}

		return sb.reverse().toString();
	}

	/**
	 * 大数乘法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String multiply(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		StringBuilder result = new StringBuilder("0");
		int zero = 0;// 末尾加零的个数
		for (int i = lenB - 1; i >= 0; --i) {
			int numB = b.charAt(i) - 48;
			int upper = 0;// 进位
			StringBuilder sb = new StringBuilder();// 没一个数字与乘数的结果
			if (0 == numB) {
				zero++;
				continue;
			}
			for (int j = lenA - 1; j >= 0; --j) {
				int numA = a.charAt(j) - 48;
				int multi = numA * numB + upper;
				if (multi / 10 > 0) {
					upper = multi / 10;
				} else {
					upper = 0;
				}
				sb.append(multi % 10);
			}
			if (upper != 0) {// 如果进位了且最高位计算完毕,则进位的数字直接为最高位
				sb.append(upper);
				upper = 0;
			}
			sb.reverse();
			for (int k = 0; k < zero; ++k) {// 计算在数字后面添加0
				sb.append("0");
			}
			result = new StringBuilder(add(result.toString(), sb.toString()));
			zero++;
		}

		return result.toString();
	}

	/**
	 * 大数除法
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String divide(String a, String b) {
		int result = 0;
		if (a.length() == b.length()) {
			if (a.compareTo(b) < 0) {
				return String.valueOf(result);
			} else if (a.compareTo(b) == 0) {
				result = 1;
			} else {
				while (true) {
					a = substract(a, b);
					if (a.indexOf("-") != -1) {
						break;
					}
					result++;
				}
			}
		} else {
			if (a.length() < b.length()) {
				return String.valueOf(result);
			} else {
				int lenA = a.length();
				int lenB = b.length();
				// 最大商0的个数
				// 比如 除数是12345 被除数是112 此时假设最大商是100
				// 如果12345-112*100>0 则,在结果上加100,否则,先用10去商
				int zero = lenA - lenB;
				String div = "1";// 假设最大商
				String divResult = "0";// 计算结果
				for (int i = 0; i < zero; ++i) {
					div += "0";
				}
				while (true) {
					String tempA = substract(a, multiply(b, div));
					if (tempA.indexOf("-") == -1) {
						divResult = add(divResult, div);// 运用大数加法相加
						a = substract(a, multiply(b, div));// 大数减法减去倍数
					} else {
						if ("1".equals(div)) {// 如果以被除数的1倍去商结果为负,则跳出循环
							break;
						} else {// 否则,此时是以被除数的1*10^n倍去商,然后n减去1,这里是用的字符串表示,直接截取到最后一个0处
							div = div.substring(0, div.length() - 1);
						}
					}
				}
				return divResult;
			}
		}

		return String.valueOf(result);
	}

	public static void main(String[] args) {
		String a = "151412341312341324312431245321531243214321122";
		String b = "12132452";
		BigNumber bn = new BigNumber();
		System.out.println(bn.add(a, b));
		System.out.println(new BigInteger(a).add(new BigInteger(b)));// 使用BigInteger测试计算结果
		System.out.println(bn.substract(a, b));
		System.out.println(new BigInteger(a).subtract(new BigInteger(b)));// 使用BigInteger测试计算结果
		System.out.println(bn.substract(b, a));
		System.out.println(new BigInteger(b).subtract(new BigInteger(a)));// 使用BigInteger测试计算结果
		System.out.println(bn.multiply(a, b));
		System.out.println(new BigInteger(a).multiply(new BigInteger(b)));// 使用BigInteger测试计算结果
		System.out.println(bn.divide(a, b));
		System.out.println(new BigInteger(a).divide(new BigInteger(b)));// 使用BigInteger测试计算结果
	}
}
