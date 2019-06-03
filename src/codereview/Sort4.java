package codereview;

import java.util.Arrays;

/**
 * @Description
 * @auther guangxush
 * @create 2019/6/3
 */
public class Sort4 {
    public static void main(String[] args) {
        System.out.println("quicksort:");
        int[] array1 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        quickSort(array1, 0 ,array1.length-1);
        System.out.println(Arrays.toString(array1));
    }

    public static void quickSort(int[] a, int start, int end){
        if(start < end){
            int i = start;
            int j = end;
            int pivot = a[start];
            while (i<j){
                while (i<j&&pivot<a[j]){j--;}
                if(i<j){
                    a[i] = a[j];
                    a[j] = pivot;
                    i++;
                }
                while(i<j&&pivot>a[j]){i++;}
                if(i<j){
                    a[j] = a[i];
                    a[i] = pivot;
                    j--;
                }
            }
            quickSort(a, start, i-1);
            quickSort(a, i+1, end);
        }
    }

}
