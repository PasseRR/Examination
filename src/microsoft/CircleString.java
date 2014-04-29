package microsoft;

/**
 * 判断一个字符串是否回文
 * 
 * @company 微软
 * @author xiehai
 * @date 2014-2-18 下午03:47:46
 */
public class CircleString {
	/**
	 * 利用Java的API判断<BR>
	 * 直接将所给的字符串倒置,看是否和原字符串相同
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
		int i = 0;// 头遍历开始位置
		int j = size - 1;// 尾遍历开始位置
		boolean flg = true;
		int leftMid;// 前一段终点
		int rightMid;// 后一段终点
		leftMid = rightMid = size / 2;
		if (1 == size % 2) {// 若字母个数为奇数,
			rightMid = size / 2 + 1;
		}
		while (i < leftMid && j >= rightMid) {// 头尾比较,若所有均为相同则为true,否则为false
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
