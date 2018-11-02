package chapterZero;

import java.util.Arrays;

/**
 * 堆的定义如下：具有n个元素的序列（h1,h2,...,hn),当且仅当满足（hi>=h2i,hi>=2i+1）或（hi<=h2i,hi<=2i+1）(i=1,2,...,n/2)时称之为堆。
 * 在这里只讨论满足前者条件的堆。由堆的定义可以看出，堆顶元素（即第一个元素）必为最大项（大顶堆）。完全二叉树可以很直观地表示堆的结构。
 * 堆顶为根，其它为左子树、右子树。初始时把要排序的数的序列看作是一棵顺序存储的二叉树，调整它们的存储序，使之成为一个堆，这时堆的根节点的数最大。
 * 然后将根节点与堆的最后一个节点交换。然后对前面(n-1)个数重新调整使之成为堆。依此类推，直到只有两个节点的堆，并对它们作交换，最后得到有n个节点的有序序列。
 * 从算法描述来看，堆排序需要两个过程，一是建立堆，二是堆顶与堆的最后一个元素交换位置。所以堆排序有两个函数组成。一是建堆的渗透函数，二是反复调用渗透函数实现排序的函数。
 */
public class HeapSort {
    /**
     * 下沉调整
     * @param array 待调整的堆
     * @param parentIndex 要下沉的父节点
     * @param length 堆的有效大小
     */
    public static void downAdjust(int[] array, int parentIndex, int length){
        //temp保存父节点的值，用于最后的赋值
        int temp = array[parentIndex];
        int childIndex = 2*parentIndex + 1;
        while(childIndex < length){
            //如果有右孩子，且右孩子大于左孩子的值，则定位到右孩子
            if(childIndex+1<length && array[childIndex+1]>array[childIndex]){
                childIndex++;
            }
            //如果父节点小于任何一个孩子的值，直接跳出
            if(temp>=array[childIndex])
                break;
            //无需真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            childIndex = 2*childIndex + 1;
        }
        array[parentIndex] = temp;
    }

    /**
     * 堆排序
     * @param array 待调整的堆
     */
    public static void heapSort(int[] array){
        //1.把无序数组构建成二叉堆
        for(int i=(array.length-2)/2;i>=0;i--){
            downAdjust(array,i,array.length);
        }
        System.out.println(Arrays.toString(array));
        //2.循环删除堆顶元素，移动到集合尾部，调节堆产生新的堆顶
        for(int i=array.length-1;i>0;i--){
            //最后一个元素和第一个元素交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            //下沉调整最大堆
            downAdjust(array, 0 ,i);
        }
    }
}
