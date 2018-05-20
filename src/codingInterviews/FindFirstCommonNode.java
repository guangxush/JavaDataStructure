package codingInterviews;
/**
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class FindFirstCommonNode {
	public ListNode findFirstCommonNode(ListNode head1,ListNode head2){
		int len1=getListLength(head1);
		int len2=getListLength(head2);
		ListNode longListNode=null;
		ListNode shortListNode=null;
		//找到长的链表
		int dif=0;
		if(len1>len2){
			longListNode=head1;
			shortListNode=head2;
			dif=len1-len2;
		}else{
			longListNode=head2;
			shortListNode=head1;
			dif=len2-len1;
		}
		for(int i=0;i<dif;i++){ 
			longListNode=longListNode.next;
		}
		while(longListNode!=null&&shortListNode!=null&&longListNode!=shortListNode){ 
			longListNode=longListNode.next; 
			shortListNode=shortListNode.next;
		}
		return longListNode;
	}
	//获取链表长度
	private int getListLength(ListNode head) {
		int result = 0;
		if(head==null) return result;
		ListNode point = head;
		while(point!=null) {
			result++;
			point = point.next;
		}
		return result;
	}
	public static void main(String[] args) {
		ListNode head1=new ListNode(1);
		ListNode second1=new ListNode(2);
		ListNode third1=new ListNode(3);
		ListNode forth1=new ListNode(6);
		ListNode fifth1=new ListNode(7);
		ListNode head2=new ListNode(4);
		ListNode second2=new ListNode(5);
		ListNode third2=new ListNode(6);
		ListNode forth2=new ListNode(7); 
		head1.next=second1; 
		second1.next=third1; 
		third1.next=forth1; 
		forth1.next=fifth1; 
		head2.next=second2; 
		second2.next=forth1; 
		third2.next=forth2;
		FindFirstCommonNode test=new FindFirstCommonNode();
		System.out.println(test.findFirstCommonNode(head1, head2).val);
	}
}
