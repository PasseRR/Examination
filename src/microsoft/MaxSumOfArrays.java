package microsoft;

/**
 * 输入一个整形数组，数组里有正数也有负数。<BR>
 * 数组中连续的一个或多个整数组成一个子数组，每个子数组都有一个和。<BR>
 * 求所有子数组的和的最大值。要求时间复杂度为O(n)。
 * @company 微软
 * @author xiehai
 * @date 2014-2-27 下午01:52:38 
 */
public class MaxSumOfArrays {
    /** 
     * 获得数组最大子数组和
     * @param arrays
     * @return
     */
    public int maxSumOfArrays(int []arrays){
	int sum = 0;//结果
	int sumTemp = 0;//计算当前的数组元素和
	for(int i = 0; i < arrays.length; ++i){
	    if(sumTemp <= 0){//如果和小于等于0,则用当前元素替换总和
		sumTemp = arrays[i];
	    }else{//否则,将当前元素加到总和上
		sumTemp += arrays[i];
	    }
	    if(sumTemp > sum){//如果计算到一个总和大于结果,替换结果值
		sum = sumTemp;
	    }
	}
	
	return sum;
    }
    
    public static void main(String[] args) {
	int []arrays = {1, -2, 3, 10, -4, 7, 2, -5};
	MaxSumOfArrays msoa = new MaxSumOfArrays();
	System.out.println(msoa.maxSumOfArrays(arrays));
    }
}
