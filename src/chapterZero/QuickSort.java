package chapterZero;

/**
 * Created by gshan on 2018/11/2
 * 选择一个基准元素,通常选择第一个元素或者最后一个元素,通过一趟扫描，将待排序列分成两部分,
 * 一部分比基准元素小,一部分大于等于基准元素,此时基准元素在其排好序后的正确位置,然后再用同样的方法递归地排序划分的两部分。
 */
public class QuickSort {
    /**
     * 快速排序
     * @param array 待排序数组
     * @param low 最低位
     * @param high 最高位
     */
    public static void quickSort(int[] array, int low, int high){
        if(low<high){
            int pivot = array[low];
            int i = low;
            int j = high;
            while(i<j){
                while(i<j&&array[j]>pivot) j--;
                if(i<j){
                    array[i] = array[j];
                    array[j] = pivot;
                    i++;
                }
                while(i<j&&array[i]<pivot) i++;
                if(i<j){
                    array[j] = array[i];
                    array[i] = pivot;
                    j--;
                }
            }
            array[i] = pivot;
            quickSort(array, low, i-1);
            quickSort(array, i+1, high);
        }
    }
}
