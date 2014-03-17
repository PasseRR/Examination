package xiaomi;

import java.util.Arrays;

/**
 * 给出一个int数组，通过变换使得左边全为奇数右边全为偶数。
 * @company 小米
 * @author xiehai
 * @date 2014-2-18 下午02:47:55 
 */
public class ArrayOddEven {
    /** 
     * 从头开始遍历,当有一个数为偶数,遍历剩余的元素<BR>
     * 当找到一个奇数,和前一个偶数交换O(n*n)
     * @param arrays
     */
    public void positionSwap(int []arrays){
	int len = arrays.length;
	for(int i = 0; i < len; ++i){
	    if(isEven(arrays[i])){
		for(int j = i+1; j < len; ++j){
		    if(isOdd(arrays[j])){
			int temp = arrays[i];
			arrays[i] = arrays[j];
			arrays[j] = temp;
			break;
		    }
		}
	    }
	}
    }
    
    /**
     * 从首尾开始遍历,若开始处为偶数且结束处为奇数<BR>
     * 则两个数交换,否则首往后遍历,尾往前遍历O(n) 
     * @param arrays
     */
    public void positionHeadAndTail(int []arrays){
	int head = 0;
	int tail = arrays.length-1;
	while(head < tail){
	    while(isOdd(arrays[head])){
		head ++;
	    }
	    while(isEven(arrays[tail])){
		tail --;
	    }
	    if(head < tail){
		int temp = arrays[head];
		arrays[head] = arrays[tail];
		arrays[tail] = temp;
	    }
	}
    }
    
    /** 
     * 判断一个数是否是偶数
     * @param n
     * @return
     */
    private boolean isEven(int n){
	return 0 == n%2 ? true : false;
    }
    
    /** 
     * 判断一个数是否是奇数
     * @param n
     * @return
     */
    private boolean isOdd(int n){
	return 1 == n%2 ? true : false;
    }
    
    public static void main(String[] args) {
	int []arrays = {2, 4, 1, 2, 5, 7, 8};
	ArrayOddEven aoe = new ArrayOddEven();
//	aoe.positionSwap(arrays);
//	System.out.println(Arrays.toString(arrays));
	aoe.positionHeadAndTail(arrays);
	System.out.println(Arrays.toString(arrays));
    }
}
