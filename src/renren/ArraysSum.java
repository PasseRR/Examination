package renren;

/**
 * 给定一个有序数组,和一个数n,判断数组中是否存在两个数的和为n
 * 
 * @company 人人网
 * @author xiehai
 * @date 2014-2-14 下午02:38:42
 */
public class ArraysSum {
	/**
	 * 穷举法获得结果 <BR>
	 * 暴力解决O(n*n)
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
	 * 因为数组是有序的,所以从两头开始遍历<BR>
	 * 当头尾相加大于n,则尾向前移动;<BR>
	 * 当头尾相加小于n,则头向后移动.<BR>
	 * 保证数组是升序的,O(n)
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
