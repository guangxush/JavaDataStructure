package codingInterviews;

import java.util.Arrays;

/**
 * 题目描述：输入二叉树的前序遍历和中序遍历的结果，重建出该二叉树。假设前序遍历和中序遍历结果中都不包含重复的数字，
 * 例如输入的前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}重建出如图所示的二叉树。
 */
public class RestructionBinaryTreeNode {
	/**
	 * 构造一个二叉树
	 * @param preorder 前序遍历节点
	 * @param inorder 中序遍历节点
	 * @return
	 * @throws Exception
	 */
	public static BinaryTreeNode constructCore(int[] preorder,int[] inorder) throws Exception{
		if(preorder==null||inorder==null)
			return null;
		if(preorder.length!=inorder.length) {
			throw new Exception("节点数目不一致，无法构造二叉树");
		}
		BinaryTreeNode root = new BinaryTreeNode();
		for(int i=0;i<inorder.length;i++) {
			if(inorder[i]==preorder[0]) {
				root.value = inorder[i];//先序遍历的第一个节点为根节点
				System.out.println(root.value);
				//左子树：先序遍历为节点1到当前节点，中序遍历为根节点左侧的所有节点
				root.left = constructCore(Arrays.copyOfRange(preorder, 1, i+1),
						Arrays.copyOfRange(inorder, 0, i));
				//右子树：先序遍历为下一个节点到最后的节点，中序遍历为根节点右侧所有节点
				root.right=constructCore(Arrays.copyOfRange(preorder,i+1, preorder.length),
						Arrays.copyOfRange(inorder, i+1, inorder.length));
			}
		}
		return root;
	}
	public static void main(String[] args) throws Exception {
		int[] preSort={1,2,4,7,3,5,6,8};
		int[] inSort={4,7,2,1,5,3,8,6};
		BinaryTreeNode root=constructCore(preSort,inSort);
	}
}
/**
 * Arrays.copyOfRange(T[ ] original,int from,int to)
 * 将一个原始的数组original，从小标from开始复制，复制到小标to，生成一个新的数组。
 * 注意这里包括下标from，不包括下标to。
 */
