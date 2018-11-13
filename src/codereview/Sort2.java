package codereview;

import java.util.Arrays;

/**
 * Created by gshan on 2018/11/13
 */
public class Sort2 {

    public static void main(String[] args){
        System.out.println("quicksort:");
        int[] array1 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        quickSort(array1, 0 ,array1.length-1);
        System.out.println(Arrays.toString(array1));
//        int[] array2 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
//        puppleSort(array2);
//        System.out.println(Arrays.toString(array2));
//        int[] array3 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
//        selectSort(array3);
//        System.out.println(Arrays.toString(array3));
//        int[] array4 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
//        insertSort(array4);
//        System.out.println(Arrays.toString(array4));
//        int[] array5 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
//        shellSort(array5);
//        System.out.println(Arrays.toString(array5));
        System.out.println("heapsort:");
        int[] array6 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        heapSort(array6);
        System.out.println(Arrays.toString(array6));
        System.out.println("mergesort:");
        int[] array7 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        mergeSort(array7, 0, array7.length-1);
        System.out.println(Arrays.toString(array7));
    }

    public static void quickSort(int[] array, int begin, int end){
        if(begin<end){
            int i = begin;
            int j = end;
            int povit = array[i];
            while (i<j){
                while(i<j&&povit<array[j]) j--;
                if(i<j){
                    array[i] = array[j];
                    array[j] = povit;
                    i++;
                }
                while(i<j&&povit>array[i]) i++;
                if(i<j){
                    array[j] = array[i];
                    array[i] = povit;
                    j--;
                }
            }
            quickSort(array, begin, i-1);
            quickSort(array, i+1, end);
        }
    }

    public static void mergeSort(int[] a, int begin, int end){
        if(begin<end){
            int mid = (begin+end)/2;
            mergeSort(a,begin,mid);
            mergeSort(a,mid+1,end);
            merge(a,begin,mid,end);
        }
    }

    public static void merge(int[] a, int left,int mid, int right){
        int[] temp = new int [a.length];
        int i = left;
        int j = mid+1;
        int t = 0;
        while(i<=mid&&j<=right){
            if(a[i]<a[j]){
                temp[t++] = a[i++];
            }else{
                temp[t++] = a[j++];
            }
        }
        while(i<=mid){
            temp[t++] = a[i++];
        }
        while(j<=right){
            temp[t++] = a[j++];
        }
        t = 0;
        while(left<=right){
            a[left++] = temp[t++];
        }
    }

    public static void heapSort(int[] a){
        //从最后一个节点array.length-1的父节点（array.length-1-1）/2开始，直到根节点0，反复调整堆
        for(int i=(a.length-2)/2;i>=0;i--){
            adjustHeap(a,i,a.length);
        }
        System.out.println(Arrays.toString(a));
        for(int i=a.length-1;i>0;i--){
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            adjustHeap(a,0,i);
            System.out.println(Arrays.toString(a));
        }
    }

    public static void adjustHeap(int[] a, int parentIndex, int length){
        int temp = a[parentIndex];
        int childIndex = 2*parentIndex+1;
        while(childIndex<length){
            if(childIndex+1<length&&a[childIndex]<a[childIndex+1]){
                childIndex = childIndex+1;
            }
            if(temp>=a[childIndex])
                break;
            a[parentIndex] = a[childIndex];
            parentIndex = childIndex;
            childIndex = 2*parentIndex+1;
        }
        a[parentIndex] = temp;
    }

}
