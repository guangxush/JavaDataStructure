package ChapterOne;
import java.util.Stack;
/**
 * 设计一个有getMing功能的栈
 * @author Console
 *
 */
public class MyStack1 {
	private Stack<Integer> stackData;
	private Stack<Integer> stackMin;
	public MyStack1() {
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
