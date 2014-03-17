package netease;

/**
 * 1-1000���ں���1001��Ԫ�ص������У�ֻ��Ψһ��һ��Ԫ��ֵ�ظ���<BR>
 * ������ֻ����һ�Ρ�ÿ������Ԫ��ֻ�ܷ���һ�Σ����һ���㷨��<BR>
 * �����ҳ��������ø����洢�ռ䣬�ܷ����һ���㷨ʵ�֣�<BR>
 * @company ����
 * @author xiehai
 * @date 2014-2-20 ����02:48:14 
 */
public class RepeatItem {
    private int []arrays;
    public RepeatItem(int []arrays){
	this.arrays = arrays;
    }
   
    /** 
     * ���ò�ֵ����ظ���Ԫ��
     * @return
     */
    public int method1(){
	long sum = 0;
	long realSum = 0;
	for(int i = 1; i < arrays.length; ++i){//����1��n�ĺ�
	    sum += i;
	}
	for(int i = 0; i < arrays.length; ++i){//�������������Ԫ�صĺ�
	    realSum += arrays[i];
	}
	//��������������ظ����Ǹ�����
	return (int) (realSum - sum);
    }
    
    /** 
     * ���������������±�������ϵ
     * @return
     */
    public int method2(){
	int i = 0;
	while(true){
	    if(arrays[i] < 0){
		break;
	    }
	    arrays[i] *= -1;//���ʹ������� ��¼�ɸ���
	    i = -arrays[i];//��Ϊ��˳���,����ǰ�±���Ϊǰһ��Ԫ������
	}
	return i;
    }
    
    /** 
     * A ^ 0 = A;��ʱA����<BR>
     * A ^ A = 0;��ʱAΪ0<BR>
     * ���մ˹��ɿɵó�,������εõ�ԭ����
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
