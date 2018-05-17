package codingInterviews;
/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BSTtoDoubleLink {
	public BinaryTreeNode convert(BinaryTreeNode root) {
		BinaryTreeNode lastNodeList = null;
		convertNode(root,lastNodeList);//转换成排好序的单链表
		//从原二叉树的root节点往前遍历找到双向链表的头返回即可
		while(lastNodeList!=null&&lastNodeList.left!=null) {//遍历二叉树链表，找到最左侧节点返回
			lastNodeList = lastNodeList.left;//左指针指向左节点，一直到最左侧节点
		}
		//返回头节点
		return lastNodeList;
	}
	private void convertNode(BinaryTreeNode root,BinaryTreeNode lastNodeList) {
		if(root==null) return;
		BinaryTreeNode current = root;
		if(current.left!=null)//根节点的左侧不为空
			convertNode(current.left,lastNodeList);
		current.left = lastNodeList;//根节点的左指针指向最后一个节点
		if(lastNodeList!=null)
			lastNodeList.right=current;//之前最后一个节点的右指针指向根节点
		lastNodeList=current;//最后一个节点指向当前节点
		if(current.right!=null)//右侧不为空
			convertNode(current.right,lastNodeList);
	}
}
/**
 * 中序遍历二叉排序树会得到一个有序的链表
 * 先把左右子树转换成排序的双向链表之后再把和根节点链接起来
 * 整个二叉搜索树也就成了排序的双向链表
 * 因此具体步骤如下：
 * 1.中序遍历找到根节点时，他的左侧已经是排好序的链表，并且在链表的最后一个节点时当前值的最大节点
 * 2.把左侧最后一个节点与根节点相连，接着遍历右子树，并把根节点与右子树最小的节点连接起来
 * 3.至于怎么转换他的左右子树遍历和转换的过程时一样的，使用递归调用即可
 * 由于二叉树的中序遍历具有可以实现递增的功能，同时二叉树的每一个节点都有两个指针，左指针和右指针，因此我们可以用这些特点将二叉树转换成一个双向链表，
 * 每次在递归遍历的时候设置一个pre，记录中序遍历时当前节点的前节点，然后将当前节点的左指针指向pre节点，然后如果pre节点不为空则将pre的右节点指向当前节点，
 * 由此就形成了一个双向链表的前后指针。每次递归重复这两步，则可以形成一个完整的双向链表。
 */
