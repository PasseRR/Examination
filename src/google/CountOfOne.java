package google;

/**
 * ����һ������n�����1��n��n��������ʮ���Ʊ�ʾ��1���ֵĴ�����
 * @company �ȸ�
 * @author xiehai
 * @date 2014-2-27 ����04:12:52 
 */
public class CountOfOne {
    public int getCountOfOne(int num){
	int count = 0;
	for(int i = 1; i <= num; ++i){
	    int j = i;
	    while(j > 0){//ͳ��һ������ÿλ�Ƿ���1
		count += (j%10 == 1) ? 1 : 0;//���λ�Ƿ���1
		j /= 10;
	    }
	}
	
	return count;
    }
    
    public static void main(String[] args) {
	CountOfOne coo = new CountOfOne();
	System.out.println(coo.getCountOfOne(50));
    }
}
