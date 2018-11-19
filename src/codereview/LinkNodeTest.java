package codereview;


import sun.awt.image.ImageWatched;

import java.util.*;

/**
 * Created by gshan on 2018/11/14
 */
public class LinkNodeTest {
    public static void main(String[] args) {
        LinkNode node1 = new LinkNode(1);
        LinkNode node2 = new LinkNode(2);
        LinkNode node3 = new LinkNode(3);
        LinkNode node4 = new LinkNode(4);
        LinkNode node5 = new LinkNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;
        printLinkNode(node1);
        LinkNode newNode = reverseList(node1);
        printLinkNode(newNode);
        System.out.println(searchLastNElement(newNode, 2));
        System.out.println("deletNElement(newNode,3)");
        printLinkNode(deletNElement(newNode,3));
        System.out.println("addNElement(newNode, 2, 1)");
        printLinkNode(addNElement(newNode, 2, 1));


        LinkNode node11 = new LinkNode(1);
        LinkNode node12 = new LinkNode(3);
        LinkNode node13 = new LinkNode(5);
        LinkNode node21 = new LinkNode(2);
        LinkNode node22 = new LinkNode(4);
        node11.next = node12;
        node12.next = node13;
        node13.next = null;
        node21.next = node22;
        node22.next = null;
        printLinkNode(mergeTwoLink(node11,node21));
        printLinkNode(node11);
        System.out.println("printListReverse:");
        printListReverse(node11);
        System.out.println();
        printListReverseWithStack(node11);
        System.out.println("sortLinkNode");
        sortLinkNode(node11);
        System.out.println("delete node2");
        printLinkNode(removeLinkNode(node11,node12));

        System.out.println("isCircle:");
        System.out.println(isCircle(node11));
    }

    //链表翻转
    public static LinkNode reverseList(LinkNode head){
        LinkNode pre = null;
        LinkNode now = head;
        while(now!=null){
            LinkNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }

    //链表值打印
    public static void printLinkNode(LinkNode head){
        LinkNode node = head;
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    //找出链表中的倒数第n个元素
    public static int searchLastNElement(LinkNode node, int n){
        LinkNode now = node;
        for(;n>0&&now!=null;n--){
            now = now.next;
        }
        while(now!=null){
            node = node.next;
            now = now.next;
        }
        return node.data;
    }

    //删除链表中的第n个元素
    public static LinkNode deletNElement(LinkNode node, int n){
        LinkNode now = node;
        for(int i=0;i<n-1;i++){
            now = now.next;
            if(now.next==null)
                throw new IllegalArgumentException("The nth element don't exist!");
        }
        now.next = now.next.next;
        return node;
    }

    //在第n个位置插入一个元素
    public static LinkNode addNElement(LinkNode node, int n, int data){
        LinkNode now = node;
        for(int i=0;i<n-2;i++){
            now = now.next;
            if(now.next==null)
                throw new IllegalArgumentException("The nth element don't exist!");
        }
        System.out.println(now.data);
        LinkNode temp = new LinkNode(data);
        LinkNode next = now.next;
        now.next = temp;
        temp.next = next;
        return node;
    }

    //两个单链表按照元素大小合并为一个链表
    public static LinkNode mergeTwoLink(LinkNode node1, LinkNode node2){
        if(node1==null){
            return node2;
        }
        if(node2==null){
            return node1;
        }
        LinkNode head = null;
        if(node1.data<=node2.data){
            head = node1;
            head.next = mergeTwoLink(node1.next,node2);
        }else{
            head = node2;
            head.next = mergeTwoLink(node1,node2.next);
        }
        return head;
    }

    //从尾到头打印单链表
    public static void printListReverse(LinkNode head){
        if(head!=null&&head.next!=null){
              printListReverse(head.next);
        }
        System.out.print(head.data+" ");
    }

    //借助栈实现链表反向输出
    public static void printListReverseWithStack(LinkNode head){
        Stack stack = new Stack();
        while(head!=null){
            stack.push(head.data);
            head = head.next;
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }
        System.out.println();
    }

    //对链表中的元素进行排序输出
    public static void sortLinkNode(LinkNode head){
        Set set = new TreeSet();
        while(head!=null){
            set.add(head.data);
            head = head.next;
        }
        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.print(it.next()+" ");
        }
        System.out.println();
    }

    //O(1)时间内删除链表中指定的节点
    public static LinkNode removeLinkNode(LinkNode head, LinkNode delNode){
        if(head==null||delNode==null) return null;
        if(head==delNode){
            //head = null;//删除头节点
            return  head.next;
        }else{
            if(delNode.next==null){//删除尾节点
                LinkNode newHead = head;
                while(newHead.next.next!=null){
                    newHead = newHead.next;
                }
                newHead.next=null;
            }else{
                delNode.data = delNode.next.data;
                delNode.next = delNode.next.next;
            }
            return head;
        }
    }

    //判断链表有没有环
    public static boolean isCircle(LinkNode head){
        //快慢指针
        LinkNode fast = head;
        LinkNode slow = head;
        while(fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) return true;
        }
        return false;
    }

}

class LinkNode{
    public LinkNode next;
    public int data;
    public LinkNode(int data){
        this.data = data;
    }
}
