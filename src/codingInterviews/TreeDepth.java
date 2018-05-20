package codingInterviews;
/**
 * 输入一棵二叉树的根结点，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {
	public int treeDepth(BinaryTreeNode tree) {
		if(tree==null) return 0;
		int left = 1+treeDepth(tree.left);
		int right = 1+treeDepth(tree.right);
		return left>right?left:right;
	}
	public static void main(String[] args) {
		BinaryTreeNode root=new BinaryTreeNode();
		BinaryTreeNode node1=new BinaryTreeNode();
		BinaryTreeNode node2=new BinaryTreeNode();
		BinaryTreeNode node3=new BinaryTreeNode();
		BinaryTreeNode node4=new BinaryTreeNode();
		BinaryTreeNode node5=new BinaryTreeNode();
		BinaryTreeNode node6=new BinaryTreeNode();
		root.left=node1;
		root.right=node2;
		node1.left=node3;
		node1.right=node4;
		node2.right=node5;
		node4.left=node6;
		root.value=1;
		node1.value=2;
		node2.value=3;
		node3.value=4;
		node4.value=5;
		node5.value=6;
		node6.value=7;
		TreeDepth p=new TreeDepth(); 
		System.out.println(p.treeDepth(root));
	}
}
