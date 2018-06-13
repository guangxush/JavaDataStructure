package chapterTwo;

import java.util.HashSet;

/**
 * 删除单链表中重复出现的节点
 */
public class RemoveRepNode {
    //借助hash表的方法
    public void removeRep1(Node head){
        if(head==null) return;
        HashSet<Integer> set = new HashSet<>();
        Node pre = head;
        Node cur = head.next;
        set.add(head.value);
        while(cur!=null){
            if(set.contains(cur.value)){
                pre.next = cur.next;
            }else{
                set.add(cur.value);
                pre = cur;
            }
            cur = cur.next;
        }
    }
    //选择排序的思想
    public void removeRep2(Node head){
        if(head==null) return;
        Node cur = head;
        Node pre = null;
        Node next  = null;
        while(cur!=null){
            pre = cur;
            next = cur.next;
            while(next!=null){
                if(cur.value==next.value){
                    pre.next = next.next;
                }else{
                    pre = next;
                }
                next = next.next;
            }
            cur = cur.next;
        }
    }
}
