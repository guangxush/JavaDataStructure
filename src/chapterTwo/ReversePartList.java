package chapterTwo;

/**
 * 翻转部分单向链表
 */
public class ReversePartList {
    public Node reversePart(Node head,int from,int to){
        int len = 0;
        Node node1 = head;
        Node fPre = null;
        Node tPos = null;
        while(node1!=null){
            len++;
            fPre = len == from-1?node1:fPre;//要反转的前一个节点
            tPos = len == to+1?node1:tPos;//要反转的后一个节点
            node1 = node1.next;
        }
        if(from > to||from < 1||to > len){
            return head;
        }
        node1 = fPre==null?head:fPre.next;
        Node node2 = node1.next;
        Node next = null;
        while(node2!=null){
            next = node1.next;
            node2.next = node1;
            node1 = node2;
            node2 = next;
        }
        if(fPre!=null){
            fPre.next = node1;
            return head;
        }
        return node1;
    }
}
