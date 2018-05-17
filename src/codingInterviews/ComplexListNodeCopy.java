package codingInterviews;
/**
 * 实现函数复制一个复杂链表。在复杂链表中，每个结点除了有一个next指针指向下一个结点外，
 * 还有一个指向链表中任意结点或null。
 */
public class ComplexListNodeCopy {
	public ComplexListNode clone(ComplexListNode head){
		cloneNodes(head);//第一步：复制链表节点
		connectSlibingNodes(head);//第二步：链接节点
		return reconnectNodes(head);//第三步：保留最后复制出来的节点
	}
	public void cloneNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while(node!=null) {
			ComplexListNode cloneNode = new ComplexListNode();
			//先设置出一个clone节点来
			cloneNode.data=node.data;
			cloneNode.next=node.next;
			cloneNode.sibling = null;//先设置为空
			node.next = cloneNode;//当前节点指向clone节点
			node = cloneNode.next;//当前节点指向clone的下一个节点
		}
	}
	public void connectSlibingNodes(ComplexListNode head) {
		ComplexListNode node = head;
		while(node!=null) {
			ComplexListNode cloneNode = node.next;//只找到clone的节点
			if(node.sibling!=null) {//指向node的sibling的下一个节点
				cloneNode.sibling=node.sibling.next;
			}
			node=cloneNode.next;
		}
	}
	public ComplexListNode reconnectNodes(ComplexListNode head) {
		ComplexListNode node = head;
		ComplexListNode clonedHead = null;
		ComplexListNode clonedNode = null;
		if(node!=null) {//判断是否是空链表
			clonedNode=node.next;
			clonedHead=clonedNode;
			node.next=clonedHead.next;
			node=node.next;
		}
		while(node!=null) {
			clonedNode=node.next;
			clonedHead.next=clonedNode;
			node.next=clonedNode.next;
			node=node.next;
		}
		return clonedHead;
	}
	public static void main(String[] args) {
		ComplexListNodeCopy testClone=new ComplexListNodeCopy();
		ComplexListNode root=new ComplexListNode();
		ComplexListNode node1=new ComplexListNode();
		ComplexListNode node2=new ComplexListNode();
		ComplexListNode node3=new ComplexListNode();
		ComplexListNode node4=new ComplexListNode();
		root.data=1;
		node1.next=node2;
		node2.next=node3;
		node3.next=node4;
		root.data=1;
		node1.data=2;
		node2.data=3;
		node3.data=4;
		node4.data=5;
		root.sibling=node1;
		node1.sibling=root;
		node3.sibling=node1 ;
		ComplexListNode result=testClone.clone(root);
		System.out.println(result.data);
	}
}
/**
 * 复杂链表类
 */
class ComplexListNode
{
	int data;//节点的值
	ComplexListNode next;//指向下一个节点
	ComplexListNode sibling;//指向另一个节点或者为空
}
/**
 * 思路：第一步在原始链表的基础上，每一个节点后面复制一个相同的节点出来
 * 第二步复制出来的节点指向原始链表的指向节点的下一个节点
 * 第三步，奇数步得到原始链表，偶数步得到复制出来的链表
 */
