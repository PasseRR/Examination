package microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 有一个链表L = {L0, L1, L2, L3....Ln-1, Ln},<BR>
 * 编写代码使得L = {L0, Ln, L1, Ln-1, L2, Ln-1...}<BR>
 * 类似于完美洗牌:<BR>
 * 有个长度为2n的数组{a1,a2,a3,...,an,b1,b2,b3,...,bn}，<BR>
 * 希望排序后{a1,b1,a2,b2,....,an,bn}，<BR>
 * 请考虑有无时间复杂度o(n)，空间复杂度0(1)的解法。<BR>
 * @company 微软
 * @author xiehai
 * @date 2014-2-14 下午03:43:17 
 */
public class ListItemMove {
    /** 
     * 将链表截取成2个链表,在按次序插入组成新链表<BR>
     * 蛮力变换
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
	//将链表截取成两个链表
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
	
	//插入两段链表的最后一个元素
	list.add(segement1.get(segement1.size()-1));
	if(0 == size%2){
	    list.add(segement2.get(segement1.size()-1));
	}
	return list;
    }
    
    /** 
     * 位置置换<BR>
     * List:{b1, b2,...., bn, a1, a2, ..., an}
     * 假设List有元素2n个,则:<BR>
     * {a1, b1, a2, b2, ..., an-1, bn-1, an, bn}<BR>
     * 其在原list中的位置变化为:<BR>
     * 任意的第i个元素，我们最终换到了 (2 * i) % (2 * n + 1)的位置。
     * @param list
     * @return
     */
    public List<Integer> swapPosition(List<Integer> list){
	int size = list.size();
	List<Integer> result = new ArrayList<Integer>(list);
	for(int i = 0; i < size; ++i){
	    result.set((i*2+1) % (size+1), list.get(i));//list索引是从0开始的
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
