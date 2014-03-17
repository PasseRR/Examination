package google;

/**
 * �ж�һ����Ȼ���Ƿ���ĳ������ƽ��,����ʹ�ÿ�������
 * @company �ȸ�
 * @author xiehai
 * @date 2014-2-13 ����04:59:01 
 */
public class CheckNumber {
    /** 
     * ѭ��0��n,�����Ƿ���ĳ�����ֵ�ƽ��
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
     * ���ֲ���ƽ����,ֻ��ȷ��int��Χ
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
