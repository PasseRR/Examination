package innovationworks;
/**
 * ��һ��int�����飬ÿ�������ڵ���֮��Ĳ�ֵ����1����-1��<br>
 * ���ڸ���һ������Ҫ�����������������е�λ��
 * 
 * @company ���¹���
 * @author xiehai
 * @date 2014-2-10 ����10:20:10
 */
public class Search {
	/**
	 * ˳���������,����ָ�����ֵ�����
	 * 
	 * @param arrays
	 * @param num
	 * @return
	 */
	public int getIndexOrder(int[] arrays, int num) {
		for (int i = 0; i < arrays.length; ++i) {
			if (arrays[i] == num) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * ��Ծ��������,ͨ����ֵ1��-1�жϲ���������
	 * 
	 * @param arrays
	 * @param num
	 * @return
	 */
	public int getIndexJump(int[] arrays, int num) {
		for (int i = 0; i < arrays.length; i += 2) {
			if (arrays[i] == num) {
				return i;
			} else if (1 == (arrays[i] - num) || -1 == (arrays[i] - num)) {
				if (i - 1 >= 0 && arrays[i - 1] == num) {
					return i - 1;
				} else if (i + 1 < arrays.length && arrays[i + 1] == num) {
					return i + 1;
				}
			}
		}

		return -1;
	}

	public static void main(String[] args) {
		int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Search search = new Search();
		System.out.println(search.getIndexJump(arrays, 0));
	}
}
