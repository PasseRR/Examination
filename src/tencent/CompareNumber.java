package tencent;

/**
 * �Ƚ�������a��b�Ĵ�С������ʹ�ô��ڡ�С�ڡ�if���
 * 
 * @company ��Ѷ
 * @author xiehai
 * @date 2014-2-13 ����01:36:55
 */
public class CompareNumber {
	/** int��С���ֵ�16���� */
	private final int MIN = 0X80000000;// Integer.MIN_VALUE
	/**
	 * �Ƚ�������,���ֱܷ�����
	 * 
	 * @param a
	 * @param b
	 * @return a >= b����true,���򷵻�false
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
