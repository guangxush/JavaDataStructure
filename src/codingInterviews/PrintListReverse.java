package codingInterviews;
import java.util.Stack;
public class PrintListReverse {
	/**
	 * 采用非递归的方式，使用栈存储元素
	 * @param headNode
	 */
	public static void printListReverse1(ListNode headNode) {
		Stack<ListNode> stack  = new Stack<ListNode>();
		while(headNode!=null) {
			stack.push(headNode);
			headNode = headNode.next;
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop().val);
		}
	}
	/**
	 * 采用递归的方式打印
	 * @param headNode
	 */
	public static void printListReverse2(ListNode headNode) {
		if(headNode.next==null)
			System.out.println(headNode.val);
		else {
			printListReverse2(headNode.next);//递归执行结束后，打印当前节点的值
			System.out.println(headNode.val);
		}
	}
	public static void main(String[] args) {
		ListNode node1=new ListNode(1);
		ListNode node2=new ListNode(2);
		ListNode node3=new ListNode(3);
		node1.next=node2;
		node2.next=node3;
		System.out.println("非递归方式");
		PrintListReverse.printListReverse1(node1);
		System.out.println("递归方式");
		PrintListReverse.printListReverse2(node1);
	}
}
