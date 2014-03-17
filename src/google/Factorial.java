package google;

import java.math.BigDecimal;

/**
 * 1024!ĩβ�ж��ٸ�0
 * @company �ȸ�
 * @author xiehai
 * @date 2014-2-14 ����10:58:39 
 */
public class Factorial {
    /** 
     * ���һ�����Ľ׳�,����BigDecimal
     * @param n
     * @return
     */
    public BigDecimal factorial(int n){
	if(n == 0 || n == 1){
	    return new BigDecimal(1);
	}else{
	    return new BigDecimal(n).multiply(factorial(n-1));
	}
    }
    
    /** 
     * ���һ�����׳˵�0�ĸ���<BR>
     * 1 ÿ��5���ͻ����һ��0,����5,10,15,20....<BR>
     * 2 ÿ��5*5���ͻ����һ��0,����25,50,75....<BR>
     * 3 ÿ��5*5*5���ͻ����һ��0,����125,250...<BR>
     * 4 ÿ��m*5^n���ͻ����һ��0
     * @param num
     * @return
     */
    public int getZeroOfFactorial(int num){
	int count = 0;
	int current = 5;
	while(current <= num){
	    count += num/current;
	    current *= 5;
	}
	
	return count;
    }
    
    public static void main(String[] args) {
	Factorial factorial = new Factorial();
	System.out.println(factorial.factorial(1001));
	System.out.println(factorial.getZeroOfFactorial(1001));
    }
}
