package thoughtworks;

/**
 * 你是一名体育老师，在某次课距离下课还有五分钟时，你决定搞一个游戏。<BR>
 * 此时有100名学生在上课。游戏的规则是：<BR>
 * 1. 你首先说出三个不同的特殊数，要求必须是个位数，比如3、5、7。<BR>
 * 2. 让所有学生拍成一队，然后按顺序报数。<BR>
 * 3. 学生报数时，如果所报数字是第一个特殊数(3)的倍数，那么不能说该数字，而要说Fizz；<BR>
 *    如果所报数字是第二个特殊数(5)的倍数，那么要说Buzz；<BR>
 *    如果所报数字是第三个特殊数(7)的倍数，那么要说Whizz。<BR>
 * 4. 学生报数时，如果所报数字同时是两个特殊数的倍数情况下，也要特殊处理，<BR>
 *    比如第一个特殊数和第二个特殊数的倍数，那么不能说该数字，而是要说FizzBuzz, 以此类推。<BR>
 *    如果同时是三个特殊数的倍数，那么要说FizzBuzzWhizz。<BR>
 * 5. 学生报数时，如果所报数字包含了第一个特殊数，那么也不能说该数字，而是要说相应的单词，<BR>
 *    比如本例中第一个特殊数是3，那么要报13的同学应该说Fizz。如果数字中包含了第一个特殊数，<BR>
 *    那么忽略规则3和规则4，比如要报35的同学只报Fizz，不报BuzzWhizz。<BR>
 * @company thoughtworks
 * @author xiehai
 * @date 2014年4月29日 下午1:41:33 
 */
public class CountOff {
	private int first;
	private int second;
	private int third;
	/**表达式Fizz*/
	private final String FIZZ = "Fizz";
	/**表达式Buzz*/
	private final String BUZZ = "Buzz";
	/**表达式Whizz*/
	private final String WHIZZ = "Whizz";
	/**空字符串*/
	private final String EMPTY = "";
	public CountOff(int a, int b, int c) {
		this.first = a;
		this.second = b;
		this.third = c;
	}
	
	/**
	 * 输入是否是3个数字的倍数<BR>
	 * 返回字符串对应规则3, 4
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
	 * 输入数字是否包含3个数字<BR>
	 * 返回字符串对应规则5
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
	 * 获得应该报出的数字或单词
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
