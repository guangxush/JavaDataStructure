package codingInterviews;
/**
 * 定义一个函数，输入一个链表的头结点，反转该链表并输出反转后链表的头结点。
 */
public class ReverseList {
	public ListNode reverseList(ListNode head) {
		if(head==null) return null;
		if(head.next==null) return head;
		ListNode preListNode = null;
		ListNode nowListNode = head;
		ListNode reversedHead = null;
		while(nowListNode.next!=null) {
			ListNode nextListNode  = nowListNode.next;
			if(nextListNode==null)
				reversedHead = nextListNode;
			nowListNode.next = preListNode;
			preListNode = nowListNode;
			nowListNode = nextListNode;
		}
		return nowListNode;
	}
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode second=new ListNode(2);
		ListNode third=new ListNode(3);
		ListNode forth=new ListNode(4);
		head.next=second;
		second.next=third;
		third.next=forth;
		ReverseList test=new ReverseList();
		ListNode resultListNode=test.reverseList(head);
		System.out.println(resultListNode.val);
	}
}
