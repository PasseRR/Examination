package storm;

/**
 * 给定字符串A和B,输出A和B中的最长公共子串,<BR>
 * 比如A="wepiabc" B="pabcni",则输出"abc"
 * 
 * @company 暴风影音
 * @author xiehai
 * @date 2014-2-18 下午02:31:58
 */
public class SubString {
	/**
	 * 取得两个字符串的最长且第一个出现的公共串
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public String getCommonString(String a, String b) {
		int lenA = a.length();
		int lenB = b.length();
		String longStr;
		String shortStr;
		if (lenA >= lenB) {
			longStr = a;
			shortStr = b;
		} else {
			longStr = b;
			shortStr = a;
		}
		if (longStr.contains(shortStr)) {
			return shortStr;
		} else {
			int len = shortStr.length();
			String result = null;
			for (int i = 0; i < len; ++i) {
				for (int j = i + 1; j <= len; ++j) {
					String temp = shortStr.substring(i, j);
					if (longStr.contains(temp)) {
						int currentLen = j - i;// 取得的公共串的长度,通过长度判断是否是最长公共串
						if (null == result || currentLen > result.length()) {
							result = temp;
						}
					}
				}
			}
			return result;
		}
	}
	public static void main(String[] args) {
		SubString ss = new SubString();
		String a = "wepiabc";
		String b = "pabcni";
		System.out.println(ss.getCommonString(a, b));
	}
}
