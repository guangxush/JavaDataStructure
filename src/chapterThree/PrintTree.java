package chapterThree;

/**
 * 直观的打印二叉树
 */
public class PrintTree {
    public void printTree(Node head){
        System.out.println("Binary Tree");

    }
    public void printInOrder(Node head,int height,String to,int len){
        if(head==null) return;
        printInOrder(head.right,height+1,"V",len);
        String val = to+head.value+to;
        int lenM = val.length();
        int lenL = (len-lenM)/2;
        int lenR = len-lenL-lenM;
        val = getSpace(lenL)+val+getSpace(lenR);
        System.out.println(getSpace(height*len)+val);
        printInOrder(head.left,height+1,"^",len);
    }
    public String getSpace(int num){
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for(int i=0;i<num;i++){
            buf.append(space);
        }
        return buf.toString();
    }
}
