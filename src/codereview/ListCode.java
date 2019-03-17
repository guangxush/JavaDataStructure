package codereview;

/**
 * @author: guangxush
 * @create: 2019/03/17
 */
public class ListCode {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode l7 = new ListNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        printList(l1);
        ListNode x2 = l1;
        printList(reverseList(l1));
        printList(reverseListRecur(l7));
        ListNode x1 = removeLastKNode(l1,2);
        printList(x1);
        printList(x2);
        ListNode x3 = mergeSortedList(x1,x2);
        printList(x3);
    }

    /**
     * 非递归方式链表反转
     * @param head
     * @return
     */
    public static ListNode reverseList(ListNode head){
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        ListNode pre = null;
        ListNode now = head;
        while(now!=null){
            ListNode next = now.next;
            now.next = pre;
            pre = now;
            now = next;
        }
        return pre;
    }

    /**
     * 递归方式单链表反转
     * @param head
     * @return
     */
    public static ListNode reverseListRecur(ListNode head){
        if(head.next==null){
            return head;
        }
        ListNode reverseNode = reverseListRecur(head.next);
        //next节点的next指向当前节点
        head.next.next = head;
        //当前节点next节点指向null
        head.next = null;
        return reverseNode;
    }

    /**
     * 判断链表是否有环
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head){
        if(head==null||head.next==null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    /**
     * 删除链表中倒数第k个节点
     * @param head
     * @return
     */
    public static ListNode removeLastKNode(ListNode head, int k){
        ListNode pre = head;
        ListNode fast = head;
        ListNode slow = head;
        while(fast!=null){
            if(k--<0){
                slow = slow.next;
            }
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return pre;
    }

    /**
     * 递归合并两个有序链表
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeSortedList(ListNode l1, ListNode l2){
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode mergeNode = null;
        if(l1.val<l2.val){
            mergeNode = l1;
            mergeNode.next = mergeSortedList(l1.next,l2);
        }else{
            mergeNode = l2;
            mergeNode.next = mergeSortedList(l1,l2.next);
        }
        return mergeNode;
    }

    public static void printList(ListNode head){
        while(head!=null){
            System.out.print(head.val);
            head = head.next;
        }
        System.out.println();
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        this.val = x;
    }
}