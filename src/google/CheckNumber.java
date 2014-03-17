package google;

/**
 * 判断一个自然数是否是某个数的平方,不能使用开方运算
 * @company 谷歌
 * @author xiehai
 * @date 2014-2-13 下午04:59:01 
 */
public class CheckNumber {
    /** 
     * 循环0到n,计算是否是某个数字的平方
     * @param n
     * @return
     */
    public int isNumberOfSquare(int n){
	for(int i = 0; i <= n/2; ++i){
	    if(i*i == n){
		return i;
	    }
	}
	
	return -1;
    }
    
    /** 
     * 二分查找平方根,只精确到int范围
     * @param n 
     * @param start
     * @param end
     * @return
     */
    public int isNumuerOfSquare(int n, int start, int end){
	int mid;
	int sum;
	while(start <= end){
	    sum = start+end;
	    if(sum%2 == 0){
		mid = sum/2;
	    }else{
		mid = sum/2+1;
	    }
	    if(mid*mid > n){
		end = mid;
	    }else if(mid*mid < n){
		start = mid;
	    }else if(mid*mid == n){
		return mid;
	    }
	}
	
	return -1;
    }
    
    public static void main(String[] args) {
	int n = 1000000;
	CheckNumber cn = new CheckNumber();
	System.out.println(cn.isNumberOfSquare(n));
	System.out.println(cn.isNumuerOfSquare(n, 0, n/2+1));
//	System.out.println(500000*500000);
    }
}
