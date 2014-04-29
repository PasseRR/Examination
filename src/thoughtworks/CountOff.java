package thoughtworks;

/**
 * ����һ��������ʦ����ĳ�οξ����¿λ��������ʱ���������һ����Ϸ��<BR>
 * ��ʱ��100��ѧ�����ϿΡ���Ϸ�Ĺ����ǣ�<BR>
 * 1. ������˵��������ͬ����������Ҫ������Ǹ�λ��������3��5��7��<BR>
 * 2. ������ѧ���ĳ�һ�ӣ�Ȼ��˳������<BR>
 * 3. ѧ������ʱ��������������ǵ�һ��������(3)�ı�������ô����˵�����֣���Ҫ˵Fizz��<BR>
 *    ������������ǵڶ���������(5)�ı�������ôҪ˵Buzz��<BR>
 *    ������������ǵ�����������(7)�ı�������ôҪ˵Whizz��<BR>
 * 4. ѧ������ʱ�������������ͬʱ�������������ı�������£�ҲҪ���⴦��<BR>
 *    �����һ���������͵ڶ����������ı�������ô����˵�����֣�����Ҫ˵FizzBuzz, �Դ����ơ�<BR>
 *    ���ͬʱ�������������ı�������ôҪ˵FizzBuzzWhizz��<BR>
 * 5. ѧ������ʱ������������ְ����˵�һ������������ôҲ����˵�����֣�����Ҫ˵��Ӧ�ĵ��ʣ�<BR>
 *    ���籾���е�һ����������3����ôҪ��13��ͬѧӦ��˵Fizz����������а����˵�һ����������<BR>
 *    ��ô���Թ���3�͹���4������Ҫ��35��ͬѧֻ��Fizz������BuzzWhizz��<BR>
 * @company thoughtworks
 * @author xiehai
 * @date 2014��4��29�� ����1:41:33 
 */
public class CountOff {
	private int first;
	private int second;
	private int third;
	/**���ʽFizz*/
	private final String FIZZ = "Fizz";
	/**���ʽBuzz*/
	private final String BUZZ = "Buzz";
	/**���ʽWhizz*/
	private final String WHIZZ = "Whizz";
	/**���ַ���*/
	private final String EMPTY = "";
	public CountOff(int a, int b, int c) {
		this.first = a;
		this.second = b;
		this.third = c;
	}
	
	/**
	 * �����Ƿ���3�����ֵı���<BR>
	 * �����ַ�����Ӧ����3, 4
	 * @param num
	 * @return
	 */
	private String isTimes(int num){
		StringBuilder sb = new StringBuilder();
		if(num%first == 0){
			sb.append(FIZZ);
		}
		if(num%second == 0){
			sb.append(BUZZ);
		}
		if(num%third == 0){
			sb.append(WHIZZ);
		}
		
		return sb.toString();
	}
	
	/**
	 * ���������Ƿ����3������<BR>
	 * �����ַ�����Ӧ����5
	 * @param num
	 * @return
	 */
	private String isContains(int num) {
		StringBuilder sb = new StringBuilder();
		if(String.valueOf(num).contains(String.valueOf(first))){
			sb.append(FIZZ);
		}
		
		return sb.toString();
	}
	
	/**
	 * ���Ӧ�ñ��������ֻ򵥴�
	 * @param num
	 * @return
	 */
	public String getCount(int num){
		String contains = isContains(num);
		if(EMPTY.equals(contains)){
			String times = isTimes(num);
			if(EMPTY.equals(times)){
				return String.valueOf(num);
			}else {
				return times;
			}
		}else {
			return contains;
		}
	}

	/**
	 * @return the first
	 */
	public int getFirst() {
		return first;
	}

	/**
	 * @return the second
	 */
	public int getSecond() {
		return second;
	}

	/**
	 * @return the third
	 */
	public int getThird() {
		return third;
	}
	
	public static void main(String[] args) {
		CountOff countOff = new CountOff(3, 5, 7);
		for(int i = 1; i < 101; ++i){
			System.out.println(countOff.getCount(i));
		}
	}
}
