package codereview;

import java.util.*;

/**
 * Created by gshan on 2018/11/17
 */
public class BinaryTreeTest {

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

    //二叉树的镜像
    public static void mirrorBinaryTree(Node root){
        if(root==null) return;
        if(root.left==null&&root.right==null)
            return;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
           Node root1 = stack.pop();
           Node temp = root1.left;
           root1.left = root1.right;
           root1.right = temp;
           if(root1.right!=null) stack.push(root1.right);
           if(root1.left!=null) stack.push(root1.left);
        }
    }

    //二叉树的镜像递归实现
    public static Node mirrorBinaryTreeRec(Node root){
        if(root==null) return null;
        if(root.left==null&&root.right==null) return null;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        if(root.left!=null)
            mirrorBinaryTreeRec(root.left);
        if(root.right!=null)
            mirrorBinaryTreeRec(root.right);
        return root;
    }

    //层次遍历二叉树并打印
    public static void printBinaryTree(Node root){
        if(root==null) return;
        if(root.left==null&&root.right==null)
            System.out.println(root.value);
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(null);//层分隔符
        queue.add(root);
        while(queue.size()!=1){
            Node temp = queue.removeFirst();
            if(temp==null){//到达层分隔符
                Iterator<Node> it = queue.iterator();
                while(it.hasNext()){
                    System.out.print(it.next().value+" ");
                }
                System.out.println();
                queue.add(null);
                continue;
            }
            if(temp.left!=null) queue.addLast(temp.left);
            if(temp.right!=null) queue.addLast(temp.right);
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
        System.out.println();
        Node node2 = createBinaryTree();
        printBinaryTree(node);
        System.out.println("mirrorBinaryTreeRec");
        printBinaryTree(mirrorBinaryTreeRec(node2));
        Node node3 = createBinaryTree();
        mirrorBinaryTree(node3);
        System.out.println("mirrorBinaryTree");
        printBinaryTree(node3);
    }
}
