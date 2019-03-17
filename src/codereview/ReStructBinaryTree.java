package codereview;

import java.util.Arrays;

/**
 * @author: guangxush
 * @create: 2019/03/17
 */
public class ReStructBinaryTree {

    /**
     * 根据先序遍历和中序遍历构造一颗二叉树
     * @param preorder
     * @param inorder
     * @return
     * @throws Exception
     */
    public static Node constructCore(int[] preorder, int[] inorder) throws Exception{
        if(preorder==null||inorder==null){
            return null;
        }
        if(preorder.length!=inorder.length){
            throw new IllegalArgumentException("节点数目不一致");
        }
        Node root = new Node();
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==preorder[0]){
                root.value = inorder[i];
                System.out.print(root.value);
                root.left = constructCore(Arrays.copyOfRange(preorder,1,i+1),
                        Arrays.copyOfRange(inorder,0,i));
                root.right = constructCore(Arrays.copyOfRange(preorder, i+1, preorder.length),
                        Arrays.copyOfRange(inorder, i+1, inorder.length));

            }
        }
        return root;
    }

    /**
     * 根据后序遍历和中序遍历构造一颗二叉树
     * @param posorder
     * @param inorder
     * @return
     * @throws Exception
     */
    public static Node constructCore2(int[] posorder, int[] inorder) throws Exception{
        if(posorder==null||inorder==null){
            return null;
        }
        if(posorder.length!=inorder.length){
            throw new IllegalArgumentException("数组数目不一致");
        }
        Node root= new Node();
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==posorder[posorder.length-1]) {
                root.value = inorder[i];
                System.out.print(root.value);
                root.left = constructCore2(Arrays.copyOfRange(posorder, 0, i),
                        Arrays.copyOfRange(inorder, 0, i));
                root.right = constructCore2(Arrays.copyOfRange(posorder, i, posorder.length - 1),
                        Arrays.copyOfRange(inorder, i + 1, inorder.length));
            }
        }
        return root;
    }


    public static void main(String[] args) throws Exception {
        int[] preSort={1,2,4,7,3,5,6,8};
        int[] inSort={4,7,2,1,5,3,8,6};
        int[] posSort={7,4,2,5,8,6,3,1};
        Node root=constructCore(preSort,inSort);
        root = constructCore2(posSort,inSort);
    }
}
