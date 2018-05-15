package codingInterviews;

import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 */
public class MirrorBinaryTree {
	public BinaryTreeNode mirrorBinaryTree(BinaryTreeNode root) {
		if(root==null) return null;
		if(root.left==null&&root.right==null) return null;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		while(root!=null||!stack.isEmpty()) {
			while(root!=null) {
				BinaryTreeNode temp = root.left;
				root.left = root.right;
				root.right = temp;
				stack.push(root);
				root=root.left;
			}
			root=stack.pop();
			root=root.right;
		}
		return root;
	}
	public static void main(String[] args) {
		BinaryTreeNode root1=new BinaryTreeNode();
		BinaryTreeNode node1=new BinaryTreeNode();
		BinaryTreeNode node2=new BinaryTreeNode();
		BinaryTreeNode node3=new BinaryTreeNode();
		BinaryTreeNode node4=new BinaryTreeNode();
		BinaryTreeNode node5=new BinaryTreeNode();
		BinaryTreeNode node6=new BinaryTreeNode();
		root1.left=node1;
		root1.right=node2;
		node1.left=node3;
		node1.right=node4;
		node4.left=node5;
		node4.right=node6; root1.value=8; node1.value=8;
		node2.value=7; node3.value=9; node4.value=2; node5.value=4; node6.value=7;
		MirrorBinaryTree test=new MirrorBinaryTree();
		BinaryTreeNode rootBinaryTreeNode=test.mirrorBinaryTree(root1);
		System.out.println(root1.right.value);
	}
}
/**
 * 先序遍历二叉树的每个节点，如果遍历到的节点有子节点，就交换他得的两个子节点。
 * 当交换玩所有飞叶子节点的左右子节点之后就得到了他的镜像。
 */
