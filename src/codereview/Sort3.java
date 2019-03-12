package codereview;

import java.util.Arrays;

/**
 * @Description
 * @auther guangxush
 * @create 2019/3/12
 */
public class Sort3 {
    public static void main(String[] args){
        System.out.println("quicksort:");
        int[] array1 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        //quickSort(array1, 0 ,array1.length-1);
        //mergeSort(array1, 0, array1.length-1);
        heapSort(array1);
        System.out.println(Arrays.toString(array1));
    }

    private static void quickSort(int[] a, int start, int end){
        if(start<end){
            int pivot = a[start];
            int i = start;
            int j = end;
            while (i<j){
                while (i<j&&a[i]<a[j]){
                    j--;
                }
                if(i<j){
                    a[i] = a[j];
                    a[j] = pivot;
                    i++;
                }
                while (i<j&&a[i]<a[j]){
                    i++;
                }
                if(i<j){
                    a[j] = a[i];
                    a[i] = pivot;
                    i++;
                }
            }
            quickSort(a, start, i-1);
            quickSort(a, i+1, end);
        }
    }

    public static void mergeSort(int[] a,int begin, int end){
        if(begin<end){
            int mid = (end+begin)/2;
            mergeSort(a,begin,mid);
            mergeSort(a,mid+1,end);
            merge(a,begin,mid,end);
        }
    }

    public static void merge(int[] a, int left,int mid, int right){
        int[] temp = new int[a.length];
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
        while (i<=mid){
            temp[t++] = a[i++];
        }
        while (j<=right){
            temp[t++] = a[j++];
        }
        t=0;
        while(left<=right){
            a[left++] = temp[t++];
        }
    }

    public static void adjustHeap(int[] a, int parentIndex, int length){
        int temp = a[parentIndex];
        int childIndex = 2*parentIndex+1;
        while(childIndex<length){
            if(childIndex+1<length&&a[childIndex+1]>a[childIndex]){
                childIndex++;
            }
            if(temp>=a[childIndex]){
                break;
            }
            a[parentIndex] = a[childIndex];
            parentIndex = childIndex;
            childIndex = 2*parentIndex+1;
        }
        a[parentIndex] = temp;
    }

    public static void heapSort(int[] a){
        for(int i=(a.length-2)/2;i>=0;i--){
            adjustHeap(a,i,a.length);
        }
        System.out.println(Arrays.toString(a));
        for(int i=a.length-1;i>=0;i--){
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            adjustHeap(a, 0, i);
        }
        System.out.println(Arrays.toString(a));
    }
}
