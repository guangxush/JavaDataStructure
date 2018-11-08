package codereview;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Sort {
    public static void main(String[] args){
        int[] array1 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        quickSort(array1, 0 ,array1.length-1);
        System.out.println(Arrays.toString(array1));
        int[] array2 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        puppleSort(array2);
        System.out.println(Arrays.toString(array2));
        int[] array3 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        selectSort(array3);
        System.out.println(Arrays.toString(array3));
        int[] array4 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        insertSort(array4);
        System.out.println(Arrays.toString(array4));
        int[] array5 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        shellSort(array5);
        System.out.println(Arrays.toString(array5));
        int[] array6 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        heapSort(array6);
        System.out.println(Arrays.toString(array6));
        int[] array7 = new int[]{1, 8, 2, 3, 7, 0, 5, 4, 2, 9, 6};
        mergeSort(array7, 0, array7.length-1);
        System.out.println(Arrays.toString(array7));
    }

    public static void quickSort(int[] a, int begin, int end){
        if(begin<end){
            int i = begin;
            int j = end;
            int temp = a[begin];
            while(i<j){
                while(i<j&&a[j]>temp) j--;
                if(i<j){
                    a[i] = a[j];
                    a[j] = temp;
                    i++;
                }
                while(i<j&&a[i]<temp) i++;
                if(i<j){
                    a[j] = a[i];
                    a[i] = temp;
                    j--;
                }
            }
            a[i] = temp;
            quickSort(a, begin, i-1);
            quickSort(a, i+1, end);
        }
    }

    public static void puppleSort(int[] a){
        int length = a.length;
        for(int j=0;j<length;j++){
            for(int i=0;i<length-1-j;i++){
                if(a[i]>a[i+1]){
                    int temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;
                }
            }
        }
    }

    public static void selectSort(int[] a){
        int length = a.length;
        for(int i=0;i<length;i++){
            int temp = i;
            int value = a[i];
            for(int j=i+1;j<length;j++){
                if(a[j]<value){
                    value = a[j];
                    temp = j;
                }
            }
            a[temp] = a[i];
            a[i] = value;
        }
    }

    public static void insertSort(int[] a){
        int length = a.length;
        int temp =0;
        for(int i=0;i<length;i++){
            int j = i-1;
            temp = a[i];
            for(;j>=0&&a[j]>temp;j--){
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
    }

    public static void shellSort(int[] a){
        int b = a.length;
        int temp = 0;
        while(true){
            b = b/2;
            for(int i=0;i<b;i++){
                for(int j=i+b;j<a.length;j+=b){
                    int k = j-b;
                    temp = a[j];
                    for(;k>=0&&temp<a[k];k-=b){
                        a[k+b] = a[k];
                    }
                    a[k+b] = temp;
                }
            }
            if(b==1) break;
        }
    }

    public static void downAdjust(int[] a, int parentIndex, int length){
        int temp = a[parentIndex];
        int childIndex = parentIndex*2+1;
        while (childIndex < length) {
            if(childIndex+1<length&&a[childIndex]<a[childIndex+1])
                 childIndex++;
            if(temp>=a[childIndex])
                break;
            a[parentIndex] = a[childIndex];
            parentIndex = childIndex;
            childIndex = parentIndex*2 + 1;
        }
        a[parentIndex] = temp;
    }

    public static void heapSort(int[] a){
        for(int i=(a.length-2)/2;i>=0;i--){
            downAdjust(a,i,a.length);
        }
        System.out.println(Arrays.toString(a));
        for(int i=a.length-1;i>0;i--){
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            downAdjust(a,0,i);
        }
    }

    public static void merge(int[] a, int left, int mid, int right){
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
        while(j<=right){
            temp[t++] = a[j++];
        }
        t = 0;
        while(left<=right){
            a[left++] = temp[t++];
        }
    }

    public static void mergeSort(int[] a,int left, int right){
        if(left<right){
            int mid = (left+right)/2;
            mergeSort(a, left, mid);
            mergeSort(a, mid+1, right);
            merge(a, left, mid, right );
        }
    }
}
