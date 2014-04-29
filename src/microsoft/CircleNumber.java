package microsoft;

import java.util.LinkedList;
import java.util.Queue;

/**
 * n个数字（0,1,…,n-1）形成一个圆圈，从数字0开始，<BR>
 * 每次从这个圆圈中删除第m个数字（第一个为当前数字本身，第二个为当前数字的下一个数字）。<BR>
 * 当一个数字删除后，从被删除数字的下一个继续删除第m个数字。<BR>
 * 求出在这个圆圈中剩下的最后一个数字。
 * 
 * @company 微软
 * @author xiehai
 * @date 2014-2-27 下午02:47:59
 */
public class CircleNumber {
	/**
	 * 使用队列实现
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
			int current = queue.poll();// 当前要出队的元素
			if (count != m) {// 弹出队列第一个元素,如果是第m个,则出队,否则进入队列尾
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
