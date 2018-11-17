package codereview;

/**
 * Created by gshan on 2018/11/17
 */
public class CalBinaryTreeDepth {

    //计算二叉树的深度
    public static int calBinaryTreeDepth(Node tree){
        if(tree==null){
            return 0;
        }else {
            return 1+Math.max(calBinaryTreeDepth(tree.right),calBinaryTreeDepth(tree.left));
        }
    }

    //计算二叉树的最小深度
    public static int calBinaryTreeMinDepth(Node tree){
        if(tree==null){
            return 0;
        }else {
            return 1+Math.min(calBinaryTreeMinDepth(tree.right),calBinaryTreeMinDepth(tree.left));
        }
    }

    //构建一个二叉树
    /**
     *     1
     *    2 3
     *  4 5 6 7
     * 8 9
     */
    public static Node createBinaryTree(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node8 = new Node(8);
        Node node9 = new Node(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;
        node5.left = node5.right = null;
        node6.left = node6.right = null;
        node7.left = node7.right = null;
        node8.left = node8.right = null;
        node9.left = node9.right = null;
        return node1;
    }

    public static void main(String[] args) {
        Node node = createBinaryTree();
        System.out.println(calBinaryTreeDepth(node));
        System.out.println(calBinaryTreeMinDepth(node));
    }
}
