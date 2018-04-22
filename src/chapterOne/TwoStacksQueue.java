package chapterOne;
import java.util.Stack;
/**
 * 两个栈实现队列
 * @author Console
 *
 */
public class TwoStacksQueue {
	public Stack<Integer> stackPush;
	public Stack<Integer> stackPop;
	public TwoStacksQueue() {
		stackPush = new Stack<Integer>();
		stackPop = new Stack<Integer>();
	}
	//队列添加元素
	public void add(int pushInt) {
		stackPush.push(pushInt);
	}
	// 移除并返问队列头部的元素
	public int poll() {
		if(stackPop.isEmpty()&&stackPush.isEmpty()) {
			throw new RuntimeException("Queue is empty!");
		}else if(!stackPop.isEmpty()) {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.pop();
	}
	// 获取队列对头元素
	public int peek() {
		if(stackPop.isEmpty()&&stackPush.isEmpty()) {
			throw new RuntimeException("Queue is empty!");
		}else if(!stackPop.isEmpty()) {
			while(!stackPush.isEmpty()) {
				stackPop.push(stackPush.pop());
			}
		}
		return stackPop.peek();
	}
}
