package codingInterviews;
/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间删除该结点。
 */
public class DeleteLinkNode {
	/**
	 * 删除链表中的节点
	 * @param head 链表头指针
	 * @param deListNode 链表中要删除的节点
	 */
	public void deleteNode(ListNode head, ListNode deListNode) {
		if(deListNode==null||head==null) return;
		if(head==deListNode) {//删除头节点
			head=null;
		}else {
			if(deListNode.next==null){//删除尾结点
				ListNode pointListNode=head;
				while(pointListNode.next.next!=null){
					pointListNode=pointListNode.next;
				}
				pointListNode.next=null;
			}else{ 
				deListNode.val=deListNode.next.val;
				deListNode.next=deListNode.next.next;
			}
		}
	}
	public static void main(String[] args) {
		ListNode head=new ListNode(1);
		ListNode second=new ListNode(2);
		ListNode third=new ListNode(3);
		head.next=second;
		second.next=third; 
		DeleteLinkNode dlink=new DeleteLinkNode();
		dlink.deleteNode(head, second); 
		System.out.println(head.next.val);
	}
}
