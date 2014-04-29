package microsoft;

/**
 * ����һ����������������Ķ����Ʊ�����ж��ٸ�1��<BR>
 * ��������10������������Ʊ�ʾΪ1010��������1��������2��
 * 
 * @company ΢��
 * @author xiehai
 * @date 2014-2-27 ����03:52:38
 */
public class CountOfOne {
	/**
	 * ��λ�����ý��
	 * 
	 * @param num
	 * @return
	 */
	public int getCountOfOne(int num) {
		int count = 0;
		while (num != 0) {
			count += num & 1;// ���λ��1����������,������λ��1,��1�ĸ�������,������Ϊ0
			num >>= 1;// ÿ����һ��,������һλ
		}

		return count;
	}

	/**
	 * �ó�����ý��
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
		System.out.println(coo.getCountOfOne(num));// ����1�ĸ���
		System.out.println(coo.getCountOfOneDivide(num));
		System.out.println(Integer.toBinaryString(num));// �������ֵĶ�������ʽ
	}
}
