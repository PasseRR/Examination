package microsoft;

/**
 * ����һ���������飬������������Ҳ�и�����<BR>
 * ������������һ�������������һ�������飬ÿ�������鶼��һ���͡�<BR>
 * ������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)��
 * @company ΢��
 * @author xiehai
 * @date 2014-2-27 ����01:52:38 
 */
public class MaxSumOfArrays {
    /** 
     * �����������������
     * @param arrays
     * @return
     */
    public int maxSumOfArrays(int []arrays){
	int sum = 0;//���
	int sumTemp = 0;//���㵱ǰ������Ԫ�غ�
	for(int i = 0; i < arrays.length; ++i){
	    if(sumTemp <= 0){//�����С�ڵ���0,���õ�ǰԪ���滻�ܺ�
		sumTemp = arrays[i];
	    }else{//����,����ǰԪ�ؼӵ��ܺ���
		sumTemp += arrays[i];
	    }
	    if(sumTemp > sum){//������㵽һ���ܺʹ��ڽ��,�滻���ֵ
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
