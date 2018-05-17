package codingInterviews;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出序列。
 * 假设压入栈的所有数字均不相等。
 * 例如压栈序列为1、2、3、4、5.序列4、5、3、2、1是压栈序列对应的一个弹出序列，但4、3、5、1、2却不是。
 */
public class IsStackPopOrder {
	public boolean isPopOrder(int[] line1,int[] line2){
		if(line1==null||line2==null) {
			return false;
		}
		int point1 = 0;//line1中的遍历指针
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0;i<line2.length;i++) {
			if(!stack.isEmpty()&&stack.peek()==line2[i]) {
				stack.pop();
			}else {
				if(point1==line1.length) {
					return false;
				}else {
					do {
						stack.push(line1[point1++]);
					}while(stack.peek()!=line2[i]&&point1!=line1.length);
					if(stack.peek()==line2[i])
						stack.pop();
					else
						return false;
				}
			}
		}
		return true;
	}
}
