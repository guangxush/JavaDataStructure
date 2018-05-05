package codingInterviews;

import java.util.Stack;

/**
 * 用两个栈实现一个队列，实现对了的两个函数push和poll，
 * 分别完成在队列尾插入结点和在队列头部删除结点的功能。
 */
public class TwoStacksImplyQueue<T> {
	private Stack<T> stack1 = new Stack<T>();
	private Stack<T> stack2 = new Stack<T>();
	/**
	 * 入队列
	 * @param t
	 */
	public void offer(T t) {
		stack1.push(t);
	}
	/**
	 * 出队列
	 * @return
	 * @throws Exception
	 */
	public T poll() throws Exception{
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		if(stack2.isEmpty()) {
			throw new Exception("队列为空，无法删除");
		}
		return stack2.pop();
	}
	public static void main(String args[])throws Exception{
		TwoStacksImplyQueue<Integer> queue = new TwoStacksImplyQueue<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		System.out.println(queue.poll());
	}
}
