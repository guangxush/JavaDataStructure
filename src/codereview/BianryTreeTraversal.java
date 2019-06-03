package codereview;

import java.util.ArrayDeque;
import java.util.Stack;

public class BianryTreeTraversal {
    //先序遍历
    public static void preOrderRecur(Node head){
        if(head == null) return;
        System.out.print(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //后序遍历
    public static void posOrderRecur(Node head){
        if(head==null) return;
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value+" ");
    }

    //中序遍历
    public static void inOrderRecur(Node head){
        if(head == null) return;
        inOrderRecur(head.left);
        System.out.print(head.value+" ");
        inOrderRecur(head.right);
    }

    //广度优先遍历
    public static void levelOrderTraversal(Node head){
        ArrayDeque<Node> queue= new ArrayDeque<>();
        queue.add(head);
        while(!queue.isEmpty()){
            Node temp = queue.remove();
            System.out.print(temp.value+" ");
            if(temp.left!=null) queue.add(head.right);
            if(temp.right!=null) queue.add(head.left);
        }
    }

    //深度优先遍历
    public static void depthTraversal(Node head){
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.println(temp.value);
            if(temp.right!=null) stack.push(head.right);
            if(temp.left!=null) stack.push(head.left);
        }
    }

    //先序遍历非递归实现
    public static void preOrderUnrecur(Node head){
        if(head==null) return;
        Stack<Node> stack = new Stack<>();
        stack.add(head);
        while(!stack.isEmpty()){
            Node temp = stack.pop();
            System.out.print(temp+" ");
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
        }
    }

    //中序遍历非递归实现
    public static void inOrderUnRecur(Node head){
        if(head==null) return;
        Stack<Node> stack = new Stack<>();
        while(!stack.isEmpty()||head!=null){
            if(head!=null){
                stack.push(head);
                head = head.left;
            }else{
                head = stack.pop();
                System.out.print(head.value+" ");
                head = head.right;
            }
        }
    }

    //后序遍历非递归实现
    public static void posOrderUnRecur(Node head){
        if(head==null) return;
        Stack<Node> stack = new Stack<>();
        stack.push(head);
        Node temp = null;
        while(!stack.isEmpty()){
            temp = stack.peek();
            if(temp.left!=null&&head!=temp.left&&head.right!=temp.right){
                stack.push(temp.left);//左子树还没有打印完毕
            }else if(temp.right!=null&&head!=temp.right){
                stack.push(temp.right);//右子树还没有处理过
            }else{
                //左右子树都处理完毕
                System.out.print(stack.pop().value+" ");
                head = temp;
            }
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

    public static void main(String[] args){
        Node head = createBinaryTree();
        System.out.println("preOrderRecur:");
        preOrderRecur(head);
        System.out.println();
        System.out.println("inOrderRecur:");
        inOrderRecur(head);
        System.out.println();
        System.out.println("posOrderRecur:");
        posOrderRecur(head);
        System.out.println();
        System.out.println("levelOrderTraversal");
        levelOrderTraversal(head);
        System.out.println();
        System.out.println("depthTraversal");
        depthTraversal(head);
        System.out.println();
    }
}

class Node{
    public Node left;
    public Node right;
    public int value;
    public Node(int value){
        this.value = value;
    }
    public Node(){}
}
