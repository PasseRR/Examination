package alibaba;

/**
 * ����һ��n��Ԫ�ص�������������Сֵ
 * @company ����Ͱ�
 * @author xiehai
 * @date 2014-2-13 ����03:12:33 
 */
public class MaxAndMin {
    /**�������ֵ*/
    private int max = Integer.MIN_VALUE;
    /**������Сֵ*/
    private int min = Integer.MAX_VALUE;
    
    /** 
     * �Ƚ�2n��,��������Сֵ<br>
     * ��Ϊ����Ǳ�max��Ͳ����min�Ƚ�,���Բ���2n��
     * @param arrays
     */
    public void getMaxAndMinMethod1(int []arrays){
	for(int i = 0; i < arrays.length; ++i){
	    int item = arrays[i];
	    if(max < item){
		max = item;
	    }else if(min > item){
		min = item;
	    }
	}
    }
    
    /** 
     * �Ƚ�������������,С�����,����ұ�<br>
     * �ڱ�������,����������max�Ƚ�,ż��������min�Ƚ�<br>
     * ȱ��:���ƻ�ԭ����
     * @param arrays
     */
    public void getMaxAndMinMethod2(int []arrays){
	int len = arrays.length;
	boolean flg = 0 == len%2 ? false : true;//����Ԫ���Ƿ�ΪΪ������
	for(int i = 0; i < len; i += 2){//��������,�˴��Ƚ�n/2��
	    if(flg && i+2 > len){//���Ԫ����������,�����һ��Ԫ��,�����������������Խ��
		break;
	    }
	    if(arrays[i] > arrays[i+1]){
		int temp = arrays[i];
		arrays[i] = arrays[i+1];
		arrays[i+1] = temp;
	    }
	}
	//��ߺ�min�Ƚ�,�ұߺ�max�Ƚ�,�˴��Ƚ�n��
	//���Ƚ�(3/2)n��
	for(int i = 0; i < len; ++i){
	    int item = arrays[i];
	    if(flg && i == len-1){//���Ԫ����������,�ҵ�ǰΪ���һ��Ԫ��,��min,max���Ƚ�
		if(item < min){
		    min = item;
		}else if(item > max){
		    max = item;
		}
	    }else if(0 == i%2){//��ߵ�Сֵ
		if(item < min){
		    min = item;
		}
	    }else{//�ұߵĴ�ֵ
		if(item > max){
		    max = item;
		}
	    }
	}
    }
    
    public static void main(String[] args) {
	int []arrays = {111, 111};
	MaxAndMin mam = new MaxAndMin();
	mam.getMaxAndMinMethod1(arrays);
	System.out.println(mam.max + " " + mam.min);
	mam.getMaxAndMinMethod2(arrays);
	System.out.println(mam.max + " " + mam.min);
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
