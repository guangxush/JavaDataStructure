package codingInterviews;
/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的结点仍然是按照递增排序的。
 */
public class MergeList {
	public ListNode mergeList(ListNode head1,ListNode head2){
		if(head1==null) return head2;
		if(head2==null) return head1;
		ListNode mergeHead = null;
		if(head1.val<head2.val) {
			mergeHead = head1;
			mergeHead.next = mergeList(head1.next,head2);
		}else {
			mergeHead = head2;
			mergeHead.next = mergeList(head1,head2.next);
		}
		return mergeHead;
	}
	public static void main(String[] args) {
		ListNode head1=new ListNode(1);
		ListNode second1=new ListNode(3);
		ListNode head2=new ListNode(2);
		ListNode second2=new ListNode(2);
		ListNode third2=new ListNode(2);
		head1.next=second1;
		head2.next=second2;
		second2.next=third2;
		MergeList test=new MergeList();
		ListNode result=test.mergeList(head1, head2);
		System.out.println(result.next.next.next.next.val);
	}
}
