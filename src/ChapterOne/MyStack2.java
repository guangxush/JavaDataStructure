package ChapterOne;
import java.util.Stack;
/**
 * 最小元素出栈
 * @author Console
 *
 */
public class MyStack2 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public MyStack2() {
		this.stackData = new Stack<Integer>();
		this.stackMin  = new Stack<Integer>();
	}
	//元素入栈
	public void push(int newNum) {
		if(this.stackMin.isEmpty()) {
			this.stackMin.push(newNum);
		}else if(newNum<this.getMin()) {
			this.stackMin.push(newNum);
		}else {
			int newMin = this.stackMin.peek();
			this.stackMin.push(newMin);
		}
		this.stackData.push(newNum);
	}
	//获取最小元素
	public int getMin() {
		if(this.stackMin.isEmpty()) {
			throw new RuntimeException("Your Stack is Empty!");
		}else {
			return this.stackMin.peek();
		}
	}
	//元素出栈
	public int pop() {
		if(this.stackData.isEmpty()) {
			throw new RuntimeException("Your Stack is Empty!");
		}
		this.stackMin.pop();
		return this.stackData.pop();
	}
}
