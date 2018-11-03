package chapterZero;

/**
 * 在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 *
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 */
public class SelectSort {
    public static void selectSort(int a[]){
        int position = 0;
        for(int i=0;i<a.length;i++){
            position = i;
            int temp = a[i];
            for(int j=i+1;j<a.length;j++){
                if(a[j]<temp){
                    temp = a[j];
                    position = j;
                }
            }
            a[position] = a[i];
            a[i] = temp;
        }
    }
}
