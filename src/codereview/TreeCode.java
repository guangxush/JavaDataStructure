package codereview;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author: guangxush
 * @create: 2019/03/17
 */
public class TreeCode {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.left = new Node(6);
        root.right.right = new Node(7);

        depthTraversal(root);
    }

    /**
     * 递归先序遍历二叉树
     * @param root
     */
    public static void preOrderRecur(Node root){
        if(root==null){
            return;
        }
        //根
        System.out.print(root.value);
        //左
        preOrderRecur(root.left);
        //右
        preOrderRecur(root.right);
    }

    /**
     * 一个栈的方式先序遍历二叉树
     * @param root
     */
    public static void preOrderUnRecur(Node root){
        if(root!=null){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                //根
                System.out.print(root.value);
                //右
                if(root.right!=null){
                    stack.push(root.right);
                }
                //左
                if(root.left!=null){
                    stack.push(root.left);
                }
            }
        }
    }

    /**
     * 递归实现中序遍历
     * @param root
     */
    public static void inOrderRecur(Node root){
        if(root==null){
            return;
        }
        inOrderRecur(root.left);
        System.out.println(root.value);
        inOrderRecur(root.right);
    }

    /**
     * 栈实现中序遍历
     * @param root
     */
    public static void inOrderUnRecur(Node root){
        if(root!=null){
            Stack<Node> stack = new Stack<>();
            while(!stack.isEmpty()||root!=null){
                if(root!=null){
                    //根节点不为空的情况下继续寻找最左节点
                    stack.push(root);
                    //注意先进栈，然后找左节点
                    root = root.left;
                }else{
                    //已经找到了最左节点，输出左节点
                    root = stack.pop();
                    System.out.print(root.value);
                    root = root.right;
                }
            }
        }
    }

    /**
     * 递归实现二叉树的先序遍历
     * @param root
     */
    public static void posOrderRecur(Node root){
        if(root==null){
            return;
        }
        posOrderRecur(root.left);
        posOrderRecur(root.right);
        System.out.print(root.value);
    }

    /**
     * 两个栈实现非递归后序遍历
     * @param root
     */
    public static void posOrderUnRecur(Node root){
        if(root!=null){
            Stack<Node> stack1 = new Stack<>();
            Stack<Node> stack2 = new Stack<>();
            stack1.push(root);
            while(!stack1.isEmpty()){
                root = stack1.pop();
                stack2.push(root);
                if(root.left!=null){
                    stack1.push(root.left);
                }
                if(root.right!=null){
                    stack1.push(root.right);
                }
            }
            while(!stack2.isEmpty()){
                System.out.print(stack2.pop().value);
            }
        }
    }

    /**
     * 一个队列实现层次遍历二叉树
     * @param root
     */
    public static void levelOrderUnRecur(Node root){
        if(root!=null){
            LinkedList<Node> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()){
                root = queue.removeFirst();
                System.out.print(root.value);
                if(root.left!=null){
                    queue.addLast(root.left);
                }
                if(root.right!=null){
                    queue.addLast(root.right);
                }
            }
        }
    }

    /**
     * 一个栈实现深度遍历二叉树=先序遍历
     * @param root
     */
    public static void depthTraversal(Node root){
        if(root!=null){
            Stack<Node> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                root = stack.pop();
                System.out.print(root.value);
                if(root.right!=null){
                    stack.push(root.right);
                }
                if(root.left!=null){
                    stack.add(root.left);
                }
            }
        }
    }


}
