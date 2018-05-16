package codingInterviews;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的min函数。
 * 在该栈中，调用min、push及pop德尔时间复杂度都是O(1).
 */
public class StackWithMin {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public StackWithMin() {
		this.stackData = new Stack<Integer>();
		this.stackMin  = new Stack<Integer>();
	}
	//元素入栈
	public void push(int newNum) {
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		}else if(newNum<=this.getMin()) {
			this.stackMin.push(newNum);
		}
		this.stackData.push(newNum);
	}
	//获取最小元素
	public int getMin() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("Your stack is empty");
		}else {
			return stackMin.peek();
		}
	}
	//元素出栈
	public int pop() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("Your stack is empty");
		}
		int value = this.stackData.pop();
		if(value==this.getMin()) {
			this.stackMin.pop();
		}
		return value;
	}
}
