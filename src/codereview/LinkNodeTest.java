package codereview;


import sun.awt.image.ImageWatched;

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
        //printLinkNode(mergeTwoLink(newNode,newNode));
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

}

class LinkNode{
    public LinkNode next;
    public int data;
    public LinkNode(int data){
        this.data = data;
    }
}
