package google;

import java.math.BigDecimal;

/**
 * 1024!末尾有多少个0
 * @company 谷歌
 * @author xiehai
 * @date 2014-2-14 上午10:58:39 
 */
public class Factorial {
    /** 
     * 获得一个数的阶乘,返回BigDecimal
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
     * 获得一个数阶乘的0的个数<BR>
     * 1 每隔5个就会产生一个0,比如5,10,15,20....<BR>
     * 2 每隔5*5个就会产生一个0,比如25,50,75....<BR>
     * 3 每隔5*5*5个就会产生一个0,比如125,250...<BR>
     * 4 每隔m*5^n个就会产生一个0
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
