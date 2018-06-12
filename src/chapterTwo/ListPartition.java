package chapterTwo;

/**
 * 将单向链表按照某值划分成左边小，中间相等，右边大的形式
 */
public class ListPartition {
    public Node listPartition1(Node head,int pivot) {
        if(head==null) return head;
        Node cur = head;
        int i= 0;
        while(cur!=null){//获取链表长度
            i++;
            cur = cur.next;
        }
        Node[] nodeArr = new Node[i];
        i = 0;
        cur = head;
        for(i=0;i!=nodeArr.length;i++){//遍历链表存入nodeArr中
            nodeArr[i] = cur;
            cur = cur.next;
        }
        arrPartition(nodeArr, pivot);//调整数组中的元素
        for(i = 1;i!=nodeArr.length;i++){//重新连接链表元素
            nodeArr[i-1].next=nodeArr[i];
        }
        nodeArr[i-1].next = null;
        return nodeArr[0];//返回头指针
    }
    public void arrPartition(Node[] nodeArr, int pivot){
        int small = -1;
        int big = nodeArr.length;
        int index  = 0;
        while(index!=big){
            if(nodeArr[index].value<pivot){
                swap(nodeArr, ++small, index++);
            }else if(nodeArr[index].value == pivot){
                index++;
            }else{
                swap(nodeArr,--big,index);
            }
        }
    }
    public void swap(Node[] nodeArr, int a, int b){
        Node tmp = nodeArr[a];
        nodeArr[a] = nodeArr[b];
        nodeArr[b] = tmp;
    }
}
