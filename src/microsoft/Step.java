package microsoft;

/**
 * һ��̨���ܹ���n�������һ�ο�����1����Ҳ������2����<BR>
 * ���ܹ��ж������������������㷨��ʱ�临�Ӷȡ�
 * @company ΢��
 * @author xiehai
 * @date 2014-2-27 ����03:09:58 
 */
public class Step {
    /** 
     * �ݹ����
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
     * �������<BR>
     * ������������һ�������־ͻ����
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
