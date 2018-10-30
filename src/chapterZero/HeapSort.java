package chapterZero;

/**
 * 堆的定义如下：具有n个元素的序列（h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）(i=1,2,...,n/2)时称之为堆。
 * 在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。完全二叉树可以很直观地表示堆的结构。
 * 堆顶为根，其它为左子树、右子树。初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这时堆的根节点的数最大。
 * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。
 * 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
 */
public class HeapSort {
    public static void heapSort(int[] a){
        int length = a.length;
        //循环建队
        for(int i=0;i<length-1;i++){
            //建堆
            buildHeap()
        }
    }
    private buildHeap(int[] data, int lastIndex){
        //从lastIndex处节点的父节点开始（最后一个节点的父节点）
        for(int i=(lastIndex-1)/2;i>0;i--){
            //k保存正在判断的节点
            int k = i;
            //如果当前节点的子节点存在
            while(k*2+1<=lastIndex){
                //k节点作子节点的索引，
                int biggerIndex = 2*k+1;
                //如果big
            }
        }
    }
}
