package renren;

/**
 * ����һ����������,��һ����n,�ж��������Ƿ�����������ĺ�Ϊn
 * 
 * @company ������
 * @author xiehai
 * @date 2014-2-14 ����02:38:42
 */
public class ArraysSum {
	/**
	 * ��ٷ���ý�� <BR>
	 * �������O(n*n)
	 * 
	 * @param arrays
	 * @param n
	 * @return
	 */
	public boolean getResultForce(final int[] arrays, final int n) {
		int len = arrays.length;
		for (int i = 0; i < len; ++i) {
			for (int j = i + 1; j < len; ++j) {
				if (n == (arrays[i] + arrays[j])) {
					System.out.println(arrays[i] + " + " + arrays[j] + " = "
							+ n);
					return true;
				}
			}
		}

		return false;
	}

	/**
	 * ��Ϊ�����������,���Դ���ͷ��ʼ����<BR>
	 * ��ͷβ��Ӵ���n,��β��ǰ�ƶ�;<BR>
	 * ��ͷβ���С��n,��ͷ����ƶ�.<BR>
	 * ��֤�����������,O(n)
	 * 
	 * @param arrays
	 * @param n
	 * @return
	 */
	public boolean getResultHeadAndTail(final int[] arrays, final int n) {
		int head = 0;
		int tail = arrays.length - 1;
		while (head < tail) {
			if (arrays[head] + arrays[tail] > n) {
				tail--;
			} else if (arrays[head] + arrays[tail] < n) {
				head++;
			} else {
				System.out.println(arrays[head] + " + " + arrays[tail] + " = "
						+ n);
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[] arrays = {1, 3, 4, 7, 9, 10, 15};
		ArraysSum as = new ArraysSum();
		int n = 16;
		as.getResultForce(arrays, n);
		as.getResultHeadAndTail(arrays, n);
	}
}
