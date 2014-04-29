package microsoft;

import java.math.BigInteger;

/**
 * �����ļӼ��˳�<BR>
 * ֻ�������������,δ�����쳣���
 * 
 * @company ΢��
 * @author xiehai
 * @date 2014-2-21 ����04:55:52
 */
public class BigNumber {
	/**
	 * �����ӷ�
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String add(String a, String b) {
		if (a.length() < b.length()) {// ��֤a�ǳ��Ƚϳ����Ǹ�����
			String temp = a;
			a = b;
			b = temp;
		}
		StringBuilder result = new StringBuilder();
		int lenA = a.length();
		int lenB = b.length();
		int upper = 0;// ��λ
		int i = lenA - 1;
		int j = lenB - 1;
		while (i >= 0 && j >= 0) {// �ӵ�λ����λ�������
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
		for (i = lenA - lenB - 1; i >= 0; --i) {// ���㳤�Ƚϳ����������µ�
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
	 * ��������
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String substract(String a, String b) {
		boolean isNegative = false;// ����Ƿ�Ϊ��
		if (a.length() != b.length()) {
			if (a.length() < b.length()) {
				isNegative = true;
			}
		} else {
			if (a.compareTo(b) < 0) {
				isNegative = true;
			}
		}
		if (isNegative) {// ������������ڼ���,������������λ��
			String temp = a;
			a = b;
			b = temp;
		}
		int lenA = a.length();
		int lenB = b.length();
		int upper = 0;// ��λ
		int i = lenA - 1;
		int j = lenB - 1;
		StringBuilder sb = new StringBuilder();
		while (i >= 0 && j >= 0) {// �ӵ�λ����λ�������
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
		for (i = lenA - lenB - 1; i >= 0; --i) {// ���㳤�Ƚϳ����������µ�
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
	 * �����˷�
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String multiply(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		StringBuilder result = new StringBuilder("0");
		int zero = 0;// ĩβ����ĸ���
		for (int i = lenB - 1; i >= 0; --i) {
			int numB = b.charAt(i) - 48;
			int upper = 0;// ��λ
			StringBuilder sb = new StringBuilder();// ûһ������������Ľ��
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
			if (upper != 0) {// �����λ�������λ�������,���λ������ֱ��Ϊ���λ
				sb.append(upper);
				upper = 0;
			}
			sb.reverse();
			for (int k = 0; k < zero; ++k) {// ���������ֺ������0
				sb.append("0");
			}
			result = new StringBuilder(add(result.toString(), sb.toString()));
			zero++;
		}

		return result.toString();
	}

	/**
	 * ��������
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
				// �����0�ĸ���
				// ���� ������12345 ��������112 ��ʱ�����������100
				// ���12345-112*100>0 ��,�ڽ���ϼ�100,����,����10ȥ��
				int zero = lenA - lenB;
				String div = "1";// ���������
				String divResult = "0";// ������
				for (int i = 0; i < zero; ++i) {
					div += "0";
				}
				while (true) {
					String tempA = substract(a, multiply(b, div));
					if (tempA.indexOf("-") == -1) {
						divResult = add(divResult, div);// ���ô����ӷ����
						a = substract(a, multiply(b, div));// ����������ȥ����
					} else {
						if ("1".equals(div)) {// ����Ա�������1��ȥ�̽��Ϊ��,������ѭ��
							break;
						} else {// ����,��ʱ���Ա�������1*10^n��ȥ��,Ȼ��n��ȥ1,�������õ��ַ�����ʾ,ֱ�ӽ�ȡ�����һ��0��
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
		System.out.println(new BigInteger(a).add(new BigInteger(b)));// ʹ��BigInteger���Լ�����
		System.out.println(bn.substract(a, b));
		System.out.println(new BigInteger(a).subtract(new BigInteger(b)));// ʹ��BigInteger���Լ�����
		System.out.println(bn.substract(b, a));
		System.out.println(new BigInteger(b).subtract(new BigInteger(a)));// ʹ��BigInteger���Լ�����
		System.out.println(bn.multiply(a, b));
		System.out.println(new BigInteger(a).multiply(new BigInteger(b)));// ʹ��BigInteger���Լ�����
		System.out.println(bn.divide(a, b));
		System.out.println(new BigInteger(a).divide(new BigInteger(b)));// ʹ��BigInteger���Լ�����
	}
}
