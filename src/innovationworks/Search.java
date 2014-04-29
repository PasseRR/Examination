package innovationworks;
/**
 * 有一个int型数组，每两个相邻的数之间的差值不是1就是-1。<br>
 * 现在给定一个数，要求查找这个数在数组中的位置
 * 
 * @company 创新工厂
 * @author xiehai
 * @date 2014-2-10 上午10:20:10
 */
public class Search {
	/**
	 * 顺序查找数组,返回指定数字的索引
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
	 * 跳跃查找数组,通过差值1和-1判断并返回索引
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
