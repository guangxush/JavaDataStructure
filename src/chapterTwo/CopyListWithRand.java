package chapterTwo;

import java.util.HashMap;

/**
 * 复制含有随机指针节点的链表
 */
class NodeRand{
    public int value;
    public NodeRand next;
    public NodeRand rand;
    public NodeRand(int data){
        this.value = data;
    }
}
public class CopyListWithRand {
    public NodeRand copyListWithRand1(NodeRand head){
        HashMap<NodeRand,NodeRand> map = new HashMap<>();
        NodeRand cur = head;
        while(cur!=null){
            map.put(cur,new NodeRand(cur.value));
        }
        cur = head;
        while(cur!=null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).rand = map.get(cur.rand);
            cur = cur.next;
        }
        return map.get(head);
    }
    public NodeRand copyListWithRand2(NodeRand head){
        if(head==null) return null;
        NodeRand cur = head;
        NodeRand next = head.next;
        //复制并链接每一个节点
        while(cur!=null){
            next = cur.next;
            cur.next = new NodeRand(cur.value);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        NodeRand curCopy = null;
        //设置复制节点的rand指针
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.rand = cur.rand!=null?cur.rand.next:null;
            cur = next;
        }
        NodeRand res = head.next;
        cur = head;
        //拆分
        while(cur!=null){
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next!=null?next.next:null;
            cur = next;
        }
        return res;
    }
}
