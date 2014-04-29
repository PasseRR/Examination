package microsoft;

/**
 * �ж�һ���ַ����Ƿ����
 * 
 * @company ΢��
 * @author xiehai
 * @date 2014-2-18 ����03:47:46
 */
public class CircleString {
	/**
	 * ����Java��API�ж�<BR>
	 * ֱ�ӽ��������ַ�������,���Ƿ��ԭ�ַ�����ͬ
	 * 
	 * @param str
	 * @return
	 */
	public boolean isCircleStringApi(String str) {
		String temp = new StringBuilder(str).reverse().toString();
		return temp.equals(str) ? true : false;
	}

	public boolean isCircleString(String str) {
		char[] data = str.toCharArray();
		int size = data.length;
		int i = 0;// ͷ������ʼλ��
		int j = size - 1;// β������ʼλ��
		boolean flg = true;
		int leftMid;// ǰһ���յ�
		int rightMid;// ��һ���յ�
		leftMid = rightMid = size / 2;
		if (1 == size % 2) {// ����ĸ����Ϊ����,
			rightMid = size / 2 + 1;
		}
		while (i < leftMid && j >= rightMid) {// ͷβ�Ƚ�,�����о�Ϊ��ͬ��Ϊtrue,����Ϊfalse
			char head = data[i];
			char tail = data[j];
			if (head != tail) {
				flg = false;
				break;
			}
			i++;
			j--;
		}

		return flg;
	}

	public static void main(String[] args) {
		String str = "cad";
		CircleString cs = new CircleString();
		System.out.println(cs.isCircleStringApi(str));
		System.out.println(cs.isCircleString(str));
	}
}
