package codingInterviews;
/**
 * 输入一棵二叉树的根结点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意结点的左右子树的深度相差不超过1，那么他就是一棵平衡二叉树。
 */
public class IsBalancedTree {
	private boolean isBalanced=true;  
    public boolean IsBalanced_Solution(BinaryTreeNode root) {  
        getDepth(root);  
        return isBalanced;  
    }
    public int getDepth(BinaryTreeNode root) {
    	if(root==null) return 0;
    	int left = getDepth(root.left);
    	int right = getDepth(root.right);
    	if(Math.abs(left-right)>1) {
    		isBalanced=false;
    	}
    	return left>right?left+1:right+1;
    }
}
