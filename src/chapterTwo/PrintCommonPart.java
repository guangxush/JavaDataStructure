package chapterTwo;

/**
 * 给定两个有序链表的头指针head1和head2打印两个有序链表公共的部分
 */
public class PrintCommonPart {
    public void printCommonPart(Node head1,Node head2){
        System.out.print("Common Part:");
        while(head1!=null&&head2!=null){
            if(head1.value<head2.value){
                head1=head1.next;
            }else if(head1.value>head2.value){
                head2=head2.next;
            }else{
                System.out.print(head1.value+" ");
                head1=head1.next;
                head2=head2.next;
            }
        }
        System.out.println();
    }
}
