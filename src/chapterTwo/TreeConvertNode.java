package chapterTwo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将搜索二叉树转换成双向链表
 */
public class TreeConvertNode {
    class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int data){
            this.value = data;
        }
    }
    //使用队列手机二叉树中序遍历的结果，然后弹出节点，重连所有的节点即可
    public Node convert1(Node head){
        Queue<Node> queue  = new LinkedList<>();
        inOrderToQueue(head,queue);
        if(queue.isEmpty()) return head;
        head = queue.poll();
        Node pre = head;
        pre.left = null;
        Node cur = null;
        while(!queue.isEmpty()){
            cur = queue.poll();
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        pre.right = null;
        return head;
    }
    public void inOrderToQueue(Node head,Queue<Node> queue){
        if(head==null) return;
        inOrderToQueue(head.left,queue);
        queue.offer(head);
        inOrderToQueue(head.right,queue);
    }
    //使用递归函数，将一颗搜索二叉树抓换成一个结构有特点的有序双向链表
    public Node convert2(Node head){
        if(head==null) return null;
        Node last = process(head);
        head = last.right;
        last.right = null;
        return head;
    }
    public Node process(Node head){
        if(head==null){
            return null;
        }
        Node leftE = process(head.left);//左边结束
        Node rightE = process(head.right);//右边结束
        Node leftS = leftE!=null?leftE.right:null;//左边开始
        Node rightS = rightE!=null?rightE.right:null;//右边开始
        if(leftE!=null&&rightE!=null){
            leftE.right = head;
            head.left = leftE;
            head.right = rightS;
            rightS.left = head;
            rightE.right = leftS;
            return leftE;
        }else if(leftE!=null){
            leftE.right = head;
            head.left = head;
            head.right = leftS;
            return head;
        }else if(rightE!=null){
            head.right = rightS;
            rightS.left = head;
            rightE.right = head;
            return rightE;
        }else{
            head.right = head;
            return head;
        }
    }
}
