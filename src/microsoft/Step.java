package microsoft;

/**
 * 一个台阶总共有n级，如果一次可以跳1级，也可以跳2级。<BR>
 * 求总共有多少总跳法，并分析算法的时间复杂度。
 * @company 微软
 * @author xiehai
 * @date 2014-2-27 下午03:09:58 
 */
public class Step {
    /** 
     * 递归求解
     * @param n
     * @return
     */
    public int jumpMethod1(int n){
	if(1 == n || 2 == n){
	    return n;
	}else{
	    return jumpMethod1(n-1)+jumpMethod1(n-2);
	}
    }
    
    /** 
     * 迭代求解<BR>
     * 两个方法超过一定的数字就会溢出
     * @param n
     * @return
     */
    public int jumpMethod2(int n){
	if(1 == n || 2 == n){
	    return n;
	}else{
	    int an = 0;
	    int a1 = 1;
	    int a2 = 2;
	    for(; n >= 3; --n){
		an = a1+a2;
		a1 = a2;
		a2 = an;
	    }
	    return an;
	}
    }
    
    public static void main(String[] args) {
	Step step = new Step();
	System.out.println(step.jumpMethod1(20));
	System.out.println(step.jumpMethod2(20));
    }
}
