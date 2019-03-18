package codereview;

/**
 * @author: guangxush
 * @create: 2019/03/18
 */
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums){
        return buildTree(nums,0,nums.length);
    }
    public TreeNode buildTree(int[] nums, int low, int high){
        if(low>high){
            return null;
        }
        int mid = (low+high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = buildTree(nums, low, mid-1);
        node.right = buildTree(nums, mid+1, high);
        return node;
    }
}
class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(int x) { val = x; }
}
