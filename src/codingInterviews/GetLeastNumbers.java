package codingInterviews;

import java.util.Arrays;

/**
 * 输入n个整数，找出其中最小的k个数。
 * 例如输入4,5,1，6,2,7,3,8这8个数字，则最少的4个数字是1,2,3,4.
 */
public class GetLeastNumbers {
    // 使用partition函数  
    public int partition(int[] src, int left, int right) {  
        int result = src[left];  
        if (left > right)  
            return -1;  
        while (left < right) {  
            while (left < right && src[right] >= result) {  
                right--;  
            }  
            src[left] = src[right];  
            while (left < right && src[left] < result) {  
                left++;  
            }  
            src[right] = src[left];  
        }  
        src[left] = result;  
        return left;  
    }  
    public int[] getLeastNumbers(int[] input,int k){  
        if(input.length == 0 || k<= 0)  
            return null;  
        int[] output = new int[k];  
        int start = 0;  
        int end = input.length-1;  
        int index = partition(input,start,end);  
        while(index != k-1){  
            if(index > k-1){  
                end = index -1;  
                index = partition(input,start ,end);  
            }  
            else{  
                start = index+1;  
                index = partition(input,start ,end);  
            }  
        }  
        for(int i = 0;i<k;i++){  
            output[i] = input[i];  
        }  
        return output;  
    }
    
    //新建大顶堆  
    public void buildMaxHeap(int[] arr,int lastIndex){  
        for(int i = (lastIndex-1)/2;i>=0;i--){  
            int k = i;  
            while(2*k+1 <= lastIndex){  
                int biggerIndex = 2*k+1;  
                if(biggerIndex <lastIndex){  
                    if(arr[biggerIndex]< arr[biggerIndex+1])  
                        biggerIndex++;  
                }  
                if(arr[k] < arr[biggerIndex]){  
                    swap(arr,k,biggerIndex);  
                    k = biggerIndex;  
                }  
                else  
                    break;  
            }  
        }  
    }  
    public static void swap(int[] arr,int i ,int j){  
        int temp = arr[i];  
        arr[i] = arr[j];  
        arr[j] = temp;  
    }  
    public void heapSort(int[] arr){  
        for(int i = 0;i<arr.length-1;i++){  
            buildMaxHeap(arr,arr.length-i-1);  
            swap(arr,0,arr.length-i-1);  
        }  
    }  
    public void getLeastNumbers1(int[] arr,int k){  
        if(arr == null || k<0 || k>arr.length)  
            return;  
        //根据输入数组前k个数建立最大堆  
        //从k+1个数开始与根节点比较  
        //大于根节点，舍去  
        //小于，取代根节点，重建最大堆  
        int[] kArray = Arrays.copyOfRange(arr, 0, k);  
        heapSort(kArray);  
        for(int i = k;i<arr.length;i++){  
            if(arr[i]<kArray[k-1]){  
                kArray[k-1] = arr[i];  
                heapSort(kArray);  
            }  
        }  
        for(int i:kArray)  
            System.out.print(i);  
    }
    public static void main(String[] args){  
        int[] arr= {4,5,1,6,2,7,3,8};  
        GetLeastNumbers test = new GetLeastNumbers();  
        int[] output=test.getLeastNumbers(arr, 4);  
        for(int i = 0;i<output.length ;i++){  
            System.out.print(output[i]+",");  
        }  
    }  
}
