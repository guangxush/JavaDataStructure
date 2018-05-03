package codingInterviews;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 用两个队列实现一个栈，实现对了的两个函数pop和push，
 * 分别完成入栈出栈的功能。
 */
public class TwoQueuesImplyStack<T> {
	private Queue<T> queue1 = new ArrayDeque<T>();
	private Queue<T> queue2 = new ArrayDeque<T>();
	/**
	 * 出栈
	 */
	public T pop() throws Exception{
		if(queue1.isEmpty()&&queue2.isEmpty()) {
			throw new Exception("栈为空，没有元素");
		}
		if(queue1.isEmpty()) {
			while(queue2.size()>1) {//非空的队列只保留一个元素
				queue1.add(queue2.poll());
			}
			return queue2.poll();//将最后的一个元素输出
		}
		if(queue2.isEmpty()) {
			while(queue1.size()>1) {
				queue2.add(queue1.poll());
			}
			return queue1.poll();
		}
		return null;
	}
	/**
	 * 进栈
	 * @param t
	 */
	public void push(T t) {
		//两个队列都为空，优先选择queue1
		if(queue1.isEmpty()&&queue2.isEmpty()) {
			queue1.add(t);
			return;
		}
		//如果queue1为空，queue2有数据，直接放入queue2
		if(queue1.isEmpty()) {
			queue2.add(t);
			return;
		}
		//如果queue2为空，queue1有数据，直接放入queue1中
		if(queue2.isEmpty()) {
			queue1.add(t);
			return;
		}
	}
	public static void main(String args[]) throws Exception {
		TwoQueuesImplyStack<Integer> stack = new TwoQueuesImplyStack<>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		System.out.println(stack.pop());
	}
}
