package codingInterviews;

import java.util.Stack;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class FindPathEqualNum {
	public void findPath(BinaryTreeNode root ,int sum) {
		if(root==null) return;
		Stack<Integer> stack = new Stack<Integer>();
		int currentSum = 0;
		findPath(root,sum,stack,currentSum);
	}
	private void findPath(BinaryTreeNode root,int sum,Stack<Integer> stack, int currentSum) {
		currentSum += root.value;
		stack.push(root.value);
		if(root.left==null&&root.right==null) {//如果是叶子节点，那么判断是否是当前路径
			if(currentSum == sum) {
				System.out.println("找到一个路径");
				for(int path:stack) {
					System.out.print(path+" ");
				}
			}
			System.out.println();
		}
		if(root.left!=null) {//遍历左节点
			findPath(root.left,sum,stack,currentSum);
		}
		if(root.right!=null) {//遍历右节点
			findPath(root.right,sum,stack,currentSum);
		}
		//在返回到父节点之前，弹出元素，并且减去当前sum的值
		stack.pop();
		currentSum -= root.value;
	}
	public static void main(String args[])
	{
		BinaryTreeNode root1=new BinaryTreeNode();
		BinaryTreeNode node1=new BinaryTreeNode();
		BinaryTreeNode node2=new BinaryTreeNode();
		BinaryTreeNode node3=new BinaryTreeNode();
		BinaryTreeNode node4=new BinaryTreeNode();
		root1.left=node1;
		root1.right=node2;
		node1.left=node3;
		node1.right=node4;
		root1.value=10;
		node1.value=5;
		node2.value=12;
		node3.value=4;
		node4.value=7;
		FindPathEqualNum testFindPath=new FindPathEqualNum();
		testFindPath.findPath(root1, 22);
	}
}
/**
 * 前序遍历的方式访问某一结点，把该节点添加到路径上，并累加该节点的值
 * 如果该节点的值恰好等于输入的整数，那么当前的路径符合要求，把他们打印出来
 * 如果当前节点不是叶节点那么继续访问他的子节点，当前节点访问结束之后自动返回到他的父节点
 * 因此在函数退出之前要在路径上删除当前节点并减去当前节点的值，确保返回父节点的路径上刚好是从根节点到父节点的路径
 * 可以使用栈的方法与递归调用的状态保持一致
 */