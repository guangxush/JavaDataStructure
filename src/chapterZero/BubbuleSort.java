package chapterZero;

/**
 * Created by gshan on 2018/11/2
 */
public class BubbuleSort {
    /**
     * 在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，
     * 较小的往上冒。即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
     * @param array
     */
    public static void bubbleSort(int[] array){
        int length = array.length;
        int temp = 0;
        for(int j=0;j<length;j++){
            for(int i=0;i<length-1-j;i++){
                if(array[i]>array[i+1]){
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
    }
}
