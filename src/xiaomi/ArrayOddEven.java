package xiaomi;

import java.util.Arrays;

/**
 * ����һ��int���飬ͨ���任ʹ�����ȫΪ�����ұ�ȫΪż����
 * @company С��
 * @author xiehai
 * @date 2014-2-18 ����02:47:55 
 */
public class ArrayOddEven {
    /** 
     * ��ͷ��ʼ����,����һ����Ϊż��,����ʣ���Ԫ��<BR>
     * ���ҵ�һ������,��ǰһ��ż������O(n*n)
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
     * ����β��ʼ����,����ʼ��Ϊż���ҽ�����Ϊ����<BR>
     * ������������,�������������,β��ǰ����O(n) 
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
     * �ж�һ�����Ƿ���ż��
     * @param n
     * @return
     */
    private boolean isEven(int n){
	return 0 == n%2 ? true : false;
    }
    
    /** 
     * �ж�һ�����Ƿ�������
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
