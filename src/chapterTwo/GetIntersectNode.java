package chapterTwo;

/**
 * 给定两个单链表的头结点head1和head2，这两个链表如果相交，返回相交的第一个节点
 * 如果不想交，返回null即可
 */
public class GetIntersectNode {
    //判断一个链表是否有环，如果有返回第一个进入环的节点，如果没有返回null
    public Node getLoopNode(Node head){
        if(head==null||head.next==null||head.next.next==null){
            return null;
        }
        Node n1 = head.next;//n1->slow
        Node n2 = head.next.next;//n2->fast
        while(n1!=n2){
            if(n2.next==null||n2.next.next==null) return null;
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head;//n2->walk again from head
        while(n1!=n2){
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
    //两个链表都无环的情况
    public Node noLoop(Node head1,Node head2){
        if(head1==null||head2==null) return null;
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        //求出两个链表相差的长度n
        while(cur1.next!=null){
            n++;
            cur1 = cur1.next;
        }
        while(cur2.next!=null){
            n--;
            cur2 = cur2.next;
        }
        if(cur1!=cur2) return null;//链表最后的节点都不相同，说明不想交
        cur1 = n>0?head1:head2;
        cur2 = cur1==head1?head2:head1;
        n = Math.abs(n);
        while(n!=0){
            n--;
            cur1 = cur1.next;
        }
        while(cur1!=cur2){
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }
    //两个链表都有环的情况
    public Node bothLoop(Node head1,Node loop1,Node head2,Node loop2){
        Node cur1 = null,cur2 = null;
        if(loop1==loop2){
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while(cur1!=loop1){
                n++;
                cur1 = cur1.next;
            }
            while(cur2!=loop2){
                n--;
                cur2 = cur2.next;
            }
            cur1 = n>0?head1:head2;
            cur2 = cur1==head1?head2:head1;
            n = Math.abs(n);
            while(n!=0){
                n--;
                cur1 = cur1.next;
            }
            while(cur1!=cur2){
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
        }else{
            cur1 = loop1.next;
            while(cur1!=loop1){
                if(cur1==loop2){
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }
    public Node getIntersectNode(Node head1,Node head2){
        if(head1==null||head2==null) return null;
        Node loop1 = getLoopNode(head1);
        Node loop2 = getLoopNode(head2);
        if(loop1==null&&loop2==null){
            return noLoop(head1,head2);
        }
        if(loop1!=null&&loop2!=null){
            return bothLoop(head1,loop1,head2,loop2);
        }
        return null;
    }
}
