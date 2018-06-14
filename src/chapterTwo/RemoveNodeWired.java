package chapterTwo;

/**
 * 给定链表中的节点node，但是不给定整个链表的头结点，删除该节点node
 */
public class RemoveNodeWired {
    public void removeNodeWired(Node node){
        if(node==null) return;
        Node next = node.next;
        if(next==null){
            throw new RuntimeException("can not remove last node;");
        }
        node.value = next.value;
        node.next = next.next;
    }
}
