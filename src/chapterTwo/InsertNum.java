package chapterTwo;

/**
 * 有序的环形单链表中插入新节点
 */
public class InsertNum {
    public Node insertNum(Node head,int num){
        Node node = new Node(num);
        if(head==null){
            node.next = node;
            return node;
        }
        Node pre = head;
        Node cur = head.next;
        while(cur!=head){
            if(pre.value<=num&&cur.value>=num){
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        pre.next = node;
        node.next = cur;
        return head.value<num?head:node;
    }
}
