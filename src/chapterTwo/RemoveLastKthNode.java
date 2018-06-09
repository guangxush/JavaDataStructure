package chapterTwo;

/**
 * 删除单链表和双链表的倒数第K个节点
 */
public class RemoveLastKthNode {
    public Node removeKthNode(Node head,int lastKth){
        if(head==null||lastKth<1) return head;
        Node cur = head;
        while(cur!=null){
            lastKth--;
            cur = cur.next;
        }
        if(lastKth==0)
            head = head.next;
        if(lastKth<0){
            cur=head;
            while(++lastKth!=0){
                cur = cur.next;
            }
            cur.next=cur.next.next;
        }
        return head;
    }
    public DoubleNode removeKthDoubleNode(DoubleNode head,int lastKth){
        if(head==null||lastKth<1) return head;
        DoubleNode cur = head;
        while(cur!=null){
            lastKth--;
            cur=cur.next;
        }
        if(lastKth==0){
            head=head.next;
            head.last=null;
        }
        if(lastKth<0){
            cur=head;
            while(++lastKth!=0){
                cur=cur.next;
            }
            DoubleNode newNext = cur.next.next;
            cur.next=newNext;
            if(newNext!=null){
                newNext.last=cur;
            }
        }
        return head;
    }
}
