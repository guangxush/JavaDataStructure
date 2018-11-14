package codereview;


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
    }

    //链表翻转
    public static LinkNode reverseList(LinkNode head){
        LinkNode prev = null;
        LinkNode now = head;
        while(now!=null){
            LinkNode next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        return prev;
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

}

class LinkNode{
    public LinkNode next;
    public int data;
    public LinkNode(int data){
        this.data = data;
    }
}
