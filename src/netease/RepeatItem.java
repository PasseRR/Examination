package netease;

/**
 * 1-1000放在含有1001个元素的数组中，只有唯一的一个元素值重复，<BR>
 * 其它均只出现一次。每个数组元素只能访问一次，设计一个算法，<BR>
 * 将它找出来；不用辅助存储空间，能否设计一个算法实现？<BR>
 * @company 网易
 * @author xiehai
 * @date 2014-2-20 下午02:48:14 
 */
public class RepeatItem {
    private int []arrays;
    public RepeatItem(int []arrays){
	this.arrays = arrays;
    }
   
    /** 
     * 利用差值求的重复的元素
     * @return
     */
    public int method1(){
	long sum = 0;
	long realSum = 0;
	for(int i = 1; i < arrays.length; ++i){//计算1到n的和
	    sum += i;
	}
	for(int i = 0; i < arrays.length; ++i){//计算数组的所有元素的和
	    realSum += arrays[i];
	}
	//两个和相减就是重复的那个数字
	return (int) (realSum - sum);
    }
    
    /** 
     * 利用数组内容与下标的特殊关系
     * @return
     */
    public int method2(){
	int i = 0;
	while(true){
	    if(arrays[i] < 0){
		break;
	    }
	    arrays[i] *= -1;//访问过的数字 记录成负数
	    i = -arrays[i];//因为是顺序的,将当前下标置为前一个元素内容
	}
	return i;
    }
    
    /** 
     * A ^ 0 = A;此时A不变<BR>
     * A ^ A = 0;此时A为0<BR>
     * 按照此规律可得出,异或两次得到原数字
     * @return
     */
    public int method3(){
	int result = 0;
	for(int i = 1; i < arrays.length; ++i){
	    result ^= i;
	}
	for(int i = 0; i < arrays.length; ++i){
	    result ^= arrays[i];
	}
	
	return result;
    }
    
    public static void main(String[] args) {
	int []arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 5};
	RepeatItem ri = new RepeatItem(arrays);
	System.out.println(ri.method3());
	System.out.println(ri.method1());
	System.out.println(ri.method2());
    }
}
