package codingInterviews;
/**
 * 输入两颗二叉树A和B，判断B是不是A的子结构。
 */
public class IsSubTree {
	/**
	 * 递归调用树的遍历,首先找到第二棵树的根节点在第一棵树中的位置
	 * @param root1
	 * @param root2
	 * @return
	 */
	public boolean hasSubTree(BinaryTreeNode root1,BinaryTreeNode root2) {
		boolean result = false;
		if(root1!=null&&root2!=null) {
			if(root1.value==root2.value)
				result = doesTree1HavaTree2(root1,root2);//如果两个根节点相等，判断是否是子树
			if(!result)//如果不是子树，那么继续遍历左右节点
				result = hasSubTree(root1.left,root2);
			if(!result)
				result = hasSubTree(root1.right,root2);
		}
		return result;
	}
	/**
	 * 头节点相同，判断左右节点是否相同，同样采用递归的方法
	 * @param root1
	 * @param root2
	 * @return
	 */
	private boolean doesTree1HavaTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
		if(root2==null) {
			return true;//节点2已经遍历结束，返回true
		}else if(root1==null) {
			return false;//节点2没有遍历结束，但是节点1已经没有元素，此时返回false
		}
		if(root1.value!=root2.value) {//两个节点不相等
			return false;
		}
		//当前节点满足条件，继续遍历
		return doesTree1HavaTree2(root1.left, root2.left)&&doesTree1HavaTree2(root1.right, root2.right);
	}
	public static void main(String args[])
	{
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
		node4.right=node6;
		root1.value=8;
		node1.value=8;
		node2.value=7;
		node3.value=9;
		node4.value=2;
		node5.value=4;
		node6.value=7;
		BinaryTreeNode root2=new BinaryTreeNode();
		BinaryTreeNode a=new BinaryTreeNode();
		BinaryTreeNode b=new BinaryTreeNode();
		root2.left=a;
		root2.right=b;
		root2.value=8;
		a.value=9;
		b.value=2;
		IsSubTree test=new IsSubTree();
		System.out.println(test.hasSubTree(root1, root2));
	}
}
