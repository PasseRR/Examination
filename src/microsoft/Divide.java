package microsoft;

/**
 * ���ʵ�������������ĳ�������Ȼ�����ó�����������
 * 
 * @company ΢��
 * @author xiehai
 * @date 2014-2-13 ����01:52:55
 */
public class Divide {
	/**
	 * ����������
	 * 
	 * @param a
	 *            ������
	 * @param b
	 *            ����
	 * @return
	 */
	public int divide(final int a, final int b) {
		int x = a;
		int y = b;
		int result = 0;
		boolean flgA = false;
		boolean flgB = false;// �Ƿ�Ϊ����
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
