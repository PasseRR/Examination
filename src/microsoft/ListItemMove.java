package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��һ������L = {L0, L1, L2, L3....Ln-1, Ln},<BR>
 * ��д����ʹ��L = {L0, Ln, L1, Ln-1, L2, Ln-1...}<BR>
 * ����������ϴ��:<BR>
 * �и�����Ϊ2n������{a1,a2,a3,...,an,b1,b2,b3,...,bn}��<BR>
 * ϣ�������{a1,b1,a2,b2,....,an,bn}��<BR>
 * �뿼������ʱ�临�Ӷ�o(n)���ռ临�Ӷ�0(1)�Ľⷨ��<BR>
 * @company ΢��
 * @author xiehai
 * @date 2014-2-14 ����03:43:17 
 */
public class ListItemMove {
    /** 
     * �������ȡ��2������,�ڰ�����������������<BR>
     * �����任
     * @param list
     * @return
     */
    public List<Integer> reorder(List<Integer> list){
	int size = list.size();
	List<Integer> segement1 = new ArrayList<Integer>();
	List<Integer> segement2 = new ArrayList<Integer>();
	int cutPosition = 0;
	if(0 == size%2){
	    cutPosition = size/2;
	}else{
	    cutPosition = size/2 + 1;
	}
	//�������ȡ����������
	for(int i = 0; i < cutPosition; ++i){
	    segement1.add(list.get(i));
	}
	for(int i = cutPosition; i < size; ++i){
	    segement2.add(list.get(i));
	}
	list = new ArrayList<Integer>();
	for(int i = 0; i < segement1.size()-1; ++i){
	    list.add(segement1.get(i));
	    list.add(segement2.get(i));
	}
	
	//����������������һ��Ԫ��
	list.add(segement1.get(segement1.size()-1));
	if(0 == size%2){
	    list.add(segement2.get(segement1.size()-1));
	}
	return list;
    }
    
    /** 
     * λ���û�<BR>
     * List:{b1, b2,...., bn, a1, a2, ..., an}
     * ����List��Ԫ��2n��,��:<BR>
     * {a1, b1, a2, b2, ..., an-1, bn-1, an, bn}<BR>
     * ����ԭlist�е�λ�ñ仯Ϊ:<BR>
     * ����ĵ�i��Ԫ�أ��������ջ����� (2 * i) % (2 * n + 1)��λ�á�
     * @param list
     * @return
     */
    public List<Integer> swapPosition(List<Integer> list){
	int size = list.size();
	List<Integer> result = new ArrayList<Integer>(list);
	for(int i = 0; i < size; ++i){
	    result.set((i*2+1) % (size+1), list.get(i));//list�����Ǵ�0��ʼ��
	}
	
	return result;
    }
    
    public static void main(String[] args) {
	List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
	ListItemMove lim = new ListItemMove();
	System.out.println(lim.reorder(list));
	System.out.println(lim.swapPosition(list));
    }
}
