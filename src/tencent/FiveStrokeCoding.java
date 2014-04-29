package tencent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * ��ʵı��뷶Χ��a ~ y��25����ĸ����1λ��4λ�ı��룬<BR>
 * ������ǰ���ʵı��밴�ֵ��������γ�һ���������£�<BR>
 * a, aa, aaa, aaaa, aaab, aaac, �� ��, b, ba, baa, baaa, baab, baac �� ��, yyyw,
 * yyyx, yyyy<BR>
 * ����a��IndexΪ0��aa��IndexΪ1��aaa��IndexΪ2���Դ����ơ�<BR>
 * 1)��дһ������������������һ�����룬����baca�������������Ӧ��Index��<BR>
 * 2)��дһ������������������һ��Index������12345��������Index��Ӧ�ı��롣<BR>
 * 
 * @company ��Ѷ
 * @author xiehai
 * @date 2014-2-27 ����05:28:04
 */
public class FiveStrokeCoding {
	private Map<String, Integer> dict = new HashMap<String, Integer>();

	/** �ַ������ַ����������ļ�� */
	private final int[] FACTOR = {25 * 25 * 25 + 25 * 25 + 25 + 1, 1, 25 + 1,
			25 * 25 + 25 + 1};

	public FiveStrokeCoding() {
		this.initDict();
	}

	/**
	 * ��ʼ���ֵ�
	 */
	private void initDict() {
		int index = 0;
		for (char c = 'a'; c < 'z'; ++c) {// a,b,c...y
			dict.put(String.valueOf(c), index);
			index += 25 + 25 * 25 + 25 * 25 * 25 + 1;
		}
		index = 1;
		for (char i = 'a'; i < 'z'; ++i) {// aa,ab,ac......ya,yb...yy
			char[] data = new char[2];
			data[0] = i;
			for (char j = 'a'; j < 'z'; ++j) {// aa,ab,ac...ay
				data[1] = j;
				dict.put(new String(data), index);
				index++;
			}
			index += 25 + 25 * 25 + 25 * 25 * 25 + 1;
		}
		index = 1 + 25;
		for (char i = 'a'; i < 'z'; ++i) {// aaa,aab,aac......yyy
			char[] data = new char[3];
			data[0] = i;
			for (char j = 'a'; j < 'z'; ++j) {
				data[1] = j;
				for (char k = 'a'; k < 'z'; ++k) {
					data[2] = k;
					dict.put(new String(data), index);
					index++;
				}
			}
			index += 25 + 25 * 25 + 25 * 25 * 25 + 1;
		}
		index = 1 + 25 + 25 * 25;
		for (char i = 'a'; i < 'z'; ++i) {
			char[] data = new char[4];
			data[0] = i;
			for (char j = 'a'; j < 'z'; ++j) {
				data[1] = j;
				for (char m = 'a'; m < 'z'; ++m) {
					data[2] = m;
					for (char n = 'a'; n < 'z'; ++n) {
						data[3] = n;
						dict.put(new String(data), index);
						index++;
					}
				}
			}
			index += 25 + 25 * 25 + 25 * 25 * 25 + 1;
		}
	}

	/**
	 * ���ָ���ַ���������
	 * 
	 * @param code
	 * @return
	 */
	public int encode(String code) {
		return dict.get(code);
	}

	/**
	 * ͨ���������ָ���ַ���
	 * 
	 * @param index
	 * @return
	 */
	public String decode(int index) {
		Iterator<String> it = dict.keySet().iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (dict.get(key) == index) {
				return key;
			}
		}

		return null;
	}

	public int getIndex(String code) {
		int len = code.length();
		int index = len - 1;
		for (int i = 0; i < len; ++i) {
			char current = code.charAt(i);
			index += FACTOR[i] * (current - 'a');
		}

		return index;
	}

	public static void main(String[] args) {
		FiveStrokeCoding fsc = new FiveStrokeCoding();
		System.out.println(fsc.encode("abcd"));
		System.out.println(fsc.getIndex("abcd"));
		System.out.println(fsc.decode(123));
	}
}
