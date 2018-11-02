package chapterZero;

/**
 * Created by gshan on 2018/11/2
 * 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。
 * 然后再把有序子序列合并为整体有序序列。
 */
public class MergeSort {
    public static void mergeSort(int[] array, int left ,int right){
        if(left<right){
            //找出中间索引
            int mid = (left+right)/2;
            //对左边进行归并
            mergeSort(array, left, mid);
            //对右边进行归并
            mergeSort(array, mid+1, right);
            //合并
            merge(array, left, mid, right);
        }
    }

    /**
     * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] array, int left, int mid, int right){
        int[] temp = new int[array.length];
        int i = left;//左序列指针
        int j = mid+1;//右序列指针
        int t = 0;//临时指针
        while(i<=mid&&j<=right){
            if(array[i]<array[j]){
                temp[t++] = array[i++];
            }else{
                temp[t++] = array[j++];
            }
        }
        while(i<=mid){//将左边元素全部填充到temp中
            temp[t++] = array[i++];
        }
        while(j<=right){//将右边元素全部填充到temp中
            temp[t++] = array[j++];
        }
        t = 0;
        //将temp中的元素全部拷贝到原数组中
        while(left<=right){
            array[left++] = temp[t++];
        }
    }
}
