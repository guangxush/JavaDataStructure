package chapterOne;
import java.util.*;
/**
 * 用一个栈实现另一个栈排序
 */
public class SortStackbyStack {
	public static void sortStackbyStack(Stack<Integer> stack) {
		Stack<Integer> help = new Stack<Integer>();//申请辅助栈help
		while(!stack.isEmpty()) {
			int cur = stack.pop();//弹出的元素记为cur
			while(!help.isEmpty()&&help.peek()>cur) {
				stack.push(help.pop());//弹出比cur大的值
			}
			help.push(cur);//将cur压入help
		}
		while(!help.isEmpty()) {
			stack.push(help.pop());//将help中一排好序的元素全部压入stack中
		}
	}
}
