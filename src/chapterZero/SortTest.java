package chapterZero;

import java.util.Arrays;
import org.junit.Test;
import static chapterZero.BubbuleSort.bubbleSort;
import static chapterZero.HeapSort.heapSort;
import static chapterZero.InsertSort.insertSort;
import static chapterZero.MergeSort.mergeSort;
import static chapterZero.QuickSort.quickSort;
import static chapterZero.RadixSort.radixSort;
import static chapterZero.SelectSort.selectSort;
import static chapterZero.ShellSort.shellSort;

/**
 * Created by gshan on 2018/11/2
 */

public class SortTest {

    @Test
    public static void testHeapSort(){
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public static void testShellSort(){
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public static void testSelectSort(){
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public static void testBubbleSort(){
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public static void testQuickSort(){
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        quickSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public static void testInsertSort(){
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public static void testMergeSort(){
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        mergeSort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public static void testRadixSort(){
        int[] arr = new int[] {1,3,2,6,5,7,8,9,10,0};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
