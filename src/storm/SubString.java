package storm;

/**
 * �����ַ���A��B,���A��B�е�������Ӵ�,<BR>
 * ����A="wepiabc" B="pabcni",�����"abc"
 * 
 * @company ����Ӱ��
 * @author xiehai
 * @date 2014-2-18 ����02:31:58
 */
public class SubString {
	/**
	 * ȡ�������ַ�������ҵ�һ�����ֵĹ�����
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
						int currentLen = j - i;// ȡ�õĹ������ĳ���,ͨ�������ж��Ƿ����������
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
