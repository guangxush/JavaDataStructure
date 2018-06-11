package chapterTwo;

import java.util.Stack;

public class IsPalindrome {
    public boolean isPalindrome1(Node head){
        Stack<Node>  stack = new Stack<>();
        Node cur = head;
        while(cur!=null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head!=null){
            if(head.value!=stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public boolean isPalindrome2(Node head){
        if(head==null||head.next==null) return true;
        Node right = head.next;
        Node cur = head;
        while(cur.next!=null&&cur.next.next!=null){
            right = right.next;
            cur = cur.next.next;
        }
        Stack<Node> stack = new Stack<>();
        while(right!=null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if(head.value!=stack.pop().value){
                return false;
            }
            head = head.next;
        }
        return true;
    }
    public boolean isPalindrome3(Node head){
        if(head==null||head.next==null) return true;
        Node n1 = head;
        Node n2 = head;
        while(n1.next!=null&&n2.next.next!=null){
            n1= n1.next;//n1中部
            n2 = n2.next.next;//n2结尾
        }
        n2 = n1.next;//n2->右部分第一个节点
        n1.next = null;//mid.nextg->null
        Node n3 = null;
        while(n1!=null){//右半区域翻转
            n3 = n2.next;//n3->保存下一个节点
            n2.next = n1;//下一个反转节点
            n1 = n2;//n1移动
            n2 = n3;//n2移动
        }
        n3 = n1;//n3->保存的最后一个节点
        n2 = head;//n2->左边第一个节点
        boolean res = true;
        while(n1!=null&&n2!=null){//检查回文
            if(n1.value!=n2.value){
                res = false;
                break;
            }
            n1 = n1.next;//从左到中
            n2 = n2.next;//从右到中
        }
        n1 = n3.next;
        n3.next=null;
        while(n1!=null){//恢复链表
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }
        return res;
    }
}
