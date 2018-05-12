package codingInterviews;
/**
 * 输入一个链表，输出该链表中倒数第k个结点。为了符合大多数人的习惯，本题从1开始计数，
 * 即链表的尾结点是倒数第一个结点。例如一个有6个结点的链表，从头结点依次是1,2,3,4,5,6。
 * 倒数第三个结点就是值为4的结点。
 */
public class FindKToTail {
	public ListNode findKToTail(ListNode head,int k){
		if(head==null||k==0) return null;
		ListNode resultNode = null;
		ListNode headListNode = head;
		for(int i=0;i<k;i++) {
			if(headListNode.next!=null) {
				headListNode = headListNode.next;
			}else {
				return null;
			}
		}
		resultNode = head;
		while(headListNode!=null) {
			resultNode = resultNode.next;
			headListNode = headListNode.next;
		}
		return resultNode;
	}
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode second=new ListNode(2);
		ListNode third=new ListNode(3);
		ListNode forth=new ListNode(4);
		head.next=second;
		second.next=third;
		third.next=forth;
		FindKToTail test=new FindKToTail();
		ListNode resultListNode=test.findKToTail(head, 3);
		System.out.println(resultListNode.val);
	}
}
/**
 * 第一个指针在链表上走k步；
 * 第二个指针和第一个指针同时往后移动
 * 当第一个指针先到达尾部都时候，第二个指针就是倒数第k个
 */
