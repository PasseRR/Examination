package microsoft;

import java.util.LinkedList;
import java.util.Queue;

/**
 * n�����֣�0,1,��,n-1���γ�һ��ԲȦ��������0��ʼ��<BR>
 * ÿ�δ����ԲȦ��ɾ����m�����֣���һ��Ϊ��ǰ���ֱ����ڶ���Ϊ��ǰ���ֵ���һ�����֣���<BR>
 * ��һ������ɾ���󣬴ӱ�ɾ�����ֵ���һ������ɾ����m�����֡�<BR>
 * ��������ԲȦ��ʣ�µ����һ�����֡�
 * 
 * @company ΢��
 * @author xiehai
 * @date 2014-2-27 ����02:47:59
 */
public class CircleNumber {
	/**
	 * ʹ�ö���ʵ��
	 * 
	 * @param n
	 * @param m
	 * @return
	 */
	public int getLastNumber(int n, int m) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i <= n; ++i) {
			queue.offer(i);
		}
		int count = 1;
		while (1 != queue.size()) {
			int current = queue.poll();// ��ǰҪ���ӵ�Ԫ��
			if (count != m) {// �������е�һ��Ԫ��,����ǵ�m��,�����,����������β
				queue.offer(current);
				count++;
			} else {
				count = 1;
			}
		}

		return queue.poll();
	}

	public static void main(String[] args) {
		CircleNumber cn = new CircleNumber();
		System.out.println(cn.getLastNumber(10, 3));
	}
}
