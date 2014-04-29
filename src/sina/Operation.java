package sina;

/**
 * ��ֻʹ��++�������������,ʵ�ּӡ������ˡ������ܡ�<br>
 * ���������ȫΪ������
 * 
 * @company ����
 * @author xiehai
 * @date 2014-2-7 ����05:07:56
 */
public class Operation {
	/**
	 * ֻʹ��++ʵ�ּӷ�
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
	 * ֻʹ��++ʵ�ּ���
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int substract(int a, int b) {
		int c = 0;
		boolean flg = true;// true���ؽ��Ϊ��,false���ؽ��Ϊ��
		if (a < b) {// ������������ڼ���,����������ֵ,�������ؽ����Ϊ����
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
	 * ֻʹ��++ʵ�ּ���(a-b = -b+a)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int minus(int a, int b) {
		return add(-b, a);
	}

	/**
	 * ֻʹ��++ʵ�ֳ˷�
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
	 * ֻʹ��++ʵ�ֳ���
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
