package chapterTwo;

import java.util.Stack;

/**
 * 两个链表相加生成新的链表
 * 9->3->7+6->3=1->0->0->0
 */
public class AddList {
    //利用栈空间
    public Node addList1(Node head1,Node head2){
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(head1!=null){
            s1.push(head1.value);
            head1 = head1.next;
        }
        while(head2!=null){
            s2.push(head2.value);
            head2 = head2.next;
        }
        int ca = 0;
        int n1= 0;
        int n2 = 0;
        int n = 0;
        Node node = null;
        Node pre = null;
        while(!s1.isEmpty()||!s2.isEmpty()){
            n1 = s1.isEmpty()?0:s1.pop();
            n2 = s2.isEmpty()?0:s2.pop();
            n2 = n1+n2+ca;
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n/10;
        }
        if(ca==1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return node;
    }
    //利用链表的逆序求解
    public Node addLists2(Node head1,Node head2){
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        int ca = 0,n1 = 0, n2= 0, n = 0;
        Node c1 = head1, c2 = head2, node =null,pre = null;
        while(c1!=null||c2!=null){
            n1 = c1!=null?c1.value:0;
            n2 = c2!=null?c2.value:0;
            n = n1+n2+ca;
            pre = node;
            node = new Node(n%10);
            node.next = pre;
            ca = n/10;
            c1 = c1!=null?c1.next:null;
            c2 = c2!=null?c2.next:null;
        }
        if(ca==1){
            pre = node;
            node = new Node(1);
            node.next = pre;
        }
        return null;
    }
    //链表逆序
    public Node reverseList(Node head){
        Node pre = null;
        Node next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
