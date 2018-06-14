package chapterTwo;

/**
 * 单链表的选择排序
 */
public class SelectionSortNode {
    public Node selectionSort(Node head){
        Node tail = null;//排序部分尾部
        Node cur = head;//未排序部分的头部
        Node smallPre = null;//最小节点的前一个节点
        Node small = null;//最小节点
        while(cur!=null){
            small = cur;
            smallPre = getSmallestPreNode(cur);
            if(smallPre!=null){
                small = smallPre.next;
                smallPre.next = small.next;
            }
            cur = cur==small?cur.next:cur;
            if(tail==null){
                head = small;
            }else{
                tail.next = small;
            }
            tail = small;
        }
        return head;
    }
    public Node getSmallestPreNode(Node head){
        Node smallPre = null;
        Node small = head;
        Node pre = head;
        Node cur = head.next;
        while(cur!=null){
            if(cur.value<small.value){
                smallPre = pre;
                small = cur;
            }
            pre = cur;
            cur = cur.next;
        }
        return smallPre;
    }
}
