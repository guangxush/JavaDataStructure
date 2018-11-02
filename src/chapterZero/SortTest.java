package chapterZero;

import java.util.Arrays;

import static chapterZero.HeapSort.heapSort;

/**
 * Created by gshan on 2018/11/2
 */
public class SortTest {
    public static void main(String[] args) {
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
