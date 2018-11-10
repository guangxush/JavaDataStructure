package codereview;

public class BianryTreeTraversal {
    //先序遍历
    public static void preOrderRecur(Node head){
        if(head == null) return;
        System.out.println(head.value+" ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    //后序遍历
    public static void posOrderRecur(Node head){

    }
}
class Node{
    public Node left;
    public Node right;
    public int value;
    public Node(int value){
        this.value = value;
    }
}
