package tencent;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 五笔的编码范围是a ~ y的25个字母，从1位到4位的编码，<BR>
 * 如果我们把五笔的编码按字典序排序，形成一个数组如下：<BR>
 * a, aa, aaa, aaaa, aaab, aaac, … …, b, ba, baa, baaa, baab, baac … …, yyyw,
 * yyyx, yyyy<BR>
 * 其中a的Index为0，aa的Index为1，aaa的Index为2，以此类推。<BR>
 * 1)编写一个函数，输入是任意一个编码，比如baca，输出这个编码对应的Index；<BR>
 * 2)编写一个函数，输入是任意一个Index，比如12345，输出这个Index对应的编码。<BR>
 * 
 * @company 腾讯
 * @author xiehai
 * @date 2014-2-27 下午05:28:04
 */
public class FiveStrokeCoding {
	private Map<String, Integer> dict = new HashMap<String, Integer>();

	/** 字符串与字符串索引相差的间隔 */
	private final int[] FACTOR = {25 * 25 * 25 + 25 * 25 + 25 + 1, 1, 25 + 1,
			25 * 25 + 25 + 1};

	public FiveStrokeCoding() {
		this.initDict();
	}

	/**
	 * 初始化字典
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
	 * 获得指定字符串的索引
	 * 
	 * @param code
	 * @return
	 */
	public int encode(String code) {
		return dict.get(code);
	}

	/**
	 * 通过索引获得指定字符串
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
